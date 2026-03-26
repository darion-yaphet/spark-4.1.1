package org.apache.spark.scheduler;
public  class SparkListenerBlockUpdated implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.storage.BlockUpdatedInfo blockUpdatedInfo ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerBlockUpdated (org.apache.spark.storage.BlockUpdatedInfo blockUpdatedInfo)  { throw new RuntimeException(); }
}
