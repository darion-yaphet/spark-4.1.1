package org.apache.spark.api.python;
/**
 * A simple wrapper for a Python function created via pyspark.
 */
  class SimplePythonFunction implements org.apache.spark.api.python.PythonFunction, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.Object> command ()  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.String> envVars ()  { throw new RuntimeException(); }
  public  java.util.List<java.lang.String> pythonIncludes ()  { throw new RuntimeException(); }
  public  java.lang.String pythonExec ()  { throw new RuntimeException(); }
  public  java.lang.String pythonVer ()  { throw new RuntimeException(); }
  public  java.util.List<org.apache.spark.broadcast.Broadcast<org.apache.spark.api.python.PythonBroadcast>> broadcastVars ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.CollectionAccumulator<byte[]> accumulator ()  { throw new RuntimeException(); }
  // not preceding
  public   SimplePythonFunction (scala.collection.immutable.Seq<java.lang.Object> command, java.util.Map<java.lang.String, java.lang.String> envVars, java.util.List<java.lang.String> pythonIncludes, java.lang.String pythonExec, java.lang.String pythonVer, java.util.List<org.apache.spark.broadcast.Broadcast<org.apache.spark.api.python.PythonBroadcast>> broadcastVars, org.apache.spark.util.CollectionAccumulator<byte[]> accumulator)  { throw new RuntimeException(); }
  public   SimplePythonFunction (byte[] command, java.util.Map<java.lang.String, java.lang.String> envVars, java.util.List<java.lang.String> pythonIncludes, java.lang.String pythonExec, java.lang.String pythonVer, java.util.List<org.apache.spark.broadcast.Broadcast<org.apache.spark.api.python.PythonBroadcast>> broadcastVars, org.apache.spark.util.CollectionAccumulator<byte[]> accumulator)  { throw new RuntimeException(); }
}
