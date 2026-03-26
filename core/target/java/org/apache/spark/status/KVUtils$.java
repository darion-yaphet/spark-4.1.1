package org.apache.spark.status;
public  class KVUtils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final KVUtils$ MODULE$ = null;
  public   KVUtils$ ()  { throw new RuntimeException(); }
  /**
   * Open or create a disk-based KVStore.
   * <p>
   * @param path Location of the store.
   * @param metadata Metadata value to compare to the data in the store. If the store does not
   *                 contain any metadata (e.g. it's a new store), this value is written as
   *                 the store's metadata.
   * @param conf SparkConf use to get <code>HYBRID_STORE_DISK_BACKEND</code>
   * @param live (undocumented)
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  public <M extends java.lang.Object> org.apache.spark.util.kvstore.KVStore open (java.io.File path, M metadata, org.apache.spark.SparkConf conf, boolean live, scala.reflect.ClassTag<M> evidence$1)  { throw new RuntimeException(); }
  public  org.apache.spark.status.KVUtils.KVStoreScalaSerializer serializerForHistoryServer (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.util.kvstore.KVStore createKVStore (scala.Option<java.io.File> storePath, boolean live, org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /** Turns a KVStoreView into a Scala sequence, applying a filter. */
  public <T extends java.lang.Object> scala.collection.immutable.Seq<T> viewToSeq (org.apache.spark.util.kvstore.KVStoreView<T> view, int max, scala.Function1<T, java.lang.Object> filter)  { throw new RuntimeException(); }
  /** Turns an interval of KVStoreView into a Scala sequence, applying a filter. */
  public <T extends java.lang.Object> scala.collection.immutable.Seq<T> viewToSeq (org.apache.spark.util.kvstore.KVStoreView<T> view, int from, int until, scala.Function1<T, java.lang.Object> filter)  { throw new RuntimeException(); }
  /** Turns a KVStoreView into a Scala sequence. */
  public <T extends java.lang.Object> scala.collection.immutable.Seq<T> viewToSeq (org.apache.spark.util.kvstore.KVStoreView<T> view)  { throw new RuntimeException(); }
  /** Counts the number of elements in the KVStoreView which satisfy a predicate. */
  public <T extends java.lang.Object> int count (org.apache.spark.util.kvstore.KVStoreView<T> view, scala.Function1<T, java.lang.Object> countFunc)  { throw new RuntimeException(); }
  /** Applies a function f to all values produced by KVStoreView. */
  public <T extends java.lang.Object> void foreach (org.apache.spark.util.kvstore.KVStoreView<T> view, scala.Function1<T, scala.runtime.BoxedUnit> foreachFunc)  { throw new RuntimeException(); }
  /** Maps all values of KVStoreView to new values using a transformation function. */
  public <T extends java.lang.Object, B extends java.lang.Object> scala.collection.immutable.Seq<B> mapToSeq (org.apache.spark.util.kvstore.KVStoreView<T> view, scala.Function1<T, B> mapFunc)  { throw new RuntimeException(); }
  /**
   * Maps all values of KVStoreView to new values using a transformation function
   * and filtered by a filter function.
   * @param view (undocumented)
   * @param max (undocumented)
   * @param mapFunc (undocumented)
   * @param filterFunc (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object, B extends java.lang.Object> scala.collection.immutable.Seq<B> mapToSeqWithFilter (org.apache.spark.util.kvstore.KVStoreView<T> view, int max, scala.Function1<T, B> mapFunc, scala.Function1<B, java.lang.Object> filterFunc)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> int size (org.apache.spark.util.kvstore.KVStoreView<T> view)  { throw new RuntimeException(); }
}
