package org.apache.spark.scheduler;
/**
 * Class to hold information about a type of Resource on an Executor. This information is managed
 * by SchedulerBackend, and TaskScheduler shall schedule tasks on idle Executors based on the
 * information.
 * param:  name Resource name
 * param:  addresses Resource addresses provided by the executor
 */
  class ExecutorResourceInfo extends org.apache.spark.resource.ResourceInformation implements org.apache.spark.resource.ResourceAllocator {
  public   ExecutorResourceInfo (java.lang.String name, scala.collection.immutable.Seq<java.lang.String> addresses)  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Seq<java.lang.String> resourceAddresses ()  { throw new RuntimeException(); }
  protected  java.lang.String resourceName ()  { throw new RuntimeException(); }
  public  int totalAddressesAmount ()  { throw new RuntimeException(); }
}
