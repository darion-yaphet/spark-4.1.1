package org.apache.spark.storage;
public  class CacheId extends org.apache.spark.storage.BlockId implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sessionUUID ()  { throw new RuntimeException(); }
  public  java.lang.String hash ()  { throw new RuntimeException(); }
  // not preceding
  public   CacheId (java.lang.String sessionUUID, java.lang.String hash)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
}
