package org.apache.spark.scheduler;
  class StageFailed implements org.apache.spark.scheduler.DAGSchedulerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int stageId ()  { throw new RuntimeException(); }
  public  java.lang.String reason ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Throwable> exception ()  { throw new RuntimeException(); }
  // not preceding
  public   StageFailed (int stageId, java.lang.String reason, scala.Option<java.lang.Throwable> exception)  { throw new RuntimeException(); }
}
