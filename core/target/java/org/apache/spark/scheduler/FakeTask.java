package org.apache.spark.scheduler;
public  class FakeTask extends org.apache.spark.scheduler.Task<java.lang.Object> {
  /**
   * Utility method to create a TaskSet, potentially setting a particular sequence of preferred
   * locations for each task (given as varargs) if this sequence is not empty.
   * @param numTasks (undocumented)
   * @param prefLocs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.scheduler.TaskSet createTaskSet (int numTasks, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskSet createTaskSet (int numTasks, int rpId, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskSet createTaskSet (int numTasks, int stageId, int stageAttemptId, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskSet createTaskSet (int numTasks, int stageId, int stageAttemptId, int priority, int rpId, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskSet createShuffleMapTaskSet (int numTasks, int stageId, int stageAttemptId, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskSet createShuffleMapTaskSet (int numTasks, int stageId, int stageAttemptId, int priority, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskSet createBarrierTaskSet (int numTasks, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskSet createBarrierTaskSet (int numTasks, int rpId, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskSet createBarrierTaskSet (int numTasks, int stageId, int stageAttemptId, int priority, int rpId, scala.collection.immutable.Seq<scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation>> prefLocs)  { throw new RuntimeException(); }
  // not preceding
  public   FakeTask (int stageId, int partitionId, scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation> prefLocs, boolean isBarrier, org.apache.spark.executor.TaskMetrics fakeTaskMetrics)  { throw new RuntimeException(); }
  public  int runTask (org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.scheduler.TaskLocation> preferredLocations ()  { throw new RuntimeException(); }
}
