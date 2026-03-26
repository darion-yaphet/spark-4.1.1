package org.apache.spark.scheduler;
/** A result-yielding job was submitted on a target RDD */
  class JobSubmitted implements org.apache.spark.scheduler.DAGSchedulerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int jobId ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<?> finalRDD ()  { throw new RuntimeException(); }
  public  scala.Function2<org.apache.spark.TaskContext, scala.collection.Iterator<java.lang.Object>, ?> func ()  { throw new RuntimeException(); }
  public  int[] partitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.CallSite callSite ()  { throw new RuntimeException(); }
  public  org.apache.spark.scheduler.JobListener listener ()  { throw new RuntimeException(); }
  public  org.apache.spark.JobArtifactSet artifactSet ()  { throw new RuntimeException(); }
  public  java.util.Properties properties ()  { throw new RuntimeException(); }
  // not preceding
  public   JobSubmitted (int jobId, org.apache.spark.rdd.RDD<?> finalRDD, scala.Function2<org.apache.spark.TaskContext, scala.collection.Iterator<java.lang.Object>, ?> func, int[] partitions, org.apache.spark.util.CallSite callSite, org.apache.spark.scheduler.JobListener listener, org.apache.spark.JobArtifactSet artifactSet, java.util.Properties properties)  { throw new RuntimeException(); }
}
