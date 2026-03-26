package org.apache.spark.deploy.rest;
/**
 * A servlet for handling readyz requests passed to the {@link StandaloneRestServer}.
 */
  class StandaloneReadyzRequestServlet extends org.apache.spark.deploy.rest.ReadyzRequestServlet {
  public   StandaloneReadyzRequestServlet (org.apache.spark.rpc.RpcEndpointRef masterEndpoint, org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.ReadyzResponse handleReadyz ()  { throw new RuntimeException(); }
}
