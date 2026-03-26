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

/** Broadcast 核心流程说明：
  *   1. 创建与封装：通过 SparkContext.broadcast(v) 将一个普通的变量 v 封装为 Broadcast[T] 对象。
  *   2. 任务分发优化：在集群运行函数时，直接引用 Broadcast 对象而非原始变量 v。 Spark 保证变量 v
  *      仅在每个节点（Executor）上存储一份缓存，而非随每个 Task 重复发送。
  *   3. 跨节点传输：利用高效的广播算法（如 TorrentBroadcast 中的 BitTorrent 风格分发）来减少网络 IO 压力。
  *   4. 只读约束：广播后的原始对象不应被修改，以保证分布式环境下的并发一致性。
  *   5. 资源生命周期管理：
  *      - value: 获取广播值。
  *      - unpersist: 指示 Executor 移除本地变量缓存。
  *      - destroy: 彻底销毁广播变量及其在所有节点上的元数据，该操作不可逆。
  */
package org.apache.spark.broadcast

import java.io.Serializable

import scala.reflect.ClassTag

import org.apache.spark.SparkException
import org.apache.spark.internal.{Logging, LogKeys}
import org.apache.spark.util.Utils

/** A broadcast variable. Broadcast variables allow the programmer to keep a
  * read-only variable cached on each machine rather than shipping a copy of it
  * with tasks. They can be used, for example, to give every node a copy of a
  * large input dataset in an efficient manner. Spark also attempts to
  * distribute broadcast variables using efficient broadcast algorithms to
  * reduce communication cost. 广播变量。广播变量允许编程人员在每台机器上缓存一个只读变量，而不是随任务一起发送其副本。
  * 例如，它们可以用于以高效的方式为每个节点提供大型输入数据集的副本。 Spark 还尝试使用高效的广播算法分发广播变量，以降低通信成本。
  *
  * Broadcast variables are created from a variable `v` by calling
  * [[org.apache.spark.SparkContext#broadcast]]. The broadcast variable is a
  * wrapper around `v`, and its value can be accessed by calling the `value`
  * method. The interpreter session below shows this: 广播变量通过调用
  * [[org.apache.spark.SparkContext#broadcast]] 从变量 `v` 创建。 广播变量是对 `v`
  * 的包装，其值可以通过调用 `value` 方法访问。 下面的解释器会话展示了这一点：
  *
  * {{{
  * scala> val broadcastVar = sc.broadcast(Array(1, 2, 3))
  * broadcastVar: org.apache.spark.broadcast.Broadcast[Array[Int]] = Broadcast(0)
  *
  * scala> broadcastVar.value
  * res0: Array[Int] = Array(1, 2, 3)
  * }}}
  *
  * After the broadcast variable is created, it should be used instead of the
  * value `v` in any functions run on the cluster so that `v` is not shipped to
  * the nodes more than once. In addition, the object `v` should not be modified
  * after it is broadcast in order to ensure that all nodes get the same value
  * of the broadcast variable (e.g. if the variable is shipped to a new node
  * later). 广播变量创建后，在集群上运行的任何函数中都应使用它来代替值 `v`，这样 `v` 就不会多次运送到节点。 此外，对象 `v`
  * 在广播后不应被修改，以确保所有节点获得相同的广播变量值（例如，如果该变量稍后被发送到新节点）。
  *
  * @param id
  *   A unique identifier for the broadcast variable. 广播变量的唯一标识符。
  * @tparam T
  *   Type of the data contained in the broadcast variable. 广播变量中所含数据的类型。
  */
