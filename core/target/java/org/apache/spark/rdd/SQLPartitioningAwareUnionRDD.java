package org.apache.spark.rdd;
/**
 * This is similar to {@link PartitionerAwareUnionRDD}, but it doesn't require the parent RDDs
 * to have defined partitioner and have the same partitioner if defined.
 * It is because SQL's shuffle RDD's partitioner is not defined in <code>ShuffledRowRDD</code>.
 * The actual partitioning is implemented in <code>ShuffleExchangeExec.prepareShuffleDependency</code>.
 * <p>
 * Thus, this RDD doesn't check the partitioner of parent RDDs. Its correctness relies on the
 * fact that the given RDDs are partitioned in the same way. So before using this RDD, you must
 * ensure that all parent RDDs are partitioned correctly by checking their SQL output partitioning.
 */
  class SQLPartitioningAwareUnionRDD<T extends java.lang.Object> extends org.apache.spark.rdd.PartitionerAwareUnionRDDBase<T> {
  // not preceding
  public   SQLPartitioningAwareUnionRDD (org.apache.spark.SparkContext sc, scala.collection.immutable.Seq<org.apache.spark.rdd.RDD<T>> _rdds, int numPartitions, scala.reflect.ClassTag<T> evidence$3)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.rdd.RDD<T>> _rdds ()  { throw new RuntimeException(); }
  public  org.apache.spark.Partition[] getPartitions ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
}
