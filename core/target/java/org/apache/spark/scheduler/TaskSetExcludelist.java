package org.apache.spark.scheduler;
/**
 * Handles excluding executors and nodes within a taskset.  This includes excluding specific
 * (task, executor) / (task, nodes) pairs, and also completely excluding executors and nodes
 * for the entire taskset.
 * <p>
 * It also must store sufficient information in task failures for application level exclusion,
 * which is handled by {@link HealthTracker}.  Note that HealthTracker does not know anything
 * about task failures until a taskset completes successfully.
 * <p>
 * If isDryRun is true, then this class will only function to store information for application
 * level exclusion, and will not actually exclude any tasks in task/stage level.
 * <p>
 * THREADING:  This class is a helper to {@link TaskSetManager}; as with the methods in
 * {@link TaskSetManager} this class is designed only to be called from code with a lock on the
 * TaskScheduler (e.g. its event handlers). It should not be called from other threads.
 */
  class TaskSetExcludelist implements org.apache.spark.internal.Logging {
  /**
   * Returns true if the excludeOnFailure is enabled on the task/stage level,
   * based on checking the configuration in the following order:
   * 1. Is taskset level exclusion specifically enabled or disabled?
   * 2. Is overall exclusion feature enabled or disabled?
   * 3. Default is off
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  boolean isExcludeOnFailureEnabled (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf conf ()  { throw new RuntimeException(); }
  public  int stageId ()  { throw new RuntimeException(); }
  public  int stageAttemptId ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.Clock clock ()  { throw new RuntimeException(); }
  public  boolean isDryRun ()  { throw new RuntimeException(); }
  // not preceding
  public   TaskSetExcludelist (org.apache.spark.scheduler.LiveListenerBus listenerBus, org.apache.spark.SparkConf conf, int stageId, int stageAttemptId, org.apache.spark.util.Clock clock, boolean isDryRun)  { throw new RuntimeException(); }
  /**
   * A map from each executor to the task failures on that executor.  This is used for exclusion
   * within this taskset, and it is also relayed onto {@link HealthTracker} for app-level
   * exlucsion if this taskset completes successfully.
   * @return (undocumented)
   */
  public  scala.collection.mutable.HashMap<java.lang.String, org.apache.spark.scheduler.ExecutorFailuresInTaskSet> execToFailures ()  { throw new RuntimeException(); }
  /**
   * Get the most recent failure reason of this TaskSet.
   * @return (undocumented)
   */
  public  java.lang.String getLatestFailureReason ()  { throw new RuntimeException(); }
  /**
   * Return true if this executor is excluded for the given task.  This does *not*
   * need to return true if the executor is excluded for the entire stage, or excluded
   * for the entire application.  That is to keep this method as fast as possible in the inner-loop
   * of the scheduler, where those filters will have already been applied.
   * @param executorId (undocumented)
   * @param index (undocumented)
   * @return (undocumented)
   */
  public  boolean isExecutorExcludedForTask (java.lang.String executorId, int index)  { throw new RuntimeException(); }
  public  boolean isNodeExcludedForTask (java.lang.String node, int index)  { throw new RuntimeException(); }
  /**
   * Return true if this executor is excluded for the given stage.  Completely ignores whether
   * the executor is excluded for the entire application (or anything to do with the node the
   * executor is on).  That is to keep this method as fast as possible in the inner-loop of the
   * scheduler, where those filters will already have been applied.
   * @param executorId (undocumented)
   * @return (undocumented)
   */
  public  boolean isExecutorExcludedForTaskSet (java.lang.String executorId)  { throw new RuntimeException(); }
  public  boolean isNodeExcludedForTaskSet (java.lang.String node)  { throw new RuntimeException(); }
    void updateExcludedForFailedTask (java.lang.String host, java.lang.String exec, int index, java.lang.String failureReason)  { throw new RuntimeException(); }
}
