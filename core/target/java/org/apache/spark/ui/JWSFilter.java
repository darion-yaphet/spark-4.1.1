package org.apache.spark.ui;
/**
 * A servlet filter that requires JWS, a cryptographically signed JSON Web Token, in the header.
 * <p>
 * Like the other UI filters, the following configurations are required to use this filter.
 * <pre><code>
 *   - spark.ui.filters=org.apache.spark.ui.JWSFilter
 *   - spark.org.apache.spark.ui.JWSFilter.param.secretKey=BASE64URL-ENCODED-YOUR-PROVIDED-KEY
 * </code></pre>
 * The HTTP request should have {@code Authorization: Bearer <jws>} header.
 * <pre><code>
 *   - &lt;jws&gt; is a string with three fields, '&lt;header&gt;.&lt;payload&gt;.&lt;signature&gt;'.
 *   - &lt;header&gt; is supposed to be a base64url-encoded string of '{"alg":"HS256","typ":"JWT"}'.
 *   - &lt;payload&gt; is a base64url-encoded string of fully-user-defined content.
 *   - &lt;signature&gt; is a signature based on '&lt;header&gt;.&lt;payload&gt;' and a user-provided key parameter.
 * </code></pre>
 */
public  class JWSFilter implements jakarta.servlet.Filter {
  public   JWSFilter ()  { throw new RuntimeException(); }
  public  void doFilter (jakarta.servlet.ServletRequest req, jakarta.servlet.ServletResponse res, jakarta.servlet.FilterChain chain)  { throw new RuntimeException(); }
  /**
   * Load and validate the configurtions:
   * - IllegalArgumentException will happen if the user didn't provide this argument
   * - WeakKeyException will happen if the user-provided value is insufficient
   * @param config (undocumented)
   */
  public  void init (jakarta.servlet.FilterConfig config)  { throw new RuntimeException(); }
}
