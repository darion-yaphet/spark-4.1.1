package org.apache.spark.rdd;
  class ZippedPartitionsWithEvaluatorRDD<T extends java.lang.Object, U extends java.lang.Object> extends org.apache.spark.rdd.ZippedPartitionsBaseRDD<U> {
  // not preceding
  public   ZippedPartitionsWithEvaluatorRDD (org.apache.spark.rdd.RDD<T> rdd1, org.apache.spark.rdd.RDD<T> rdd2, org.apache.spark.PartitionEvaluatorFactory<T, U> evaluatorFactory, scala.reflect.ClassTag<T> evidence$1, scala.reflect.ClassTag<U> evidence$2)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<U> compute (org.apache.spark.Partition split, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<T> rdd1 ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<T> rdd2 ()  { throw new RuntimeException(); }
}