abstract class Broadcast[T: ClassTag](val id: Long)
    extends Serializable
    with Logging {

  /** Flag signifying whether the broadcast variable is valid (that is, not
    * already destroyed) or not. 标记广播变量是否有效（即尚未被销毁）。
    */
  @volatile private var _isValid = true

  private var _destroySite = ""

  /** Get the broadcasted value. 获取广播值。
    */
  def value: T = {
    assertValid()
    getValue()
  }

  /** Asynchronously delete cached copies of this broadcast on the executors. If
    * the broadcast is used after this is called, it will need to be re-sent to
    * each executor. 异步地从 Executor 上删除此广播变量的缓存副本。 如果在调用此方法后仍使用该广播变量，则需要将其重新发送到各个
    * Executor。
    */
  def unpersist(): Unit = {
    unpersist(blocking = false)
  }

  /** Delete cached copies of this broadcast on the executors. If the broadcast
    * is used after this is called, it will need to be re-sent to each executor.
    * 从 Executor 上删除此广播变量的缓存副本。如果在调用此方法后仍使用该广播变量， 则需要将其重新发送到各个 Executor。
    * @param blocking
    *   Whether to block until unpersisting has completed 是否阻塞直到取消持久化完成。
    */
  def unpersist(blocking: Boolean): Unit = {
    assertValid()
    doUnpersist(blocking)
  }

  /** Destroy all data and metadata related to this broadcast variable. Use this
    * with caution; once a broadcast variable has been destroyed, it cannot be
    * used again. 销毁与此广播变量相关的所有数据和元数据。请谨慎使用； 广播变量一旦被销毁，就无法再次使用。
    */
  def destroy(): Unit = {
    destroy(blocking = false)
  }

  /** Destroy all data and metadata related to this broadcast variable. Use this
    * with caution; once a broadcast variable has been destroyed, it cannot be
    * used again.
    *
    * 销毁与此广播变量相关的所有数据和元数据。请谨慎使用； 广播变量一旦被销毁，就无法再次使用。
    * @param blocking
    *   Whether to block until destroy has completed 是否阻塞直到销毁完成。
    */
  private[spark] def destroy(blocking: Boolean): Unit = {
    assertValid()
    _isValid = false
    _destroySite = Utils.getCallSite().shortForm
    logInfo(
      log"Destroying ${MDC(LogKeys.BROADCAST, toString)} " +
        log"(from ${MDC(LogKeys.CALL_SITE_SHORT_FORM, _destroySite)})"
    )
    doDestroy(blocking)
  }

  /** Whether this Broadcast is actually usable. This should be false once
    * persisted state is removed from the driver. 此广播变量是否实际可用。一旦从 Driver
    * 中移除持久化状态，此值应为 false。
    */
  private[spark] def isValid: Boolean = {
    _isValid
  }

  /** Actually get the broadcasted value. Concrete implementations of Broadcast
    * class must define their own way to get the value. 实际获取广播值。Broadcast
    * 类的具体实现必须定义其各自获取该值的方式。
    */
  protected def getValue(): T

  /** Actually unpersist the broadcasted value on the executors. Concrete
    * implementations of Broadcast class must define their own logic to
    * unpersist their own data. 实际上从 Executor 上取消广播值的持久化。Broadcast
    * 类的具体实现必须定义其各自取消 持久化数据的逻辑。
    */
  protected def doUnpersist(blocking: Boolean): Unit

  /** Actually destroy all data and metadata related to this broadcast variable.
    * Implementation of Broadcast class must define their own logic to destroy
    * their own state. 实际上销毁与此广播变量相关的所有数据和元数据。 Broadcast 类的实现必须定义其各自销毁自身状态的逻辑。
    */
  protected def doDestroy(blocking: Boolean): Unit

  /** Check if this broadcast is valid. If not valid, exception is thrown.
    * 检查此广播变量是否有效。如果无效，则抛出异常。
    */
  protected def assertValid(): Unit = {
    if (!_isValid) {
      throw SparkException.internalError(
        "Attempted to use %s after it was destroyed (%s) "
          .format(toString, _destroySite),
        category = "BROADCAST"
      )
    }
  }

  override def toString: String = "Broadcast(" + id + ")"
}
