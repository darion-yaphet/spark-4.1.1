package org.apache.spark.executor;
public  class TestErrorExecutorPlugin implements org.apache.spark.api.plugin.ExecutorPlugin {
  public   TestErrorExecutorPlugin ()  { throw new RuntimeException(); }
  public  void init (org.apache.spark.api.plugin.PluginContext _ctx, java.util.Map<java.lang.String, java.lang.String> extraConf)  { throw new RuntimeException(); }
}
