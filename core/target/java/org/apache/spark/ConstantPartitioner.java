package org.apache.spark;
/**
 * A {@link org.apache.spark.Partitioner} that partitions all records into a single partition.
 */
  class ConstantPartitioner extends org.apache.spark.Partitioner {
  public   ConstantPartitioner ()  { throw new RuntimeException(); }
  public  int getPartition (Object key)  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
}
