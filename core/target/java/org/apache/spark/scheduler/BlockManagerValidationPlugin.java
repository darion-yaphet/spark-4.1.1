package org.apache.spark.scheduler;
public  class BlockManagerValidationPlugin implements org.apache.spark.api.plugin.SparkPlugin {
  static public  java.util.concurrent.Semaphore releaseTaskSem ()  { throw new RuntimeException(); }
  static public  java.util.concurrent.Semaphore taskStartedSem ()  { throw new RuntimeException(); }
  static public  void resetState ()  { throw new RuntimeException(); }
  public   BlockManagerValidationPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.DriverPlugin driverPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.ExecutorPlugin executorPlugin ()  { throw new RuntimeException(); }
}
