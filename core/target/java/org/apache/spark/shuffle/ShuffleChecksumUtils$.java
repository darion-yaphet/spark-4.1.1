package org.apache.spark.shuffle;
public  class ShuffleChecksumUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ShuffleChecksumUtils$ MODULE$ = null;
  public   ShuffleChecksumUtils$ ()  { throw new RuntimeException(); }
  /**
   * Return checksumFile for shuffle data block ID. Otherwise, null.
   * @param blockId (undocumented)
   * @param algorithm (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getChecksumFileName (org.apache.spark.storage.BlockId blockId, java.lang.String algorithm)  { throw new RuntimeException(); }
  /**
   * Ensure that the checksum values are consistent with index file and data file.
   * @param numPartition (undocumented)
   * @param algorithm (undocumented)
   * @param checksum (undocumented)
   * @param data (undocumented)
   * @param index (undocumented)
   * @return (undocumented)
   */
  public  boolean compareChecksums (int numPartition, java.lang.String algorithm, java.io.File checksum, java.io.File data, java.io.File index)  { throw new RuntimeException(); }
}
