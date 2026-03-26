package org.apache.spark.rdd;
/**
 * Class representing an RDD that can take multiple RDDs partitioned by the same partitioner and
 * unify them into a single RDD while preserving the partitioner. So m RDDs with p partitions each
 * will be unified to a single RDD with p partitions and the same partitioner. The preferred
 * location for each partition of the unified RDD will be the most common preferred location
 * of the corresponding partitions of the parent RDDs. For example, location of partition 0
 * of the unified RDD will be where most of partition 0 of the parent RDDs are located.
 */
  class PartitionerAwareUnionRDD<T extends java.lang.Object> extends org.apache.spark.rdd.PartitionerAwareUnionRDDBase<T> {
  // not preceding
  public   PartitionerAwareUnionRDD (org.apache.spark.SparkContext sc, scala.collection.immutable.Seq<org.apache.spark.rdd.RDD<T>> _rdds, scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.rdd.RDD<T>> _rdds ()  { throw new RuntimeException(); }
}
