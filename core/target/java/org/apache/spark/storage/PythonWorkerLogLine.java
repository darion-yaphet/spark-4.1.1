package org.apache.spark.storage;
public  class PythonWorkerLogLine implements org.apache.spark.storage.LogLine, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long eventTime ()  { throw new RuntimeException(); }
  public  long sequenceId ()  { throw new RuntimeException(); }
  public  java.lang.String message ()  { throw new RuntimeException(); }
  // not preceding
  public   PythonWorkerLogLine (long eventTime, long sequenceId, java.lang.String message)  { throw new RuntimeException(); }
}
