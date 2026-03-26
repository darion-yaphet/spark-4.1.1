package org.apache.spark;
/**
 * :: DeveloperApi ::
 * We don't know why the task ended -- for example, because of a ClassNotFound exception when
 * deserializing the task result.
 */
public  class UnknownReason {
  static public  java.lang.String toErrorString ()  { throw new RuntimeException(); }
  static public  boolean countTowardsTaskFailures ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  int productArity ()  ;
  static public abstract  Object productElement (int n)  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  static public  java.lang.String productElementName (int n)  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<java.lang.String> productElementNames ()  { throw new RuntimeException(); }
}
