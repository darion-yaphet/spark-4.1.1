package org.apache.spark.shuffle.checksum;
/**
 * A class for computing checksum for input (key, value) pairs. The checksum is independent of
 * the order of the input (key, value) pairs. It is done by computing a checksum for each row
 * first, then computing the XOR and SUM for all the row checksums and mixing these two values
 * as the final checksum.
 */
public abstract class RowBasedChecksum implements java.io.Serializable, org.apache.spark.internal.Logging {
  static public  long getAggregatedChecksumValue (org.apache.spark.shuffle.checksum.RowBasedChecksum[] rowBasedChecksums)  { throw new RuntimeException(); }
  public   RowBasedChecksum ()  { throw new RuntimeException(); }
  /**
   * Returns the checksum value. It returns the default checksum value (0) if there
   * are any errors encountered during the checksum computation.
   * @return (undocumented)
   */
  public  long getValue ()  { throw new RuntimeException(); }
  /** Updates the row-based checksum with the given (key, value) pair. Not thread safe. */
  public  void update (Object key, Object value)  { throw new RuntimeException(); }
  /** Computes and returns the checksum value for the given (key, value) pair */
  protected abstract  long calculateRowChecksum (Object key, Object value)  ;
}
