package org.apache.spark.paths;
/**
 * A canonical representation of a file path. This class is intended to provide
 * type-safety to the way that Spark handles Paths. Paths can be represented as
 * Strings in multiple ways, which are not always compatible. Spark regularly uses
 * two ways: 1. hadoop Path.toString and java URI.toString.
 */
public  class SparkPath implements scala.Product, java.io.Serializable {
  /**
   * Creates a SparkPath from a hadoop Path string.
   * Please be very sure that the provided string is encoded (or not encoded) in the right way.
   * <p>
   * Please see the hadoop Path documentation here:
   * https://hadoop.apache.org/docs/stable/api/org/apache/hadoop/fs/Path.html#Path-java.lang.String-
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.paths.SparkPath fromPathString (java.lang.String str)  { throw new RuntimeException(); }
  static public  org.apache.spark.paths.SparkPath fromPath (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  static public  org.apache.spark.paths.SparkPath fromFileStatus (org.apache.hadoop.fs.FileStatus fs)  { throw new RuntimeException(); }
  /**
   * Creates a SparkPath from a url-encoded string.
   * Note: It is the responsibility of the caller to ensure that str is a valid url-encoded string.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.paths.SparkPath fromUrlString (java.lang.String str)  { throw new RuntimeException(); }
  static public  org.apache.spark.paths.SparkPath fromUri (java.net.URI uri)  { throw new RuntimeException(); }
  public  java.lang.String urlEncoded ()  { throw new RuntimeException(); }
  public  java.net.URI toUri ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.Path toPath ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
