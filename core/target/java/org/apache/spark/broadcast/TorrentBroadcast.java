package org.apache.spark.broadcast;
/**
 * A BitTorrent-like implementation of {@link org.apache.spark.broadcast.Broadcast}.
 * {@link org.apache.spark.broadcast.Broadcast} &#x7684;&#x7c7b; BitTorrent &#x5b9e;&#x73b0;&#x3002;
 * <p>
 * The mechanism is as follows:
 * &#x673a;&#x5236;&#x5982;&#x4e0b;&#xff1a;
 * <p>
 * The driver divides the serialized object into small chunks and
 * stores those chunks in the BlockManager of the driver.
 * Driver &#x5c06;&#x5e8f;&#x5217;&#x5316;&#x540e;&#x7684;&#x5bf9;&#x8c61;&#x5207;&#x5206;&#x6210;&#x82e5;&#x5e72;&#x4e2a;&#x5c0f;&#x5757;&#xff0c;&#x5e76;&#x5c06;&#x8fd9;&#x4e9b;&#x5757;&#x5b58;&#x50a8;&#x5728;&#x81ea;&#x8eab;&#x7684; BlockManager &#x4e2d;&#x3002;
 * <p>
 * On each executor, the executor first attempts to fetch the object from its BlockManager. If
 * it does not exist, it then uses remote fetches to fetch the small chunks from the driver and/or
 * other executors if available. Once it gets the chunks, it puts the chunks in its own
 * BlockManager, ready for other executors to fetch from.
 * &#x5728;&#x6bcf;&#x4e2a; Executor &#x4e0a;&#xff0c;Executor &#x5c1d;&#x8bd5;&#x5148;&#x4ece;&#x81ea;&#x8eab;&#x7684; BlockManager &#x83b7;&#x53d6;&#x8be5;&#x5bf9;&#x8c61;&#x3002;
 * &#x5982;&#x679c;&#x4e0d;&#x5b58;&#x5728;&#xff0c;&#x5b83;&#x4f1a;&#x901a;&#x8fc7;&#x8fdc;&#x7a0b;&#x83b7;&#x53d6;&#x4ece; Driver &#x6216;&#x5176;&#x4ed6;&#x53ef;&#x7528;&#x7684; Executor &#x5904;&#x4e0b;&#x8f7d;&#x5c0f;&#x5757;&#x3002;
 * &#x4e00;&#x65e6;&#x83b7;&#x53d6;&#x4e86;&#x6240;&#x6709;&#x5757;&#xff0c;&#x5b83;&#x4f1a;&#x5c06;&#x8fd9;&#x4e9b;&#x5757;&#x653e;&#x5165;&#x81ea;&#x8eab;&#x7684; BlockManager&#xff0c;&#x4f9b;&#x5176;&#x4ed6; Executor &#x4e0b;&#x8f7d;&#x3002;
 * <p>
 * This prevents the driver from being the bottleneck in sending out multiple copies of the
 * broadcast data (one per executor).
 * &#x8fd9;&#x9632;&#x6b62;&#x4e86;&#x5728;&#x5411;&#x591a;&#x53f0; Executor &#x53d1;&#x9001;&#x5e7f;&#x64ad;&#x6570;&#x636e;&#x526f;&#x672c;&#x65f6;&#xff0c;Driver &#x6210;&#x4e3a;&#x7f51;&#x7edc;&#x74f6;&#x9888;&#x3002;
 * <p>
 * When initialized, TorrentBroadcast objects read SparkEnv.get.conf.
 * &#x5728;&#x521d;&#x59cb;&#x5316;&#x65f6;&#xff0c;TorrentBroadcast &#x5bf9;&#x8c61;&#x4f1a;&#x8bfb;&#x53d6; SparkEnv.get.conf&#x3002;
 * <p>
 * param:  obj object to broadcast
 *            &#x8981;&#x5e7f;&#x64ad;&#x7684;&#x5bf9;&#x8c61;&#x3002;
 * param:  id A unique identifier for the broadcast variable.
 *           &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x7684;&#x552f;&#x4e00;&#x6807;&#x8bc6;&#x7b26;&#x3002;
 * param:  serializedOnly if true, do not cache the unserialized value on the driver
 *                       &#x5982;&#x679c;&#x4e3a; true&#xff0c;&#x5219;&#x4e0d;&#x5728; Driver &#x4e0a;&#x7f13;&#x5b58;&#x672a;&#x5e8f;&#x5217;&#x5316;&#x7684;&#x503c;&#x3002;
 */
  class TorrentBroadcast<T extends java.lang.Object> extends org.apache.spark.broadcast.Broadcast<T> implements org.apache.spark.internal.Logging, java.io.Serializable {
  /**
   * Serialize and divide an object into blocks.
   * &#x5c06;&#x5bf9;&#x8c61;&#x5e8f;&#x5217;&#x5316;&#x5e76;&#x5206;&#x5272;&#x6210;&#x591a;&#x4e2a;&#x5757;&#x3002;
   * @param obj (undocumented)
   * @param blockSize (undocumented)
   * @param serializer (undocumented)
   * @param compressionCodec (undocumented)
   * @param evidence$2 (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> java.nio.ByteBuffer[] blockifyObject (T obj, int blockSize, org.apache.spark.serializer.Serializer serializer, scala.Option<org.apache.spark.io.CompressionCodec> compressionCodec, scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
  /**
   * Deserialize and reconstruct an object from blocks.
   * &#x4ece;&#x4e00;&#x7cfb;&#x5217;&#x5757;&#x4e2d;&#x53cd;&#x5e8f;&#x5217;&#x5316;&#x5e76;&#x91cd;&#x5efa;&#x5bf9;&#x8c61;&#x3002;
   * @param blocks (undocumented)
   * @param serializer (undocumented)
   * @param compressionCodec (undocumented)
   * @param evidence$3 (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> T unBlockifyObject (java.io.InputStream[] blocks, org.apache.spark.serializer.Serializer serializer, scala.Option<org.apache.spark.io.CompressionCodec> compressionCodec, scala.reflect.ClassTag<T> evidence$3)  { throw new RuntimeException(); }
  /**
   * Remove all persisted blocks associated with this torrent broadcast on the executors.
   * If removeFromDriver is true, also remove these persisted blocks on the driver.
   * &#x79fb;&#x9664; Executor &#x4e0a;&#x4e0e;&#x6b64; Torrent &#x5e7f;&#x64ad;&#x76f8;&#x5173;&#x7684;&#x6240;&#x6709;&#x6301;&#x4e45;&#x5316;&#x5757;&#x3002;
   * &#x5982;&#x679c; removeFromDriver &#x4e3a; true&#xff0c;&#x5219;&#x540c;&#x65f6;&#x79fb;&#x9664; Driver &#x4e0a;&#x7684;&#x8fd9;&#x4e9b;&#x6301;&#x4e45;&#x5316;&#x5757;&#x3002;
   * @param id (undocumented)
   * @param removeFromDriver (undocumented)
   * @param blocking (undocumented)
   */
  static public  void unpersist (long id, boolean removeFromDriver, boolean blocking)  { throw new RuntimeException(); }
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
  // not preceding
  public   TorrentBroadcast (T obj, long id, boolean serializedOnly, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  /**
   * Called by Broadcast.value to get or reconstruct the broadcasted object.
   * &#x88ab; Broadcast.value &#x8c03;&#x7528;&#xff0c;&#x7528;&#x4e8e;&#x83b7;&#x53d6;&#x6216;&#x91cd;&#x5efa;&#x5e7f;&#x64ad;&#x5bf9;&#x8c61;&#x3002;
   * @return (undocumented)
   */
  protected  T getValue ()  { throw new RuntimeException(); }
  /**
   * Remove all persisted state associated with this Torrent broadcast on the executors.
   * &#x79fb;&#x9664; Executor &#x4e0a;&#x4e0e;&#x6b64; Torrent &#x5e7f;&#x64ad;&#x76f8;&#x5173;&#x7684;&#x6240;&#x6709;&#x6301;&#x4e45;&#x5316;&#x72b6;&#x6001;&#x3002;
   * @param blocking (undocumented)
   */
  protected  void doUnpersist (boolean blocking)  { throw new RuntimeException(); }
  /**
   * Remove all persisted state associated with this Torrent broadcast on the executors
   * and driver.
   * &#x79fb;&#x9664; Executor &#x548c; Driver &#x4e0a;&#x4e0e;&#x6b64; Torrent &#x5e7f;&#x64ad;&#x76f8;&#x5173;&#x7684;&#x6240;&#x6709;&#x6301;&#x4e45;&#x5316;&#x72b6;&#x6001;&#x3002;
   * @param blocking (undocumented)
   */
  protected  void doDestroy (boolean blocking)  { throw new RuntimeException(); }
    boolean hasCachedValue ()  { throw new RuntimeException(); }
}
