package org.apache.spark.status.protobuf;
/**
 * :: DeveloperApi ::
 * <code>ProtobufSerDe</code> used to represent the API for serialize and deserialize of
 * Protobuf data related to UI. The subclass should implement this trait and
 * register itself to <code>org.apache.spark.status.protobuf.ProtobufSerDe</code> so that
 * <code>KVStoreProtobufSerializer</code> can use <code>ServiceLoader</code> to load and use them.
 * <p>
 * @since 3.4.0
 */
public  interface ProtobufSerDe<T extends java.lang.Object> {
  /**
   * Deserialize the input <code>Array[Byte]</code> to an object of the
   * type <code>T</code>.
   * @param bytes (undocumented)
   * @return (undocumented)
   */
  public  T deserialize (byte[] bytes)  ;
  /**
   * Serialize the input data of the type <code>T</code> to <code>Array[Byte]</code>.
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  byte[] serialize (T input)  ;
}
