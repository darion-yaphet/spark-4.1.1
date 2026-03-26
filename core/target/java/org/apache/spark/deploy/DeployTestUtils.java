package org.apache.spark.deploy;
public  class DeployTestUtils {
  static public  org.apache.spark.resource.ResourceProfile defaultResourceProfile ()  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.ApplicationDescription createAppDesc (scala.collection.immutable.Map<java.lang.String, java.lang.Object> customResources)  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.master.ApplicationInfo createAppInfo ()  { throw new RuntimeException(); }
  static public  org.apache.spark.resource.ResourceProfile createDefaultResourceProfile (int memoryPerExecutorMb, scala.collection.immutable.Map<java.lang.String, java.lang.Object> customResources, scala.Option<java.lang.Object> coresPerExecutor)  { throw new RuntimeException(); }
  static public  org.apache.spark.resource.ResourceProfile createResourceProfile (scala.Option<java.lang.Object> memoryPerExecutorMb, scala.collection.immutable.Map<java.lang.String, java.lang.Object> customResources, scala.Option<java.lang.Object> coresPerExecutor)  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.Command createDriverCommand ()  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.DriverDescription createDriverDesc ()  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.master.DriverInfo createDriverInfo ()  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.master.WorkerInfo createWorkerInfo ()  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.worker.ExecutorRunner createExecutorRunner (int execId, boolean withResources)  { throw new RuntimeException(); }
  static public  org.apache.spark.deploy.worker.DriverRunner createDriverRunner (java.lang.String driverId)  { throw new RuntimeException(); }
}
