package org.apache.spark.deploy.master;
/**
 * Describe resource requirements for different resource profiles. Used for executor schedule.
 * <p>
 * param:  coresPerExecutor cores for each executor.
 * param:  memoryMbPerExecutor memory for each executor.
 * param:  customResourcesPerExecutor custom resource requests for each executor.
 */
  class ExecutorResourceDescription implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> coresPerExecutor ()  { throw new RuntimeException(); }
  public  int memoryMbPerExecutor ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.resource.ResourceRequirement> customResourcesPerExecutor ()  { throw new RuntimeException(); }
  // not preceding
  public   ExecutorResourceDescription (scala.Option<java.lang.Object> coresPerExecutor, int memoryMbPerExecutor, scala.collection.immutable.Seq<org.apache.spark.resource.ResourceRequirement> customResourcesPerExecutor)  { throw new RuntimeException(); }
}
