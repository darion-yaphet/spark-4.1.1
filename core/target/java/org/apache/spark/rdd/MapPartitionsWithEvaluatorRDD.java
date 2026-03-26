package org.apache.spark.rdd;
  class MapPartitionsWithEvaluatorRDD<T extends java.lang.Object, U extends java.lang.Object> extends org.apache.spark.rdd.RDD<U> {
  // not preceding
  public   MapPartitionsWithEvaluatorRDD (org.apache.spark.rdd.RDD<T> prev, org.apache.spark.PartitionEvaluatorFactory<T, U> evaluatorFactory, scala.reflect.ClassTag<T> evidence$1, scala.reflect.ClassTag<U> evidence$2)  { throw new RuntimeException(); }
  public  void clearDependencies ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<U> compute (org.apache.spark.Partition split, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  public  org.apache.spark.Partition[] getPartitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<T> prev ()  { throw new RuntimeException(); }
}
