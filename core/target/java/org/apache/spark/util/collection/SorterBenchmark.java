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
public  class SorterBenchmark {
  /** Wrapper of Int for key reuse. */
  static public  class IntWrapper implements scala.math.Ordered<org.apache.spark.util.collection.SorterBenchmark.IntWrapper> {
    public  int key ()  { throw new RuntimeException(); }
    // not preceding
    public   IntWrapper (int key)  { throw new RuntimeException(); }
    public  int compare (org.apache.spark.util.collection.SorterBenchmark.IntWrapper that)  { throw new RuntimeException(); }
  }
  static public  class IntWrapper$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final IntWrapper$ MODULE$ = null;
    public   IntWrapper$ ()  { throw new RuntimeException(); }
  }
  /** Format to sort a simple Array[Int]. Could be easily generified and specialized. */
  static public  class IntArraySortDataFormat extends org.apache.spark.util.collection.SorterBenchmark.AbstractIntArraySortDataFormat<java.lang.Object> {
    public   IntArraySortDataFormat ()  { throw new RuntimeException(); }
    protected  int getKey (int[] data, int pos)  { throw new RuntimeException(); }
  }
  static public abstract class AbstractIntArraySortDataFormat<K extends java.lang.Object> extends org.apache.spark.util.collection.SortDataFormat<K, int[]> {
    // not preceding
    // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
    public   AbstractIntArraySortDataFormat ()  { throw new RuntimeException(); }
    /** Allocates a new structure that can hold up to 'length' elements. */
    public  int[] allocate (int length)  { throw new RuntimeException(); }
    public  void copyElement (int[] src, int srcPos, int[] dst, int dstPos)  { throw new RuntimeException(); }
    /** Copy a range of elements starting at src(srcPos) to dest, starting at destPos. */
    public  void copyRange (int[] src, int srcPos, int[] dst, int dstPos, int length)  { throw new RuntimeException(); }
    public  void swap (int[] data, int pos0, int pos1)  { throw new RuntimeException(); }
  }
  /** SortDataFormat for Array[Int] with reused keys. */
  static public  class KeyReuseIntArraySortDataFormat extends org.apache.spark.util.collection.SorterBenchmark.AbstractIntArraySortDataFormat<org.apache.spark.util.collection.SorterBenchmark.IntWrapper> {
    public   KeyReuseIntArraySortDataFormat ()  { throw new RuntimeException(); }
    public  org.apache.spark.util.collection.SorterBenchmark.IntWrapper getKey (int[] data, int pos, org.apache.spark.util.collection.SorterBenchmark.IntWrapper reuse)  { throw new RuntimeException(); }
    protected  org.apache.spark.util.collection.SorterBenchmark.IntWrapper getKey (int[] data, int pos)  { throw new RuntimeException(); }
    public  org.apache.spark.util.collection.SorterBenchmark.IntWrapper newKey ()  { throw new RuntimeException(); }
  }
  static public  void keyValuePairsSortBenchmark ()  { throw new RuntimeException(); }
  static public  void primitiveIntArraySortBenchmark ()  { throw new RuntimeException(); }
  static public  void runBenchmarkSuite (java.lang.String[] mainArgs)  { throw new RuntimeException(); }
  static public  scala.Option<java.io.OutputStream> output ()  { throw new RuntimeException(); }
  static public  void output_$eq (scala.Option<java.io.OutputStream> x$1)  { throw new RuntimeException(); }
  static public final  void runBenchmark (java.lang.String benchmarkName, scala.Function0<java.lang.Object> func)  { throw new RuntimeException(); }
  static public  void main (java.lang.String[] args)  { throw new RuntimeException(); }
  static public  java.lang.String suffix ()  { throw new RuntimeException(); }
  static public  void afterAll ()  { throw new RuntimeException(); }
}
