package org.apache.spark.resource;
/**
 * Resource profile which only contains task resources, can be used for stage level task schedule
 * when dynamic allocation is disabled, tasks will be scheduled to executors with default resource
 * profile based on task resources described by this task resource profile.
 * And when dynamic allocation is enabled, will require new executors for this profile based on
 * the default executor resources requested at startup and assign tasks only on executors created
 * with this resource profile.
 * <p>
 * param:  taskResources Resource requests for tasks. Mapped from the resource
 *                      name (e.g., cores, memory, CPU) to its specific request.
 */
  class TaskResourceProfile extends org.apache.spark.resource.ResourceProfile {
  // not preceding
  public   TaskResourceProfile (scala.collection.immutable.Map<java.lang.String, org.apache.spark.resource.TaskResourceRequest> taskResources)  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Map<java.lang.String, org.apache.spark.resource.ExecutorResourceRequest> getCustomExecutorResources ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.resource.TaskResourceRequest> taskResources ()  { throw new RuntimeException(); }
  protected  void validate ()  { throw new RuntimeException(); }
}
