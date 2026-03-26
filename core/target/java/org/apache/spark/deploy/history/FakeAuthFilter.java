package org.apache.spark.deploy.history;
/**
 * A filter used for auth tests; sets the request's user to the value of the "HTTP_USER" header.
 */
public  class FakeAuthFilter implements jakarta.servlet.Filter {
  static public  java.lang.String FAKE_HTTP_USER ()  { throw new RuntimeException(); }
  public   FakeAuthFilter ()  { throw new RuntimeException(); }
  public  void doFilter (jakarta.servlet.ServletRequest req, jakarta.servlet.ServletResponse res, jakarta.servlet.FilterChain chain)  { throw new RuntimeException(); }
}
