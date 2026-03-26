package org.apache.spark.util;
public  class TestClassWithoutDefaultConstructor implements java.io.Serializable {
  public   TestClassWithoutDefaultConstructor (int x)  { throw new RuntimeException(); }
  public  int getX ()  { throw new RuntimeException(); }
  public  int run ()  { throw new RuntimeException(); }
}
