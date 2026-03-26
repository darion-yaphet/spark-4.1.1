package org.apache.spark.scheduler;
  class SpeculativeTaskSubmitted implements org.apache.spark.scheduler.DAGSchedulerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.scheduler.Task<?> task ()  { throw new RuntimeException(); }
  public  int taskIndex ()  { throw new RuntimeException(); }
  // not preceding
  public   SpeculativeTaskSubmitted (org.apache.spark.scheduler.Task<?> task, int taskIndex)  { throw new RuntimeException(); }
}
