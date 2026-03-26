package org.apache.spark.serializer;
public  class SerializerHelper$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SerializerHelper$ MODULE$ = null;
  public   SerializerHelper$ ()  { throw new RuntimeException(); }
  /**
   * @param serializerInstance instance of SerializerInstance
   * @param objectToSerialize the object to serialize, of type <code>T</code>
   * @param estimatedSize estimated size of <code>t</code>, used as a hint to choose proper chunk size
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.util.io.ChunkedByteBuffer serializeToChunkedBuffer (org.apache.spark.serializer.SerializerInstance serializerInstance, T objectToSerialize, long estimatedSize, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> T deserializeFromChunkedBuffer (org.apache.spark.serializer.SerializerInstance serializerInstance, org.apache.spark.util.io.ChunkedByteBuffer bytes, scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
}
