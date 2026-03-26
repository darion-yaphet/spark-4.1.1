package org.apache.spark.scheduler;
/**
 * A NOT thread-safe set that only keeps the last <code>capacity</code> elements added to it.
 */
  class LimitedSizeFIFOSet<T extends java.lang.Object> {
  // not preceding
  public   LimitedSizeFIFOSet (int capacity)  { throw new RuntimeException(); }
  public  void add (T t)  { throw new RuntimeException(); }
  public  int capacity ()  { throw new RuntimeException(); }
  public  boolean contains (T t)  { throw new RuntimeException(); }
}
