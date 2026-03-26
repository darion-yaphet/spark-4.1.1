package org.apache.spark.api.python;
/**
 * A wrapper for chained Python functions (from bottom to top).
 * param:  funcs
 */
  class ChainedPythonFunctions implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.api.python.PythonFunction> funcs ()  { throw new RuntimeException(); }
  // not preceding
  public   ChainedPythonFunctions (scala.collection.immutable.Seq<org.apache.spark.api.python.PythonFunction> funcs)  { throw new RuntimeException(); }
}
