package org.apache.spark.util;
/**
 * Helper class for passing configuration options to JsonProtocol.
 * We use this instead of passing SparkConf directly because it lets us avoid
 * repeated re-parsing of configuration values on each read.
 */
  class JsonProtocolOptions {
  public   JsonProtocolOptions (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  public  boolean includeTaskMetricsAccumulators ()  { throw new RuntimeException(); }
}
