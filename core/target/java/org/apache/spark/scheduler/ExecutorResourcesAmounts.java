package org.apache.spark.scheduler;
/**
 * Class to hold information about a series of resources belonging to an executor.
 * A resource could be a GPU, FPGA, etc. And it is used as a temporary
 * class to calculate the resources amounts when offering resources to
 * the tasks in the {@link TaskSchedulerImpl}
 * <p>
 * One example is GPUs, where the addresses would be the indices of the GPUs
 * <p>
 * param:  resources The executor available resources and amount. eg,
 *                  Map("gpu" -> Map("0" -> ResourceAmountUtils.toInternalResource(0.2),
 *                                   "1" -> ResourceAmountUtils.toInternalResource(1.0)),
 *                  "fpga" -> Map("a" -> ResourceAmountUtils.toInternalResource(0.3),
 *                                "b" -> ResourceAmountUtils.toInternalResource(0.9))
 *                  )
 */
  class ExecutorResourcesAmounts implements java.io.Serializable {
  /**
   * Create an empty ExecutorResourcesAmounts
   * @return (undocumented)
   */
  static public  org.apache.spark.scheduler.ExecutorResourcesAmounts empty ()  { throw new RuntimeException(); }
  /**
   * Converts executor infos to ExecutorResourcesAmounts
   * @param executorInfos (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.scheduler.ExecutorResourcesAmounts apply (scala.collection.immutable.Map<java.lang.String, org.apache.spark.scheduler.ExecutorResourceInfo> executorInfos)  { throw new RuntimeException(); }
  // not preceding
  public   ExecutorResourcesAmounts (scala.collection.immutable.Map<java.lang.String, scala.collection.immutable.Map<java.lang.String, java.lang.Object>> resources)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, java.lang.Object> resourceAddressAmount ()  { throw new RuntimeException(); }
  /**
   * For testing purpose. convert internal resources back to the "fraction" resources.
   * @return (undocumented)
   */
    scala.collection.immutable.Map<java.lang.String, scala.collection.immutable.Map<java.lang.String, java.lang.Object>> availableResources ()  { throw new RuntimeException(); }
  /**
   * Acquire the resource.
   * @param assignedResource the assigned resource information
   */
  public  void acquire (scala.collection.immutable.Map<java.lang.String, scala.collection.immutable.Map<java.lang.String, java.lang.Object>> assignedResource)  { throw new RuntimeException(); }
  /**
   * Release the assigned resources to the resource pool
   * @param assignedResource resource to be released
   */
  public  void release (scala.collection.immutable.Map<java.lang.String, scala.collection.immutable.Map<java.lang.String, java.lang.Object>> assignedResource)  { throw new RuntimeException(); }
  /**
   * Try to assign the addresses according to the task requirement. This function always goes
   * through the available resources starting from the "small" address. If the resources amount
   * of the address is matching the task requirement, we will assign this address to this task.
   * Eg, assuming the available resources are {"gpu" -&amp;gt; {"0"-&amp;gt; 0.7, "1" -&amp;gt; 1.0}) and the
   * task requirement is 0.5, this function will return Some(Map("gpu" -&amp;gt; {"0" -&amp;gt; 0.5})).
   * <p>
   * TODO: as we consistently allocate addresses beginning from the "small" address, it can
   * potentially result in an undesired consequence where a portion of the resource is being wasted.
   * Eg, assuming the available resources are {"gpu" -&amp;gt; {"0"-&amp;gt; 1.0, "1" -&amp;gt; 0.5}) and the
   * task amount requirement is 0.5, this function will return
   * Some(Map("gpu" -&amp;gt; {"0" -&amp;gt; 0.5})), and the left available resource will be
   * {"gpu" -&amp;gt; {"0"-&amp;gt; 0.5, "1" -&amp;gt; 0.5}) which can't assign to the task that
   * requires &amp;gt; 0.5 any more.
   * <p>
   * @param taskSetProf assign resources based on which resource profile
   * @return the optional assigned resources amounts. returns None if any
   *         of the task requests for resources aren't met.
   */
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, scala.collection.immutable.Map<java.lang.String, java.lang.Object>>> assignAddressesCustomResources (org.apache.spark.resource.ResourceProfile taskSetProf)  { throw new RuntimeException(); }
}
