package org.apache.spark.deploy;
/**
 * A built-in plugin to provide Driver timeout feature.
 */
public  class DriverTimeoutPlugin implements org.apache.spark.api.plugin.SparkPlugin {
  public   DriverTimeoutPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.DriverPlugin driverPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.ExecutorPlugin executorPlugin ()  { throw new RuntimeException(); }
}
