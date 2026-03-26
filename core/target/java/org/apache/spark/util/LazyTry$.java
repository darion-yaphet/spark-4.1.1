package org.apache.spark.util;
public  class LazyTry$ implements java.io.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final LazyTry$ MODULE$ = null;
  public   LazyTry$ ()  { throw new RuntimeException(); }
  /**
   * Create a new LazyTry instance.
   * <p>
   * @param initialize The block of code to initialize the lazy value.
   * @tparam T type of the lazy value.
   * @return a new LazyTry instance.
   */
  public <T extends java.lang.Object> org.apache.spark.util.LazyTry<T> apply (scala.Function0<T> initialize)  { throw new RuntimeException(); }
}
