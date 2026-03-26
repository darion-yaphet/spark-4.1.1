package org.apache.spark.deploy.rest;
/**
 * A {@link StandaloneRestServer} that is faulty in many ways.
 * <p>
 * When handling a submit request, the server returns a malformed JSON.
 * When handling a kill request, the server returns an invalid JSON.
 * When handling a killAll request, the server returns an invalid JSON.
 * When handling a status request, the server throws an internal exception.
 * When handling a clear request, the server throws an internal exception.
 * When handling a readyz request, the server throws an internal exception.
 * The purpose of this class is to test that client handles these cases gracefully.
 */
public  class FaultyStandaloneRestServer extends org.apache.spark.deploy.rest.RestSubmissionServer {
  /** A faulty servlet that produces malformed responses. */
  public  class MalformedSubmitServlet extends org.apache.spark.deploy.rest.StandaloneSubmitRequestServlet {
    public   MalformedSubmitServlet ()  { throw new RuntimeException(); }
    protected  void sendResponse (org.apache.spark.deploy.rest.SubmitRestProtocolResponse responseMessage, jakarta.servlet.http.HttpServletResponse responseServlet)  { throw new RuntimeException(); }
  }
  /** A faulty servlet that produces invalid responses. */
  public  class InvalidKillServlet extends org.apache.spark.deploy.rest.StandaloneKillRequestServlet {
    public   InvalidKillServlet ()  { throw new RuntimeException(); }
    protected  org.apache.spark.deploy.rest.KillSubmissionResponse handleKill (java.lang.String submissionId)  { throw new RuntimeException(); }
  }
  /** A faulty servlet that produces invalid responses. */
  public  class InvalidKillAllServlet extends org.apache.spark.deploy.rest.StandaloneKillAllRequestServlet {
    public   InvalidKillAllServlet ()  { throw new RuntimeException(); }
    protected  org.apache.spark.deploy.rest.KillAllSubmissionResponse handleKillAll ()  { throw new RuntimeException(); }
  }
  /** A faulty status servlet that explodes. */
  public  class ExplodingStatusServlet extends org.apache.spark.deploy.rest.StandaloneStatusRequestServlet {
    public   ExplodingStatusServlet ()  { throw new RuntimeException(); }
    protected  org.apache.spark.deploy.rest.SubmissionStatusResponse handleStatus (java.lang.String submissionId)  { throw new RuntimeException(); }
  }
  /** A faulty clear servlet that explodes. */
  public  class ExplodingClearServlet extends org.apache.spark.deploy.rest.StandaloneClearRequestServlet {
    public   ExplodingClearServlet ()  { throw new RuntimeException(); }
    protected  org.apache.spark.deploy.rest.ClearResponse handleClear ()  { throw new RuntimeException(); }
  }
  /** A faulty readyz servlet that explodes. */
  public  class ExplodingReadyzServlet extends org.apache.spark.deploy.rest.StandaloneReadyzRequestServlet {
    public   ExplodingReadyzServlet ()  { throw new RuntimeException(); }
    protected  org.apache.spark.deploy.rest.ReadyzResponse handleReadyz ()  { throw new RuntimeException(); }
  }
  // not preceding
  public   FaultyStandaloneRestServer (java.lang.String host, int requestedPort, org.apache.spark.SparkConf masterConf, org.apache.spark.rpc.RpcEndpointRef masterEndpoint, java.lang.String masterUrl)  { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.FaultyStandaloneRestServer.ExplodingClearServlet clearRequestServlet ()  { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.FaultyStandaloneRestServer.InvalidKillAllServlet killAllRequestServlet ()  { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.FaultyStandaloneRestServer.InvalidKillServlet killRequestServlet ()  { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.FaultyStandaloneRestServer.ExplodingReadyzServlet readyzRequestServlet ()  { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.FaultyStandaloneRestServer.ExplodingStatusServlet statusRequestServlet ()  { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.FaultyStandaloneRestServer.MalformedSubmitServlet submitRequestServlet ()  { throw new RuntimeException(); }
}
