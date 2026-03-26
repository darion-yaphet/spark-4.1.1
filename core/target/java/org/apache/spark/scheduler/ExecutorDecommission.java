package org.apache.spark.scheduler;
/**
 * A loss reason that means the executor is marked for decommissioning.
 * <p>
 * This is used by the task scheduler to remove state associated with the executor, but
 * not yet fail any tasks that were running in the executor before the executor is "fully" lost.
 * If you update this code make sure to re-run the K8s integration tests.
 * <p>
 * param:  workerHost it is defined when the worker is decommissioned too
 * param:  reason detailed decommission message
 */
  class ExecutorDecommission extends org.apache.spark.scheduler.ExecutorLossReason implements scala.Product, java.io.Serializable {
  static public  java.lang.String msgPrefix ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> workerHost ()  { throw new RuntimeException(); }
  public  java.lang.String reason ()  { throw new RuntimeException(); }
  // not preceding
  public   ExecutorDecommission (scala.Option<java.lang.String> workerHost, java.lang.String reason)  { throw new RuntimeException(); }
}
