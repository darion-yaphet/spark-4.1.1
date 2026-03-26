package org.apache.spark.storage;
  class FallbackStorageRpcEndpointRef extends org.apache.spark.rpc.RpcEndpointRef {
  public   FallbackStorageRpcEndpointRef (org.apache.spark.SparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  public  org.apache.spark.rpc.RpcAddress address ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> scala.concurrent.Future<T> ask (Object message, org.apache.spark.rpc.RpcTimeout timeout, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  void send (Object message)  { throw new RuntimeException(); }
}
