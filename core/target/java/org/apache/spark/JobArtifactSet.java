package org.apache.spark;
/**
 * Artifact set for a job.
 * This class is used to store session (i.e <code>SparkSession</code>) specific resources/artifacts.
 * <p>
 * When Spark Connect is used, this job-set points towards session-specific jars and class files.
 * Note that Spark Connect is not a requirement for using this class.
 * <p>
 * param:  state Job artifact state.
 * param:  jars Jars belonging to this session.
 * param:  files Files belonging to this session.
 * param:  archives Archives belonging to this session.
 */
  class JobArtifactSet implements java.io.Serializable {
  static public  org.apache.spark.JobArtifactSet emptyJobArtifactSet ()  { throw new RuntimeException(); }
  static public  org.apache.spark.JobArtifactSet defaultJobArtifactSet ()  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.JobArtifactState> lastSeenState ()  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.JobArtifactState> getCurrentJobArtifactState ()  { throw new RuntimeException(); }
  /**
   * Set the Spark Connect specific information in the active client to the underlying
   * {@link JobArtifactSet}.
   * <p>
   * @param state Job artifact state.
   * @return the result from the function applied with {@link JobArtifactSet} specific to
   *         the active client.
   * @param block (undocumented)
   */
  static public <T extends java.lang.Object> T withActiveJobArtifactState (org.apache.spark.JobArtifactState state, scala.Function0<T> block)  { throw new RuntimeException(); }
  /**
   * When Spark Connect isn't used, we default back to the shared resources.
   * <p>
   * @param sc The active {@link SparkContext}
   * @return A {@link JobArtifactSet} containing a copy of the jars/files/archives.
   *         If there is an active client, it sets the information from them.
   *         Otherwise, it falls back to the default in the {@link SparkContext}.
   */
  static public  org.apache.spark.JobArtifactSet getActiveOrDefault (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.JobArtifactState> state ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.Object> jars ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.Object> files ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.Object> archives ()  { throw new RuntimeException(); }
  // not preceding
  public   JobArtifactSet (scala.Option<org.apache.spark.JobArtifactState> state, scala.collection.immutable.Map<java.lang.String, java.lang.Object> jars, scala.collection.immutable.Map<java.lang.String, java.lang.Object> files, scala.collection.immutable.Map<java.lang.String, java.lang.Object> archives)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean equals (Object obj)  { throw new RuntimeException(); }
}
