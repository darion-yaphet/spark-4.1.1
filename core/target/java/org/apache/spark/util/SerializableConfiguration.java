package org.apache.spark.util;
/**
 * Hadoop configuration but serializable. Use <code>value</code> to access the Hadoop configuration.
 * <p>
 * param:  value Hadoop configuration
 */
public  class SerializableConfiguration implements java.io.Serializable {
  static public  org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> broadcast (org.apache.spark.SparkContext sc, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  static public  org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> broadcast (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration value ()  { throw new RuntimeException(); }
  // not preceding
  public   SerializableConfiguration (org.apache.hadoop.conf.Configuration value)  { throw new RuntimeException(); }
}
