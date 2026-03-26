package org.apache.spark;
public  class SSLOptions$ implements org.apache.spark.internal.Logging, java.io.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SSLOptions$ MODULE$ = null;
  public   SSLOptions$ ()  { throw new RuntimeException(); }
  /**
   * Resolves SSLOptions settings from a given Spark configuration object at a given namespace.
   * <p>
   * The following settings are allowed:
   * $ - <code>[ns].enabled</code> - <code>true</code> or <code>false</code>, to enable or disable SSL respectively
   * $ - <code>[ns].port</code> - the port where to bind the SSL server
   * $ - <code>[ns].keyStore</code> - a path to the key-store file; can be relative to the current directory
   * $ - <code>[ns].keyStorePassword</code> - a password to the key-store file
   * $ - <code>[ns].privateKey</code> - a PKCS#8 private key file in PEM format
   * $ - <code>[ns].privateKeyPassword</code> - a password for the above key
   * $ - <code>[ns].keyPassword</code> - a password to the private key in the key store
   * $ - <code>[ns].keyStoreType</code> - the type of the key-store
   * $ - <code>[ns].needClientAuth</code> - whether SSL needs client authentication
   * $ - <code>[ns].certChain</code> - an X.509 certificate chain file in PEM format
   * $ - <code>[ns].trustStore</code> - a path to the trust-store file; can be relative to the current
   *                         directory
   * $ - <code>[ns].trustStorePassword</code> - a password to the trust-store file
   * $ - <code>[ns].trustStoreType</code> - the type of trust-store
   * $ - <code>[ns].trustStoreReloadingEnabled</code> - enables or disables using a trust-store
   * that reloads its configuration when the trust-store file on disk changes
   * $ - <code>[ns].trustStoreReloadIntervalMs</code> - the interval, in milliseconds, the
   * trust-store will reload its configuration
   * $ - <code>[ns].openSslEnabled</code> - enables or disables using an OpenSSL implementation
   * (if available on host system), requires certChain and keyFile arguments
   * $ - <code>[ns].protocol</code> - a protocol name supported by a particular Java version
   * $ - <code>[ns].enabledAlgorithms</code> - a comma separated list of ciphers
   * <p>
   * For a list of protocols and ciphers supported by particular Java versions, you may go to
   * <a href="https://blogs.oracle.com/java-platform-group/entry/diagnosing_tls_ssl_and_https">
   * Oracle blog page</a>.
   * <p>
   * You can optionally specify the default configuration. If you do, for each setting which is
   * missing in SparkConf, the corresponding setting is used from the default configuration.
   * <p>
   * @param conf Spark configuration object where the settings are collected from
   * @param hadoopConf Hadoop configuration to get settings
   * @param ns the namespace name
   * @param defaults the default configuration
   * @return {@link org.apache.spark.SSLOptions} object
   */
  public  org.apache.spark.SSLOptions parse (org.apache.spark.SparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf, java.lang.String ns, scala.Option<org.apache.spark.SSLOptions> defaults)  { throw new RuntimeException(); }
  public  java.lang.String SPARK_RPC_SSL_KEY_PASSWORD_CONF ()  { throw new RuntimeException(); }
  public  java.lang.String SPARK_RPC_SSL_PRIVATE_KEY_PASSWORD_CONF ()  { throw new RuntimeException(); }
  public  java.lang.String SPARK_RPC_SSL_KEY_STORE_PASSWORD_CONF ()  { throw new RuntimeException(); }
  public  java.lang.String SPARK_RPC_SSL_TRUST_STORE_PASSWORD_CONF ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> SPARK_RPC_SSL_PASSWORD_FIELDS ()  { throw new RuntimeException(); }
  public  java.lang.String ENV_RPC_SSL_KEY_PASSWORD ()  { throw new RuntimeException(); }
  public  java.lang.String ENV_RPC_SSL_PRIVATE_KEY_PASSWORD ()  { throw new RuntimeException(); }
  public  java.lang.String ENV_RPC_SSL_KEY_STORE_PASSWORD ()  { throw new RuntimeException(); }
  public  java.lang.String ENV_RPC_SSL_TRUST_STORE_PASSWORD ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> SPARK_RPC_SSL_PASSWORD_ENVS ()  { throw new RuntimeException(); }
}
