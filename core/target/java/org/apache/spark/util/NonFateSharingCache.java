package org.apache.spark.util;
  class NonFateSharingCache<K extends java.lang.Object, V extends java.lang.Object> {
  /**
   * This will return a NonFateSharingLoadingCache instance if user happens to pass a LoadingCache
   * @param cache (undocumented)
   * @return (undocumented)
   */
  static public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.util.NonFateSharingCache<K, V> apply (com.google.common.cache.Cache<K, V> cache)  { throw new RuntimeException(); }
  static public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.util.NonFateSharingLoadingCache<K, V> apply (com.google.common.cache.LoadingCache<K, V> loadingCache)  { throw new RuntimeException(); }
  /**
   * SPARK-44064 add this <code>apply</code> function to break non-core modules code directly using
   * Guava Cache related types as input parameter to invoke other <code>NonFateSharingCache#apply</code>
   * function, which can avoid non-core modules Maven test failures caused by using
   * shaded core module.
   * We should refactor this function to be more general when there are other requirements,
   * or remove this function when Maven testing is no longer supported.
   * @param loadingFunc (undocumented)
   * @param maximumSize (undocumented)
   * @return (undocumented)
   */
  static public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.util.NonFateSharingLoadingCache<K, V> apply (scala.Function1<K, V> loadingFunc, long maximumSize)  { throw new RuntimeException(); }
  static public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.util.NonFateSharingCache<K, V> apply (long maximumSize, long expireAfterAccessTime, java.util.concurrent.TimeUnit expireAfterAccessTimeUnit)  { throw new RuntimeException(); }
  protected  com.google.common.cache.Cache<K, V> cache ()  { throw new RuntimeException(); }
  // not preceding
  public   NonFateSharingCache (com.google.common.cache.Cache<K, V> cache)  { throw new RuntimeException(); }
  protected  org.apache.spark.util.KeyLock<K> keyLock ()  { throw new RuntimeException(); }
  public  V get (K key, java.util.concurrent.Callable<? extends V> valueLoader)  { throw new RuntimeException(); }
  public  V getIfPresent (Object key)  { throw new RuntimeException(); }
  public  void invalidate (Object key)  { throw new RuntimeException(); }
  public  void invalidateAll ()  { throw new RuntimeException(); }
  public  long size ()  { throw new RuntimeException(); }
}
