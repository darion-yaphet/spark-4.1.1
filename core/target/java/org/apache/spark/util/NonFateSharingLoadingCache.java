package org.apache.spark.util;
  class NonFateSharingLoadingCache<K extends java.lang.Object, V extends java.lang.Object> extends org.apache.spark.util.NonFateSharingCache<K, V> {
  // not preceding
  public   NonFateSharingLoadingCache (com.google.common.cache.LoadingCache<K, V> loadingCache)  { throw new RuntimeException(); }
  public  V get (K key)  { throw new RuntimeException(); }
  protected  com.google.common.cache.LoadingCache<K, V> loadingCache ()  { throw new RuntimeException(); }
}
