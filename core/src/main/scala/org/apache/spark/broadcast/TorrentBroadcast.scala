/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * TorrentBroadcast 核心流程说明 (BitTorrent-style Broadcast)：
 * 1. 块化 (Blockify)：在 Driver 端，将原始对象序列化并分割成大小均匀的数据分片 (pieces/chunks)。
 * 2. 初始存储：这些分片被直接推送到 Driver 本地的 BlockManager 中，并向 Master 汇报可用。
 * 3. 分布式拉取 (Distributed Fetch)：Executor 端的 Task 触发广播值读取时，会随机顺序拉取分片。
 *    Executor 优先从本地缓存或远程 Executor 的 BlockManager 处获取分片，最后才会请求 Driver。
 * 4. P2P 共享：一旦某个 Executor 下载了一个分片，它就会立即将该分片存入本地 BlockManager 并汇报给 Master，
 *    从而使自己也成为该分片的数据源，减轻 Driver 的带宽压力。
 * 5. 重构对象 (Reconstruction)：所有分片下载完成后，通过 SequenceInputStream 将分片按序连接并反序列化，还原原始对象并缓存到内存。
 */
package org.apache.spark.broadcast

import java.io._
import java.lang.ref.{Reference, SoftReference, WeakReference}
import java.nio.ByteBuffer
import java.util.zip.Adler32

import scala.jdk.CollectionConverters._
import scala.reflect.ClassTag
import scala.util.Random

import org.apache.spark._
import org.apache.spark.internal.{config, Logging}
import org.apache.spark.internal.LogKeys._
import org.apache.spark.io.CompressionCodec
import org.apache.spark.serializer.Serializer
import org.apache.spark.storage._
import org.apache.spark.util.{KeyLock, Utils}
import org.apache.spark.util.io.{ChunkedByteBuffer, ChunkedByteBufferOutputStream}

/**
 * A BitTorrent-like implementation of [[org.apache.spark.broadcast.Broadcast]].
 * [[org.apache.spark.broadcast.Broadcast]] 的类 BitTorrent 实现。
 *
 * The mechanism is as follows:
 * 机制如下：
 *
 * The driver divides the serialized object into small chunks and
 * stores those chunks in the BlockManager of the driver.
 * Driver 将序列化后的对象切分成若干个小块，并将这些块存储在自身的 BlockManager 中。
 *
 * On each executor, the executor first attempts to fetch the object from its BlockManager. If
 * it does not exist, it then uses remote fetches to fetch the small chunks from the driver and/or
 * other executors if available. Once it gets the chunks, it puts the chunks in its own
 * BlockManager, ready for other executors to fetch from.
 * 在每个 Executor 上，Executor 尝试先从自身的 BlockManager 获取该对象。
 * 如果不存在，它会通过远程获取从 Driver 或其他可用的 Executor 处下载小块。
 * 一旦获取了所有块，它会将这些块放入自身的 BlockManager，供其他 Executor 下载。
 *
 * This prevents the driver from being the bottleneck in sending out multiple copies of the
 * broadcast data (one per executor).
 * 这防止了在向多台 Executor 发送广播数据副本时，Driver 成为网络瓶颈。
 *
 * When initialized, TorrentBroadcast objects read SparkEnv.get.conf.
 * 在初始化时，TorrentBroadcast 对象会读取 SparkEnv.get.conf。
 *
 * @param obj object to broadcast
 *            要广播的对象。
 * @param id A unique identifier for the broadcast variable.
 *           广播变量的唯一标识符。
 * @param serializedOnly if true, do not cache the unserialized value on the driver
 *                       如果为 true，则不在 Driver 上缓存未序列化的值。
 */
