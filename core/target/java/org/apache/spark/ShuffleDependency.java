package org.apache.spark;
public  class ShuffleDependency<K extends java.lang.Object, V extends java.lang.Object, C extends java.lang.Object> extends org.apache.spark.Dependency<scala.Product2<K, V>> implements org.apache.spark.internal.Logging {
  // not preceding
  static   org.apache.spark.shuffle.checksum.RowBasedChecksum[] EMPTY_ROW_BASED_CHECKSUMS ()  { throw new RuntimeException(); }
  public  org.apache.spark.Partitioner partitioner ()  { throw new RuntimeException(); }
  public  org.apache.spark.serializer.Serializer serializer ()  { throw new RuntimeException(); }
  public  scala.Option<scala.math.Ordering<K>> keyOrdering ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.Aggregator<K, V, C>> aggregator ()  { throw new RuntimeException(); }
  public  boolean mapSideCombine ()  { throw new RuntimeException(); }
  public  org.apache.spark.shuffle.ShuffleWriteProcessor shuffleWriterProcessor ()  { throw new RuntimeException(); }
  public  org.apache.spark.shuffle.checksum.RowBasedChecksum[] rowBasedChecksums ()  { throw new RuntimeException(); }
  public  boolean checksumMismatchFullRetryEnabled ()  { throw new RuntimeException(); }
  public   ShuffleDependency (org.apache.spark.rdd.RDD<? extends scala.Product2<K, V>> _rdd, org.apache.spark.Partitioner partitioner, org.apache.spark.serializer.Serializer serializer, scala.Option<scala.math.Ordering<K>> keyOrdering, scala.Option<org.apache.spark.Aggregator<K, V, C>> aggregator, boolean mapSideCombine, org.apache.spark.shuffle.ShuffleWriteProcessor shuffleWriterProcessor, org.apache.spark.shuffle.checksum.RowBasedChecksum[] rowBasedChecksums, boolean checksumMismatchFullRetryEnabled, scala.reflect.ClassTag<K> evidence$1, scala.reflect.ClassTag<V> evidence$2, scala.reflect.ClassTag<C> evidence$3)  { throw new RuntimeException(); }
  public   ShuffleDependency (org.apache.spark.rdd.RDD<? extends scala.Product2<K, V>> rdd, org.apache.spark.Partitioner partitioner, org.apache.spark.serializer.Serializer serializer, scala.Option<scala.math.Ordering<K>> keyOrdering, scala.Option<org.apache.spark.Aggregator<K, V, C>> aggregator, boolean mapSideCombine, org.apache.spark.shuffle.ShuffleWriteProcessor shuffleWriterProcessor, scala.reflect.ClassTag<K> evidence$4, scala.reflect.ClassTag<V> evidence$5, scala.reflect.ClassTag<C> evidence$6)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<scala.Product2<K, V>> rdd ()  { throw new RuntimeException(); }
    java.lang.String keyClassName ()  { throw new RuntimeException(); }
    java.lang.String valueClassName ()  { throw new RuntimeException(); }
    scala.Option<java.lang.String> combinerClassName ()  { throw new RuntimeException(); }
  public  int shuffleId ()  { throw new RuntimeException(); }
  public  org.apache.spark.shuffle.ShuffleHandle shuffleHandle ()  { throw new RuntimeException(); }
    void setShuffleMergeAllowed (boolean shuffleMergeAllowed)  { throw new RuntimeException(); }
  public  boolean shuffleMergeEnabled ()  { throw new RuntimeException(); }
  public  boolean shuffleMergeAllowed ()  { throw new RuntimeException(); }
  /**
   * Stores the location of the list of chosen external shuffle services for handling the
   * shuffle merge requests from mappers in this shuffle map stage.
   * @return (undocumented)
   */
    scala.collection.immutable.Seq<org.apache.spark.storage.BlockManagerId> mergerLocs ()  { throw new RuntimeException(); }
  /**
   * shuffleMergeId is used to uniquely identify merging process of shuffle
   * by an indeterminate stage attempt.
   * @return (undocumented)
   */
  public  int shuffleMergeId ()  { throw new RuntimeException(); }
  public  void setMergerLocs (scala.collection.immutable.Seq<org.apache.spark.storage.BlockManagerId> mergerLocs)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.storage.BlockManagerId> getMergerLocs ()  { throw new RuntimeException(); }
    void markShuffleMergeFinalized ()  { throw new RuntimeException(); }
    boolean isShuffleMergeFinalizedMarked ()  { throw new RuntimeException(); }
  /**
   * Returns true if push-based shuffle is disabled or if the shuffle merge for
   * this shuffle is finalized.
   * @return (undocumented)
   */
  public  boolean shuffleMergeFinalized ()  { throw new RuntimeException(); }
  public  void newShuffleMergeState ()  { throw new RuntimeException(); }
  /**
   * Mark a given map task as push completed in the tracking bitmap.
   * Using the bitmap ensures that the same map task launched multiple times due to
   * either speculation or stage retry is only counted once.
   * @param mapIndex Map task index
   * @return number of map tasks with block push completed
   */
    int incPushCompleted (int mapIndex)  { throw new RuntimeException(); }
    scala.Option<java.util.concurrent.ScheduledFuture<?>> getFinalizeTask ()  { throw new RuntimeException(); }
    void setFinalizeTask (java.util.concurrent.ScheduledFuture<?> task)  { throw new RuntimeException(); }
}
