package org.apache.spark.deploy.master;
/**
 * Stores data in RocksDB.
 * <p>
 * param:  dir Directory to setup RocksDB. Created if non-existent.
 * param:  serializer Used to serialize our objects.
 */
  class RocksDBPersistenceEngine extends org.apache.spark.deploy.master.PersistenceEngine implements org.apache.spark.internal.Logging {
  // not preceding
  public   RocksDBPersistenceEngine (java.lang.String dir, org.apache.spark.serializer.Serializer serializer)  { throw new RuntimeException(); }
  public  java.lang.String dir ()  { throw new RuntimeException(); }
  public  void persist (java.lang.String name, java.lang.Object obj)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> scala.collection.immutable.Seq<T> read (java.lang.String name, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  public  org.apache.spark.serializer.Serializer serializer ()  { throw new RuntimeException(); }
  public  void unpersist (java.lang.String name)  { throw new RuntimeException(); }
}
