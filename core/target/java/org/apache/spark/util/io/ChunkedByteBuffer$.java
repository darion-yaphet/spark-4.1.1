package org.apache.spark.util.io;
public  class ChunkedByteBuffer$ implements java.io.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ChunkedByteBuffer$ MODULE$ = null;
  public   ChunkedByteBuffer$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.io.ChunkedByteBuffer fromManagedBuffer (org.apache.spark.network.buffer.ManagedBuffer data)  { throw new RuntimeException(); }
  public  org.apache.spark.util.io.ChunkedByteBuffer fromFile (java.io.File file)  { throw new RuntimeException(); }
  /**
   * Try to estimate appropriate chunk size so that it's not too large (waste memory) or too
   * small (too many segments)
   * @param estimatedSize (undocumented)
   * @return (undocumented)
   */
  public  int estimateBufferChunkSize (long estimatedSize)  { throw new RuntimeException(); }
}
