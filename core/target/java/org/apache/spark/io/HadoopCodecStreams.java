package org.apache.spark.io;
/**
 * An utility object to look up Hadoop compression codecs and create input streams.
 * In addition to standard Hadoop codecs, it also supports Spark's Zstandard codec
 * if Hadopp is not compiled with Zstandard support. Additionally, it supports
 * non-standard file extensions like <code>.zstd</code> and <code>.gzip</code> for Zstandard and Gzip codecs.
 */
public  class HadoopCodecStreams {
  static public  scala.Option<org.apache.hadoop.io.compress.CompressionCodec> getDecompressionCodec (org.apache.hadoop.conf.Configuration config, org.apache.hadoop.fs.Path file)  { throw new RuntimeException(); }
  static public  scala.Option<java.io.InputStream> createZstdInputStream (org.apache.hadoop.fs.Path file, java.io.InputStream inputStream)  { throw new RuntimeException(); }
  static public  java.io.InputStream createInputStream (org.apache.hadoop.conf.Configuration config, org.apache.hadoop.fs.Path file)  { throw new RuntimeException(); }
}
