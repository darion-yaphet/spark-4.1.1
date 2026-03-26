package org.apache.spark.storage;
public  class ReadPartialInputStream extends java.io.InputStream implements org.apache.hadoop.fs.Seekable, org.apache.hadoop.fs.PositionedReadable {
  // not preceding
  public   ReadPartialInputStream (org.apache.hadoop.fs.FSDataInputStream in)  { throw new RuntimeException(); }
  public  long getPos ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.FSDataInputStream in ()  { throw new RuntimeException(); }
  public  int read ()  { throw new RuntimeException(); }
  public  int read (byte[] b, int off, int len)  { throw new RuntimeException(); }
  public  int read (long position, byte[] buffer, int offset, int length)  { throw new RuntimeException(); }
  public  void readFully (long position, byte[] buffer, int offset, int length)  { throw new RuntimeException(); }
  public  void readFully (long position, byte[] buffer)  { throw new RuntimeException(); }
  public  void seek (long pos)  { throw new RuntimeException(); }
  public  boolean seekToNewSource (long targetPos)  { throw new RuntimeException(); }
}
