package org.apache.spark.storage;
/**
 * Identifies a block of log data.
 * <p>
 * param:  lastLogTime the timestamp of the last log entry in this block, used for filtering
 *                    and log management.
 * param:  executorId the ID of the executor that produced this log block.
 */
public abstract class LogBlockId extends org.apache.spark.storage.BlockId {
  static public  org.apache.spark.storage.LogBlockId empty (scala.Enumeration.Value logBlockType)  { throw new RuntimeException(); }
  public   LogBlockId ()  { throw new RuntimeException(); }
  public abstract  long lastLogTime ()  ;
  public abstract  java.lang.String executorId ()  ;
  public abstract  scala.Enumeration.Value logBlockType ()  ;
}
