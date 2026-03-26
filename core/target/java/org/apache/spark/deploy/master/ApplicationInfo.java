package org.apache.spark.deploy.master;
  class ApplicationInfo implements java.io.Serializable {
  // not preceding
  public   ApplicationInfo (long startTime, java.lang.String id, org.apache.spark.deploy.ApplicationDescription desc, java.util.Date submitDate, org.apache.spark.rpc.RpcEndpointRef driver, int defaultCores)  { throw new RuntimeException(); }
    org.apache.spark.deploy.master.ExecutorDesc addExecutor (org.apache.spark.deploy.master.WorkerInfo worker, int cores, int memoryMb, scala.collection.immutable.Map<java.lang.String, org.apache.spark.resource.ResourceInformation> resources, int rpId, scala.Option<java.lang.Object> useID)  { throw new RuntimeException(); }
  public  org.apache.spark.deploy.master.ApplicationSource appSource ()  { throw new RuntimeException(); }
  public  int coresGranted ()  { throw new RuntimeException(); }
    int coresLeft ()  { throw new RuntimeException(); }
  public  org.apache.spark.deploy.ApplicationDescription desc ()  { throw new RuntimeException(); }
  public  org.apache.spark.rpc.RpcEndpointRef driver ()  { throw new RuntimeException(); }
  public  long duration ()  { throw new RuntimeException(); }
  public  long endTime ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.HashMap<java.lang.Object, org.apache.spark.deploy.master.ExecutorDesc> executors ()  { throw new RuntimeException(); }
  /**
   * Return the total limit on the number of executors for all resource profiles.
   * @return (undocumented)
   */
    int getExecutorLimit ()  { throw new RuntimeException(); }
    scala.collection.mutable.Set<java.lang.Object> getOrUpdateExecutorsForRPId (int rpId)  { throw new RuntimeException(); }
    scala.collection.immutable.Seq<java.lang.Object> getRequestedRPIds ()  { throw new RuntimeException(); }
    org.apache.spark.deploy.master.ExecutorResourceDescription getResourceDescriptionForRpId (int rpId)  { throw new RuntimeException(); }
    org.apache.spark.resource.ResourceProfile getResourceProfileById (int rpId)  { throw new RuntimeException(); }
    int getTargetExecutorNumForRPId (int rpId)  { throw new RuntimeException(); }
  public  java.lang.String id ()  { throw new RuntimeException(); }
    int incrementRetryCount ()  { throw new RuntimeException(); }
    boolean isFinished ()  { throw new RuntimeException(); }
    void markFinished (scala.Enumeration.Value endState)  { throw new RuntimeException(); }
    void removeExecutor (org.apache.spark.deploy.master.ExecutorDesc exec)  { throw new RuntimeException(); }
  public  scala.collection.mutable.ArrayBuffer<org.apache.spark.deploy.master.ExecutorDesc> removedExecutors ()  { throw new RuntimeException(); }
    void requestExecutors (scala.collection.immutable.Map<org.apache.spark.resource.ResourceProfile, java.lang.Object> resourceProfileToTotalExecs)  { throw new RuntimeException(); }
    void resetRetryCount ()  { throw new RuntimeException(); }
    int retryCount ()  { throw new RuntimeException(); }
  public  long startTime ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value state ()  { throw new RuntimeException(); }
  public  java.util.Date submitDate ()  { throw new RuntimeException(); }
}