private[spark] class TorrentBroadcast[T: ClassTag](obj: T, id: Long, serializedOnly: Boolean)
  extends Broadcast[T](id) with Logging with Serializable {

  /**
   * Value of the broadcast object on executors. This is reconstructed by [[readBroadcastBlock]],
   * which builds this value by reading blocks from the driver and/or other executors.
   * 
   * Executor 上广播对象的值。该值由 [[readBroadcastBlock]] 构建，
   * 它是通过从 Driver 或其他 Executor 读取块来还原的。
   *
   * On the driver, if the value is required, it is read lazily from the block manager. We hold
   * a soft reference so that it can be garbage collected if required, as we can always reconstruct
   * in the future. For internal broadcast variables where `serializedOnly = true`, we hold a
   * WeakReference to allow the value to be reclaimed more aggressively.
   * 
   * 在 Driver 端，如果需要该值，它会从 BlockManager 中延迟读取。
   * 我们持有一个软引用，以便在需要时进行垃圾回收，因为我们将来总是可以重新构建。
   * 对于 `serializedOnly = true` 的内部广播变量，我们持有一个弱引用，
   * 以便更积极地回收该值。
   */
  @transient private var _value: Reference[T] = _

  /** The compression codec to use, or None if compression is disabled
    * 要使用的压缩编解码器，如果禁用了压缩则为 None。 */
  @transient private var compressionCodec: Option[CompressionCodec] = _
  /** Size of each block. Default value is 4MB.  This value is only read by the broadcaster.
    * 每个数据块的大小。默认值为 4MB。此值仅由广播端读取。 */
  @transient private var blockSize: Int = _
  /** Is the execution in local mode.
    * 是否在本地模式下执行。 */
  @transient private var isLocalMaster: Boolean = _

  /** Whether to generate checksum for blocks or not.
    * 是否为数据块生成校验和。 */
  private var checksumEnabled: Boolean = false

  /**
   * Set configuration (compression codec, block size, checksum flag, etc.).
   * 设置相关配置（压缩编解码器、块大小、检验和开关等）。
   */
  private def setConf(conf: SparkConf): Unit = {
    compressionCodec = if (conf.get(config.BROADCAST_COMPRESS)) {
      Some(CompressionCodec.createCodec(conf))
    } else {
      None
    }
    // Note: use getSizeAsKb (not bytes) to maintain compatibility if no units are provided
    // 注意：使用 getSizeAsKb（而不是 bytes）以在未提供单位时保持兼容性
    blockSize = conf.get(config.BROADCAST_BLOCKSIZE).toInt * 1024
    checksumEnabled = conf.get(config.BROADCAST_CHECKSUM)
    isLocalMaster = Utils.isLocalMaster(conf)
  }
  setConf(SparkEnv.get.conf)

  private val broadcastId = BroadcastBlockId(id)

  /** Total number of blocks this broadcast variable contains.
    * 此广播变量包含的数据块总数。 */
  private val numBlocks: Int = writeBlocks(obj)

  /** The checksum for all the blocks.
    * 所有数据块的校验和。 */
  private var checksums: Array[Int] = _

  /**
   * Called by Broadcast.value to get or reconstruct the broadcasted object.
   * 被 Broadcast.value 调用，用于获取或重建广播对象。
   */
  override protected def getValue() = synchronized {
    val memoized: T = if (_value == null) null.asInstanceOf[T] else _value.get
    if (memoized != null) {
      memoized
    } else {
      val newlyRead = readBroadcastBlock()
      _value = if (serializedOnly) {
        new WeakReference[T](newlyRead)
      } else {
        new SoftReference[T](newlyRead)
      }
      newlyRead
    }
  }

  /**
   * Calculate the checksum for a given data block.
   * 计算指定数据块的校验和。
   */
  private def calcChecksum(block: ByteBuffer): Int = {
    val adler = new Adler32()
    if (block.hasArray) {
      adler.update(block.array, block.arrayOffset + block.position(), block.limit()
        - block.position())
    } else {
      val bytes = new Array[Byte](block.remaining())
      block.duplicate.get(bytes)
      adler.update(bytes)
    }
    adler.getValue.toInt
  }

  /**
   * Divide the object into multiple blocks and put those blocks in the block manager.
   * 将对象分成多个块，并将这些块放入块管理器中。
   *
   * @param value the object to divide
   *              待切割的对象。
   * @return number of blocks this broadcast variable is divided into
   *         此广播变量被切割后的块数。
   */
  private def writeBlocks(value: T): Int = {
    import StorageLevel._
    val blockManager = SparkEnv.get.blockManager
    if (serializedOnly && !isLocalMaster) {
      // SPARK-39983: When creating a broadcast variable internal to Spark (such as a broadcasted
      // hashed relation), don't store the broadcasted value in the driver's block manager:
      // we do not expect internal broadcast variables' values to be read on the driver, so
      // skipping the store reduces driver memory pressure because we don't add a long-lived
      // reference to the broadcasted object. However, this optimization cannot be applied for
      // local mode (since tasks might run on the driver). To guard against performance
      // regressions if an internal broadcast is accessed on the driver, we store a weak
      // reference to the broadcasted value:
      // SPARK-39983：当创建 Spark 内部的广播变量（如广播的哈希关系）时，不要将广播值存储在 
      // Driver 的块管理器中：我们不希望在 Driver 上读取内部广播变量的值，因此跳过存储可以 
      // 减轻 Driver 的内存压力，因为我们没有为广播对象添加长生命周期的引用。
      // 但是，此优化不能应用于本地模式（因为任务可能在 Driver 上运行）。为了防止在 Driver 
      // 上访问内部广播时出现性能退化，我们存储了广播值的弱引用：
      _value = new WeakReference[T](value)
    } else {
      // Store a copy of the broadcast variable in the driver so that tasks run on the driver
      // do not create a duplicate copy of the broadcast variable's value.
      // 在 Driver 中存储广播变量的副本，以便在 Driver 上运行的任务不会创建广播变量值的重复副本。
      if (!blockManager.putSingle(broadcastId, value, MEMORY_AND_DISK, tellMaster = false)) {
        throw SparkException.internalError(
          s"Failed to store $broadcastId in BlockManager", category = "BROADCAST")
      }
    }
    try {
      val blocks =
        TorrentBroadcast.blockifyObject(value, blockSize, SparkEnv.get.serializer, compressionCodec)
      if (checksumEnabled) {
        checksums = new Array[Int](blocks.length)
      }
      blocks.zipWithIndex.foreach { case (block, i) =>
        if (checksumEnabled) {
          checksums(i) = calcChecksum(block)
        }
        val pieceId = BroadcastBlockId(id, "piece" + i)
        val bytes = new ChunkedByteBuffer(block.duplicate())
        if (!blockManager.putBytes(pieceId, bytes, MEMORY_AND_DISK_SER, tellMaster = true)) {
          throw SparkException.internalError(s"Failed to store $pieceId of $broadcastId " +
            s"in local BlockManager", category = "BROADCAST")
        }
      }
      blocks.length
    } catch {
      case t: Throwable =>
        // scalastyle:off line.size.limit
        logError(log"Store broadcast ${MDC(BROADCAST_ID, broadcastId)} fail, remove all pieces of the broadcast")
        // scalastyle:on
        blockManager.removeBroadcast(id, tellMaster = true)
        throw t
    }
  }

  /** Fetch torrent blocks from the driver and/or other executors.
    * 从 Driver 或其他 Executor 处理拉取分片（Torrent 块）。 */
  private def readBlocks(): Array[BlockData] = {
    // Fetch chunks of data. Note that all these chunks are stored in the BlockManager and reported
    // to the driver, so other executors can pull these chunks from this executor as well.
    // 获取数据块。请注意，所有这些块都存储在 BlockManager 中并向 Driver 汇报，
    // 因此其他 Executor 也可以从该 Executor 拉取这些块。
    val blocks = new Array[BlockData](numBlocks)
    val bm = SparkEnv.get.blockManager

    for (pid <- Random.shuffle(Seq.range(0, numBlocks))) {
      val pieceId = BroadcastBlockId(id, "piece" + pid)
      logDebug(s"Reading piece $pieceId of $broadcastId")
      // First try getLocalBytes because there is a chance that previous attempts to fetch the
      // broadcast blocks have already fetched some of the blocks. In that case, some blocks
      // would be available locally (on this executor).
      // 首先尝试 getLocalBytes，因为之前的抓取广播块尝试可能已经抓取了其中的部分块。
      // 在这种情况下，某些块可能在本地（此 Executor 上）可用。
      bm.getLocalBytes(pieceId) match {
        case Some(block) =>
          blocks(pid) = block
          releaseBlockManagerLock(pieceId)
        case None =>
          bm.getRemoteBytes(pieceId) match {
            case Some(b) =>
              if (checksumEnabled) {
                val sum = calcChecksum(b.chunks(0))
                if (sum != checksums(pid)) {
                  throw SparkException.internalError(
                    s"corrupt remote block $pieceId of $broadcastId: $sum != ${checksums(pid)}",
                    category = "BROADCAST")
                }
              }
              // We found the block from remote executors/driver's BlockManager, so put the block
              // in this executor's BlockManager.
              // 我们从远程 Executor/Driver 的 BlockManager 中找到了该块，因此将该块放入
              // 此 Executor 的 BlockManager 中。
              if (!bm.putBytes(pieceId, b, StorageLevel.MEMORY_AND_DISK_SER, tellMaster = true)) {
                throw SparkException.internalError(
                  s"Failed to store $pieceId of $broadcastId in local BlockManager",
                  category = "BROADCAST")
              }
              blocks(pid) = new ByteBufferBlockData(b, true)
            case None =>
              throw SparkException.internalError(
                s"Failed to get $pieceId of $broadcastId", category = "BROADCAST")
          }
      }
    }
    blocks
  }

  /**
   * Remove all persisted state associated with this Torrent broadcast on the executors.
   * 移除 Executor 上与此 Torrent 广播相关的所有持久化状态。
   */
  override protected def doUnpersist(blocking: Boolean): Unit = {
    TorrentBroadcast.unpersist(id, removeFromDriver = false, blocking)
  }

  /**
   * Remove all persisted state associated with this Torrent broadcast on the executors
   * and driver.
   * 移除 Executor 和 Driver 上与此 Torrent 广播相关的所有持久化状态。
   */
  override protected def doDestroy(blocking: Boolean): Unit = {
    TorrentBroadcast.unpersist(id, removeFromDriver = true, blocking)
  }

  /** Used by the JVM when serializing this object.
    * JVM 在序列化此对象时使用。 */
  private def writeObject(out: ObjectOutputStream): Unit = Utils.tryOrIOException {
    assertValid()
    out.defaultWriteObject()
  }

  /**
   * Get the broadcast block from local cache or BlockManager. If it doesn't exist, 
   * fetch chunks via readBlocks and reconstruct the object.
   * 从本地缓存或 BlockManager 获取广播块。如果不存在，则通过 readBlocks 抓取分片并重建对象。
   */
  private def readBroadcastBlock(): T = Utils.tryOrIOException {
    TorrentBroadcast.torrentBroadcastLock.withLock(broadcastId) {
      // As we only lock based on `broadcastId`, whenever using `broadcastCache`, we should only
      // touch `broadcastId`.
      // 由于我们仅基于 `broadcastId` 进行锁定，因此每当使用 `broadcastCache` 时，
      // 我们只应触及 `broadcastId`。
      val broadcastCache = SparkEnv.get.broadcastManager.cachedValues

      Option(broadcastCache.get(broadcastId)).map(_.asInstanceOf[T]).getOrElse {
        setConf(SparkEnv.get.conf)
        val blockManager = SparkEnv.get.blockManager
        blockManager.getLocalValues(broadcastId) match {
          case Some(blockResult) =>
            if (blockResult.data.hasNext) {
              val x = blockResult.data.next().asInstanceOf[T]
              releaseBlockManagerLock(broadcastId)

              if (x != null) {
                broadcastCache.put(broadcastId, x)
              }

              x
            } else {
              throw SparkException.internalError(
                s"Failed to get locally stored broadcast data: $broadcastId",
                category = "BROADCAST")
            }
          case None =>
            val estimatedTotalSize = Utils.bytesToString(numBlocks.toLong * blockSize)
            logInfo(log"Started reading broadcast variable ${MDC(BROADCAST_ID, id)} with ${MDC(NUM_BROADCAST_BLOCK, numBlocks)} pieces " +
              log"(estimated total size ${MDC(NUM_BYTES, estimatedTotalSize)})")
            val startTimeNs = System.nanoTime()
            val blocks = readBlocks()
            logInfo(log"Reading broadcast variable ${MDC(BROADCAST_ID, id)}" +
              log" took ${MDC(TOTAL_TIME, Utils.getUsedTimeNs(startTimeNs))}")

            try {
              val obj = TorrentBroadcast.unBlockifyObject[T](
                blocks.map(_.toInputStream()), SparkEnv.get.serializer, compressionCodec)

              if (!serializedOnly || isLocalMaster || Utils.isInRunningSparkTask) {
                // Store the merged copy in BlockManager so other tasks on this executor don't
                // need to re-fetch it.
                // 将合并后的副本存储在 BlockManager 中，以便此 Executor 上的其他任务不需要重新抓取。
                val storageLevel = StorageLevel.MEMORY_AND_DISK
                if (!blockManager.putSingle(broadcastId, obj, storageLevel, tellMaster = false)) {
                  throw SparkException.internalError(
                    s"Failed to store $broadcastId in BlockManager", category = "BROADCAST")
                }
              }

              if (obj != null) {
                broadcastCache.put(broadcastId, obj)
              }

              obj
            } finally {
              blocks.foreach(_.dispose())
            }
        }
      }
    }
  }

  /**
   * If running in a task, register the given block's locks for release upon task completion.
   * Otherwise, if not running in a task then immediately release the lock.
   * 如果在任务中运行，则注册给定块的锁，以便在任务完成后释放。
   * 否则，如果不在任务中运行，则立即释放锁。
   */
  private def releaseBlockManagerLock(blockId: BlockId): Unit = {
    val blockManager = SparkEnv.get.blockManager
    Option(TaskContext.get()) match {
      case Some(taskContext) =>
        taskContext.addTaskCompletionListener[Unit](_ => blockManager.releaseLock(blockId))
      case None =>
        // This should only happen on the driver, where broadcast variables may be accessed
        // outside of running tasks (e.g. when computing rdd.partitions()). In order to allow
        // broadcast variables to be garbage collected we need to free the reference here
        // which is slightly unsafe but is technically okay because broadcast variables aren't
        // stored off-heap.
        blockManager.releaseLock(blockId)
    }
  }

  // Is the unserialized value cached. Exposed for testing.
  // 未序列化的值是否已缓存。公开用于测试。
  private[spark] def hasCachedValue: Boolean = {
    TorrentBroadcast.torrentBroadcastLock.withLock(broadcastId) {
      setConf(SparkEnv.get.conf)
      val blockManager = SparkEnv.get.blockManager
      blockManager.getLocalValues(broadcastId) match {
        case Some(blockResult) if (blockResult.data.hasNext) =>
          val x = blockResult.data.next().asInstanceOf[T]
          releaseBlockManagerLock(broadcastId)
          x != null
        case _ => false
      }
    }
  }
}


