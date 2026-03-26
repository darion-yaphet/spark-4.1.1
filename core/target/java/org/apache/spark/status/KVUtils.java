package org.apache.spark.status;
public  class KVUtils {
  /**
   * A KVStoreSerializer that provides Scala types serialization too, and uses the same options as
   * the API serializer.
   */
  static   class KVStoreScalaSerializer extends org.apache.spark.util.kvstore.KVStoreSerializer {
    public   KVStoreScalaSerializer ()  { throw new RuntimeException(); }
  }
  static   class MetadataMismatchException extends java.lang.Exception {
    public   MetadataMismatchException ()  { throw new RuntimeException(); }
  }
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
  static public <M extends java.lang.Object> org.apache.spark.util.kvstore.KVStore open (java.io.File path, M metadata, org.apache.spark.SparkConf conf, boolean live, scala.reflect.ClassTag<M> evidence$1)  { throw new RuntimeException(); }
  static public  org.apache.spark.status.KVUtils.KVStoreScalaSerializer serializerForHistoryServer (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  static public  org.apache.spark.util.kvstore.KVStore createKVStore (scala.Option<java.io.File> storePath, boolean live, org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /** Turns a KVStoreView into a Scala sequence, applying a filter. */
  static public <T extends java.lang.Object> scala.collection.immutable.Seq<T> viewToSeq (org.apache.spark.util.kvstore.KVStoreView<T> view, int max, scala.Function1<T, java.lang.Object> filter)  { throw new RuntimeException(); }
  /** Turns an interval of KVStoreView into a Scala sequence, applying a filter. */
  static public <T extends java.lang.Object> scala.collection.immutable.Seq<T> viewToSeq (org.apache.spark.util.kvstore.KVStoreView<T> view, int from, int until, scala.Function1<T, java.lang.Object> filter)  { throw new RuntimeException(); }
  /** Turns a KVStoreView into a Scala sequence. */
  static public <T extends java.lang.Object> scala.collection.immutable.Seq<T> viewToSeq (org.apache.spark.util.kvstore.KVStoreView<T> view)  { throw new RuntimeException(); }
  /** Counts the number of elements in the KVStoreView which satisfy a predicate. */
  static public <T extends java.lang.Object> int count (org.apache.spark.util.kvstore.KVStoreView<T> view, scala.Function1<T, java.lang.Object> countFunc)  { throw new RuntimeException(); }
  /** Applies a function f to all values produced by KVStoreView. */
  static public <T extends java.lang.Object> void foreach (org.apache.spark.util.kvstore.KVStoreView<T> view, scala.Function1<T, scala.runtime.BoxedUnit> foreachFunc)  { throw new RuntimeException(); }
  /** Maps all values of KVStoreView to new values using a transformation function. */
  static public <T extends java.lang.Object, B extends java.lang.Object> scala.collection.immutable.Seq<B> mapToSeq (org.apache.spark.util.kvstore.KVStoreView<T> view, scala.Function1<T, B> mapFunc)  { throw new RuntimeException(); }
  /**
   * Maps all values of KVStoreView to new values using a transformation function
   * and filtered by a filter function.
   * @param view (undocumented)
   * @param max (undocumented)
   * @param mapFunc (undocumented)
   * @param filterFunc (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object, B extends java.lang.Object> scala.collection.immutable.Seq<B> mapToSeqWithFilter (org.apache.spark.util.kvstore.KVStoreView<T> view, int max, scala.Function1<T, B> mapFunc, scala.Function1<B, java.lang.Object> filterFunc)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> int size (org.apache.spark.util.kvstore.KVStoreView<T> view)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.Logging.LogStringContext LogStringContext (scala.StringContext sc)  { throw new RuntimeException(); }
  static protected  void withLogContext (java.util.Map<java.lang.String, java.lang.String> context, scala.Function0<scala.runtime.BoxedUnit> body)  { throw new RuntimeException(); }
  static protected  org.apache.spark.internal.MDC MDC (org.apache.spark.internal.LogKey key, Object value)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logInfo (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logDebug (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logTrace (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logWarning (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logError (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void logBasedOnLevel (org.slf4j.event.Level level, scala.Function0<org.apache.spark.internal.MessageWithContext> f)  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
}
