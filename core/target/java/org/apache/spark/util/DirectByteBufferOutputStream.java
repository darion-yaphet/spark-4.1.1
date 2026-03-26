package org.apache.spark.util;
/**
 * An output stream that dumps data into a direct byte buffer. The byte buffer grows in size
 * as more data is written to the stream.
 * param:  capacity The initial capacity of the direct byte buffer
 */
  class DirectByteBufferOutputStream extends java.io.OutputStream {
  public   DirectByteBufferOutputStream (int capacity)  { throw new RuntimeException(); }
  public   DirectByteBufferOutputStream ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public  int size ()  { throw new RuntimeException(); }
  /**
   * Any subsequent call to {@link close()}, {@link write()}, {@link reset()} will invalidate the buffer
   * returned by this method.
   * @return (undocumented)
   */
  public  java.nio.ByteBuffer toByteBuffer ()  { throw new RuntimeException(); }
  public  void write (int b)  { throw new RuntimeException(); }
  public  void write (byte[] b, int off, int len)  { throw new RuntimeException(); }
}
