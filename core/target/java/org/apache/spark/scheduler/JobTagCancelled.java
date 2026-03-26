package org.apache.spark.scheduler;
  class JobTagCancelled implements org.apache.spark.scheduler.DAGSchedulerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String tagName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> reason ()  { throw new RuntimeException(); }
  public  scala.Option<scala.concurrent.Promise<scala.collection.immutable.Seq<org.apache.spark.scheduler.ActiveJob>>> cancelledJobs ()  { throw new RuntimeException(); }
  // not preceding
  public   JobTagCancelled (java.lang.String tagName, scala.Option<java.lang.String> reason, scala.Option<scala.concurrent.Promise<scala.collection.immutable.Seq<org.apache.spark.scheduler.ActiveJob>>> cancelledJobs)  { throw new RuntimeException(); }
}
