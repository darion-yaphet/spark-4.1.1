package org.apache.spark.memory;
public  class UnifiedMemoryManager$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UnifiedMemoryManager$ MODULE$ = null;
  public   UnifiedMemoryManager$ ()  { throw new RuntimeException(); }
  /**
   * Returns the total unmanaged memory in bytes, including both
   * on-heap unmanaged memory and off-heap unmanaged memory.
   * @return (undocumented)
   */
    long getUnmanagedMemoryUsed ()  { throw new RuntimeException(); }
  /**
   * Register an unmanaged memory consumer to track its memory usage.
   * <p>
   * Unmanaged memory consumers are components that manage their own memory outside
   * of Spark's unified memory management system. By registering, their memory usage
   * will be periodically polled and factored into Spark's memory allocation decisions.
   * <p>
   * @param unmanagedMemoryConsumer The consumer to register for memory tracking
   */
  public  void registerUnmanagedMemoryConsumer (org.apache.spark.memory.UnmanagedMemoryConsumer unmanagedMemoryConsumer)  { throw new RuntimeException(); }
  /**
   * Unregister an unmanaged memory consumer.
   * This should be called when a component is shutting down to prevent memory leaks
   * and ensure accurate memory tracking.
   * <p>
   * @param unmanagedMemoryConsumer The consumer to unregister. Only used in tests
   */
    void unregisterUnmanagedMemoryConsumer (org.apache.spark.memory.UnmanagedMemoryConsumer unmanagedMemoryConsumer)  { throw new RuntimeException(); }
  /**
   * Get the current memory usage in bytes for a specific component type.
   * @param componentType The type of component to filter by (e.g., "RocksDB")
   * @return Total memory usage in bytes for the specified component type
   */
  public  long getMemoryByComponentType (java.lang.String componentType)  { throw new RuntimeException(); }
  /**
   * Clear all unmanaged memory users.
   * This is useful during executor shutdown or cleanup.
   * Since each executor runs in its own JVM, this clears all users for this executor.
   */
  public  void clearUnmanagedMemoryUsers ()  { throw new RuntimeException(); }
  /**
   * Start unmanaged memory polling if not already started.
   * This ensures only one polling thread is created per JVM, regardless of how many
   * UnifiedMemoryManager instances are created.
   * @param pollingIntervalMs (undocumented)
   */
    void startPollingIfNeeded (long pollingIntervalMs)  { throw new RuntimeException(); }
  /**
   * Shutdown the unmanaged memory polling thread. Only used in tests
   */
    void shutdownUnmanagedMemoryPoller ()  { throw new RuntimeException(); }
  public  org.apache.spark.memory.UnifiedMemoryManager apply (org.apache.spark.SparkConf conf, int numCores)  { throw new RuntimeException(); }
}
