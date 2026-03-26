package org.apache.spark.util;
/**
 * Utility functions to simplify and speed-up file listing.
 */
public  class HadoopFSUtils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HadoopFSUtils$ MODULE$ = null;
  public   HadoopFSUtils$ ()  { throw new RuntimeException(); }
  /**
   * Lists a collection of paths recursively. Picks the listing strategy adaptively depending
   * on the number of paths to list.
   * <p>
   * This may only be called on the driver.
   * <p>
   * @param sc Spark context used to run parallel listing.
   * @param paths Input paths to list
   * @param hadoopConf Hadoop configuration
   * @param filter Path filter used to exclude leaf files from result
   * @param ignoreMissingFiles Ignore missing files that happen during recursive listing
   *                           (e.g., due to race conditions)
   * @param ignoreLocality Whether to fetch data locality info when listing leaf files. If false,
   *                       this will return <code>FileStatus</code> without <code>BlockLocation</code> info.
   * @param parallelismThreshold The threshold to enable parallelism. If the number of input paths
   *                             is smaller than this value, this will fallback to use
   *                             sequential listing.
   * @param parallelismMax The maximum parallelism for listing. If the number of input paths is
   *                       larger than this value, parallelism will be throttled to this value
   *                       to avoid generating too many tasks.
   * @return for each input path, the set of discovered files for the path
   */
  public  scala.collection.immutable.Seq<scala.Tuple2<org.apache.hadoop.fs.Path, scala.collection.immutable.Seq<org.apache.hadoop.fs.FileStatus>>> parallelListLeafFiles (org.apache.spark.SparkContext sc, scala.collection.immutable.Seq<org.apache.hadoop.fs.Path> paths, org.apache.hadoop.conf.Configuration hadoopConf, org.apache.hadoop.fs.PathFilter filter, boolean ignoreMissingFiles, boolean ignoreLocality, int parallelismThreshold, int parallelismMax)  { throw new RuntimeException(); }
  /**
   * Lists a collection of paths recursively with a single API invocation.
   * Like parallelListLeafFiles, this ignores FileNotFoundException on the given root path.
   * <p>
   * This is able to be called on both driver and executors.
   * <p>
   * @param path a path to list
   * @param hadoopConf Hadoop configuration
   * @param filter Path filter used to exclude leaf files from result
   * @return  the set of discovered files for the path
   */
  public  scala.collection.immutable.Seq<scala.Tuple2<org.apache.hadoop.fs.Path, scala.collection.immutable.Seq<org.apache.hadoop.fs.FileStatus>>> listFiles (org.apache.hadoop.fs.Path path, org.apache.hadoop.conf.Configuration hadoopConf, org.apache.hadoop.fs.PathFilter filter)  { throw new RuntimeException(); }
  /** Checks if we should filter out this path name. */
  public  boolean shouldFilterOutPathName (java.lang.String pathName)  { throw new RuntimeException(); }
  /** Checks if we should filter out this path. */
  public  boolean shouldFilterOutPath (java.lang.String path)  { throw new RuntimeException(); }
}
