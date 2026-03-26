package org.apache.spark.util;
public  class MyData implements java.io.Serializable {
  // not preceding
  public   MyData (int i)  { throw new RuntimeException(); }
  public  int i ()  { throw new RuntimeException(); }
}
