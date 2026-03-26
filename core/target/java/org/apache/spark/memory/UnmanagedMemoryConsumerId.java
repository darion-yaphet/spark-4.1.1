package org.apache.spark.memory;
/**
 * Identifier for an unmanaged memory consumer.
 * <p>
 * param:  componentType The type of component (e.g., "RocksDB", "NativeLibrary")
 * param:  instanceKey A unique key to identify this specific instance of the component.
 *                    For shared memory consumers, this should be a common key across
 *                    all instances to avoid double counting.
 */
public  class UnmanagedMemoryConsumerId implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String componentType ()  { throw new RuntimeException(); }
  public  java.lang.String instanceKey ()  { throw new RuntimeException(); }
  // not preceding
  public   UnmanagedMemoryConsumerId (java.lang.String componentType, java.lang.String instanceKey)  { throw new RuntimeException(); }
}
