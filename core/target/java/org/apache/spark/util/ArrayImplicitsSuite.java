package org.apache.spark.util;
public  class ArrayImplicitsSuite extends org.apache.spark.SparkFunSuite {
  public  class TestClass implements scala.Product, java.io.Serializable {
    static public abstract  R apply (T1 v1)  ;
    static public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  int i ()  { throw new RuntimeException(); }
    // not preceding
    public   TestClass (int i)  { throw new RuntimeException(); }
  }
  public  class TestClass$ extends scala.runtime.AbstractFunction1<java.lang.Object, org.apache.spark.util.ArrayImplicitsSuite.TestClass> implements java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final TestClass$ MODULE$ = null;
    public   TestClass$ ()  { throw new RuntimeException(); }
  }
  public   ArrayImplicitsSuite ()  { throw new RuntimeException(); }
}
