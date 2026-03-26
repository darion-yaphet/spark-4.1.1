package org.apache.spark;
/**
 * Hadoop file already exists exception thrown from Spark with an error class.
 */
  class SparkFileAlreadyExistsException extends org.apache.hadoop.fs.FileAlreadyExistsException implements org.apache.spark.SparkThrowable {
  public   SparkFileAlreadyExistsException (java.lang.String errorClass, scala.collection.immutable.Map<java.lang.String, java.lang.String> messageParameters)  { throw new RuntimeException(); }
  public  java.lang.String getCondition ()  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.String> getMessageParameters ()  { throw new RuntimeException(); }
}