private object TorrentBroadcast extends Logging {

  /**
   * A [[KeyLock]] whose key is [[BroadcastBlockId]] to ensure there is only one thread fetching
   * the same [[TorrentBroadcast]] block.
   * 一个以 [[BroadcastBlockId]] 为键的 [[KeyLock]]，用于确保只有一个线程在抓取
   * 同一个 [[TorrentBroadcast]] 块。
   */
  private val torrentBroadcastLock = new KeyLock[BroadcastBlockId]

  /**
   * Serialize and divide an object into blocks.
   * 将对象序列化并分割成多个块。
   */
  def blockifyObject[T: ClassTag](
      obj: T,
      blockSize: Int,
      serializer: Serializer,
      compressionCodec: Option[CompressionCodec]): Array[ByteBuffer] = {
    val cbbos = new ChunkedByteBufferOutputStream(blockSize, ByteBuffer.allocate)
    val out = compressionCodec.map(c => c.compressedOutputStream(cbbos)).getOrElse(cbbos)
    val ser = serializer.newInstance()
    val serOut = ser.serializeStream(out)
    Utils.tryWithSafeFinally {
      serOut.writeObject[T](obj)
    } {
      serOut.close()
    }
    cbbos.toChunkedByteBuffer.getChunks()
  }

  /**
   * Deserialize and reconstruct an object from blocks.
   * 从一系列块中反序列化并重建对象。
   */
  def unBlockifyObject[T: ClassTag](
      blocks: Array[InputStream],
      serializer: Serializer,
      compressionCodec: Option[CompressionCodec]): T = {
    require(blocks.nonEmpty, "Cannot unblockify an empty array of blocks")
    val is = new SequenceInputStream(blocks.iterator.asJavaEnumeration)
    val in: InputStream = compressionCodec.map(c => c.compressedInputStream(is)).getOrElse(is)
    val ser = serializer.newInstance()
    val serIn = ser.deserializeStream(in)
    val obj = Utils.tryWithSafeFinally {
      serIn.readObject[T]()
    } {
      serIn.close()
    }
    obj
  }

  /**
   * Remove all persisted blocks associated with this torrent broadcast on the executors.
   * If removeFromDriver is true, also remove these persisted blocks on the driver.
   * 移除 Executor 上与此 Torrent 广播相关的所有持久化块。
   * 如果 removeFromDriver 为 true，则同时移除 Driver 上的这些持久化块。
   */
  def unpersist(id: Long, removeFromDriver: Boolean, blocking: Boolean): Unit = {
    logDebug(s"Unpersisting TorrentBroadcast $id")
    SparkEnv.get.blockManager.master.removeBroadcast(id, removeFromDriver, blocking)
  }
}
