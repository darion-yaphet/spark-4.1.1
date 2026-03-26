package org.apache.spark.deploy;
/**
 * ExecutorFailureTracker is responsible for tracking executor failures both for each host
 * separately and for all hosts altogether.
 */
  class ExecutorFailureTracker implements org.apache.spark.internal.Logging {
  static public  int maxNumExecutorFailures (org.apache.spark.SparkConf sparkConf)  { throw new RuntimeException(); }
  public  org.apache.spark.util.Clock clock ()  { throw new RuntimeException(); }
  // not preceding
  public   ExecutorFailureTracker (org.apache.spark.SparkConf sparkConf, org.apache.spark.util.Clock clock)  { throw new RuntimeException(); }
  public  int numFailedExecutors ()  { throw new RuntimeException(); }
  public  void registerFailureOnHost (java.lang.String hostname)  { throw new RuntimeException(); }
  public  void registerExecutorFailure ()  { throw new RuntimeException(); }
  public  int numFailuresOnHost (java.lang.String hostname)  { throw new RuntimeException(); }
}
