package org.apache.spark.memory;
/**
 * A {@link MemoryManager} that enforces a soft boundary between execution and storage such that
 * either side can borrow memory from the other.
 * <p>
 * The region shared between execution and storage is a fraction of (the total heap space - 300MB)
 * configurable through <code>spark.memory.fraction</code> (default 0.6). The position of the boundary
 * within this space is further determined by <code>spark.memory.storageFraction</code> (default 0.5).
 * This means the size of the storage region is 0.6 * 0.5 = 0.3 of the heap space by default.
 * <p>
 * Storage can borrow as much execution memory as is free until execution reclaims its space.
 * When this happens, cached blocks will be evicted from memory until sufficient borrowed
 * memory is released to satisfy the execution memory request.
 * <p>
 * Similarly, execution can borrow as much storage memory as is free. However, execution
 * memory is *never* evicted by storage due to the complexities involved in implementing this.
 * The implication is that attempts to cache blocks may fail if execution has already eaten
 * up most of the storage space, in which case the new blocks will be evicted immediately
 * according to their respective storage levels.
 * <p>
 * param:  onHeapStorageRegionSize Size of the storage region, in bytes.
 *                          This region is not statically reserved; execution can borrow from
 *                          it if necessary. Cached blocks can be evicted only if actual
 *                          storage memory usage exceeds this region.
 */
  class UnifiedMemoryManager extends org.apache.spark.memory.MemoryManager implements org.apache.spark.internal.Logging {
  /**
   * Returns the total unmanaged memory in bytes, including both
   * on-heap unmanaged memory and off-heap unmanaged memory.
   * @return (undocumented)
   */
  static   long getUnmanagedMemoryUsed ()  { throw new RuntimeException(); }
  /**
   * Register an unmanaged memory consumer to track its memory usage.
   * <p>
   * Unmanaged memory consumers are components that manage their own memory outside
   * of Spark's unified memory management system. By registering, their memory usage
   * will be periodically polled and factored into Spark's memory allocation decisions.
   * <p>
   * @param unmanagedMemoryConsumer The consumer to register for memory tracking
   */
  static public  void registerUnmanagedMemoryConsumer (org.apache.spark.memory.UnmanagedMemoryConsumer unmanagedMemoryConsumer)  { throw new RuntimeException(); }
  /**
   * Unregister an unmanaged memory consumer.
   * This should be called when a component is shutting down to prevent memory leaks
   * and ensure accurate memory tracking.
   * <p>
   * @param unmanagedMemoryConsumer The consumer to unregister. Only used in tests
   */
  static   void unregisterUnmanagedMemoryConsumer (org.apache.spark.memory.UnmanagedMemoryConsumer unmanagedMemoryConsumer)  { throw new RuntimeException(); }
  /**
   * Get the current memory usage in bytes for a specific component type.
   * @param componentType The type of component to filter by (e.g., "RocksDB")
   * @return Total memory usage in bytes for the specified component type
   */
  static public  long getMemoryByComponentType (java.lang.String componentType)  { throw new RuntimeException(); }
  /**
   * Clear all unmanaged memory users.
   * This is useful during executor shutdown or cleanup.
   * Since each executor runs in its own JVM, this clears all users for this executor.
   */
  static public  void clearUnmanagedMemoryUsers ()  { throw new RuntimeException(); }
  /**
   * Start unmanaged memory polling if not already started.
   * This ensures only one polling thread is created per JVM, regardless of how many
   * UnifiedMemoryManager instances are created.
   * @param pollingIntervalMs (undocumented)
   */
  static   void startPollingIfNeeded (long pollingIntervalMs)  { throw new RuntimeException(); }
  /**
   * Shutdown the unmanaged memory polling thread. Only used in tests
   */
  static   void shutdownUnmanagedMemoryPoller ()  { throw new RuntimeException(); }
  static public  org.apache.spark.memory.UnifiedMemoryManager apply (org.apache.spark.SparkConf conf, int numCores)  { throw new RuntimeException(); }
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
  public  long maxHeapMemory ()  { throw new RuntimeException(); }
  // not preceding
  public   UnifiedMemoryManager (org.apache.spark.SparkConf conf, long maxHeapMemory, long onHeapStorageRegionSize, int numCores)  { throw new RuntimeException(); }
  public  long maxOnHeapStorageMemory ()  { throw new RuntimeException(); }
  public  long maxOffHeapStorageMemory ()  { throw new RuntimeException(); }
  /**
   * Try to acquire up to <code>numBytes</code> of execution memory for the current task and return the
   * number of bytes obtained, or 0 if none can be allocated.
   * <p>
   * This call may block until there is enough free memory in some situations, to make sure each
   * task has a chance to ramp up to at least 1 / 2N of the total memory pool (where N is the # of
   * active tasks) before it is forced to spill. This can happen if the number of tasks increase
   * but an older task had a lot of memory already.
   * @param numBytes (undocumented)
   * @param taskAttemptId (undocumented)
   * @param memoryMode (undocumented)
   * @return (undocumented)
   */
    long acquireExecutionMemory (long numBytes, long taskAttemptId, org.apache.spark.memory.MemoryMode memoryMode)  { throw new RuntimeException(); }
  public  boolean acquireStorageMemory (org.apache.spark.storage.BlockId blockId, long numBytes, org.apache.spark.memory.MemoryMode memoryMode)  { throw new RuntimeException(); }
  public  boolean acquireUnrollMemory (org.apache.spark.storage.BlockId blockId, long numBytes, org.apache.spark.memory.MemoryMode memoryMode)  { throw new RuntimeException(); }
}
