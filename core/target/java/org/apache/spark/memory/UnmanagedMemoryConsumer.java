package org.apache.spark.memory;
/**
 * Interface for components that consume memory outside of Spark's unified memory management.
 * <p>
 * Components implementing this trait can register themselves with the memory manager
 * to have their memory usage tracked and factored into memory allocation decisions.
 * This helps prevent OOM errors when unmanaged components use significant memory.
 * <p>
 * Examples of unmanaged memory consumers:
 * - RocksDB state stores in structured streaming
 * - Native libraries with custom memory allocation
 * - Off-heap caches managed outside of Spark
 */
public  interface UnmanagedMemoryConsumer {
  /**
   * Returns the current memory usage in bytes.
   * <p>
   * This method is called periodically by the memory polling mechanism to track
   * memory usage over time. Implementations should return the current total memory
   * consumed by this component.
   * <p>
   * @return Current memory usage in bytes. Should return 0 if no memory is currently used.
   *         Return -1L to indicate this consumer is no longer active and should be
   *         automatically removed from tracking.
   * @throws Exception if memory usage cannot be determined. The polling mechanism
   *                   will handle exceptions gracefully and log warnings.
   */
  public  long getMemBytesUsed ()  ;
  /**
   * Returns the memory mode (ON_HEAP or OFF_HEAP) that this consumer uses.
   * This is used to ensure unmanaged memory usage only affects the correct memory pool.
   * @return (undocumented)
   */
  public  org.apache.spark.memory.MemoryMode memoryMode ()  ;
  /**
   * Returns the unique identifier for this memory consumer.
   * The identifier is used to track and manage the consumer in the memory tracking system.
   * @return (undocumented)
   */
  public  org.apache.spark.memory.UnmanagedMemoryConsumerId unmanagedMemoryConsumerId ()  ;
}
