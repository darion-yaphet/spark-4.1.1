package org.apache.spark.executor;
public  class TestFatalErrorPlugin implements org.apache.spark.api.plugin.SparkPlugin {
  public   TestFatalErrorPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.DriverPlugin driverPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.ExecutorPlugin executorPlugin ()  { throw new RuntimeException(); }
}
