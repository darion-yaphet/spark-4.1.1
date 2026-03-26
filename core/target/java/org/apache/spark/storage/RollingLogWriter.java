package org.apache.spark.storage;
/**
 * Rolling log writer that writes log entries to blocks in a rolling manner. Here we split
 * log blocks based on size limit.
 * <p>
 * param:  blockManager BlockManager to manage log blocks.
 * param:  blockIdGenerator BlockId generator to generate unique block IDs for log blocks.
 * param:  rollingSize Size limit for each log block. Default is 32MB (33554432 bytes).
 */
  class RollingLogWriter implements org.apache.spark.internal.Logging {
  public   RollingLogWriter (org.apache.spark.storage.BlockManager blockManager, org.apache.spark.storage.LogBlockIdGenerator blockIdGenerator, long rollingSize)  { throw new RuntimeException(); }
  /**
   * Write a log entry. If the current block writer is empty, it will create a new one.
   * If the current block exceeds the rolling size, it will roll over to a new block for
   * the next log entry.
   * <p>
   * @param logEntry log entry to write.
   * @param removeBlockOnException if true, current log block will be deleted without saving to
   *                               BlockManager. Otherwise, not action will be taken on current
   *                               block which might be corrupted.
   */
  public  void writeLog (org.apache.spark.storage.LogLine logEntry, boolean removeBlockOnException)  { throw new RuntimeException(); }
  public  void rollOver ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
    void flush ()  { throw new RuntimeException(); }
}
