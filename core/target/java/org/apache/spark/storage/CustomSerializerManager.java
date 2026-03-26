package org.apache.spark.storage;
public  class CustomSerializerManager extends org.apache.spark.serializer.SerializerManager {
  public   CustomSerializerManager (org.apache.spark.serializer.Serializer defaultSerializer, org.apache.spark.SparkConf conf, scala.Option<byte[]> encryptionKey)  { throw new RuntimeException(); }
  public  java.io.OutputStream wrapStream (org.apache.spark.storage.BlockId blockId, java.io.OutputStream s)  { throw new RuntimeException(); }
}
