package org.apache.spark.internal.plugin;
public  class SetShuffleManagerPlugin implements org.apache.spark.api.plugin.SparkPlugin {
  static public  class MyShuffleManager extends org.apache.spark.shuffle.sort.SortShuffleManager {
    public   MyShuffleManager (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  }
  public   SetShuffleManagerPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.DriverPlugin driverPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.ExecutorPlugin executorPlugin ()  { throw new RuntimeException(); }
}
