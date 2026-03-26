package org.apache.spark.util;
/**
 * {@link ClassLoader} that replaces missing classes with stubs, if the cannot be found. It will only
 * do this for classes that are marked for stubbing.
 * <p>
 * While this is generally not a good idea. In this particular case this is used to load lambda's
 * whose capturing class contains unknown (and unneeded) classes. The lambda itself does not need
 * the class and therefor is safe to replace by a stub.
 */
  class StubClassLoader extends java.lang.ClassLoader implements org.apache.spark.internal.Logging {
  static public  org.apache.spark.util.StubClassLoader apply (java.lang.ClassLoader parent, scala.collection.immutable.Seq<java.lang.String> binaryName)  { throw new RuntimeException(); }
  static public  byte[] generateStub (java.lang.String binaryName)  { throw new RuntimeException(); }
  public   StubClassLoader (java.lang.ClassLoader parent, scala.Function1<java.lang.String, java.lang.Object> shouldStub)  { throw new RuntimeException(); }
  public  java.lang.Class<?> findClass (java.lang.String name)  { throw new RuntimeException(); }
}
