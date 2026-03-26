package org.apache.spark;
/**
 * A test shuffle data IO implementation, which allows both executor and driver component to
 * be mocked.
 * Note: cannot intercept initialization of executor/driver currently.
 * <p>
 */
public  class TestShuffleDataIOWithMockedComponents implements org.apache.spark.shuffle.api.ShuffleDataIO {
  // not preceding
  public   TestShuffleDataIOWithMockedComponents (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf conf ()  { throw new RuntimeException(); }
  public  org.apache.spark.shuffle.api.ShuffleDriverComponents driver ()  { throw new RuntimeException(); }
  public  org.apache.spark.shuffle.api.ShuffleExecutorComponents executor ()  { throw new RuntimeException(); }
}
