package org.apache.spark.util;
/**
 * Test non-fate-sharing behavior
 */
public  class NonFateSharingCacheSuite extends org.apache.spark.SparkFunSuite {
  static public  interface InternalTestStatus {
    public  java.lang.ThreadLocal<java.lang.Object> intentionalFail ()  ;
    public  java.util.concurrent.Semaphore startLoading ()  ;
    public  void waitUntilThread2Waiting ()  ;
  }
  static public  class TestCacheLoader extends com.google.common.cache.CacheLoader<java.lang.String, java.lang.String> implements org.apache.spark.util.NonFateSharingCacheSuite.InternalTestStatus {
    public   TestCacheLoader ()  { throw new RuntimeException(); }
    public  java.lang.ThreadLocal<java.lang.Object> intentionalFail ()  { throw new RuntimeException(); }
    public  java.lang.String load (java.lang.String key)  { throw new RuntimeException(); }
    public  java.util.concurrent.Semaphore startLoading ()  { throw new RuntimeException(); }
  }
  static public  class TestLoaderFunc implements org.apache.spark.util.NonFateSharingCacheSuite.InternalTestStatus {
    public   TestLoaderFunc ()  { throw new RuntimeException(); }
    public  scala.Function1<java.lang.String, java.lang.String> func ()  { throw new RuntimeException(); }
    public  java.lang.ThreadLocal<java.lang.Object> intentionalFail ()  { throw new RuntimeException(); }
    public  java.util.concurrent.Semaphore startLoading ()  { throw new RuntimeException(); }
  }
  public   NonFateSharingCacheSuite ()  { throw new RuntimeException(); }
  public  void testImpl (org.apache.spark.util.NonFateSharingCache<java.lang.String, java.lang.String> cache, org.apache.spark.util.NonFateSharingCacheSuite.InternalTestStatus internalTestStatus, scala.Function0<scala.runtime.BoxedUnit> thread1Task, scala.Function0<scala.runtime.BoxedUnit> thread2Task)  { throw new RuntimeException(); }
}
