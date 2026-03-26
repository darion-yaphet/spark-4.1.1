package org.apache.spark.deploy.rest;
/**
 * A servlet for handling killAll requests passed to the {@link StandaloneRestServer}.
 */
  class StandaloneKillAllRequestServlet extends org.apache.spark.deploy.rest.KillAllRequestServlet {
  public   StandaloneKillAllRequestServlet (org.apache.spark.rpc.RpcEndpointRef masterEndpoint, org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.KillAllSubmissionResponse handleKillAll ()  { throw new RuntimeException(); }
}
