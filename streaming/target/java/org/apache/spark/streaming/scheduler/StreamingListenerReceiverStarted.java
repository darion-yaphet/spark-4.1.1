package org.apache.spark.streaming.scheduler;
public  class StreamingListenerReceiverStarted implements org.apache.spark.streaming.scheduler.StreamingListenerEvent, scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.streaming.scheduler.ReceiverInfo receiverInfo ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingListenerReceiverStarted (org.apache.spark.streaming.scheduler.ReceiverInfo receiverInfo)  { throw new RuntimeException(); }
}
