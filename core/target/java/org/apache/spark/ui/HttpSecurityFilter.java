package org.apache.spark.ui;
/**
 * A servlet filter that implements HTTP security features. The following actions are taken
 * for every request:
 * <p>
 * - perform access control of authenticated requests.
 * - check request data for disallowed content (e.g. things that could be used to create XSS
 *   attacks).
 * - set response headers to prevent certain kinds of attacks.
 * <p>
 * Request parameters are sanitized so that HTML content is escaped, and disallowed content is
 * removed.
 */
public  class HttpSecurityFilter implements jakarta.servlet.Filter {
  public   HttpSecurityFilter (org.apache.spark.SparkConf conf, org.apache.spark.SecurityManager securityMgr)  { throw new RuntimeException(); }
  public  void doFilter (jakarta.servlet.ServletRequest req, jakarta.servlet.ServletResponse res, jakarta.servlet.FilterChain chain)  { throw new RuntimeException(); }
}
