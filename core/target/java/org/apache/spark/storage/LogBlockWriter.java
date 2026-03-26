package org.apache.spark.storage;
/**
 * A class for writing logs directly to a file on disk and save as a block in BlockManager if
 * there are any logs written.
 * <code>save</code> or <code>close</code> must be called to ensure resources are released properly. <code>save</code> will add
 * the log block to BlockManager, while <code>close</code> will just release the resources without saving
 * the log block.
 * <p>
 * Notes:
 * - This class does not support concurrent writes.
 * - The writer will be automatically closed when failed to write logs or failed to save the
 *   log block.
 * - Write operations after closing will throw exceptions.
 */
  class LogBlockWriter implements org.apache.spark.internal.Logging {
  public   LogBlockWriter (org.apache.spark.storage.BlockManager blockManager, scala.Enumeration.Value logBlockType, org.apache.spark.SparkConf sparkConf, int bufferSize)  { throw new RuntimeException(); }
    java.io.File tmpFile ()  { throw new RuntimeException(); }
  public  int bytesWritten ()  { throw new RuntimeException(); }
  /**
   * Write a log entry to the log block. Exception will be thrown if the writer has been closed
   * or if there is an error during writing. Caller needs to deal with the exception. Suggest to
   * close the writer when exception is thrown as block data could be corrupted which would lead
   * to issues when reading the log block later.
   * <p>
   * @param logEntry The log entry to write.
   */
  public  void writeLog (org.apache.spark.storage.LogLine logEntry)  { throw new RuntimeException(); }
  public  void save (org.apache.spark.storage.LogBlockId blockId)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
    void flush ()  { throw new RuntimeException(); }
    boolean saveToBlockManager (org.apache.spark.storage.LogBlockId blockId, long blockSize)  { throw new RuntimeException(); }
}
