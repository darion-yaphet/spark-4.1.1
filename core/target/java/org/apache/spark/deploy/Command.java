package org.apache.spark.deploy;
  class Command implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String mainClass ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> arguments ()  { throw new RuntimeException(); }
  public  scala.collection.Map<java.lang.String, java.lang.String> environment ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> classPathEntries ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> libraryPathEntries ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> javaOpts ()  { throw new RuntimeException(); }
  // not preceding
  public   Command (java.lang.String mainClass, scala.collection.immutable.Seq<java.lang.String> arguments, scala.collection.Map<java.lang.String, java.lang.String> environment, scala.collection.immutable.Seq<java.lang.String> classPathEntries, scala.collection.immutable.Seq<java.lang.String> libraryPathEntries, scala.collection.immutable.Seq<java.lang.String> javaOpts)  { throw new RuntimeException(); }
}
