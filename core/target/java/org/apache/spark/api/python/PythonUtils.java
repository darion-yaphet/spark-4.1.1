package org.apache.spark.api.python;
public  class PythonUtils {
  static public  java.lang.String PY4J_ZIP_NAME ()  { throw new RuntimeException(); }
  /** Get the PYTHONPATH for PySpark, either from SPARK_HOME, if it is set, or from our JAR */
  static public  java.lang.String sparkPythonPath ()  { throw new RuntimeException(); }
  /** Merge PYTHONPATHS with the appropriate separator. Ignores blank strings. */
  static public  java.lang.String mergePythonPaths (scala.collection.immutable.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
  static public  org.apache.spark.api.java.JavaRDD<java.lang.String> generateRDDWithNull (org.apache.spark.api.java.JavaSparkContext sc)  { throw new RuntimeException(); }
  /**
   * Convert list of T into seq of T (for calling API with varargs)
   * @param vs (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.collection.immutable.Seq<T> toSeq (java.util.List<T> vs)  { throw new RuntimeException(); }
  /**
   * Convert list of T into a (Scala) List of T
   * @param vs (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.collection.immutable.List<T> toList (java.util.List<T> vs)  { throw new RuntimeException(); }
  /**
   * Convert list of T into array of T (for calling API with array)
   * @param vs (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> java.lang.Object toArray (java.util.List<T> vs)  { throw new RuntimeException(); }
  /**
   * Convert java map of K, V into Map of K, V (for calling API with varargs)
   * @param jm (undocumented)
   * @return (undocumented)
   */
  static public <K extends java.lang.Object, V extends java.lang.Object> scala.collection.immutable.Map<K, V> toScalaMap (java.util.Map<K, V> jm)  { throw new RuntimeException(); }
  static public  boolean isEncryptionEnabled (org.apache.spark.api.java.JavaSparkContext sc)  { throw new RuntimeException(); }
  static public  long getBroadcastThreshold (org.apache.spark.api.java.JavaSparkContext sc)  { throw new RuntimeException(); }
  static public  long getPythonAuthSocketTimeout (org.apache.spark.api.java.JavaSparkContext sc)  { throw new RuntimeException(); }
  static public  int getSparkBufferSize (org.apache.spark.api.java.JavaSparkContext sc)  { throw new RuntimeException(); }
  static public  void logPythonInfo (java.lang.String pythonExec)  { throw new RuntimeException(); }
  static   scala.Option<java.lang.String> additionalTestingPath ()  { throw new RuntimeException(); }
  static   java.lang.String defaultPythonExec ()  { throw new RuntimeException(); }
  static   org.apache.spark.api.python.SimplePythonFunction createPythonFunction (byte[] command)  { throw new RuntimeException(); }
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
