package org.apache.spark.shuffle.checksum;
/**
 * A Concrete implementation of RowBasedChecksum. The checksum for each row is
 * computed by first converting the (key, value) pair to byte array using OutputStreams,
 * and then computing the checksum for the byte array.
 * Note that this checksum computation is very expensive, and it is used only in tests
 * in the core component. A much cheaper implementation of RowBasedChecksum is in
 * UnsafeRowChecksum.
 * <p>
 * param:  checksumAlgorithm the algorithm used for computing checksum.
 */
public  class OutputStreamRowBasedChecksum extends org.apache.spark.shuffle.checksum.RowBasedChecksum {
  public   OutputStreamRowBasedChecksum (java.lang.String checksumAlgorithm)  { throw new RuntimeException(); }
  protected  long calculateRowChecksum (Object key, Object value)  { throw new RuntimeException(); }
  // not preceding
  protected  java.util.zip.Checksum checksum ()  { throw new RuntimeException(); }
}
