package org.apache.spark.executor;
/**
 * :: DeveloperApi ::
 * A collection of accumulators that represent metrics about reading shuffle data.
 * Operations are not thread-safe.
 */
public  class ShuffleReadMetrics implements java.io.Serializable {
     ShuffleReadMetrics ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _corruptMergedBlockChunks ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _fetchWaitTime ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _localBlocksFetched ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _localBytesRead ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _localMergedBlocksFetched ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _localMergedBytesRead ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _localMergedChunksFetched ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _mergedFetchFallbackCount ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _recordsRead ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _remoteBlocksFetched ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _remoteBytesRead ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _remoteBytesReadToDisk ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _remoteMergedBlocksFetched ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _remoteMergedBytesRead ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _remoteMergedChunksFetched ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _remoteMergedReqsDuration ()  { throw new RuntimeException(); }
    org.apache.spark.util.LongAccumulator _remoteReqsDuration ()  { throw new RuntimeException(); }
  /**
   * Number of corrupt merged shuffle block chunks encountered by this task (remote or local).
   * @return (undocumented)
   */
  public  long corruptMergedBlockChunks ()  { throw new RuntimeException(); }
  /**
   * Time the task spent waiting for remote shuffle blocks. This only includes the time
   * blocking on shuffle input data. For instance if block B is being fetched while the task is
   * still not finished processing block A, it is not considered to be blocking on block B.
   * @return (undocumented)
   */
  public  long fetchWaitTime ()  { throw new RuntimeException(); }
    void incCorruptMergedBlockChunks (long v)  { throw new RuntimeException(); }
    void incFetchWaitTime (long v)  { throw new RuntimeException(); }
    void incLocalBlocksFetched (long v)  { throw new RuntimeException(); }
    void incLocalBytesRead (long v)  { throw new RuntimeException(); }
    void incLocalMergedBlocksFetched (long v)  { throw new RuntimeException(); }
    void incLocalMergedBytesRead (long v)  { throw new RuntimeException(); }
    void incLocalMergedChunksFetched (long v)  { throw new RuntimeException(); }
    void incMergedFetchFallbackCount (long v)  { throw new RuntimeException(); }
    void incRecordsRead (long v)  { throw new RuntimeException(); }
    void incRemoteBlocksFetched (long v)  { throw new RuntimeException(); }
    void incRemoteBytesRead (long v)  { throw new RuntimeException(); }
    void incRemoteBytesReadToDisk (long v)  { throw new RuntimeException(); }
    void incRemoteMergedBlocksFetched (long v)  { throw new RuntimeException(); }
    void incRemoteMergedBytesRead (long v)  { throw new RuntimeException(); }
    void incRemoteMergedChunksFetched (long v)  { throw new RuntimeException(); }
    void incRemoteMergedReqsDuration (long v)  { throw new RuntimeException(); }
    void incRemoteReqsDuration (long v)  { throw new RuntimeException(); }
  /**
   * Number of local blocks fetched in this shuffle by this task.
   * @return (undocumented)
   */
  public  long localBlocksFetched ()  { throw new RuntimeException(); }
  /**
   * Shuffle data that was read from the local disk (as opposed to from a remote executor).
   * @return (undocumented)
   */
  public  long localBytesRead ()  { throw new RuntimeException(); }
  /**
   * Number of local merged blocks fetched.
   * @return (undocumented)
   */
  public  long localMergedBlocksFetched ()  { throw new RuntimeException(); }
  /**
   * Total number of local merged bytes read.
   * @return (undocumented)
   */
  public  long localMergedBytesRead ()  { throw new RuntimeException(); }
  /**
   * Number of local merged chunks fetched.
   * @return (undocumented)
   */
  public  long localMergedChunksFetched ()  { throw new RuntimeException(); }
  /**
   * Number of times the task had to fallback to fetch original shuffle blocks for a merged
   * shuffle block chunk (remote or local).
   * @return (undocumented)
   */
  public  long mergedFetchFallbackCount ()  { throw new RuntimeException(); }
  /**
   * Total number of records read from the shuffle by this task.
   * @return (undocumented)
   */
  public  long recordsRead ()  { throw new RuntimeException(); }
  /**
   * Number of remote blocks fetched in this shuffle by this task.
   * @return (undocumented)
   */
  public  long remoteBlocksFetched ()  { throw new RuntimeException(); }
  /**
   * Total number of remote bytes read from the shuffle by this task.
   * @return (undocumented)
   */
  public  long remoteBytesRead ()  { throw new RuntimeException(); }
  /**
   * Total number of remotes bytes read to disk from the shuffle by this task.
   * @return (undocumented)
   */
  public  long remoteBytesReadToDisk ()  { throw new RuntimeException(); }
  /**
   * Number of remote merged blocks fetched.
   * @return (undocumented)
   */
  public  long remoteMergedBlocksFetched ()  { throw new RuntimeException(); }
  /**
   * Total number of remote merged bytes read.
   * @return (undocumented)
   */
  public  long remoteMergedBytesRead ()  { throw new RuntimeException(); }
  /**
   * Number of remote merged chunks fetched.
   * @return (undocumented)
   */
  public  long remoteMergedChunksFetched ()  { throw new RuntimeException(); }
  /**
   * Total time taken for remote merged requests.
   * @return (undocumented)
   */
  public  long remoteMergedReqsDuration ()  { throw new RuntimeException(); }
  /**
   * Total time taken for remote requests to complete by this task. This doesn't include
   * duration of remote merged requests.
   * @return (undocumented)
   */
  public  long remoteReqsDuration ()  { throw new RuntimeException(); }
    void setCorruptMergedBlockChunks (long v)  { throw new RuntimeException(); }
    void setFetchWaitTime (long v)  { throw new RuntimeException(); }
    void setLocalBlocksFetched (int v)  { throw new RuntimeException(); }
    void setLocalBytesRead (long v)  { throw new RuntimeException(); }
    void setLocalMergedBlocksFetched (long v)  { throw new RuntimeException(); }
    void setLocalMergedBytesRead (long v)  { throw new RuntimeException(); }
    void setLocalMergedChunksFetched (long v)  { throw new RuntimeException(); }
  /**
   * Resets the value of the current metrics (<code>this</code>) and merges all the independent
   * {@link TempShuffleReadMetrics} into <code>this</code>.
   * @param metrics (undocumented)
   */
    void setMergeValues (scala.collection.immutable.Seq<org.apache.spark.executor.TempShuffleReadMetrics> metrics)  { throw new RuntimeException(); }
    void setMergedFetchFallbackCount (long v)  { throw new RuntimeException(); }
    void setRecordsRead (long v)  { throw new RuntimeException(); }
    void setRemoteBlocksFetched (int v)  { throw new RuntimeException(); }
    void setRemoteBytesRead (long v)  { throw new RuntimeException(); }
    void setRemoteBytesReadToDisk (long v)  { throw new RuntimeException(); }
    void setRemoteMergedBlocksFetched (long v)  { throw new RuntimeException(); }
    void setRemoteMergedBytesRead (long v)  { throw new RuntimeException(); }
    void setRemoteMergedChunksFetched (long v)  { throw new RuntimeException(); }
    void setRemoteMergedReqsDuration (long v)  { throw new RuntimeException(); }
    void setRemoteReqsDuration (long v)  { throw new RuntimeException(); }
  /**
   * Number of blocks fetched in this shuffle by this task (remote or local).
   * @return (undocumented)
   */
  public  long totalBlocksFetched ()  { throw new RuntimeException(); }
  /**
   * Total bytes fetched in the shuffle by this task (both remote and local).
   * @return (undocumented)
   */
  public  long totalBytesRead ()  { throw new RuntimeException(); }
}
