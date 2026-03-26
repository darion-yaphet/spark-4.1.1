package org.apache.spark.input;
/**
 * Tests the correctness of
 * {@link org.apache.spark.input.WholeTextFileRecordReader WholeTextFileRecordReader}. A temporary
 * directory is created as fake input. Temporal storage would be deleted in the end.
 */
public  class WholeTextFileRecordReaderSuite extends org.apache.spark.SparkFunSuite {
  static public  class CompressionType$ extends scala.Enumeration {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final CompressionType$ MODULE$ = null;
    public   CompressionType$ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value NONE ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value GZ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value GZIP ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value ZST ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value ZSTD ()  { throw new RuntimeException(); }
  }
  public   WholeTextFileRecordReaderSuite ()  { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf getSparkConf ()  { throw new RuntimeException(); }
  public  void beforeAll ()  { throw new RuntimeException(); }
  public  void afterAll ()  { throw new RuntimeException(); }
  public  void createNativeFile (java.io.File inputDir, java.lang.String fileName, byte[] contents, scala.Enumeration.Value compressionType)  { throw new RuntimeException(); }
}
