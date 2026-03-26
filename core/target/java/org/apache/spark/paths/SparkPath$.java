package org.apache.spark.paths;
public  class SparkPath$ implements java.io.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkPath$ MODULE$ = null;
  public   SparkPath$ ()  { throw new RuntimeException(); }
  /**
   * Creates a SparkPath from a hadoop Path string.
   * Please be very sure that the provided string is encoded (or not encoded) in the right way.
   * <p>
   * Please see the hadoop Path documentation here:
   * https://hadoop.apache.org/docs/stable/api/org/apache/hadoop/fs/Path.html#Path-java.lang.String-
   * @param str (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.paths.SparkPath fromPathString (java.lang.String str)  { throw new RuntimeException(); }
  public  org.apache.spark.paths.SparkPath fromPath (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  org.apache.spark.paths.SparkPath fromFileStatus (org.apache.hadoop.fs.FileStatus fs)  { throw new RuntimeException(); }
  /**
   * Creates a SparkPath from a url-encoded string.
   * Note: It is the responsibility of the caller to ensure that str is a valid url-encoded string.
   * @param str (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.paths.SparkPath fromUrlString (java.lang.String str)  { throw new RuntimeException(); }
  public  org.apache.spark.paths.SparkPath fromUri (java.net.URI uri)  { throw new RuntimeException(); }
}
