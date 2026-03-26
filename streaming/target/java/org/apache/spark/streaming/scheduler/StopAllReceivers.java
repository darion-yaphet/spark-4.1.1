package org.apache.spark.streaming.scheduler;
/**
 * This message will trigger ReceiverTrackerEndpoint to send stop signals to all registered
 * receivers.
 */
public  class StopAllReceivers {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  int productArity ()  ;
  static public abstract  Object productElement (int n)  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  static public  java.lang.String productElementName (int n)  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<java.lang.String> productElementNames ()  { throw new RuntimeException(); }
}
