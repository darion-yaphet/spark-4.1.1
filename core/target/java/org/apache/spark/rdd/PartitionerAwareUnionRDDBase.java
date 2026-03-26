package org.apache.spark.rdd;
 abstract class PartitionerAwareUnionRDDBase<T extends java.lang.Object> extends org.apache.spark.rdd.RDD<T> {
  // not preceding
  public   PartitionerAwareUnionRDDBase (org.apache.spark.SparkContext sc, scala.collection.immutable.Seq<org.apache.spark.rdd.RDD<T>> rdds, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  public  void clearDependencies ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<T> compute (org.apache.spark.Partition s, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  public  org.apache.spark.Partition[] getPartitions ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> getPreferredLocations (org.apache.spark.Partition s)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.Partitioner> partitioner ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.rdd.RDD<T>> rdds ()  { throw new RuntimeException(); }
}
