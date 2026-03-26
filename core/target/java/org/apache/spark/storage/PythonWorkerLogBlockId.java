package org.apache.spark.storage;
/**
 * Identifies a block of Python worker log data.
 * <p>
 * param:  lastLogTime the timestamp of the last log entry in this block, used for filtering
 *                    and log management.
 * param:  executorId the ID of the executor that produced this log block.
 * param:  sessionId the session ID to isolate the logs.
 * param:  workerId the worker ID to distinguish the Python worker process.
 */
public  class PythonWorkerLogBlockId extends org.apache.spark.storage.LogBlockId implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long lastLogTime ()  { throw new RuntimeException(); }
  public  java.lang.String executorId ()  { throw new RuntimeException(); }
  public  java.lang.String sessionId ()  { throw new RuntimeException(); }
  public  java.lang.String workerId ()  { throw new RuntimeException(); }
  // not preceding
  public   PythonWorkerLogBlockId (long lastLogTime, java.lang.String executorId, java.lang.String sessionId, java.lang.String workerId)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value logBlockType ()  { throw new RuntimeException(); }
}
