package org.apache.spark.util.kvstore;
/**
 * Benchmark suite for the KVStore implemented based on RocksDB.
 * <p>
 * The benchmarks are run over two different types (one with just a natural index, and one
 * with a ref index), over a set of elements, and the following tests are performed:
 * <p>
 * - create and close rocksdb
 * - write/update/delete elements in sequential natural key order
 * - write/update/delete elements in random natural key order
 * - iterate over natural index, ascending and descending
 * - iterate over ref index, ascending and descending
 * <p>
 * To run this benchmark:
 * <pre><code>
 *   1. without sbt:
 *      bin/spark-submit --class &lt;this class&gt; &lt;spark core test jar&gt;
 *   2. build/sbt "core/Test/runMain &lt;this class&gt;"
 *   3. generate result:
 *      SPARK_GENERATE_BENCHMARK_FILES=1 build/sbt "core/Test/runMain &lt;this class&gt;"
 *      Results will be written to "benchmarks/RocksDBBenchmark-results.txt".
 * </code></pre>
 */
public  class RocksDBBenchmark {
  static public  void runBenchmarkSuite (java.lang.String[] mainArgs)  { throw new RuntimeException(); }
  static public  scala.Option<java.io.OutputStream> output ()  { throw new RuntimeException(); }
  static public  void output_$eq (scala.Option<java.io.OutputStream> x$1)  { throw new RuntimeException(); }
  static public final  void runBenchmark (java.lang.String benchmarkName, scala.Function0<java.lang.Object> func)  { throw new RuntimeException(); }
  static public  void main (java.lang.String[] args)  { throw new RuntimeException(); }
  static public  java.lang.String suffix ()  { throw new RuntimeException(); }
  static public  void afterAll ()  { throw new RuntimeException(); }
}
