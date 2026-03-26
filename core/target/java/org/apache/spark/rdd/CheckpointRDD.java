package org.apache.spark.rdd;
/**
 * An RDD that recovers checkpointed data from storage.
 */
 abstract class CheckpointRDD<T extends java.lang.Object> extends org.apache.spark.rdd.RDD<T> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   CheckpointRDD (org.apache.spark.SparkContext sc, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  public  void checkpoint ()  { throw new RuntimeException(); }
  public  void doCheckpoint ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.CheckpointRDD<T> localCheckpoint ()  { throw new RuntimeException(); }
}
