package org.apache.spark.deploy.master;
  class WorkerResourceInfo implements java.io.Serializable, org.apache.spark.resource.ResourceAllocator, scala.Product {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> addresses ()  { throw new RuntimeException(); }
  // not preceding
  public   WorkerResourceInfo (java.lang.String name, scala.collection.immutable.Seq<java.lang.String> addresses)  { throw new RuntimeException(); }
  protected  java.lang.String resourceName ()  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Seq<java.lang.String> resourceAddresses ()  { throw new RuntimeException(); }
  /**
   * Acquire the resources.
   * @param amount How many addresses are requesting.
   * @return ResourceInformation
   */
  public  org.apache.spark.resource.ResourceInformation acquire (int amount)  { throw new RuntimeException(); }
}
