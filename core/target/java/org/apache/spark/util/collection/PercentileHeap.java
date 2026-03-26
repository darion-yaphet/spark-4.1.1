package org.apache.spark.util.collection;
/**
 * PercentileHeap tracks the percentile of a collection of numbers.
 * <p>
 * Insertion is O(log n), Lookup is O(1).
 * <p>
 * The implementation keeps two heaps: a small heap (<code>smallHeap</code>) and a large heap (<code>largeHeap</code>).
 * The small heap stores all the numbers below the percentile and the large heap stores the ones
 * above the percentile. During insertion the relative sizes of the heaps are adjusted to match
 * the target percentile.
 */
  class PercentileHeap {
  public   PercentileHeap (double percentage)  { throw new RuntimeException(); }
  public  boolean isEmpty ()  { throw new RuntimeException(); }
  public  int size ()  { throw new RuntimeException(); }
  /**
   * Returns percentile of the inserted elements as if the inserted elements were sorted and we
   * returned <code>sorted(p)</code> where <code>p = (sorted.length * percentage).toInt</code>.
   * @return (undocumented)
   */
  public  double percentile ()  { throw new RuntimeException(); }
  public  void insert (double x)  { throw new RuntimeException(); }
}
