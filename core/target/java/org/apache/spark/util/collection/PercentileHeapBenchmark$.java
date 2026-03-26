package org.apache.spark.util.collection;
/**
 * Benchmark for PercentileHeap performance.
 * Measures heap insertion and percentile calculation performance
 * under various heap sizes and percentile values.
 * <pre><code>
 *   To run this benchmark:
 *   1. without sbt: bin/spark-submit --class &lt;this class&gt; &lt;spark core test jar&gt;
 *   2. build/sbt "core/Test/runMain &lt;this class&gt;"
 *   3. generate result: SPARK_GENERATE_BENCHMARK_FILES=1 build/sbt "core/Test/runMain &lt;this class&gt;"
 *      Results will be written to "benchmarks/PercentileHeapBenchmark-results.txt".
 * </code></pre>
 */
public  class PercentileHeapBenchmark$ extends org.apache.spark.benchmark.BenchmarkBase {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PercentileHeapBenchmark$ MODULE$ = null;
  public   PercentileHeapBenchmark$ ()  { throw new RuntimeException(); }
  public  void runBenchmarkSuite (java.lang.String[] mainArgs)  { throw new RuntimeException(); }
}
