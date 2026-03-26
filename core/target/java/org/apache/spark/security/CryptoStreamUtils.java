package org.apache.spark.security;
/**
 * A util class for manipulating IO encryption and decryption streams.
 */
public  class CryptoStreamUtils {
  static public  int IV_LENGTH_IN_BYTES ()  { throw new RuntimeException(); }
  static public  java.lang.String SPARK_IO_ENCRYPTION_COMMONS_CONFIG_PREFIX ()  { throw new RuntimeException(); }
  /**
   * Helper method to wrap <code>OutputStream</code> with <code>CryptoOutputStream</code> for encryption.
   * @param os (undocumented)
   * @param sparkConf (undocumented)
   * @param key (undocumented)
   * @return (undocumented)
   */
  static public  java.io.OutputStream createCryptoOutputStream (java.io.OutputStream os, org.apache.spark.SparkConf sparkConf, byte[] key)  { throw new RuntimeException(); }
  /**
   * Wrap a <code>WritableByteChannel</code> for encryption.
   * @param channel (undocumented)
   * @param sparkConf (undocumented)
   * @param key (undocumented)
   * @return (undocumented)
   */
  static public  java.nio.channels.WritableByteChannel createWritableChannel (java.nio.channels.WritableByteChannel channel, org.apache.spark.SparkConf sparkConf, byte[] key)  { throw new RuntimeException(); }
  /**
   * Helper method to wrap <code>InputStream</code> with <code>CryptoInputStream</code> for decryption.
   * @param is (undocumented)
   * @param sparkConf (undocumented)
   * @param key (undocumented)
   * @return (undocumented)
   */
  static public  java.io.InputStream createCryptoInputStream (java.io.InputStream is, org.apache.spark.SparkConf sparkConf, byte[] key)  { throw new RuntimeException(); }
  /**
   * Wrap a <code>ReadableByteChannel</code> for decryption.
   * @param channel (undocumented)
   * @param sparkConf (undocumented)
   * @param key (undocumented)
   * @return (undocumented)
   */
  static public  java.nio.channels.ReadableByteChannel createReadableChannel (java.nio.channels.ReadableByteChannel channel, org.apache.spark.SparkConf sparkConf, byte[] key)  { throw new RuntimeException(); }
  static public  java.util.Properties toCryptoConf (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /**
   * Creates a new encryption key.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  byte[] createKey (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
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
