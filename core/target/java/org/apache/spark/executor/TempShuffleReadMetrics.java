package org.apache.spark.executor;
/**
 * A temporary shuffle read metrics holder that is used to collect shuffle read metrics for each
 * shuffle dependency, and all temporary metrics will be merged into the {@link ShuffleReadMetrics} at
 * last.
 */
  class TempShuffleReadMetrics implements org.apache.spark.shuffle.ShuffleReadMetricsReporter {
  public   TempShuffleReadMetrics ()  { throw new RuntimeException(); }
  public  long corruptMergedBlockChunks ()  { throw new RuntimeException(); }
  public  long fetchWaitTime ()  { throw new RuntimeException(); }
  public  void incCorruptMergedBlockChunks (long v)  { throw new RuntimeException(); }
  public  void incFetchWaitTime (long v)  { throw new RuntimeException(); }
  public  void incLocalBlocksFetched (long v)  { throw new RuntimeException(); }
  public  void incLocalBytesRead (long v)  { throw new RuntimeException(); }
  public  void incLocalMergedBlocksFetched (long v)  { throw new RuntimeException(); }
  public  void incLocalMergedBytesRead (long v)  { throw new RuntimeException(); }
  public  void incLocalMergedChunksFetched (long v)  { throw new RuntimeException(); }
  public  void incMergedFetchFallbackCount (long v)  { throw new RuntimeException(); }
  public  void incRecordsRead (long v)  { throw new RuntimeException(); }
  public  void incRemoteBlocksFetched (long v)  { throw new RuntimeException(); }
  public  void incRemoteBytesRead (long v)  { throw new RuntimeException(); }
  public  void incRemoteBytesReadToDisk (long v)  { throw new RuntimeException(); }
  public  void incRemoteMergedBlocksFetched (long v)  { throw new RuntimeException(); }
  public  void incRemoteMergedBytesRead (long v)  { throw new RuntimeException(); }
  public  void incRemoteMergedChunksFetched (long v)  { throw new RuntimeException(); }
  public  void incRemoteMergedReqsDuration (long v)  { throw new RuntimeException(); }
  public  void incRemoteReqsDuration (long v)  { throw new RuntimeException(); }
  public  long localBlocksFetched ()  { throw new RuntimeException(); }
  public  long localBytesRead ()  { throw new RuntimeException(); }
  public  long localMergedBlocksFetched ()  { throw new RuntimeException(); }
  public  long localMergedBytesRead ()  { throw new RuntimeException(); }
  public  long localMergedChunksFetched ()  { throw new RuntimeException(); }
  public  long mergedFetchFallbackCount ()  { throw new RuntimeException(); }
  public  long recordsRead ()  { throw new RuntimeException(); }
  public  long remoteBlocksFetched ()  { throw new RuntimeException(); }
  public  long remoteBytesRead ()  { throw new RuntimeException(); }
  public  long remoteBytesReadToDisk ()  { throw new RuntimeException(); }
  public  long remoteMergedBlocksFetched ()  { throw new RuntimeException(); }
  public  long remoteMergedBytesRead ()  { throw new RuntimeException(); }
  public  long remoteMergedChunksFetched ()  { throw new RuntimeException(); }
  public  long remoteMergedReqsDuration ()  { throw new RuntimeException(); }
  public  long remoteReqsDuration ()  { throw new RuntimeException(); }
}
