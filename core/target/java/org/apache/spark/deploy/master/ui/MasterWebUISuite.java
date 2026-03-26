package org.apache.spark.deploy.master.ui;
public  class MasterWebUISuite extends org.apache.spark.SparkFunSuite {
  static   java.lang.String convPostDataToString (scala.collection.immutable.Seq<scala.Tuple2<java.lang.String, java.lang.String>> data)  { throw new RuntimeException(); }
  static   java.lang.String convPostDataToString (scala.collection.immutable.Map<java.lang.String, java.lang.String> data)  { throw new RuntimeException(); }
  /**
   * Send an HTTP request to the given URL using the method and the body specified.
   * Return the connection object.
   * @param url (undocumented)
   * @param method (undocumented)
   * @param body (undocumented)
   * @return (undocumented)
   */
  static   java.net.HttpURLConnection sendHttpRequest (java.lang.String url, java.lang.String method, java.lang.String body)  { throw new RuntimeException(); }
  public   MasterWebUISuite ()  { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf conf ()  { throw new RuntimeException(); }
  public  org.apache.spark.SecurityManager securityMgr ()  { throw new RuntimeException(); }
  public  org.apache.spark.rpc.RpcEnv rpcEnv ()  { throw new RuntimeException(); }
  public  org.apache.spark.deploy.master.Master master ()  { throw new RuntimeException(); }
  public  org.apache.spark.rpc.RpcEndpointRef masterEndpointRef ()  { throw new RuntimeException(); }
  public  org.apache.spark.deploy.master.ui.MasterWebUI masterWebUI ()  { throw new RuntimeException(); }
  public  void beforeAll ()  { throw new RuntimeException(); }
  public  void afterAll ()  { throw new RuntimeException(); }
}
