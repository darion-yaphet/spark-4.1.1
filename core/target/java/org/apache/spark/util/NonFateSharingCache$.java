package org.apache.spark.util;
/**
 * SPARK-43300: Guava cache fate-sharing behavior might lead to unexpected cascade failure:
 * when multiple threads access the same key in the cache at the same time when the key is not in
 * the cache, Guava cache will block all requests and load the data only once. If the loading fails,
 * all requests will fail immediately without retry. Therefore individual failure will also fail
 * other irrelevant queries who are waiting for the same key. Given that spark can cancel tasks at
 * arbitrary times for many different reasons, fate sharing means that a task which gets canceled
 * while populating a cache entry can cause spurious failures in tasks from unrelated jobs -- even
 * though those tasks would have successfully populated the cache if they had been allowed to try.
 * <p>
 * This util Cache wrapper with KeyLock to synchronize threads looking for the same key
 * so that they should run individually and fail as if they had arrived one at a time.
 * <p>
 * There are so many ways to add cache entries in Guava Cache, instead of implementing Guava Cache
 * and LoadingCache interface, we expose a subset of APIs so that we can control at compile time
 * what cache operations are allowed.
 */
public  class NonFateSharingCache$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NonFateSharingCache$ MODULE$ = null;
  public   NonFateSharingCache$ ()  { throw new RuntimeException(); }
  /**
   * This will return a NonFateSharingLoadingCache instance if user happens to pass a LoadingCache
   * @param cache (undocumented)
   * @return (undocumented)
   */
  public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.util.NonFateSharingCache<K, V> apply (com.google.common.cache.Cache<K, V> cache)  { throw new RuntimeException(); }
  public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.util.NonFateSharingLoadingCache<K, V> apply (com.google.common.cache.LoadingCache<K, V> loadingCache)  { throw new RuntimeException(); }
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
  public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.util.NonFateSharingLoadingCache<K, V> apply (scala.Function1<K, V> loadingFunc, long maximumSize)  { throw new RuntimeException(); }
  public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.util.NonFateSharingCache<K, V> apply (long maximumSize, long expireAfterAccessTime, java.util.concurrent.TimeUnit expireAfterAccessTimeUnit)  { throw new RuntimeException(); }
}
