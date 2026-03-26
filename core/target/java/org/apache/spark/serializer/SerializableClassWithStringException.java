package org.apache.spark.serializer;
public  class SerializableClassWithStringException implements java.io.Serializable {
  // not preceding
  public   SerializableClassWithStringException (java.lang.Object objectField)  { throw new RuntimeException(); }
  public  java.lang.Object objectField ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
