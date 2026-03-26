package org.apache.spark.streaming.scheduler;
  class BatchCleanupEvent implements org.apache.spark.streaming.scheduler.ReceivedBlockTrackerLogEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.streaming.Time> times ()  { throw new RuntimeException(); }
  // not preceding
  public   BatchCleanupEvent (scala.collection.immutable.Seq<org.apache.spark.streaming.Time> times)  { throw new RuntimeException(); }
}
