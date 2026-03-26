package org.apache.spark.storage;
public  class CustomJavaSerializerInstance extends org.apache.spark.serializer.SerializerInstance {
  public   CustomJavaSerializerInstance (org.apache.spark.serializer.SerializerInstance instance)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> T deserialize (java.nio.ByteBuffer bytes, scala.reflect.ClassTag<T> evidence$3)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> T deserialize (java.nio.ByteBuffer bytes, java.lang.ClassLoader loader, scala.reflect.ClassTag<T> evidence$4)  { throw new RuntimeException(); }
  public  org.apache.spark.serializer.DeserializationStream deserializeStream (java.io.InputStream s)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> java.nio.ByteBuffer serialize (T t, scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
  public  org.apache.spark.serializer.SerializationStream serializeStream (java.io.OutputStream s)  { throw new RuntimeException(); }
}
