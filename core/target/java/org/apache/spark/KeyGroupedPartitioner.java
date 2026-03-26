package org.apache.spark;
/**
 * A {@link org.apache.spark.Partitioner} that partitions all records using partition value map.
 * The <code>valueMap</code> is a map that contains tuples of (partition value, partition id). It is generated
 * by {@link org.apache.spark.sql.catalyst.plans.physical.KeyGroupedPartitioning}, used to partition
 * the other side of a join to make sure records with same partition value are in the same
 * partition.
 */
  class KeyGroupedPartitioner extends org.apache.spark.Partitioner {
  // not preceding
  public   KeyGroupedPartitioner (scala.collection.mutable.Map<scala.collection.immutable.Seq<java.lang.Object>, java.lang.Object> valueMap, int numPartitions)  { throw new RuntimeException(); }
  public  int getPartition (Object key)  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
}
