package org.apache.spark.status.api.v1;
public  class ThreadStackTrace implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11, T12 v12, T13 v13, T14 v14, T15 v15)  ;
  public  long threadId ()  { throw new RuntimeException(); }
  public  java.lang.String threadName ()  { throw new RuntimeException(); }
  public  java.lang.Thread.State threadState ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.StackTrace stackTrace ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> blockedByThreadId ()  { throw new RuntimeException(); }
  public  java.lang.String blockedByLock ()  { throw new RuntimeException(); }
  /**
   * @deprecated using synchronizers and monitors instead. Since 4.0.0.
  */
  public  scala.collection.immutable.Seq<java.lang.String> holdingLocks ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> synchronizers ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<java.lang.String> monitors ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> lockName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> lockOwnerName ()  { throw new RuntimeException(); }
  public  boolean suspended ()  { throw new RuntimeException(); }
  public  boolean inNative ()  { throw new RuntimeException(); }
  public  boolean isDaemon ()  { throw new RuntimeException(); }
  public  int priority ()  { throw new RuntimeException(); }
  // not preceding
  public   ThreadStackTrace (long threadId, java.lang.String threadName, java.lang.Thread.State threadState, org.apache.spark.status.api.v1.StackTrace stackTrace, scala.Option<java.lang.Object> blockedByThreadId, java.lang.String blockedByLock, scala.collection.immutable.Seq<java.lang.String> holdingLocks, scala.collection.immutable.Seq<java.lang.String> synchronizers, scala.collection.immutable.Seq<java.lang.String> monitors, scala.Option<java.lang.String> lockName, scala.Option<java.lang.String> lockOwnerName, boolean suspended, boolean inNative, boolean isDaemon, int priority)  { throw new RuntimeException(); }
  /**
   * Returns a string representation of this thread stack trace
   * w.r.t java.lang.management.ThreadInfo(JDK 8)'s toString.
   * <p>
   * TODO(SPARK-44896): Also considering adding information os_prio, cpu, elapsed, tid, nid, etc.,
   *   from the jstack tool
   * @return (undocumented)
   */
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
