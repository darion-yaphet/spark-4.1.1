package org.apache.spark.deploy;
/**
 * A built-in plugin to allow redirecting stdout/stderr to logging system (SLF4J).
 */
public  class RedirectConsolePlugin implements org.apache.spark.api.plugin.SparkPlugin {
  static public  void redirectStdoutToLog ()  { throw new RuntimeException(); }
  static public  void redirectStderrToLog ()  { throw new RuntimeException(); }
  public   RedirectConsolePlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.DriverPlugin driverPlugin ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.plugin.ExecutorPlugin executorPlugin ()  { throw new RuntimeException(); }
}
