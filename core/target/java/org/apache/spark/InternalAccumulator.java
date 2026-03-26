package org.apache.spark;
/**
 * A collection of fields and methods concerned with internal accumulators that represent
 * task level metrics.
 */
public  class InternalAccumulator {
  static public  class shuffleRead$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final shuffleRead$ MODULE$ = null;
    public   shuffleRead$ ()  { throw new RuntimeException(); }
    public  java.lang.String REMOTE_BLOCKS_FETCHED ()  { throw new RuntimeException(); }
    public  java.lang.String LOCAL_BLOCKS_FETCHED ()  { throw new RuntimeException(); }
    public  java.lang.String REMOTE_BYTES_READ ()  { throw new RuntimeException(); }
    public  java.lang.String REMOTE_BYTES_READ_TO_DISK ()  { throw new RuntimeException(); }
    public  java.lang.String LOCAL_BYTES_READ ()  { throw new RuntimeException(); }
    public  java.lang.String FETCH_WAIT_TIME ()  { throw new RuntimeException(); }
    public  java.lang.String RECORDS_READ ()  { throw new RuntimeException(); }
    public  java.lang.String REMOTE_REQS_DURATION ()  { throw new RuntimeException(); }
    public  java.lang.String CORRUPT_MERGED_BLOCK_CHUNKS ()  { throw new RuntimeException(); }
    public  java.lang.String MERGED_FETCH_FALLBACK_COUNT ()  { throw new RuntimeException(); }
    public  java.lang.String REMOTE_MERGED_BLOCKS_FETCHED ()  { throw new RuntimeException(); }
    public  java.lang.String LOCAL_MERGED_BLOCKS_FETCHED ()  { throw new RuntimeException(); }
    public  java.lang.String REMOTE_MERGED_CHUNKS_FETCHED ()  { throw new RuntimeException(); }
    public  java.lang.String LOCAL_MERGED_CHUNKS_FETCHED ()  { throw new RuntimeException(); }
    public  java.lang.String REMOTE_MERGED_BYTES_READ ()  { throw new RuntimeException(); }
    public  java.lang.String LOCAL_MERGED_BYTES_READ ()  { throw new RuntimeException(); }
    public  java.lang.String REMOTE_MERGED_REQS_DURATION ()  { throw new RuntimeException(); }
  }
  static public  class shuffleWrite$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final shuffleWrite$ MODULE$ = null;
    public   shuffleWrite$ ()  { throw new RuntimeException(); }
    public  java.lang.String BYTES_WRITTEN ()  { throw new RuntimeException(); }
    public  java.lang.String RECORDS_WRITTEN ()  { throw new RuntimeException(); }
    public  java.lang.String WRITE_TIME ()  { throw new RuntimeException(); }
  }
  static public  class output$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final output$ MODULE$ = null;
    public   output$ ()  { throw new RuntimeException(); }
    public  java.lang.String BYTES_WRITTEN ()  { throw new RuntimeException(); }
    public  java.lang.String RECORDS_WRITTEN ()  { throw new RuntimeException(); }
  }
  static public  class input$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final input$ MODULE$ = null;
    public   input$ ()  { throw new RuntimeException(); }
    public  java.lang.String BYTES_READ ()  { throw new RuntimeException(); }
    public  java.lang.String RECORDS_READ ()  { throw new RuntimeException(); }
  }
  static public  java.lang.String METRICS_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String SHUFFLE_READ_METRICS_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String SHUFFLE_WRITE_METRICS_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String OUTPUT_METRICS_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String INPUT_METRICS_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String SHUFFLE_PUSH_READ_METRICS_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String EXECUTOR_DESERIALIZE_TIME ()  { throw new RuntimeException(); }
  static public  java.lang.String EXECUTOR_DESERIALIZE_CPU_TIME ()  { throw new RuntimeException(); }
  static public  java.lang.String EXECUTOR_RUN_TIME ()  { throw new RuntimeException(); }
  static public  java.lang.String EXECUTOR_CPU_TIME ()  { throw new RuntimeException(); }
  static public  java.lang.String RESULT_SIZE ()  { throw new RuntimeException(); }
  static public  java.lang.String JVM_GC_TIME ()  { throw new RuntimeException(); }
  static public  java.lang.String RESULT_SERIALIZATION_TIME ()  { throw new RuntimeException(); }
  static public  java.lang.String MEMORY_BYTES_SPILLED ()  { throw new RuntimeException(); }
  static public  java.lang.String DISK_BYTES_SPILLED ()  { throw new RuntimeException(); }
  static public  java.lang.String PEAK_EXECUTION_MEMORY ()  { throw new RuntimeException(); }
  static public  java.lang.String PEAK_ON_HEAP_EXECUTION_MEMORY ()  { throw new RuntimeException(); }
  static public  java.lang.String PEAK_OFF_HEAP_EXECUTION_MEMORY ()  { throw new RuntimeException(); }
  static public  java.lang.String UPDATED_BLOCK_STATUSES ()  { throw new RuntimeException(); }
  static public  java.lang.String TEST_ACCUM ()  { throw new RuntimeException(); }
  static public  java.lang.String COLLECT_METRICS_ACCUMULATOR ()  { throw new RuntimeException(); }
}
