package org.apache.spark.storage;
public  class SerializationStreamWithCloseDetecting extends org.apache.spark.serializer.SerializationStream implements org.apache.spark.storage.CloseDetecting {
  public   SerializationStreamWithCloseDetecting (org.apache.spark.serializer.SerializationStream serializationStream)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  void flush ()  { throw new RuntimeException(); }
  public  boolean isClosed ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> org.apache.spark.serializer.SerializationStream writeObject (T t, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
}
