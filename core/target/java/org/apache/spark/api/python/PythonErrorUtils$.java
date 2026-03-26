package org.apache.spark.api.python;
/**
 * Utility object that provides convenient accessors for extracting
 * detailed information from a {@link SparkThrowable} instance.
 * <p>
 * This object is primarily used in PySpark
 * to retrieve structured error metadata because Py4J does not work
 * with default methods.
 */
public  class PythonErrorUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PythonErrorUtils$ MODULE$ = null;
  public   PythonErrorUtils$ ()  { throw new RuntimeException(); }
  public  java.lang.String getCondition (org.apache.spark.SparkThrowable e)  { throw new RuntimeException(); }
  public  java.lang.String getErrorClass (org.apache.spark.SparkThrowable e)  { throw new RuntimeException(); }
  public  java.lang.String getSqlState (org.apache.spark.SparkThrowable e)  { throw new RuntimeException(); }
  public  boolean isInternalError (org.apache.spark.SparkThrowable e)  { throw new RuntimeException(); }
  public  org.apache.spark.BreakingChangeInfo getBreakingChangeInfo (org.apache.spark.SparkThrowable e)  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.String> getMessageParameters (org.apache.spark.SparkThrowable e)  { throw new RuntimeException(); }
  public  java.lang.String getDefaultMessageTemplate (org.apache.spark.SparkThrowable e)  { throw new RuntimeException(); }
  public  org.apache.spark.QueryContext[] getQueryContext (org.apache.spark.SparkThrowable e)  { throw new RuntimeException(); }
}
