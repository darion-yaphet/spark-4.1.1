package org.apache.spark.internal.plugin;
public  class MemoryOverridePlugin implements org.apache.spark.api.plugin.SparkPlugin {
  static public  long offHeapMemory ()  { throw new RuntimeException(); }
  public   MemoryOverridePlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.DriverPlugin driverPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.ExecutorPlugin executorPlugin ()  { throw new RuntimeException(); }
}
