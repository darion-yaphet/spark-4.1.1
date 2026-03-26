package org.apache.spark.api.python;
/**
 * A wrapper for a Python function, contains all necessary context to run the function in Python
 * runner.
 */
public  interface PythonFunction {
  public  scala.collection.immutable.Seq<java.lang.Object> command ()  ;
  public  java.util.Map<java.lang.String, java.lang.String> envVars ()  ;
  public  java.util.List<java.lang.String> pythonIncludes ()  ;
  public  java.lang.String pythonExec ()  ;
  public  java.lang.String pythonVer ()  ;
  public  java.util.List<org.apache.spark.broadcast.Broadcast<org.apache.spark.api.python.PythonBroadcast>> broadcastVars ()  ;
  public  org.apache.spark.util.CollectionAccumulator<byte[]> accumulator ()  ;
}
