package org.apache.spark.deploy;
/**
 * Contains util methods to interact with Hadoop from Spark.
 */
  class SparkHadoopUtil implements org.apache.spark.internal.Logging {
  /**
   * Number of records to update input metrics when reading from HadoopRDDs.
   * <p>
   * Each update is potentially expensive because we need to use reflection to access the
   * Hadoop FileSystem API of interest (only available in 2.5), so we should do this sparingly.
   * @return (undocumented)
   */
  static   int UPDATE_INPUT_METRICS_INTERVAL_RECORDS ()  { throw new RuntimeException(); }
  /**
   * Name of the file containing the gateway's Hadoop configuration, to be overlayed on top of the
   * cluster's Hadoop config. It is up to the Spark code launching the application to create
   * this file if it's desired. If the file doesn't exist, it will just be ignored.
   * @return (undocumented)
   */
  static   java.lang.String SPARK_HADOOP_CONF_FILE ()  { throw new RuntimeException(); }
  /**
   * Source for hive-site.xml configuration options.
   * @return (undocumented)
   */
  static   java.lang.String SOURCE_HIVE_SITE ()  { throw new RuntimeException(); }
  /**
   * Source for configuration options set by spark when another source is
   * not explicitly declared.
   * @return (undocumented)
   */
  static   java.lang.String SOURCE_SPARK ()  { throw new RuntimeException(); }
  /**
   * Source for configuration options with <code>spark.hadoop.</code> prefix copied
   * from spark-defaults.
   * @return (undocumented)
   */
  static   java.lang.String SOURCE_SPARK_HADOOP ()  { throw new RuntimeException(); }
  /**
   * AWS Endpoint URL.
   * @return (undocumented)
   */
  static   java.lang.String ENV_VAR_AWS_ENDPOINT_URL ()  { throw new RuntimeException(); }
  /**
   * AWS Access key.
   * @return (undocumented)
   */
  static   java.lang.String ENV_VAR_AWS_ACCESS_KEY ()  { throw new RuntimeException(); }
  /**
   * AWS Secret Key.
   * @return (undocumented)
   */
  static   java.lang.String ENV_VAR_AWS_SECRET_KEY ()  { throw new RuntimeException(); }
  /**
   * AWS Session token.
   * @return (undocumented)
   */
  static   java.lang.String ENV_VAR_AWS_SESSION_TOKEN ()  { throw new RuntimeException(); }
  /**
   * Source for configuration options with <code>spark.hive.</code> prefix copied
   * from spark-defaults.
   * @return (undocumented)
   */
  static   java.lang.String SOURCE_SPARK_HIVE ()  { throw new RuntimeException(); }
  /**
   * Hadoop configuration options set to their default values.
   * @return (undocumented)
   */
  static   java.lang.String SET_TO_DEFAULT_VALUES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.SparkHadoopUtil get ()  { throw new RuntimeException(); }
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
  static   void appendS3CredentialsFromEnvironment (org.apache.hadoop.conf.Configuration hadoopConf, java.lang.String endpointUrl, java.lang.String keyId, java.lang.String accessKey, java.lang.String sessionToken)  { throw new RuntimeException(); }
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
  static public  java.lang.String propertySources (org.apache.hadoop.conf.Configuration hadoopConf, java.lang.String key)  { throw new RuntimeException(); }
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
  static public  org.apache.hadoop.fs.FSDataOutputStream createFile (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path path, boolean allowEC)  { throw new RuntimeException(); }
  static public  boolean isFile (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.Logging.LogStringContext LogStringContext (scala.StringContext sc)  { throw new RuntimeException(); }
  static protected  void withLogContext (java.util.Map<java.lang.String, java.lang.String> context, scala.Function0<scala.runtime.BoxedUnit> body)  { throw new RuntimeException(); }
  static protected  org.apache.spark.internal.MDC MDC (org.apache.spark.internal.LogKey key, Object value)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logInfo (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logDebug (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logTrace (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logWarning (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logError (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void logBasedOnLevel (org.slf4j.event.Level level, scala.Function0<org.apache.spark.internal.MessageWithContext> f)  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  public   SparkHadoopUtil ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration conf ()  { throw new RuntimeException(); }
  /**
   * Runs the given function with a Hadoop UserGroupInformation as a thread local variable
   * (distributed to child threads), used for authenticating HDFS and YARN calls.
   * <p>
   * IMPORTANT NOTE: If this function is going to be called repeated in the same process
   * you need to look https://issues.apache.org/jira/browse/HDFS-3545 and possibly
   * do a FileSystem.closeAllForUGI in order to avoid leaking Filesystems
   * @param func (undocumented)
   */
  public  void runAsSparkUser (scala.Function0<scala.runtime.BoxedUnit> func)  { throw new RuntimeException(); }
  public  org.apache.hadoop.security.UserGroupInformation createSparkUser ()  { throw new RuntimeException(); }
  public  void transferCredentials (org.apache.hadoop.security.UserGroupInformation source, org.apache.hadoop.security.UserGroupInformation dest)  { throw new RuntimeException(); }
  /**
   * Appends S3-specific, spark.hadoop.*, and spark.buffer.size configurations to a Hadoop
   * configuration.
   * @param conf (undocumented)
   * @param hadoopConf (undocumented)
   */
  public  void appendS3AndSparkHadoopHiveConfigurations (org.apache.spark.SparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /**
   * Appends spark.hadoop.* configurations from a {@link SparkConf} to a Hadoop
   * configuration without the spark.hadoop. prefix.
   * @param conf (undocumented)
   * @param hadoopConf (undocumented)
   */
  public  void appendSparkHadoopConfigs (org.apache.spark.ReadOnlySparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /**
   * Appends spark.hadoop.* configurations from a Map to another without the spark.hadoop. prefix.
   * @param srcMap (undocumented)
   * @param destMap (undocumented)
   */
  public  void appendSparkHadoopConfigs (scala.collection.immutable.Map<java.lang.String, java.lang.String> srcMap, scala.collection.mutable.HashMap<java.lang.String, java.lang.String> destMap)  { throw new RuntimeException(); }
  public  void appendSparkHiveConfigs (scala.collection.immutable.Map<java.lang.String, java.lang.String> srcMap, scala.collection.mutable.HashMap<java.lang.String, java.lang.String> destMap)  { throw new RuntimeException(); }
  /**
   * Return an appropriate (subclass) of Configuration. Creating config can initialize some Hadoop
   * subsystems.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  public  org.apache.hadoop.conf.Configuration newConfiguration (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /**
   * Add any user credentials to the job conf which are necessary for running on a secure Hadoop
   * cluster.
   * @param conf (undocumented)
   */
  public  void addCredentials (org.apache.hadoop.mapred.JobConf conf)  { throw new RuntimeException(); }
  public  void addCurrentUserCredentials (org.apache.hadoop.security.Credentials creds)  { throw new RuntimeException(); }
  public  void loginUserFromKeytab (java.lang.String principalName, java.lang.String keytabFilename)  { throw new RuntimeException(); }
  /**
   * Add or overwrite current user's credentials with serialized delegation tokens,
   * also confirms correct hadoop configuration is set.
   * @param tokens (undocumented)
   * @param sparkConf (undocumented)
   */
    void addDelegationTokens (byte[] tokens, org.apache.spark.SparkConf sparkConf)  { throw new RuntimeException(); }
  /**
   * Returns a function that can be called to find Hadoop FileSystem bytes read. If
   * getFSBytesReadOnThreadCallback is called from thread r at time t, the returned callback will
   * return the bytes read on r since t.
   * @return (undocumented)
   */
    scala.Function0<java.lang.Object> getFSBytesReadOnThreadCallback ()  { throw new RuntimeException(); }
  /**
   * Returns a function that can be called to find Hadoop FileSystem bytes written. If
   * getFSBytesWrittenOnThreadCallback is called from thread r at time t, the returned callback will
   * return the bytes written on r since t.
   * <p>
   * @return None if the required method can't be found.
   */
    scala.Function0<java.lang.Object> getFSBytesWrittenOnThreadCallback ()  { throw new RuntimeException(); }
  /**
   * Get {@link FileStatus} objects for all leaf children (files) under the given base path. If the
   * given path points to a file, return a single-element collection containing {@link FileStatus} of
   * that file.
   * @param fs (undocumented)
   * @param basePath (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Seq<org.apache.hadoop.fs.FileStatus> listLeafStatuses (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path basePath)  { throw new RuntimeException(); }
  /**
   * Get {@link FileStatus} objects for all leaf children (files) under the given base path. If the
   * given path points to a file, return a single-element collection containing {@link FileStatus} of
   * that file.
   * @param fs (undocumented)
   * @param baseStatus (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Seq<org.apache.hadoop.fs.FileStatus> listLeafStatuses (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.FileStatus baseStatus)  { throw new RuntimeException(); }
  public  boolean isGlobPath (org.apache.hadoop.fs.Path pattern)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.hadoop.fs.Path> globPath (org.apache.hadoop.fs.Path pattern)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.hadoop.fs.Path> globPath (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path pattern)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.hadoop.fs.Path> globPathIfNecessary (org.apache.hadoop.fs.Path pattern)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.hadoop.fs.Path> globPathIfNecessary (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path pattern)  { throw new RuntimeException(); }
  /**
   * Substitute variables by looking them up in Hadoop configs. Only variables that match the
   * ${hadoopconf- .. } pattern are substituted.
   * @param text (undocumented)
   * @param hadoopConf (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String substituteHadoopVariables (java.lang.String text, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /**
   * Dump the credentials' tokens to string values.
   * <p>
   * @param credentials credentials
   * @return an iterator over the string values. If no credentials are passed in: an empty list
   */
    scala.collection.Iterable<java.lang.String> dumpTokens (org.apache.hadoop.security.Credentials credentials)  { throw new RuntimeException(); }
  /**
   * Convert a token to a string for logging.
   * If its an abstract delegation token, attempt to unmarshall it and then
   * print more details, including timestamps in human-readable form.
   * <p>
   * @param token token to convert to a string
   * @return a printable string value.
   */
    java.lang.String tokenToString (org.apache.hadoop.security.token.Token<? extends org.apache.hadoop.security.token.TokenIdentifier> token)  { throw new RuntimeException(); }
  public  byte[] serialize (org.apache.hadoop.security.Credentials creds)  { throw new RuntimeException(); }
  public  org.apache.hadoop.security.Credentials deserialize (byte[] tokenBytes)  { throw new RuntimeException(); }
  public  boolean isProxyUser (org.apache.hadoop.security.UserGroupInformation ugi)  { throw new RuntimeException(); }
}
