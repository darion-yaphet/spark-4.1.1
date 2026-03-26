package org.apache.spark.streaming.ui;
/**
 * A helper class for "input rate" to generate data that will be used in the timeline and histogram
 * graphs.
 * <p>
 * param:  data (batch time, record rate).
 */
  class RecordRateUIData {
  // not preceding
  public   RecordRateUIData (scala.collection.immutable.Seq<scala.Tuple2<java.lang.Object, java.lang.Object>> data)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> avg ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<scala.Tuple2<java.lang.Object, java.lang.Object>> data ()  { throw new RuntimeException(); }
  public  java.lang.String formattedAvg ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> max ()  { throw new RuntimeException(); }
}
