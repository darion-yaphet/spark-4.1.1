package org.apache.spark.scheduler;
public  class TaskSetExcludelist$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TaskSetExcludelist$ MODULE$ = null;
  public   TaskSetExcludelist$ ()  { throw new RuntimeException(); }
  /**
   * Returns true if the excludeOnFailure is enabled on the task/stage level,
   * based on checking the configuration in the following order:
   * 1. Is taskset level exclusion specifically enabled or disabled?
   * 2. Is overall exclusion feature enabled or disabled?
   * 3. Default is off
   * @param conf (undocumented)
   * @return (undocumented)
   */
  public  boolean isExcludeOnFailureEnabled (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
}
