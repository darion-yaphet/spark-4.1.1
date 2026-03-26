package org.apache.spark.serializer;
  class KryoDeserializationStream extends org.apache.spark.serializer.DeserializationStream {
  public   KryoDeserializationStream (org.apache.spark.serializer.KryoSerializerInstance serInstance, java.io.InputStream inStream, boolean useUnsafe)  { throw new RuntimeException(); }
  public final  scala.collection.Iterator<java.lang.Object> asIterator ()  { throw new RuntimeException(); }
  public final  scala.collection.Iterator<scala.Tuple2<java.lang.Object, java.lang.Object>> asKeyValueIterator ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> T readObject (scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
}
