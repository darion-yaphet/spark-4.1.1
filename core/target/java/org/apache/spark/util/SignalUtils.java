package org.apache.spark.util;
/**
 * Contains utilities for working with posix signals.
 */
public  class SignalUtils {
  /** Register a signal handler to log signals on UNIX-like systems. */
  static public  void registerLogger (org.slf4j.Logger log)  { throw new RuntimeException(); }
  /**
   * Adds an action to be run when a given signal is received by this process.
   * <p>
   * Note that signals are only supported on unix-like operating systems and work on a best-effort
   * basis: if a signal is not available or cannot be intercepted, only a warning is emitted.
   * <p>
   * All actions for a given signal are run in a separate thread.
   * @param signal (undocumented)
   * @param action (undocumented)
   */
  static public  void register (java.lang.String signal, scala.Function0<java.lang.Object> action)  { throw new RuntimeException(); }
  /**
   * Adds an action to be run when a given signal is received by this process.
   * <p>
   * This method receives failMessage as additional parameter, which would be logged when it fails
   * to register the signal. Here the failures include the cases 1) OS doesn't support signal at
   * all 2) OS doesn't support given signal (Could be possible with non-POSIX signals)
   * <p>
   * All actions for a given signal are run in a separate thread.
   * @param signal (undocumented)
   * @param failMessage (undocumented)
   * @param logStackTrace (undocumented)
   * @param action (undocumented)
   */
  static public  void register (java.lang.String signal, org.apache.spark.internal.MessageWithContext failMessage, boolean logStackTrace, scala.Function0<java.lang.Object> action)  { throw new RuntimeException(); }
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
