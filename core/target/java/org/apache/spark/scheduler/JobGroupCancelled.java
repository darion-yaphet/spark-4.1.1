package org.apache.spark.scheduler;
  class JobGroupCancelled implements org.apache.spark.scheduler.DAGSchedulerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String groupId ()  { throw new RuntimeException(); }
  public  boolean cancelFutureJobs ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> reason ()  { throw new RuntimeException(); }
  // not preceding
  public   JobGroupCancelled (java.lang.String groupId, boolean cancelFutureJobs, scala.Option<java.lang.String> reason)  { throw new RuntimeException(); }
}
