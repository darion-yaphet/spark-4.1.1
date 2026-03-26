package org.apache.spark.storage;
public  class OutputStreamWithCloseDetecting extends java.io.OutputStream implements org.apache.spark.storage.CloseDetecting {
  public   OutputStreamWithCloseDetecting (java.io.OutputStream outputStream)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  boolean isClosed ()  { throw new RuntimeException(); }
  public  void write (int b)  { throw new RuntimeException(); }
}
