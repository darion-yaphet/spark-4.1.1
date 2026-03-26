package org.apache.spark.util;
/**
 * Various utility methods used by Spark.
 */
public  class Utils {
  static public  class OriginalTryStackTraceException extends java.lang.Exception {
    public   OriginalTryStackTraceException ()  { throw new RuntimeException(); }
    public  int doTryWithCallerStacktraceDepth ()  { throw new RuntimeException(); }
  }
  static public  java.lang.String osName ()  { throw new RuntimeException(); }
  static public  java.lang.String osVersion ()  { throw new RuntimeException(); }
  static public  java.lang.String osArch ()  { throw new RuntimeException(); }
  static public  java.lang.String javaVersion ()  { throw new RuntimeException(); }
  static public  boolean isWindows ()  { throw new RuntimeException(); }
  static public  boolean isMac ()  { throw new RuntimeException(); }
  static public  boolean isMacOnAppleSilicon ()  { throw new RuntimeException(); }
  static public  boolean isLinux ()  { throw new RuntimeException(); }
  static public  boolean isUnix ()  { throw new RuntimeException(); }
  static public  java.util.Random random ()  { throw new RuntimeException(); }
  /**
   * Define a default value for driver memory here since this value is referenced across the code
   * base and nearly all files already use Utils.scala
   * @return (undocumented)
   */
  static public  int DEFAULT_DRIVER_MEM_MB ()  { throw new RuntimeException(); }
  static public  int MAX_DIR_CREATION_ATTEMPTS ()  { throw new RuntimeException(); }
  /** Scheme used for files that are locally available on worker nodes in the cluster. */
  static public  java.lang.String LOCAL_SCHEME ()  { throw new RuntimeException(); }
  /** Deserialize a Long value (used for {@link org.apache.spark.api.python.PythonPartitioner}) */
  static public  long deserializeLongValue (byte[] bytes)  { throw new RuntimeException(); }
  /** Serialize via nested stream using specific serializer */
  static public  void serializeViaNestedStream (java.io.OutputStream os, org.apache.spark.serializer.SerializerInstance ser, scala.Function1<org.apache.spark.serializer.SerializationStream, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /** Deserialize via nested stream using specific serializer */
  static public  void deserializeViaNestedStream (java.io.InputStream is, org.apache.spark.serializer.SerializerInstance ser, scala.Function1<org.apache.spark.serializer.DeserializationStream, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /** String interning to reduce the memory usage. */
  static public  java.lang.String weakIntern (java.lang.String s)  { throw new RuntimeException(); }
  /**
   * Run a segment of code using a different context class loader in the current thread
   * @param ctxClassLoader (undocumented)
   * @param fn (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> T withContextClassLoader (java.lang.ClassLoader ctxClassLoader, scala.Function0<T> fn)  { throw new RuntimeException(); }
  /**
   * Primitive often used when writing {@link java.nio.ByteBuffer} to {@link java.io.DataOutput}
   * @param bb (undocumented)
   * @param out (undocumented)
   */
  static public  void writeByteBuffer (java.nio.ByteBuffer bb, java.io.DataOutput out)  { throw new RuntimeException(); }
  /**
   * Primitive often used when writing {@link java.nio.ByteBuffer} to {@link java.io.OutputStream}
   * @param bb (undocumented)
   * @param out (undocumented)
   */
  static public  void writeByteBuffer (java.nio.ByteBuffer bb, java.io.OutputStream out)  { throw new RuntimeException(); }
  /**
   * JDK equivalent of <code>chmod 700 file</code>.
   * <p>
   * @param file the file whose permissions will be modified
   * @return true if the permissions were successfully changed, false otherwise.
   */
  static public  boolean chmod700 (java.io.File file)  { throw new RuntimeException(); }
  /**
   * Create a temporary directory inside the given parent directory. The directory will be
   * automatically deleted when the VM shuts down.
   * @param root (undocumented)
   * @param namePrefix (undocumented)
   * @return (undocumented)
   */
  static public  java.io.File createTempDir (java.lang.String root, java.lang.String namePrefix)  { throw new RuntimeException(); }
  /**
   * Create a temporary directy that will always be cleaned up when the executor stops,
   * even in the case of a hard shutdown when the shutdown hooks don't get run.
   * <p>
   * Currently this only provides special behavior on YARN, where the local dirs are not
   * guaranteed to be cleaned up on executors hard shutdown.
   * @param conf (undocumented)
   * @param namePrefix (undocumented)
   * @return (undocumented)
   */
  static public  java.io.File createExecutorLocalTempDir (org.apache.spark.SparkConf conf, java.lang.String namePrefix)  { throw new RuntimeException(); }
  /**
   * Copy the first <code>maxSize</code> bytes of data from the InputStream to an in-memory
   * buffer, primarily to check for corruption.
   * <p>
   * This returns a new InputStream which contains the same data as the original input stream.
   * It may be entirely on in-memory buffer, or it may be a combination of in-memory data, and then
   * continue to read from the original stream. The only real use of this is if the original input
   * stream will potentially detect corruption while the data is being read (e.g. from compression).
   * This allows for an eager check of corruption in the first maxSize bytes of data.
   * <p>
   * @return An InputStream which includes all data from the original stream (combining buffered
   *         data and remaining data in the original stream)
   * @param in (undocumented)
   * @param maxSize (undocumented)
   */
  static public  java.io.InputStream copyStreamUpTo (java.io.InputStream in, long maxSize)  { throw new RuntimeException(); }
  /**
   * A file name may contain some invalid URI characters, such as " ". This method will convert the
   * file name to a raw path accepted by <code>java.net.URI(String)</code>.
   * <p>
   * Note: the file name must not contain "/" or "\"
   * @param fileName (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String encodeFileNameToURIRawPath (java.lang.String fileName)  { throw new RuntimeException(); }
  /**
   * Same as {@link encodeFileNameToURIRawPath} but returns the relative UNIX path.
   * @param path (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String encodeRelativeUnixPathToURIRawPath (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Get the file name from uri's raw path and decode it. If the raw path of uri ends with "/",
   * return the name before the last "/".
   * @param uri (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String decodeFileNameInURI (java.net.URI uri)  { throw new RuntimeException(); }
  /**
   * Download a file or directory to target directory. Supports fetching the file in a variety of
   * ways, including HTTP, Hadoop-compatible filesystems, and files on a standard filesystem, based
   * on the URL parameter. Fetching directories is only supported from Hadoop-compatible
   * filesystems.
   * <p>
   * If <code>useCache</code> is true, first attempts to fetch the file to a local cache that's shared
   * across executors running the same application. <code>useCache</code> is used mainly for
   * the executors, and not in local mode.
   * <p>
   * Throws SparkException if the target file already exists and has different contents than
   * the requested file.
   * <p>
   * If <code>shouldUntar</code> is true, it untars the given url if it is a tar.gz or tgz into <code>targetDir</code>.
   * This is a legacy behavior, and users should better use <code>spark.archives</code> configuration or
   * <code>SparkContext.addArchive</code>
   * @param url (undocumented)
   * @param targetDir (undocumented)
   * @param conf (undocumented)
   * @param hadoopConf (undocumented)
   * @param timestamp (undocumented)
   * @param useCache (undocumented)
   * @param shouldUntar (undocumented)
   * @return (undocumented)
   */
  static public  java.io.File fetchFile (java.lang.String url, java.io.File targetDir, org.apache.spark.ReadOnlySparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf, long timestamp, boolean useCache, boolean shouldUntar)  { throw new RuntimeException(); }
  /**
   * Unpacks an archive file into the specified directory. It expects .jar, .zip, .tar.gz, .tgz
   * and .tar files. This behaves same as Hadoop's archive in distributed cache. This method is
   * basically copied from <code>org.apache.hadoop.yarn.util.FSDownload.unpack</code>.
   * @param source (undocumented)
   * @param dest (undocumented)
   */
  static public  void unpack (java.io.File source, java.io.File dest)  { throw new RuntimeException(); }
  /** Records the duration of running `body`. */
  static public <T extends java.lang.Object> scala.Tuple2<T, java.lang.Object> timeTakenMs (scala.Function0<T> body)  { throw new RuntimeException(); }
  /**
   * Download a file or directory to target directory. Supports fetching the file in a variety of
   * ways, including HTTP, Hadoop-compatible filesystems, and files on a standard filesystem, based
   * on the URL parameter. Fetching directories is only supported from Hadoop-compatible
   * filesystems.
   * <p>
   * Throws SparkException if the target file already exists and has different contents than
   * the requested file.
   * @param url (undocumented)
   * @param targetDir (undocumented)
   * @param filename (undocumented)
   * @param conf (undocumented)
   * @param hadoopConf (undocumented)
   * @return (undocumented)
   */
  static public  java.io.File doFetchFile (java.lang.String url, java.io.File targetDir, java.lang.String filename, org.apache.spark.ReadOnlySparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /**
   * Fetch a file or directory from a Hadoop-compatible filesystem.
   * <p>
   * Visible for testing
   * @param path (undocumented)
   * @param targetDir (undocumented)
   * @param fs (undocumented)
   * @param conf (undocumented)
   * @param hadoopConf (undocumented)
   * @param fileOverwrite (undocumented)
   * @param filename (undocumented)
   */
  static   void fetchHcfsFile (org.apache.hadoop.fs.Path path, java.io.File targetDir, org.apache.hadoop.fs.FileSystem fs, org.apache.spark.ReadOnlySparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf, boolean fileOverwrite, scala.Option<java.lang.String> filename)  { throw new RuntimeException(); }
  /**
   * Validate that a given URI is actually a valid URL as well.
   * @param uri The URI to validate
   */
  static public  void validateURL (java.net.URI uri) throws java.net.MalformedURLException { throw new RuntimeException(); }
  /**
   * Get the path of a temporary directory.  Spark's local directories can be configured through
   * multiple settings, which are used with the following precedence:
   * <p>
   *   - If called from inside of a YARN container, this will return a directory chosen by YARN.
   *   - If the SPARK_LOCAL_DIRS environment variable is set, this will return a directory from it.
   *   - Otherwise, if the spark.local.dir is set, this will return a directory from it.
   *   - Otherwise, this will return java.io.tmpdir.
   * <p>
   * Some of these configuration options might be lists of multiple paths, but this method will
   * always return a single directory. The return directory is chosen randomly from the array
   * of directories it gets from getOrCreateLocalRootDirs.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String getLocalDir (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  static   boolean isRunningInYarnContainer (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Returns if the current codes are running in a Spark task, e.g., in executors.
   * @return (undocumented)
   */
  static public  boolean isInRunningSparkTask ()  { throw new RuntimeException(); }
  /**
   * Gets or creates the directories listed in spark.local.dir or SPARK_LOCAL_DIRS,
   * and returns only the directories that exist / could be created.
   * <p>
   * If no directories could be created, this will return an empty list.
   * <p>
   * This method will cache the local directories for the application when it's first invoked.
   * So calling it multiple times with a different configuration will always return the same
   * set of directories.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static   java.lang.String[] getOrCreateLocalRootDirs (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Return the configured local directories where Spark can write files. This
   * method does not create any directories on its own, it only encapsulates the
   * logic of locating the local directories according to deployment mode.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String[] getConfiguredLocalDirs (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /** Used by unit tests. Do not call from other places. */
  static   void clearLocalRootDirs ()  { throw new RuntimeException(); }
  /**
   * Shuffle the elements of a collection into a random order, returning the
   * result in a new collection. Unlike scala.util.Random.shuffle, this method
   * uses a local random number generator, avoiding inter-thread contention.
   * @param seq (undocumented)
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.collection.immutable.Seq<T> randomize (scala.collection.IterableOnce<T> seq, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  /**
   * Shuffle the elements of an array into a random order, modifying the
   * original array. Returns the original array.
   * @param arr (undocumented)
   * @param rand (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> java.lang.Object randomizeInPlace (java.lang.Object arr, java.util.Random rand)  { throw new RuntimeException(); }
  /**
   * Allow setting a custom host name
   * @param hostname (undocumented)
   */
  static public  void setCustomHostname (java.lang.String hostname)  { throw new RuntimeException(); }
  /**
   * Get the local machine's FQDN.
   * @return (undocumented)
   */
  static public  java.lang.String localCanonicalHostName ()  { throw new RuntimeException(); }
  /**
   * Get the local machine's hostname.
   * In case of IPv6, getHostAddress may return '0:0:0:0:0:0:0:1'.
   * @return (undocumented)
   */
  static public  java.lang.String localHostName ()  { throw new RuntimeException(); }
  /**
   * Get the local machine's URI.
   * @return (undocumented)
   */
  static public  java.lang.String localHostNameForURI ()  { throw new RuntimeException(); }
  static   java.lang.String addBracketsIfNeeded (java.lang.String addr)  { throw new RuntimeException(); }
  /**
   * Normalize IPv6 IPs and no-op on all other hosts.
   * @param host (undocumented)
   * @return (undocumented)
   */
  static   java.lang.String normalizeIpIfNeeded (java.lang.String host)  { throw new RuntimeException(); }
  /**
   * Checks if the host contains only valid hostname/ip without port
   * NOTE: Incase of IPV6 ip it should be enclosed inside []
   * @param host (undocumented)
   */
  static public  void checkHost (java.lang.String host)  { throw new RuntimeException(); }
  static public  void checkHostPort (java.lang.String hostPort)  { throw new RuntimeException(); }
  static public  scala.Tuple2<java.lang.String, java.lang.Object> parseHostPort (java.lang.String hostPort)  { throw new RuntimeException(); }
  /**
   * Return the string to tell how long has passed in milliseconds.
   * @param startTimeNs - a timestamp in nanoseconds returned by <code>System.nanoTime</code>.
   * @return (undocumented)
   */
  static public  java.lang.String getUsedTimeNs (long startTimeNs)  { throw new RuntimeException(); }
  /**
   * Delete a file or directory and its contents recursively.
   * Don't follow directories if they are symlinks.
   * Throws an exception if deletion is unsuccessful.
   * @param file (undocumented)
   */
  static public  void deleteRecursively (java.io.File file)  { throw new RuntimeException(); }
  /**
   * Determines if a directory contains any files newer than cutoff seconds.
   * <p>
   * @param dir must be the path to a directory, or IllegalArgumentException is thrown
   * @param cutoff measured in seconds. Returns true if there are any files or directories in the
   *               given directory whose last modified time is later than this many seconds ago
   * @return (undocumented)
   */
  static public  boolean doesDirectoryContainAnyNewFiles (java.io.File dir, long cutoff)  { throw new RuntimeException(); }
  /**
   * Convert a time parameter such as (50s, 100ms, or 250us) to milliseconds for internal use. If
   * no suffix is provided, the passed number is assumed to be in ms.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  long timeStringAsMs (java.lang.String str)  { throw new RuntimeException(); }
  /**
   * Convert a time parameter such as (50s, 100ms, or 250us) to seconds for internal use. If
   * no suffix is provided, the passed number is assumed to be in seconds.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  long timeStringAsSeconds (java.lang.String str)  { throw new RuntimeException(); }
  /**
   * Convert a passed byte string (e.g. 50b, 100k, or 250m) to bytes for internal use.
   * <p>
   * If no suffix is provided, the passed number is assumed to be in bytes.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  long byteStringAsBytes (java.lang.String str)  { throw new RuntimeException(); }
  /**
   * Convert a passed byte string (e.g. 50b, 100k, or 250m) to kibibytes for internal use.
   * <p>
   * If no suffix is provided, the passed number is assumed to be in kibibytes.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  long byteStringAsKb (java.lang.String str)  { throw new RuntimeException(); }
  /**
   * Convert a passed byte string (e.g. 50b, 100k, or 250m) to mebibytes for internal use.
   * <p>
   * If no suffix is provided, the passed number is assumed to be in mebibytes.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  long byteStringAsMb (java.lang.String str)  { throw new RuntimeException(); }
  /**
   * Convert a passed byte string (e.g. 50b, 100k, or 250m, 500g) to gibibytes for internal use.
   * <p>
   * If no suffix is provided, the passed number is assumed to be in gibibytes.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  long byteStringAsGb (java.lang.String str)  { throw new RuntimeException(); }
  /**
   * Convert a Java memory parameter passed to -Xmx (such as 300m or 1g) to a number of mebibytes.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  int memoryStringToMb (java.lang.String str)  { throw new RuntimeException(); }
  /**
   * Convert a quantity in bytes to a human-readable string such as "4.0 MiB".
   * @param size (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String bytesToString (long size)  { throw new RuntimeException(); }
  static public  java.lang.String bytesToString (scala.math.BigInt size)  { throw new RuntimeException(); }
  /**
   * Returns a human-readable string representing a duration such as "35ms"
   * @param ms (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String msDurationToString (long ms)  { throw new RuntimeException(); }
  /**
   * Convert a quantity in megabytes to a human-readable string such as "4.0 MiB".
   * @param megabytes (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String megabytesToString (long megabytes)  { throw new RuntimeException(); }
  /**
   * Execute a command and return the process running the command.
   * @param command (undocumented)
   * @param workingDir (undocumented)
   * @param extraEnvironment (undocumented)
   * @param redirectStderr (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.Process executeCommand (scala.collection.immutable.Seq<java.lang.String> command, java.io.File workingDir, scala.collection.Map<java.lang.String, java.lang.String> extraEnvironment, boolean redirectStderr)  { throw new RuntimeException(); }
  /**
   * Execute a command and get its output, throwing an exception if it yields a code other than 0.
   * @param command (undocumented)
   * @param workingDir (undocumented)
   * @param extraEnvironment (undocumented)
   * @param redirectStderr (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String executeAndGetOutput (scala.collection.immutable.Seq<java.lang.String> command, java.io.File workingDir, scala.collection.Map<java.lang.String, java.lang.String> extraEnvironment, boolean redirectStderr)  { throw new RuntimeException(); }
  /**
   * Return and start a daemon thread that processes the content of the input stream line by line.
   * @param threadName (undocumented)
   * @param inputStream (undocumented)
   * @param processLine (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.Thread processStreamByLine (java.lang.String threadName, java.io.InputStream inputStream, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> processLine)  { throw new RuntimeException(); }
  /**
   * Execute a block of code that evaluates to Unit, forwarding any uncaught exceptions to the
   * default UncaughtExceptionHandler
   * <p>
   * NOTE: This method is to be called by the spark-started JVM process.
   * @param block (undocumented)
   */
  static public  void tryOrExit (scala.Function0<scala.runtime.BoxedUnit> block)  { throw new RuntimeException(); }
  /**
   * Execute a block of code that evaluates to Unit, stop SparkContext if there is any uncaught
   * exception
   * <p>
   * NOTE: This method is to be called by the driver-side components to avoid stopping the
   * user-started JVM process completely; in contrast, tryOrExit is to be called in the
   * spark-started JVM process .
   * @param sc (undocumented)
   * @param block (undocumented)
   */
  static public  void tryOrStopSparkContext (org.apache.spark.SparkContext sc, scala.Function0<scala.runtime.BoxedUnit> block)  { throw new RuntimeException(); }
  /** Executes the given block. Log non-fatal errors if any, and only throw fatal errors */
  static public  void tryLogNonFatalError (scala.Function0<scala.runtime.BoxedUnit> block)  { throw new RuntimeException(); }
  /**
   * Execute a block of code and call the failure callbacks in the catch block. If exceptions occur
   * in either the catch or the finally block, they are appended to the list of suppressed
   * exceptions in original exception which is then rethrown.
   * <p>
   * This is primarily an issue with <code>catch { abort() }</code> or <code>finally { out.close() }</code> blocks,
   * where the abort/close needs to be called to clean up <code>out</code>, but if an exception happened
   * in <code>out.write</code>, it's likely <code>out</code> may be corrupted and <code>abort</code> or <code>out.close</code> will
   * fail as well. This would then suppress the original/likely more meaningful
   * exception from the original <code>out.write</code> call.
   * @param block (undocumented)
   * @param catchBlock (undocumented)
   * @param finallyBlock (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> T tryWithSafeFinallyAndFailureCallbacks (scala.Function0<T> block, scala.Function0<scala.runtime.BoxedUnit> catchBlock, scala.Function0<scala.runtime.BoxedUnit> finallyBlock)  { throw new RuntimeException(); }
  static public  java.lang.String TRY_WITH_CALLER_STACKTRACE_FULL_STACKTRACE ()  { throw new RuntimeException(); }
  /**
   * Use Try with stacktrace substitution for the caller retrieving the error.
   * <p>
   * Normally in case of failure, the exception would have the stacktrace of the caller that
   * originally called doTryWithCallerStacktrace. However, we want to replace the part above
   * this function with the stacktrace of the caller who calls getTryWithCallerStacktrace.
   * So here we save the part of the stacktrace below doTryWithCallerStacktrace, and
   * getTryWithCallerStacktrace will stitch it with the new stack trace of the caller.
   * The full original stack trace is kept in ex.getSuppressed.
   * <p>
   * @param f Code block to be wrapped in Try
   * @return Try with Success or Failure of the code block. Use with getTryWithCallerStacktrace.
   */
  static public <T extends java.lang.Object> scala.util.Try<T> doTryWithCallerStacktrace (scala.Function0<T> f)  { throw new RuntimeException(); }
  /**
   * Retrieve the result of Try that was created by doTryWithCallerStacktrace.
   * <p>
   * In case of failure, the resulting exception has a stack trace that combines the stack trace
   * below the original doTryWithCallerStacktrace which triggered it, with the caller stack trace
   * of the current caller of getTryWithCallerStacktrace.
   * <p>
   * Full stack trace of the original doTryWithCallerStacktrace caller can be retrieved with
   * <code></code><code>
   * ex.getSuppressed.find { e =&gt;
   *   e.isInstanceOf[Utils.OriginalTryStackTraceException]
   * }
   * </code><code></code>
   * <p>
   * @param t Try from doTryWithCallerStacktrace
   * @return Result of the Try or rethrows the failure exception with modified stacktrace.
   */
  static public <T extends java.lang.Object> T getTryWithCallerStacktrace (scala.util.Try<T> t)  { throw new RuntimeException(); }
  /**
   * When called inside a class in the spark package, returns the name of the user code class
   * (outside the spark package) that called into Spark, as well as which Spark method they called.
   * This is used, for example, to tell users where in their code each RDD got created.
   * <p>
   * @param skipClass Function that is used to exclude non-user-code classes.
   * @return (undocumented)
   */
  static public  org.apache.spark.util.CallSite getCallSite (scala.Function1<java.lang.String, java.lang.Object> skipClass)  { throw new RuntimeException(); }
  /**
   * Return the file length, if the file is compressed it returns the uncompressed file length.
   * It also caches the uncompressed file size to avoid repeated decompression. The cache size is
   * read from workerConf.
   * @param file (undocumented)
   * @param workConf (undocumented)
   * @return (undocumented)
   */
  static public  long getFileLength (java.io.File file, org.apache.spark.ReadOnlySparkConf workConf)  { throw new RuntimeException(); }
  /** Return a string containing part of a file from byte 'start' to 'end'. */
  static public  java.lang.String offsetBytes (java.lang.String path, long length, long start, long end)  { throw new RuntimeException(); }
  /**
   * Return a string containing data across a set of files. The <code>startIndex</code>
   * and <code>endIndex</code> is based on the cumulative size of all the files take in
   * the given order. See figure below for more details.
   * @param files (undocumented)
   * @param fileLengths (undocumented)
   * @param start (undocumented)
   * @param end (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String offsetBytes (scala.collection.immutable.Seq<java.io.File> files, scala.collection.immutable.Seq<java.lang.Object> fileLengths, long start, long end)  { throw new RuntimeException(); }
  /**
   * Clone an object using a Spark serializer.
   * @param value (undocumented)
   * @param serializer (undocumented)
   * @param evidence$2 (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> T clone (T value, org.apache.spark.serializer.SerializerInstance serializer, scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
  /**
   * Split a string of potentially quoted arguments from the command line the way that a shell
   * would do it to determine arguments to a command. For example, if the string is 'a "b c" d',
   * then it would be parsed as three arguments: 'a', 'b c' and 'd'.
   * @param s (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Seq<java.lang.String> splitCommandString (java.lang.String s)  { throw new RuntimeException(); }
  static public  int nonNegativeMod (int x, int mod)  { throw new RuntimeException(); }
  static public  int nonNegativeHash (java.lang.Object obj)  { throw new RuntimeException(); }
  /**
   * Returns the system properties map that is thread-safe to iterator over. It gets the
   * properties which have been set explicitly, as well as those for which only a default value
   * has been defined.
   * @return (undocumented)
   */
  static public  scala.collection.Map<java.lang.String, java.lang.String> getSystemProperties ()  { throw new RuntimeException(); }
  /**
   * Method executed for repeating a task for side effects.
   * Unlike a for comprehension, it permits JVM JIT optimization
   * @param numIters (undocumented)
   * @param f (undocumented)
   */
  static public  void times (int numIters, scala.Function0<scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /**
   * Timing method based on iterations that permit JVM JIT optimization.
   * <p>
   * @param numIters number of iterations
   * @param f function to be executed. If prepare is not None, the running time of each call to f
   *          must be an order of magnitude longer than one nanosecond for accurate timing.
   * @param prepare function to be executed before each call to f. Its running time doesn't count.
   * @return the total time across all iterations (not counting preparation time) in nanoseconds.
   */
  static public  long timeIt (int numIters, scala.Function0<scala.runtime.BoxedUnit> f, scala.Option<scala.Function0<scala.runtime.BoxedUnit>> prepare)  { throw new RuntimeException(); }
  /**
   * Counts the number of elements of an iterator.
   * @param iterator (undocumented)
   * @return (undocumented)
   */
  static public  long getIteratorSize (scala.collection.Iterator<java.lang.Object> iterator)  { throw new RuntimeException(); }
  /**
   * Generate a zipWithIndex iterator, avoid index value overflowing problem
   * in scala's zipWithIndex
   * @param iter (undocumented)
   * @param startIndex (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.collection.Iterator<scala.Tuple2<T, java.lang.Object>> getIteratorZipWithIndex (scala.collection.Iterator<T> iter, long startIndex)  { throw new RuntimeException(); }
  /**
   * Creates a symlink.
   * <p>
   * @param src absolute path to the source
   * @param dst relative path for the destination
   */
  static public  void symlink (java.io.File src, java.io.File dst)  { throw new RuntimeException(); }
  /**
   * Return a Hadoop FileSystem with the scheme encoded in the given path.
   * @param path (undocumented)
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.hadoop.fs.FileSystem getHadoopFileSystem (java.net.URI path, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  /**
   * Return a Hadoop FileSystem with the scheme encoded in the given path.
   * @param path (undocumented)
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.hadoop.fs.FileSystem getHadoopFileSystem (java.lang.String path, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  /**
   * Whether the underlying Java version is at most 17.
   * @return (undocumented)
   */
  static public  boolean isJavaVersionAtMost17 ()  { throw new RuntimeException(); }
  /**
   * Whether the underlying Java version is at least 21.
   * @return (undocumented)
   */
  static public  boolean isJavaVersionAtLeast21 ()  { throw new RuntimeException(); }
  /**
   * Whether the underlying JVM prefer IPv6 addresses.
   * @return (undocumented)
   */
  static public  boolean preferIPv6 ()  { throw new RuntimeException(); }
  /**
   * Pattern for matching a Windows drive, which contains only a single alphabet character.
   * @return (undocumented)
   */
  static public  scala.util.matching.Regex windowsDrive ()  { throw new RuntimeException(); }
  /**
   * Terminates a process waiting for at most the specified duration.
   * <p>
   * @return the process exit value if it was successfully terminated, else None
   * @param process (undocumented)
   * @param timeoutMs (undocumented)
   */
  static public  scala.Option<java.lang.Object> terminateProcess (java.lang.Process process, long timeoutMs)  { throw new RuntimeException(); }
  /**
   * Return the stderr of a process after waiting for the process to terminate.
   * If the process does not terminate within the specified timeout, return None.
   * @param process (undocumented)
   * @param timeoutMs (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<java.lang.String> getStderr (java.lang.Process process, long timeoutMs)  { throw new RuntimeException(); }
  /**
   * Execute the given block, logging and re-throwing any uncaught exception.
   * This is particularly useful for wrapping code that runs in a thread, to ensure
   * that exceptions are printed, and to avoid having to catch Throwable.
   * @param f (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> T logUncaughtExceptions (scala.Function0<T> f)  { throw new RuntimeException(); }
  /** Executes the given block in a Try, logging any uncaught exceptions. */
  static public <T extends java.lang.Object> scala.util.Try<T> tryLog (scala.Function0<T> f)  { throw new RuntimeException(); }
  /** Returns true if the given exception was fatal. See docs for scala.util.control.NonFatal. */
  static public  boolean isFatalError (java.lang.Throwable e)  { throw new RuntimeException(); }
  /** Resolve a comma-separated list of paths. */
  static public  java.lang.String resolveURIs (java.lang.String paths)  { throw new RuntimeException(); }
  /** Return all non-local paths from a comma-separated list of paths. */
  static public  java.lang.String[] nonLocalPaths (java.lang.String paths, boolean testWindows)  { throw new RuntimeException(); }
  /**
   * Load default Spark properties from the given file. If no file is provided,
   * use the common defaults file. This mutates state in the given SparkConf and
   * in this JVM's system properties if the config specified in the file is not
   * already set. Return the path of the properties file used.
   * @param conf (undocumented)
   * @param filePath (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String loadDefaultSparkProperties (org.apache.spark.SparkConf conf, java.lang.String filePath)  { throw new RuntimeException(); }
  /**
   * Implements the same logic as JDK <code>java.lang.String#trim</code> by removing leading and trailing
   * non-printable characters less or equal to '\u0020' (SPACE) but preserves natural line
   * delimiters according to {@link java.util.Properties} load method. The natural line delimiters are
   * removed by JDK during load. Therefore any remaining ones have been specifically provided and
   * escaped by the user, and must not be ignored
   * <p>
   * @param str
   * @return the trimmed value of str
   */
  static   java.lang.String trimExceptCRLF (java.lang.String str)  { throw new RuntimeException(); }
  /** Load properties present in the given file. */
  static public  scala.collection.Map<java.lang.String, java.lang.String> getPropertiesFromFile (java.lang.String filename)  { throw new RuntimeException(); }
  /** Return the path of the default Spark properties file. */
  static public  java.lang.String getDefaultPropertiesFile (scala.collection.Map<java.lang.String, java.lang.String> env)  { throw new RuntimeException(); }
  /**
   * Return a nice string representation of the exception. It will call "printStackTrace" to
   * recursively generate the stack trace including the exception and its causes.
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String exceptionString (java.lang.Throwable e)  { throw new RuntimeException(); }
  static public  java.lang.String CONNECT_EXECUTE_THREAD_PREFIX ()  { throw new RuntimeException(); }
  static   scala.math.Ordering<java.lang.management.ThreadInfo> threadInfoOrdering ()  { throw new RuntimeException(); }
  /** Return a thread dump of all threads' stacktraces.  Used to capture dumps for the web UI */
  static public  org.apache.spark.status.api.v1.ThreadStackTrace[] getThreadDump ()  { throw new RuntimeException(); }
  /** Return a heap dump. Used to capture dumps for the web UI */
  static public  java.lang.String[] getHeapHistogram ()  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.status.api.v1.ThreadStackTrace> getThreadDumpForThread (long threadId)  { throw new RuntimeException(); }
  /**
   * Convert all spark properties set in the given SparkConf to a sequence of java options.
   * @param conf (undocumented)
   * @param filterKey (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Seq<java.lang.String> sparkJavaOpts (org.apache.spark.ReadOnlySparkConf conf, scala.Function1<java.lang.String, java.lang.Object> filterKey)  { throw new RuntimeException(); }
  /**
   * Maximum number of retries when binding to a port before giving up.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  int portMaxRetries (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Returns the user port to try when trying to bind a service. Handles wrapping and skipping
   * privileged ports.
   * @param base (undocumented)
   * @param offset (undocumented)
   * @return (undocumented)
   */
  static public  int userPort (int base, int offset)  { throw new RuntimeException(); }
  /**
   * Attempt to start a service on the given port, or fail after a number of attempts.
   * Use a shared configuration for the maximum number of port retries.
   * @param startPort (undocumented)
   * @param startService (undocumented)
   * @param conf (undocumented)
   * @param serviceName (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.Tuple2<T, java.lang.Object> startServiceOnPort (int startPort, scala.Function1<java.lang.Object, scala.Tuple2<T, java.lang.Object>> startService, org.apache.spark.ReadOnlySparkConf conf, java.lang.String serviceName)  { throw new RuntimeException(); }
  /**
   * Attempt to start a service on the given port, or fail after a number of attempts.
   * Each subsequent attempt uses 1 + the port used in the previous attempt (unless the port is 0).
   * <p>
   * @param startPort The initial port to start the service on.
   * @param startService Function to start service on a given port.
   *                     This is expected to throw java.net.BindException on port collision.
   * @param maxRetries The maximum number of retries when binding to a port.
   * @param serviceName Name of the service.
   * @return (service: T, port: Int)
   */
  static public <T extends java.lang.Object> scala.Tuple2<T, java.lang.Object> startServiceOnPort (int startPort, scala.Function1<java.lang.Object, scala.Tuple2<T, java.lang.Object>> startService, int maxRetries, java.lang.String serviceName)  { throw new RuntimeException(); }
  /**
   * Return whether the exception is caused by an address-port collision when binding.
   * @param exception (undocumented)
   * @return (undocumented)
   */
  static public  boolean isBindCollision (java.lang.Throwable exception)  { throw new RuntimeException(); }
  /**
   * configure a new log4j level
   * @param l (undocumented)
   */
  static public  void setLogLevel (org.apache.logging.log4j.Level l)  { throw new RuntimeException(); }
  static public  void setLogLevelIfNeeded (java.lang.String newLogLevel)  { throw new RuntimeException(); }
  /**
   * Get current log level
   * @return (undocumented)
   */
  static public  java.lang.String getLogLevel ()  { throw new RuntimeException(); }
  /**
   * Return the current system LD_LIBRARY_PATH name
   * @return (undocumented)
   */
  static public  java.lang.String libraryPathEnvName ()  { throw new RuntimeException(); }
  /**
   * Return the prefix of a command that appends the given library paths to the
   * system-specific library path environment variable. On Unix, for instance,
   * this returns the string LD_LIBRARY_PATH="path1:path2:$LD_LIBRARY_PATH".
   * @param libraryPaths (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String libraryPathEnvPrefix (scala.collection.immutable.Seq<java.lang.String> libraryPaths)  { throw new RuntimeException(); }
  /**
   * Return the value of a config either through the SparkConf or the Hadoop configuration.
   * We Check whether the key is set in the SparkConf before look at any Hadoop configuration.
   * If the key is set in SparkConf, no matter whether it is running on YARN or not,
   * gets the value from SparkConf.
   * Only when the key is not set in SparkConf and running on YARN,
   * gets the value from Hadoop configuration.
   * @param conf (undocumented)
   * @param key (undocumented)
   * @param default_ (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String getSparkOrYarnConfig (org.apache.spark.SparkConf conf, java.lang.String key, java.lang.String default_)  { throw new RuntimeException(); }
  /**
   * Return a pair of host and port extracted from the <code>sparkUrl</code>.
   * <p>
   * A spark url (<code>spark://host:port</code>) is a special URI that its scheme is <code>spark</code> and only contains
   * host and port.
   * <p>
   * @throws org.apache.spark.SparkException if sparkUrl is invalid.
   * @param sparkUrl (undocumented)
   * @return (undocumented)
   */
  static public  scala.Tuple2<java.lang.String, java.lang.Object> extractHostPortFromSparkUrl (java.lang.String sparkUrl) throws org.apache.spark.SparkException { throw new RuntimeException(); }
  /**
   * Returns the current user name. This is the currently logged in user, unless that's been
   * overridden by the <code>SPARK_USER</code> environment variable. In case of exceptions, returns the value
   * of {@code System.getProperty("user.name", "<unknown>")}.
   * @return (undocumented)
   */
  static public  java.lang.String getCurrentUserName ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Set<java.lang.String> EMPTY_USER_GROUPS ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Set<java.lang.String> getCurrentUserGroups (org.apache.spark.ReadOnlySparkConf sparkConf, java.lang.String username)  { throw new RuntimeException(); }
  /**
   * Split the comma delimited string of master URLs into a list.
   * For instance, "spark://abc,def" becomes [spark://abc, spark://def].
   * @param masterUrls (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String[] parseStandaloneMasterUrls (java.lang.String masterUrls)  { throw new RuntimeException(); }
  /** An identifier that backup masters use in their responses. */
  static public  java.lang.String BACKUP_STANDALONE_MASTER_PREFIX ()  { throw new RuntimeException(); }
  /** Return true if the response message is sent from a backup Master on standby. */
  static public  boolean responseFromBackup (java.lang.String msg)  { throw new RuntimeException(); }
  /**
   * To avoid calling <code>Utils.getCallSite</code> for every single RDD we create in the body,
   * set a dummy call site that RDDs use instead. This is for performance optimization.
   * @param sc (undocumented)
   * @param body (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> T withDummyCallSite (org.apache.spark.SparkContext sc, scala.Function0<T> body)  { throw new RuntimeException(); }
  /**
   * Return whether the specified file is a parent directory of the child file.
   * @param parent (undocumented)
   * @param child (undocumented)
   * @return (undocumented)
   */
  static public  boolean isInDirectory (java.io.File parent, java.io.File child)  { throw new RuntimeException(); }
  /**
   * @return whether it is local mode
   * @param conf (undocumented)
   */
  static public  boolean isLocalMaster (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Push based shuffle can only be enabled when below conditions are met:
   *   - the application is submitted to run in YARN mode
   *   - external shuffle service enabled
   *   - IO encryption disabled
   *   - serializer(such as KryoSerializer) supports relocation of serialized objects
   * @param conf (undocumented)
   * @param isDriver (undocumented)
   * @param checkSerializer (undocumented)
   * @return (undocumented)
   */
  static public  boolean isPushBasedShuffleEnabled (org.apache.spark.SparkConf conf, boolean isDriver, boolean checkSerializer)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T instantiateSerializerOrShuffleManager (java.lang.String className, org.apache.spark.SparkConf conf, boolean isDriver)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T instantiateSerializerFromConf (org.apache.spark.internal.config.ConfigEntry<java.lang.String> propertyName, org.apache.spark.SparkConf conf, boolean isDriver)  { throw new RuntimeException(); }
  /**
   * Return whether dynamic allocation is enabled in the given conf.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  boolean isDynamicAllocationEnabled (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  static public  boolean isStreamingDynamicAllocationEnabled (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Return the initial number of executors for dynamic allocation.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  int getDynamicAllocationInitialExecutors (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Returns a path of temporary file which is in the same directory with <code>path</code>.
   * @param path (undocumented)
   * @return (undocumented)
   */
  static public  java.io.File tempFileWith (java.io.File path)  { throw new RuntimeException(); }
  /**
   * Returns the name of this JVM process. This is OS dependent but typically (OSX, Linux, Windows),
   * this is formatted as PID@hostname.
   * @return (undocumented)
   */
  static public  java.lang.String getProcessName ()  { throw new RuntimeException(); }
  /**
   * Utility function that should be called early in <code>main()</code> for daemons to set up some common
   * diagnostic state.
   * @param log (undocumented)
   */
  static public  void initDaemon (org.slf4j.Logger log)  { throw new RuntimeException(); }
  /**
   * Utility function to enable or disable structured logging based on system properties.
   * This is designed for a code path which we cannot use SparkConf yet, and should be used before
   * the first invocation of <code>Logging.log()</code>. For example, this should be used before <code>initDaemon</code>.
   */
  static public  void resetStructuredLogging ()  { throw new RuntimeException(); }
  /**
   * Utility function to enable or disable structured logging based on SparkConf.
   * This is designed for a code path which logging system may be initilized before
   * loading SparkConf.
   * @param sparkConf (undocumented)
   */
  static public  void resetStructuredLogging (org.apache.spark.ReadOnlySparkConf sparkConf)  { throw new RuntimeException(); }
  /**
   * Return the jar files pointed by the "spark.jars" property. Spark internally will distribute
   * these jars through file server. In the YARN mode, it will return an empty list, since YARN
   * has its own mechanism to distribute jars.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Seq<java.lang.String> getUserJars (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Return the local jar files which will be added to REPL's classpath. These jar files are
   * specified by --jars (spark.jars) or --packages, remote jars will be downloaded to local by
   * SparkSubmit at first.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Seq<java.lang.String> getLocalUserJarsForShell (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  static   java.lang.String REDACTION_REPLACEMENT_TEXT ()  { throw new RuntimeException(); }
  /**
   * Redact the sensitive values in the given map. If a map key matches the redaction pattern then
   * its value is replaced with a dummy text.
   * @param conf (undocumented)
   * @param kvs (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> redact (org.apache.spark.ReadOnlySparkConf conf, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> kvs)  { throw new RuntimeException(); }
  /**
   * Redact the sensitive values in the given map. If a map key matches the redaction pattern then
   * its value is replaced with a dummy text.
   * @param regex (undocumented)
   * @param kvs (undocumented)
   * @return (undocumented)
   */
  static public <K extends java.lang.Object, V extends java.lang.Object> scala.collection.Seq<scala.Tuple2<K, V>> redact (scala.Option<scala.util.matching.Regex> regex, scala.collection.Seq<scala.Tuple2<K, V>> kvs)  { throw new RuntimeException(); }
  /**
   * Redact the sensitive information in the given string.
   * @param regex (undocumented)
   * @param text (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String redact (scala.Option<scala.util.matching.Regex> regex, java.lang.String text)  { throw new RuntimeException(); }
  /**
   * Looks up the redaction regex from within the key value pairs and uses it to redact the rest
   * of the key value pairs. No care is taken to make sure the redaction property itself is not
   * redacted. So theoretically, the property itself could be configured to redact its own value
   * when printing.
   * @param kvs (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> redact (scala.collection.Map<java.lang.String, java.lang.String> kvs)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Seq<java.lang.String> redactCommandLineArgs (org.apache.spark.ReadOnlySparkConf conf, scala.collection.immutable.Seq<java.lang.String> commands)  { throw new RuntimeException(); }
  /**
   * Create instances of extension classes.
   * <p>
   * The classes in the given list must:
   * - Be sub-classes of the given base class.
   * - Provide either a no-arg constructor, or a 1-arg constructor that takes a SparkConf.
   * <p>
   * The constructors are allowed to throw "UnsupportedOperationException" if the extension does not
   * want to be registered; this allows the implementations to check the Spark configuration (or
   * other state) and decide they do not need to be added. A log message is printed in that case.
   * Other exceptions are bubbled up.
   * @param extClass (undocumented)
   * @param classes (undocumented)
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.collection.immutable.Seq<T> loadExtensions (java.lang.Class<T> extClass, scala.collection.immutable.Seq<java.lang.String> classes, org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /**
   * Check the validity of the given Kubernetes master URL and return the resolved URL. Prefix
   * "k8s://" is appended to the resolved URL as the prefix is used by KubernetesClusterManager
   * in canCreate to determine if the KubernetesClusterManager should be used.
   * @param rawMasterURL (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String checkAndGetK8sMasterUrl (java.lang.String rawMasterURL)  { throw new RuntimeException(); }
  /**
   * Replaces all the {{EXECUTOR_ID}} occurrences with the Executor Id
   * and {{APP_ID}} occurrences with the App Id.
   * @param opt (undocumented)
   * @param appId (undocumented)
   * @param execId (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String substituteAppNExecIds (java.lang.String opt, java.lang.String appId, java.lang.String execId)  { throw new RuntimeException(); }
  /**
   * Replaces all the {{APP_ID}} occurrences with the App Id.
   * @param opt (undocumented)
   * @param appId (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String substituteAppId (java.lang.String opt, java.lang.String appId)  { throw new RuntimeException(); }
  /**
   * Replaces all the {{SPARK_VERSION}} occurrences with the Spark version.
   * @param opt (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String substituteSparkVersion (java.lang.String opt)  { throw new RuntimeException(); }
  static public  java.lang.String createSecret (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /**
   * Return the number of half widths in a given string. Note that a full width character
   * occupies two half widths.
   * <p>
   * For a string consisting of 1 million characters, the execution of this method requires
   * about 50ms.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  int stringHalfWidth (java.lang.String str)  { throw new RuntimeException(); }
  static public  java.lang.String sanitizeDirName (java.lang.String str)  { throw new RuntimeException(); }
  static public  java.lang.String nameForAppAndAttempt (java.lang.String appId, scala.Option<java.lang.String> appAttemptId)  { throw new RuntimeException(); }
  static public  boolean isClientMode (org.apache.spark.ReadOnlySparkConf conf)  { throw new RuntimeException(); }
  /** Returns whether the URI is a "local:" URI. */
  static public  boolean isLocalUri (java.lang.String uri)  { throw new RuntimeException(); }
  /** Create a UriBuilder from URI object. */
  static public  jakarta.ws.rs.core.UriBuilder getUriBuilder (java.net.URI uri)  { throw new RuntimeException(); }
  /** Create a UriBuilder from URI string. */
  static public  jakarta.ws.rs.core.UriBuilder getUriBuilder (java.lang.String uri)  { throw new RuntimeException(); }
  /** Check whether the file of the path is splittable. */
  static public  boolean isFileSplittable (org.apache.hadoop.fs.Path path, org.apache.hadoop.io.compress.CompressionCodecFactory codecFactory)  { throw new RuntimeException(); }
  /** Create a new properties object with the same values as `props` */
  static public  java.util.Properties cloneProperties (java.util.Properties props)  { throw new RuntimeException(); }
  /**
   * Convert a sequence of <code>Path</code>s to a metadata string. When the length of metadata string
   * exceeds <code>stopAppendingThreshold</code>, stop appending paths for saving memory.
   * @param paths (undocumented)
   * @param stopAppendingThreshold (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String buildLocationMetadata (scala.collection.immutable.Seq<org.apache.hadoop.fs.Path> paths, int stopAppendingThreshold)  { throw new RuntimeException(); }
  /**
   * Convert MEMORY_OFFHEAP_SIZE to MB Unit, return 0 if MEMORY_OFFHEAP_ENABLED is false.
   * @param sparkConf (undocumented)
   * @return (undocumented)
   */
  static public  int executorOffHeapMemorySizeAsMb (org.apache.spark.ReadOnlySparkConf sparkConf)  { throw new RuntimeException(); }
  /**
   * return 0 if MEMORY_OFFHEAP_ENABLED is false.
   * @param sparkConf (undocumented)
   * @param offHeapSize (undocumented)
   * @return (undocumented)
   */
  static public  long checkOffHeapEnabled (org.apache.spark.ReadOnlySparkConf sparkConf, long offHeapSize)  { throw new RuntimeException(); }
  /** Returns a string message about delegation token generation failure */
  static public  org.apache.spark.internal.MessageWithContext createFailedToGetTokenMessage (java.lang.String serviceName)  { throw new RuntimeException(); }
  /**
   * Decompress a zip file into a local dir. File names are read from the zip file. Note, we skip
   * addressing the directory here. Also, we rely on the caller side to address any exceptions.
   * @param fs (undocumented)
   * @param dfsZipFile (undocumented)
   * @param localDir (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Seq<java.io.File> unzipFilesFromFile (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path dfsZipFile, java.io.File localDir)  { throw new RuntimeException(); }
  /**
   * Create a resource uninterruptibly if we are in a task thread (i.e., TaskContext.get() != null).
   * Otherwise, create the resource normally. This is mainly used in the situation where we want to
   * create a multi-layer resource in a task thread. The uninterruptible behavior ensures we don't
   * leak the underlying resources when there is a task cancellation request,
   * @param createResource (undocumented)
   * @return (undocumented)
   */
  static public <R extends java.io.Closeable> R createResourceUninterruptiblyIfInTaskThread (scala.Function0<R> createResource)  { throw new RuntimeException(); }
  /**
   * Return the median number of a long array
   * <p>
   * @param sizes
   * @param alreadySorted
   * @return
   */
  static public  long median (long[] sizes, boolean alreadySorted)  { throw new RuntimeException(); }
  /**
   * Check if a command is available.
   * @param command (undocumented)
   * @return (undocumented)
   */
  static public  boolean checkCommandAvailable (java.lang.String command)  { throw new RuntimeException(); }
  // not preceding
  static public  boolean isSerialGC ()  { throw new RuntimeException(); }
  // not preceding
  static public  boolean isParallelGC ()  { throw new RuntimeException(); }
  // not preceding
  static public  boolean isG1GC ()  { throw new RuntimeException(); }
  // not preceding
  static public  boolean isZGC ()  { throw new RuntimeException(); }
  // not preceding
  static public  boolean isShenandoahGC ()  { throw new RuntimeException(); }
  static public  boolean checkUseGC (java.lang.String useGCObjectStr)  { throw new RuntimeException(); }
  /**
   * Return a string of printStackTrace result.
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String stringifyException (java.lang.Throwable e)  { throw new RuntimeException(); }
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
  static public  java.lang.ClassLoader getSparkClassLoader ()  { throw new RuntimeException(); }
  static public  java.lang.ClassLoader getContextOrSparkClassLoader ()  { throw new RuntimeException(); }
  static public <C extends java.lang.Object> java.lang.Class<C> classForName (java.lang.String className, boolean initialize, boolean noSparkClassLoader)  { throw new RuntimeException(); }
  static public <C extends java.lang.Object> boolean classForName$default$2 ()  { throw new RuntimeException(); }
  static public <C extends java.lang.Object> boolean classForName$default$3 ()  { throw new RuntimeException(); }
  static public  boolean classIsLoadable (java.lang.String clazz)  { throw new RuntimeException(); }
  static public  boolean classIsLoadableAndAssignableFrom (java.lang.String clazz, java.lang.Class<?> targetClass)  { throw new RuntimeException(); }
  static public  java.lang.String getFormattedClassName (java.lang.Object obj)  { throw new RuntimeException(); }
  static public  java.lang.String getSimpleName (java.lang.Class<?> cls)  { throw new RuntimeException(); }
  static public final  java.lang.String stripDollars (java.lang.String s)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.List<java.lang.Class<?>> getAllInterfaces (java.lang.Class<?> cls)  { throw new RuntimeException(); }
  static protected abstract  void org$apache$spark$util$SparkClassUtils$_setter_$random_$eq (java.util.Random x$1)  ;
  static public  boolean isTesting ()  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T tryOrIOException (scala.Function0<T> block)  { throw new RuntimeException(); }
  static public <R extends java.io.Closeable, T extends java.lang.Object> T tryWithResource (scala.Function0<R> createResource, scala.Function1<R, T> f)  { throw new RuntimeException(); }
  static public <R extends java.io.Closeable, T extends java.lang.Object> T tryInitializeResource (scala.Function0<R> createResource, scala.Function1<R, T> initialize)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T tryWithSafeFinally (scala.Function0<T> block, scala.Function0<scala.runtime.BoxedUnit> finallyBlock)  { throw new RuntimeException(); }
  static public  java.lang.String stackTraceToString (java.lang.Throwable t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable getRootCause (java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static public  void closeQuietly (java.io.Closeable closeable)  { throw new RuntimeException(); }
  static public  java.net.URI resolveURI (java.lang.String path)  { throw new RuntimeException(); }
  static public  long sizeOf (java.io.File f)  { throw new RuntimeException(); }
  static public  java.io.File[] recursiveList (java.io.File f)  { throw new RuntimeException(); }
  static public  java.util.Set<java.io.File> listFiles (java.io.File f)  { throw new RuntimeException(); }
  static public  java.util.Set<java.nio.file.Path> listPaths (java.io.File f)  { throw new RuntimeException(); }
  static public  boolean createDirectory (java.io.File dir)  { throw new RuntimeException(); }
  static public  java.io.File createDirectory (java.lang.String root, java.lang.String namePrefix)  { throw new RuntimeException(); }
  static public  java.lang.String createDirectory$default$2 ()  { throw new RuntimeException(); }
  static public  java.lang.String createTempDir$default$1 ()  { throw new RuntimeException(); }
  static public  java.lang.String createTempDir$default$2 ()  { throw new RuntimeException(); }
  static public  void createParentDirs (java.io.File file)  { throw new RuntimeException(); }
  static public  void cleanDirectory (java.io.File dir)  { throw new RuntimeException(); }
  static public  void deleteQuietly (java.io.File file)  { throw new RuntimeException(); }
  static public  void forceDeleteOnExit (java.io.File file)  { throw new RuntimeException(); }
  static public  java.io.File getFile (scala.collection.immutable.Seq<java.lang.String> names)  { throw new RuntimeException(); }
  static public  java.io.File getFile (java.io.File parent, scala.collection.immutable.Seq<java.lang.String> names)  { throw new RuntimeException(); }
  static public  void moveFile (java.io.File src, java.io.File dst)  { throw new RuntimeException(); }
  static public  void moveDirectory (java.io.File src, java.io.File dst)  { throw new RuntimeException(); }
  static public  void copyDirectory (java.io.File src, java.io.File dir)  { throw new RuntimeException(); }
  static public  void copyFileToDirectory (java.io.File file, java.io.File dir)  { throw new RuntimeException(); }
  static public  void copyFile (java.io.File src, java.io.File dst)  { throw new RuntimeException(); }
  static public  void copyURLToFile (java.net.URL url, java.io.File file)  { throw new RuntimeException(); }
  static public  boolean contentEquals (java.io.File file1, java.io.File file2)  { throw new RuntimeException(); }
  static public  void touch (java.io.File file)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> byte[] serialize (T o)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T deserialize (byte[] bytes)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T deserialize (byte[] bytes, java.lang.ClassLoader loader)  { throw new RuntimeException(); }
  static public  long copyStream (java.io.InputStream in, java.io.OutputStream out, boolean closeStreams, boolean transferToEnabled)  { throw new RuntimeException(); }
  static public  boolean copyStream$default$3 ()  { throw new RuntimeException(); }
  static public  boolean copyStream$default$4 ()  { throw new RuntimeException(); }
  static public  void copyFileStreamNIO (java.nio.channels.FileChannel input, java.nio.channels.WritableByteChannel output, long startPosition, long bytesToCopy)  { throw new RuntimeException(); }
  static public  java.lang.String toString (java.io.InputStream in)  { throw new RuntimeException(); }
  static public  void readFully (java.io.InputStream in, byte[] arr, int off, int len)  { throw new RuntimeException(); }
  static public final  java.util.HexFormat org$apache$spark$util$SparkStringUtils$$SPACE_DELIMITED_UPPERCASE_HEX ()  { throw new RuntimeException(); }
  static public  java.lang.String getHexString (byte[] bytes)  { throw new RuntimeException(); }
  static public  byte[] fromHexString (java.lang.String hex)  { throw new RuntimeException(); }
  static public  boolean isEmpty (java.lang.String str)  { throw new RuntimeException(); }
  static public  boolean isNotEmpty (java.lang.String str)  { throw new RuntimeException(); }
  static public  boolean isBlank (java.lang.String str)  { throw new RuntimeException(); }
  static public  boolean isNotBlank (java.lang.String str)  { throw new RuntimeException(); }
  static public  java.lang.String abbreviate (java.lang.String str, java.lang.String abbrevMarker, int len)  { throw new RuntimeException(); }
  static public  java.lang.String abbreviate (java.lang.String str, int len)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Seq<java.lang.String> sideBySide (java.lang.String left, java.lang.String right)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Seq<java.lang.String> sideBySide (scala.collection.immutable.Seq<java.lang.String> left, scala.collection.immutable.Seq<java.lang.String> right)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Seq<java.lang.String> stringToSeq (java.lang.String str)  { throw new RuntimeException(); }
  static public  java.lang.String strip (java.lang.String str, java.lang.String s)  { throw new RuntimeException(); }
  static public  java.lang.String leftPad (java.lang.String str, int width)  { throw new RuntimeException(); }
  static public  java.lang.String rightPad (java.lang.String str, int width)  { throw new RuntimeException(); }
  static public  java.lang.String rightPad (java.lang.String str, int width, java.lang.String s)  { throw new RuntimeException(); }
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$osName_$eq (java.lang.String x$1)  ;
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$osVersion_$eq (java.lang.String x$1)  ;
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$osArch_$eq (java.lang.String x$1)  ;
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$javaVersion_$eq (java.lang.String x$1)  ;
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$isWindows_$eq (boolean x$1)  ;
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$isMac_$eq (boolean x$1)  ;
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$isMacOnAppleSilicon_$eq (boolean x$1)  ;
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$isLinux_$eq (boolean x$1)  ;
  static protected abstract  void org$apache$spark$util$SparkSystemUtils$_setter_$isUnix_$eq (boolean x$1)  ;
}
