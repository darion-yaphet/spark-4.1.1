package org.apache.spark.scheduler.dynalloc;
/**
 * A monitor for executor activity, used by ExecutorAllocationManager to detect idle executors.
 */
  class ExecutorMonitor extends org.apache.spark.scheduler.SparkListener implements org.apache.spark.CleanerListener, org.apache.spark.internal.Logging {
    class Tracker {
    // not preceding
    public   Tracker (int resourceProfileId)  { throw new RuntimeException(); }
    public  void addShuffle (int id)  { throw new RuntimeException(); }
    public  scala.collection.mutable.HashMap<java.lang.Object, scala.collection.mutable.BitSet> cachedBlocks ()  { throw new RuntimeException(); }
    public  boolean decommissioning ()  { throw new RuntimeException(); }
    public  boolean hasActiveShuffle ()  { throw new RuntimeException(); }
    public  boolean isIdle ()  { throw new RuntimeException(); }
    public  boolean pendingRemoval ()  { throw new RuntimeException(); }
    public  void removeShuffle (int id)  { throw new RuntimeException(); }
    public  int resourceProfileId ()  { throw new RuntimeException(); }
    public  boolean timedOut ()  { throw new RuntimeException(); }
    public  long timeoutAt ()  { throw new RuntimeException(); }
    public  void updateActiveShuffles (scala.collection.Iterable<java.lang.Object> ids)  { throw new RuntimeException(); }
    public  void updateRunningTasks (int delta)  { throw new RuntimeException(); }
    public  void updateTimeout ()  { throw new RuntimeException(); }
  }
  public   ExecutorMonitor (org.apache.spark.SparkConf conf, org.apache.spark.ExecutorAllocationClient client, org.apache.spark.scheduler.LiveListenerBus listenerBus, org.apache.spark.util.Clock clock, org.apache.spark.ExecutorAllocationManagerSource metrics)  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  /**
   * Returns the list of executors and their ResourceProfile id that are currently considered to
   * be timed out. Should only be called from the EAM thread.
   * @return (undocumented)
   */
  public  scala.collection.immutable.Seq<scala.Tuple2<java.lang.String, java.lang.Object>> timedOutExecutors ()  { throw new RuntimeException(); }
  /**
   * Mark the given executors as pending to be removed. Should only be called in the EAM thread.
   * This covers both kills and decommissions.
   * @param ids (undocumented)
   */
  public  void executorsKilled (scala.collection.immutable.Seq<java.lang.String> ids)  { throw new RuntimeException(); }
    void executorsDecommissioned (scala.collection.immutable.Seq<java.lang.String> ids)  { throw new RuntimeException(); }
  public  int executorCount ()  { throw new RuntimeException(); }
  public  int executorCountWithResourceProfile (int id)  { throw new RuntimeException(); }
  public  int getResourceProfileId (java.lang.String executorId)  { throw new RuntimeException(); }
  public  int pendingRemovalCount ()  { throw new RuntimeException(); }
  public  int pendingRemovalCountPerResourceProfileId (int id)  { throw new RuntimeException(); }
  public  int decommissioningCount ()  { throw new RuntimeException(); }
  public  int decommissioningPerResourceProfileId (int id)  { throw new RuntimeException(); }
  public  void onJobStart (org.apache.spark.scheduler.SparkListenerJobStart event)  { throw new RuntimeException(); }
  public  void onJobEnd (org.apache.spark.scheduler.SparkListenerJobEnd event)  { throw new RuntimeException(); }
  public  void onTaskStart (org.apache.spark.scheduler.SparkListenerTaskStart event)  { throw new RuntimeException(); }
  public  void onTaskEnd (org.apache.spark.scheduler.SparkListenerTaskEnd event)  { throw new RuntimeException(); }
  public  void onExecutorAdded (org.apache.spark.scheduler.SparkListenerExecutorAdded event)  { throw new RuntimeException(); }
  public  void onExecutorRemoved (org.apache.spark.scheduler.SparkListenerExecutorRemoved event)  { throw new RuntimeException(); }
  public  void onBlockUpdated (org.apache.spark.scheduler.SparkListenerBlockUpdated event)  { throw new RuntimeException(); }
  public  void onUnpersistRDD (org.apache.spark.scheduler.SparkListenerUnpersistRDD event)  { throw new RuntimeException(); }
  public  void onOtherEvent (org.apache.spark.scheduler.SparkListenerEvent event)  { throw new RuntimeException(); }
  public  void rddCleaned (int rddId)  { throw new RuntimeException(); }
  public  void shuffleCleaned (int shuffleId)  { throw new RuntimeException(); }
  public  void broadcastCleaned (long broadcastId)  { throw new RuntimeException(); }
  public  void accumCleaned (long accId)  { throw new RuntimeException(); }
  public  void checkpointCleaned (long rddId)  { throw new RuntimeException(); }
    boolean isExecutorIdle (java.lang.String id)  { throw new RuntimeException(); }
    scala.collection.immutable.Seq<java.lang.String> timedOutExecutors (long when)  { throw new RuntimeException(); }
    scala.collection.immutable.Set<java.lang.String> executorsPendingToRemove ()  { throw new RuntimeException(); }
    scala.collection.immutable.Set<java.lang.String> executorsDecommissioning ()  { throw new RuntimeException(); }
  /**
   * This method should be used when updating executor state. It guards against a race condition in
   * which the <code>SparkListenerTaskStart</code> event is posted before the <code>SparkListenerBlockManagerAdded</code>
   * event, which is possible because these events are posted in different threads. (see SPARK-4951)
   * @param id (undocumented)
   * @param resourceProfileId (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.scheduler.dynalloc.ExecutorMonitor.Tracker ensureExecutorIsTracked (java.lang.String id, int resourceProfileId)  { throw new RuntimeException(); }
}
