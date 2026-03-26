package org.apache.spark.util.collection;
/**
 * Benchmark for o.a.s.util.collection.Sorter.
 * To run this benchmark:
 * <pre><code>
 *   1. without sbt:
 *      bin/spark-submit --class &lt;this class&gt; &lt;spark core test jar&gt;
 *   2. build/sbt "core/Test/runMain &lt;this class&gt;"
 *   3. generate result:
 *      SPARK_GENERATE_BENCHMARK_FILES=1 build/sbt "core/Test/runMain &lt;this class&gt;"
 *      Results will be written to "benchmarks/SorterBenchmark-results.txt".
 * </code></pre>
 * */
public  class SorterBenchmark$ extends org.apache.spark.benchmark.BenchmarkBase {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SorterBenchmark$ MODULE$ = null;
  public   SorterBenchmark$ ()  { throw new RuntimeException(); }
  public  void keyValuePairsSortBenchmark ()  { throw new RuntimeException(); }
  public  void primitiveIntArraySortBenchmark ()  { throw new RuntimeException(); }
  public  void runBenchmarkSuite (java.lang.String[] mainArgs)  { throw new RuntimeException(); }
}
