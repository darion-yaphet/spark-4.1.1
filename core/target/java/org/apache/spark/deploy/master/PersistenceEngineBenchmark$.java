package org.apache.spark.deploy.master;
/**
 * Benchmark for PersistenceEngines.
 * To run this benchmark:
 * <pre><code>
 *   1. without sbt:
 *      bin/spark-submit --class &lt;this class&gt; --jars `find ~/.cache/coursier \
 *        -name 'curator-test-*.jar'` &lt;spark core test jar&gt;
 *   2. build/sbt "core/Test/runMain &lt;this class&gt;"
 *   3. generate result:
 *      SPARK_GENERATE_BENCHMARK_FILES=1 build/sbt "core/Test/runMain &lt;this class&gt;"
 *      Results will be written to "benchmarks/PersistenceEngineBenchmark-results.txt".
 * </code></pre>
 * */
public  class PersistenceEngineBenchmark$ extends org.apache.spark.benchmark.BenchmarkBase {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PersistenceEngineBenchmark$ MODULE$ = null;
  public   PersistenceEngineBenchmark$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf conf ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.serializer.JavaSerializer> serializers ()  { throw new RuntimeException(); }
  public  org.apache.curator.test.TestingServer zkTestServer ()  { throw new RuntimeException(); }
  public  void runBenchmarkSuite (java.lang.String[] mainArgs)  { throw new RuntimeException(); }
  public  void afterAll ()  { throw new RuntimeException(); }
  public  int findFreePort (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
}
