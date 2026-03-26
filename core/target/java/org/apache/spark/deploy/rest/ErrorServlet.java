package org.apache.spark.deploy.rest;
/**
 * A default servlet that handles error cases that are not captured by other servlets.
 */
public  class ErrorServlet extends org.apache.spark.deploy.rest.RestServlet {
  public   ErrorServlet ()  { throw new RuntimeException(); }
  /** Service a faulty request by returning an appropriate error message to the client. */
  protected  void service (jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)  { throw new RuntimeException(); }
}
