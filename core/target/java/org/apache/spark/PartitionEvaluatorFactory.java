package org.apache.spark;
/**
 * A factory to create {@link PartitionEvaluator}. Spark serializes and sends
 * {@link PartitionEvaluatorFactory} to executors, and then creates {@link PartitionEvaluator} via the
 * factory at the executor side.
 */
public  interface PartitionEvaluatorFactory<T extends java.lang.Object, U extends java.lang.Object> extends java.io.Serializable {
  /**
   * Creates a partition evaluator. Each RDD partition will create one evaluator instance, which
   * means one evaluator instance will be used by only one thread.
   * @return (undocumented)
   */
  public  org.apache.spark.PartitionEvaluator<T, U> createEvaluator ()  ;
}
