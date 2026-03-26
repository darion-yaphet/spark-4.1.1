package org.apache.spark.storage;
public  class CustomJavaSerializer extends org.apache.spark.serializer.JavaSerializer {
  public   CustomJavaSerializer (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.serializer.SerializerInstance newInstance ()  { throw new RuntimeException(); }
}
