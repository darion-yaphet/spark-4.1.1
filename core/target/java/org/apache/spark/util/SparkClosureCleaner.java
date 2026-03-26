package org.apache.spark.util;
public  class SparkClosureCleaner {
  /**
   * Clean the given closure in place.
   * <p>
   * More specifically, this renders the given closure serializable as long as it does not
   * explicitly reference unserializable objects.
   * <p>
   * @param closure           the closure to clean
   * @param checkSerializable whether to verify that the closure is serializable after cleaning
   * @param cleanTransitively whether to clean enclosing closures transitively
   */
  static public  void clean (java.lang.Object closure, boolean checkSerializable, boolean cleanTransitively)  { throw new RuntimeException(); }
}
