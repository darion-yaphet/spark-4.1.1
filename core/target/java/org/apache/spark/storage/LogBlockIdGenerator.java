package org.apache.spark.storage;
/**
 * LogBlockIdGenerator is responsible for generating unique LogBlockIds for log blocks.
 */
public  interface LogBlockIdGenerator {
  public  org.apache.spark.storage.LogBlockId genUniqueBlockId (long lastLogTime, java.lang.String executorId)  ;
  public  scala.Enumeration.Value logBlockType ()  ;
  /**
   * Generates a new LogBlockId based on the last log time and executor ID. Make sure that
   * the generated LogBlockId has the same log block type as this generator.
   * <p>
   * @param lastLogTime The timestamp of the last log entry.
   * @param executorId The ID of the executor generating the log block.
   * @return (undocumented)
   */
  public  org.apache.spark.storage.LogBlockId nextBlockId (long lastLogTime, java.lang.String executorId)  ;
}
