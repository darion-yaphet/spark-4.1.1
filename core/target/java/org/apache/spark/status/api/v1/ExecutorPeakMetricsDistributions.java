package org.apache.spark.status.api.v1;
public  class ExecutorPeakMetricsDistributions {
  // not preceding
     ExecutorPeakMetricsDistributions (scala.collection.immutable.IndexedSeq<java.lang.Object> quantiles, scala.collection.immutable.IndexedSeq<org.apache.spark.executor.ExecutorMetrics> executorMetrics)  { throw new RuntimeException(); }
  public  scala.collection.immutable.IndexedSeq<org.apache.spark.executor.ExecutorMetrics> executorMetrics ()  { throw new RuntimeException(); }
  /** Returns the distributions for the specified metric. */
  public  scala.collection.immutable.IndexedSeq<java.lang.Object> getMetricDistribution (java.lang.String metricName)  { throw new RuntimeException(); }
  public  scala.collection.immutable.IndexedSeq<java.lang.Object> quantiles ()  { throw new RuntimeException(); }
}
