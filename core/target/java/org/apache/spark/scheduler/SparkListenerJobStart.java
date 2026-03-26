package org.apache.spark.scheduler;
public  class SparkListenerJobStart implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int jobId ()  { throw new RuntimeException(); }
  public  long time ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.scheduler.StageInfo> stageInfos ()  { throw new RuntimeException(); }
  public  java.util.Properties properties ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerJobStart (int jobId, long time, scala.collection.immutable.Seq<org.apache.spark.scheduler.StageInfo> stageInfos, java.util.Properties properties)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.Object> stageIds ()  { throw new RuntimeException(); }
}
