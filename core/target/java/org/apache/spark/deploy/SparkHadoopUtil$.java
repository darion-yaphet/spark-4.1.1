package org.apache.spark.deploy;
public  class SparkHadoopUtil$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkHadoopUtil$ MODULE$ = null;
  public   SparkHadoopUtil$ ()  { throw new RuntimeException(); }
  /**
   * Number of records to update input metrics when reading from HadoopRDDs.
   * <p>
   * Each update is potentially expensive because we need to use reflection to access the
   * Hadoop FileSystem API of interest (only available in 2.5), so we should do this sparingly.
   * @return (undocumented)
   */
    int UPDATE_INPUT_METRICS_INTERVAL_RECORDS ()  { throw new RuntimeException(); }
  /**
   * Name of the file containing the gateway's Hadoop configuration, to be overlayed on top of the
   * cluster's Hadoop config. It is up to the Spark code launching the application to create
   * this file if it's desired. If the file doesn't exist, it will just be ignored.
   * @return (undocumented)
   */
    java.lang.String SPARK_HADOOP_CONF_FILE ()  { throw new RuntimeException(); }
  /**
   * Source for hive-site.xml configuration options.
   * @return (undocumented)
   */
    java.lang.String SOURCE_HIVE_SITE ()  { throw new RuntimeException(); }
  /**
   * Source for configuration options set by spark when another source is
   * not explicitly declared.
   * @return (undocumented)
   */
    java.lang.String SOURCE_SPARK ()  { throw new RuntimeException(); }
  /**
   * Source for configuration options with <code>spark.hadoop.</code> prefix copied
   * from spark-defaults.
   * @return (undocumented)
   */
    java.lang.String SOURCE_SPARK_HADOOP ()  { throw new RuntimeException(); }
  /**
   * AWS Endpoint URL.
   * @return (undocumented)
   */
    java.lang.String ENV_VAR_AWS_ENDPOINT_URL ()  { throw new RuntimeException(); }
  /**
   * AWS Access key.
   * @return (undocumented)
   */
    java.lang.String ENV_VAR_AWS_ACCESS_KEY ()  { throw new RuntimeException(); }
  /**
   * AWS Secret Key.
   * @return (undocumented)
   */
    java.lang.String ENV_VAR_AWS_SECRET_KEY ()  { throw new RuntimeException(); }
  /**
   * AWS Session token.
   * @return (undocumented)
   */
    java.lang.String ENV_VAR_AWS_SESSION_TOKEN ()  { throw new RuntimeException(); }
  /**
   * Source for configuration options with <code>spark.hive.</code> prefix copied
   * from spark-defaults.
   * @return (undocumented)
   */
    java.lang.String SOURCE_SPARK_HIVE ()  { throw new RuntimeException(); }
  /**
   * Hadoop configuration options set to their default values.
   * @return (undocumented)
   */
    java.lang.String SET_TO_DEFAULT_VALUES ()  { throw new RuntimeException(); }
  public  org.apache.spark.deploy.SparkHadoopUtil get ()  { throw new RuntimeException(); }
  /**
   * Returns a Configuration object with Spark configuration applied on top. Unlike
   * the instance method, this will always return a Configuration instance, and not a
   * cluster manager-specific type.
   * The configuration will load all default values set in core-default.xml,
   * and if found on the classpath, those of core-site.xml.
   * This is done before the spark overrides are applied.
   * @param conf (undocumented)
   * @return (undocumented)
   */
    org.apache.hadoop.conf.Configuration newConfiguration (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Append any AWS secrets from the environment variables
   * if both <code>AWS_ACCESS_KEY_ID</code> and <code>AWS_SECRET_ACCESS_KEY</code> are set.
   * If these two are set and <code>AWS_SESSION_TOKEN</code> is also set,
   * then <code>fs.s3a.session.token</code>.
   * The option is set with a source string which includes the hostname
   * on which it was set. This can help debug propagation issues.
   * <p>
   * @param hadoopConf configuration to patch
   * @param keyId key ID or null
   * @param accessKey secret key
   * @param sessionToken session token.
   * @param endpointUrl (undocumented)
   */
    void appendS3CredentialsFromEnvironment (org.apache.hadoop.conf.Configuration hadoopConf, java.lang.String endpointUrl, java.lang.String keyId, java.lang.String accessKey, java.lang.String sessionToken)  { throw new RuntimeException(); }
  /**
   * Extract the sources of a configuration key, or a default value if
   * the key is not found or it has no known sources.
   * Note that options provided by credential providers (JCEKS stores etc)
   * are not resolved, so values retrieved by Configuration.getPassword()
   * may not be recorded as having an origin.
   * @param hadoopConf hadoop configuration to examine.
   * @param key key to look up
   * @return the origin of the current entry in the configuration, or the empty string.
   */
  public  java.lang.String propertySources (org.apache.hadoop.conf.Configuration hadoopConf, java.lang.String key)  { throw new RuntimeException(); }
  /**
   * Create a file on the given file system, optionally making sure erasure coding is disabled.
   * <p>
   * Disabling EC can be helpful as HDFS EC doesn't support hflush(), hsync(), or append().
   * https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-hdfs/HDFSErasureCoding.html#Limitations
   * @param fs (undocumented)
   * @param path (undocumented)
   * @param allowEC (undocumented)
   * @return (undocumented)
   */
  public  org.apache.hadoop.fs.FSDataOutputStream createFile (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path path, boolean allowEC)  { throw new RuntimeException(); }
  public  boolean isFile (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
}
