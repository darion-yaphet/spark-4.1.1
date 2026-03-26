package org.apache.spark;
/**
 * An evaluator for computing RDD partitions. Spark serializes and sends
 * {@link PartitionEvaluatorFactory} to executors, and then creates {@link PartitionEvaluator} via the
 * factory at the executor side.
 */
public  interface PartitionEvaluator<T extends java.lang.Object, U extends java.lang.Object> {
  /**
   * Evaluates the RDD partition at the given index. There can be more than one input iterator,
   * if the RDD was zipped from multiple RDDs.
   * @param partitionIndex (undocumented)
   * @param inputs (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<U> eval (int partitionIndex, scala.collection.immutable.Seq<scala.collection.Iterator<T>> inputs)  ;
}
