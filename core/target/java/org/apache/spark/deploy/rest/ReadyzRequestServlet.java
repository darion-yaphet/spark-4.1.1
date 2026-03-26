package org.apache.spark.deploy.rest;
/**
 * A servlet for handling readyz requests passed to the {@link RestSubmissionServer}.
 */
 abstract class ReadyzRequestServlet extends org.apache.spark.deploy.rest.RestServlet {
  public   ReadyzRequestServlet ()  { throw new RuntimeException(); }
  /**
   * Return the status of master is ready or not.
   * @param request (undocumented)
   * @param response (undocumented)
   */
  protected  void doGet (jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)  { throw new RuntimeException(); }
  protected abstract  org.apache.spark.deploy.rest.ReadyzResponse handleReadyz ()  ;
}
