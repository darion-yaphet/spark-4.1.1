package org.apache.spark.scheduler;
public  class DAGSchedulerSuite$ implements java.io.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DAGSchedulerSuite$ MODULE$ = null;
  public   DAGSchedulerSuite$ ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.ArrayBuffer<org.apache.spark.storage.BlockManagerId> mergerLocs ()  { throw new RuntimeException(); }
  public  org.apache.spark.scheduler.MapStatus makeMapStatus (java.lang.String host, int reduces, byte sizes, long mapTaskId, long checksumVal)  { throw new RuntimeException(); }
  public  org.apache.spark.storage.BlockManagerId makeBlockManagerId (java.lang.String host, scala.Option<java.lang.String> execId)  { throw new RuntimeException(); }
  public  org.apache.spark.scheduler.MergeStatus makeMergeStatus (java.lang.String host, int shuffleMergeId, long size, boolean isShufflePushMerger)  { throw new RuntimeException(); }
  public  void addMergerLocs (scala.collection.immutable.Seq<java.lang.String> locs)  { throw new RuntimeException(); }
  public  void clearMergerLocs ()  { throw new RuntimeException(); }
}
