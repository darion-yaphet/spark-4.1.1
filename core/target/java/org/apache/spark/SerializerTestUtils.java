package org.apache.spark;
public  interface SerializerTestUtils {
  public <T extends java.lang.Object> T deserializeFromBytes (byte[] bytes)  ;
  public <T extends java.lang.Object> T roundtripSerialize (T obj)  ;
  public <T extends java.lang.Object> byte[] serializeToBytes (T o)  ;
}
