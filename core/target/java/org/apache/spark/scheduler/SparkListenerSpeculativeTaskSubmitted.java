package org.apache.spark.scheduler;
public  class SparkListenerSpeculativeTaskSubmitted implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int stageId ()  { throw new RuntimeException(); }
  public  int stageAttemptId ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerSpeculativeTaskSubmitted (int stageId, int stageAttemptId)  { throw new RuntimeException(); }
  public  int taskIndex ()  { throw new RuntimeException(); }
  public  int partitionId ()  { throw new RuntimeException(); }
  public   SparkListenerSpeculativeTaskSubmitted (int stageId, int stageAttemptId, int taskIndex, int partitionId)  { throw new RuntimeException(); }
}
