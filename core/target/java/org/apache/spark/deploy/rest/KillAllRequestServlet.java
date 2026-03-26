package org.apache.spark.deploy.rest;
/**
 * A servlet for handling killAll requests passed to the {@link RestSubmissionServer}.
 */
 abstract class KillAllRequestServlet extends org.apache.spark.deploy.rest.RestServlet {
  public   KillAllRequestServlet ()  { throw new RuntimeException(); }
  /**
   * Have the Master kill all drivers and return an appropriate response to the client.
   * Otherwise, return error.
   * @param request (undocumented)
   * @param response (undocumented)
   */
  protected  void doPost (jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)  { throw new RuntimeException(); }
  protected abstract  org.apache.spark.deploy.rest.KillAllSubmissionResponse handleKillAll ()  ;
}
