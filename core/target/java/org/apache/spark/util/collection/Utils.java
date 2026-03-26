package org.apache.spark.util.collection;
/**
 * Utility functions for collections.
 */
public  class Utils {
  /**
   * Returns the first K elements from the input as defined by the specified implicit Ordering[T]
   * and maintains the ordering.
   * @param input (undocumented)
   * @param num (undocumented)
   * @param ord (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.collection.Iterator<T> takeOrdered (scala.collection.Iterator<T> input, int num, scala.math.Ordering<T> ord)  { throw new RuntimeException(); }
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
  static public <T extends java.lang.Object> scala.collection.Iterator<T> mergeOrdered (scala.collection.Iterable<scala.collection.IterableOnce<T>> inputs, scala.math.Ordering<T> ord)  { throw new RuntimeException(); }
  /**
   * Only returns <code>Some</code> iff ALL elements in <code>input</code> are defined. In this case, it is
   * equivalent to <code>Some(input.flatten)</code>.
   * <p>
   * Otherwise, returns <code>None</code>.
   * @param input (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.Option<scala.collection.immutable.Seq<T>> sequenceToOption (scala.collection.immutable.Seq<scala.Option<T>> input)  { throw new RuntimeException(); }
  /**
   * Same function as <code>keys.zip(values).toMap</code>, but has perf gain.
   * @param keys (undocumented)
   * @param values (undocumented)
   * @return (undocumented)
   */
  static public <K extends java.lang.Object, V extends java.lang.Object> scala.collection.immutable.Map<K, V> toMap (scala.collection.Iterable<K> keys, scala.collection.Iterable<V> values)  { throw new RuntimeException(); }
  /**
   * Same function as <code>keys.zip(values).toMap.asJava</code>, but has perf gain.
   * @param keys (undocumented)
   * @param values (undocumented)
   * @return (undocumented)
   */
  static public <K extends java.lang.Object, V extends java.lang.Object> java.util.Map<K, V> toJavaMap (scala.collection.Iterable<K> keys, scala.collection.Iterable<V> values)  { throw new RuntimeException(); }
  static public <K extends java.lang.Object> scala.collection.immutable.Map<K, java.lang.Object> toMapWithIndex (scala.collection.Iterable<K> keys)  { throw new RuntimeException(); }
  static public <K extends java.lang.Object, V extends java.lang.Object> boolean isEmpty (java.util.Map<K, V> map)  { throw new RuntimeException(); }
  static public <K extends java.lang.Object, V extends java.lang.Object> boolean isNotEmpty (java.util.Map<K, V> map)  { throw new RuntimeException(); }
  static public <K extends java.lang.Object> java.lang.Object createArray (int size, K defaultValue, scala.reflect.ClassTag<K> evidence$1)  { throw new RuntimeException(); }
}
