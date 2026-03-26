package org.apache.spark.storage;
public  class TestLogBlockId extends org.apache.spark.storage.LogBlockId implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long lastLogTime ()  { throw new RuntimeException(); }
  public  java.lang.String executorId ()  { throw new RuntimeException(); }
  // not preceding
  public   TestLogBlockId (long lastLogTime, java.lang.String executorId)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value logBlockType ()  { throw new RuntimeException(); }
}
