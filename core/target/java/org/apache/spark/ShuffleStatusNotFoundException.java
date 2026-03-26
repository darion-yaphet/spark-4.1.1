package org.apache.spark;
public  class ShuffleStatusNotFoundException extends org.apache.spark.SparkException implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int shuffleId ()  { throw new RuntimeException(); }
  public  java.lang.String methodName ()  { throw new RuntimeException(); }
  // not preceding
  public   ShuffleStatusNotFoundException (int shuffleId, java.lang.String methodName)  { throw new RuntimeException(); }
}
