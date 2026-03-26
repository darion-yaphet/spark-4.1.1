package org.apache.spark.util.collection;
/**
 * Utility functions for collections.
 */
public  class Utils$ implements org.apache.spark.util.SparkCollectionUtils {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Utils$ MODULE$ = null;
  public   Utils$ ()  { throw new RuntimeException(); }
  /**
   * Returns the first K elements from the input as defined by the specified implicit Ordering[T]
   * and maintains the ordering.
   * @param input (undocumented)
   * @param num (undocumented)
   * @param ord (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.collection.Iterator<T> takeOrdered (scala.collection.Iterator<T> input, int num, scala.math.Ordering<T> ord)  { throw new RuntimeException(); }
  /**
   * Returns an iterator over the merged contents of all given input iterators,
   * traversing every element of the input iterators.
   * Equivalent entries will not be de-duplicated.
   * <p>
   * Callers must ensure that all the input iterators are already sorted by
   * the same ordering <code>ord</code>, otherwise the result is likely to be incorrect.
   * @param inputs (undocumented)
   * @param ord (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.collection.Iterator<T> mergeOrdered (scala.collection.Iterable<scala.collection.IterableOnce<T>> inputs, scala.math.Ordering<T> ord)  { throw new RuntimeException(); }
  /**
   * Only returns <code>Some</code> iff ALL elements in <code>input</code> are defined. In this case, it is
   * equivalent to <code>Some(input.flatten)</code>.
   * <p>
   * Otherwise, returns <code>None</code>.
   * @param input (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.Option<scala.collection.immutable.Seq<T>> sequenceToOption (scala.collection.immutable.Seq<scala.Option<T>> input)  { throw new RuntimeException(); }
  /**
   * Same function as <code>keys.zip(values).toMap</code>, but has perf gain.
   * @param keys (undocumented)
   * @param values (undocumented)
   * @return (undocumented)
   */
  public <K extends java.lang.Object, V extends java.lang.Object> scala.collection.immutable.Map<K, V> toMap (scala.collection.Iterable<K> keys, scala.collection.Iterable<V> values)  { throw new RuntimeException(); }
  /**
   * Same function as <code>keys.zip(values).toMap.asJava</code>, but has perf gain.
   * @param keys (undocumented)
   * @param values (undocumented)
   * @return (undocumented)
   */
  public <K extends java.lang.Object, V extends java.lang.Object> java.util.Map<K, V> toJavaMap (scala.collection.Iterable<K> keys, scala.collection.Iterable<V> values)  { throw new RuntimeException(); }
}
