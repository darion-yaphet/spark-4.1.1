package org.apache.spark.broadcast;
/**
 * An interface for all the broadcast implementations in Spark (to allow
 * multiple broadcast implementations). SparkContext uses a BroadcastFactory
 * implementation to instantiate a particular broadcast for the entire Spark job.
 */
public  interface BroadcastFactory {
  public  void initialize (boolean isDriver, org.apache.spark.SparkConf conf)  ;
  /**
   * Creates a new broadcast variable.
   * <p>
   * @param value value to broadcast
   * @param isLocal whether we are in local mode (single JVM process)
   * @param id unique id representing this broadcast variable
   * @param serializedOnly if true, do not cache the unserialized value on the driver
   * @return <code>Broadcast</code> object, a read-only variable cached on each machine
   * @param evidence$1 (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.broadcast.Broadcast<T> newBroadcast (T value, boolean isLocal, long id, boolean serializedOnly, scala.reflect.ClassTag<T> evidence$1)  ;
  public  void stop ()  ;
  public  void unbroadcast (long id, boolean removeFromDriver, boolean blocking)  ;
}
