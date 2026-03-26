package org.apache.spark;
public  class JobArtifactSet$ implements java.io.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JobArtifactSet$ MODULE$ = null;
  public   JobArtifactSet$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.JobArtifactSet emptyJobArtifactSet ()  { throw new RuntimeException(); }
  public  org.apache.spark.JobArtifactSet defaultJobArtifactSet ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.JobArtifactState> lastSeenState ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.JobArtifactState> getCurrentJobArtifactState ()  { throw new RuntimeException(); }
  /**
   * Set the Spark Connect specific information in the active client to the underlying
   * {@link JobArtifactSet}.
   * <p>
   * @param state Job artifact state.
   * @return the result from the function applied with {@link JobArtifactSet} specific to
   *         the active client.
   * @param block (undocumented)
   */
  public <T extends java.lang.Object> T withActiveJobArtifactState (org.apache.spark.JobArtifactState state, scala.Function0<T> block)  { throw new RuntimeException(); }
  /**
   * When Spark Connect isn't used, we default back to the shared resources.
   * <p>
   * @param sc The active {@link SparkContext}
   * @return A {@link JobArtifactSet} containing a copy of the jars/files/archives.
   *         If there is an active client, it sets the information from them.
   *         Otherwise, it falls back to the default in the {@link SparkContext}.
   */
  public  org.apache.spark.JobArtifactSet getActiveOrDefault (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
}
