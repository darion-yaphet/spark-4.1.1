package org.apache.spark.deploy.rest;
/**
 * A servlet for handling clear requests passed to the {@link RestSubmissionServer}.
 */
 abstract class ClearRequestServlet extends org.apache.spark.deploy.rest.RestServlet {
  public   ClearRequestServlet ()  { throw new RuntimeException(); }
  /**
   * Clear the completed drivers and apps.
   * @param request (undocumented)
   * @param response (undocumented)
   */
  protected  void doPost (jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)  { throw new RuntimeException(); }
  protected abstract  org.apache.spark.deploy.rest.ClearResponse handleClear ()  ;
}
