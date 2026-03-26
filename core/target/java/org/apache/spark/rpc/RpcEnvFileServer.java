package org.apache.spark.rpc;
/**
 * A server used by the RpcEnv to server files to other processes owned by the application.
 * <p>
 * The file server can return URIs handled by common libraries (such as "http" or "hdfs"), or
 * it can return "spark" URIs which will be handled by <code>RpcEnv#fetchFile</code>.
 */
public  interface RpcEnvFileServer {
  /**
   * Adds a local directory to be served via this file server.
   * <p>
   * @param baseUri Leading URI path (files can be retrieved by appending their relative
   *                path to this base URI). This cannot be "files" nor "jars".
   * @param path Path to the local directory.
   * @return URI for the root of the directory in the file server.
   */
  public  java.lang.String addDirectory (java.lang.String baseUri, java.io.File path)  ;
  /**
   * Adds a local directory to be served via this file server.
   * If the directory is already registered with the file server, it will result in a no-op.
   * <p>
   * @param baseUri Leading URI path (files can be retrieved by appending their relative
   *                path to this base URI). This cannot be "files" nor "jars".
   * @param path Path to the local directory.
   * @return URI for the root of the directory in the file server.
   */
  public  java.lang.String addDirectoryIfAbsent (java.lang.String baseUri, java.io.File path)  ;
  /**
   * Adds a file to be served by this RpcEnv. This is used to serve files from the driver
   * to executors when they're stored on the driver's local file system.
   * <p>
   * @param file Local file to serve.
   * @return A URI for the location of the file.
   */
  public  java.lang.String addFile (java.io.File file)  ;
  /**
   * Adds a jar to be served by this RpcEnv. Similar to <code>addFile</code> but for jars added using
   * <code>SparkContext.addJar</code>.
   * <p>
   * @param file Local file to serve.
   * @return A URI for the location of the file.
   */
  public  java.lang.String addJar (java.io.File file)  ;
  /**
   * Removes a file from this RpcEnv.
   * <p>
   * @param key Local file to remove.
   */
  public  void removeFile (java.lang.String key)  ;
  /**
   * Removes a jar to from this RpcEnv.
   * <p>
   * @param key Local jar to remove.
   */
  public  void removeJar (java.lang.String key)  ;
  /** Validates and normalizes the base URI for directories. */
  public  java.lang.String validateDirectoryUri (java.lang.String baseUri)  ;
}
