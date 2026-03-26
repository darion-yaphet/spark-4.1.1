package org.apache.spark.deploy;
/**
 * An object to provide utility methods for Spark deploy module.
 */
public  class Utils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Utils$ MODULE$ = null;
  public   Utils$ ()  { throw new RuntimeException(); }
  public  int DEFAULT_BYTES ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.String> SUPPORTED_LOG_TYPES ()  { throw new RuntimeException(); }
  public  void addRenderLogHandler (org.apache.spark.ui.WebUI page, org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /** Get the part of the log files given the offset and desired length of bytes */
  public  scala.Tuple4<java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object> getLog (org.apache.spark.SparkConf conf, java.lang.String logDirectory, java.lang.String logType, scala.Option<java.lang.Object> offsetOption, int byteLength)  { throw new RuntimeException(); }
}
