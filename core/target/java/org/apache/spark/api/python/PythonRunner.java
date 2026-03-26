package org.apache.spark.api.python;
/**
 * A helper class to run Python mapPartition in Spark.
 */
  class PythonRunner extends org.apache.spark.api.python.BasePythonRunner<byte[], byte[]> {
  static public  java.util.concurrent.ConcurrentHashMap.KeySetView<scala.Tuple2<org.apache.spark.api.python.PythonWorker, java.lang.Object>, java.lang.Boolean> runningMonitorThreads ()  { throw new RuntimeException(); }
  static public  org.apache.spark.api.python.PythonRunner apply (org.apache.spark.api.python.PythonFunction func, scala.Option<java.lang.String> jobArtifactUUID)  { throw new RuntimeException(); }
  // not preceding
  public   PythonRunner (scala.collection.immutable.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs, scala.Option<java.lang.String> jobArtifactUUID)  { throw new RuntimeException(); }
  protected  org.apache.spark.api.python.BasePythonRunner<byte[], byte[]>.Writer newWriter (org.apache.spark.SparkEnv env, org.apache.spark.api.python.PythonWorker worker, scala.collection.Iterator<byte[]> inputIterator, int partitionIndex, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<byte[]> newReaderIterator (java.io.DataInputStream stream, org.apache.spark.api.python.BasePythonRunner<byte[], byte[]>.Writer writer, long startTime, org.apache.spark.SparkEnv env, org.apache.spark.api.python.PythonWorker worker, scala.Option<java.lang.Object> pid, java.util.concurrent.atomic.AtomicBoolean releasedOrClosed, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
}
