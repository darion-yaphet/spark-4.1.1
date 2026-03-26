package org.apache.spark.scheduler;
public  class SparkListenerApplicationEnd implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long time ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> exitCode ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerApplicationEnd (long time, scala.Option<java.lang.Object> exitCode)  { throw new RuntimeException(); }
}
