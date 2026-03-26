package org.apache.spark.resource;
/**
 * Manager of resource profiles. The manager allows one place to keep the actual ResourceProfiles
 * and everywhere else we can use the ResourceProfile Id to save on space.
 * Note we never remove a resource profile at this point. Its expected this number is small
 * so this shouldn't be much overhead.
 */
  class ResourceProfileManager implements org.apache.spark.internal.Logging {
  public   ResourceProfileManager (org.apache.spark.SparkConf sparkConf, org.apache.spark.scheduler.LiveListenerBus listenerBus)  { throw new RuntimeException(); }
  public  void addResourceProfile (org.apache.spark.resource.ResourceProfile rp)  { throw new RuntimeException(); }
  /**
   * Check whether a task with specific taskRpId can be scheduled to executors
   * with executorRpId.
   * <p>
   * Here are the rules:
   * 1. When dynamic allocation is disabled, only {@link TaskResourceProfile} is supported,
   *    and tasks with {@link TaskResourceProfile} can be scheduled to executors with default
   *    resource profile.
   * 2. For other scenarios(when dynamic allocation is enabled), tasks can be scheduled to
   *    executors where resource profile exactly matches.
   * @param taskRpId (undocumented)
   * @param executorRpId (undocumented)
   * @return (undocumented)
   */
    boolean canBeScheduled (int taskRpId, int executorRpId)  { throw new RuntimeException(); }
  public  org.apache.spark.resource.ResourceProfile defaultResourceProfile ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.resource.ResourceProfile> getEquivalentProfile (org.apache.spark.resource.ResourceProfile rp)  { throw new RuntimeException(); }
  /**
   * If we use anything except the default profile, it's supported on YARN, Kubernetes and
   * Standalone with dynamic allocation enabled, and task resource profile with dynamic allocation
   * disabled on Standalone. Throw an exception if not supported.
   * @param rp (undocumented)
   * @return (undocumented)
   */
    boolean isSupported (org.apache.spark.resource.ResourceProfile rp)  { throw new RuntimeException(); }
  public  org.apache.spark.resource.ResourceProfile resourceProfileFromId (int rpId)  { throw new RuntimeException(); }
}
