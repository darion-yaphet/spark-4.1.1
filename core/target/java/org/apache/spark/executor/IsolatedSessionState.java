package org.apache.spark.executor;
  class IsolatedSessionState implements org.apache.spark.internal.Logging {
  // not preceding
  public   IsolatedSessionState (java.lang.String sessionUUID, org.apache.spark.util.MutableURLClassLoader urlClassLoader, java.lang.ClassLoader replClassLoader, scala.collection.mutable.HashMap<java.lang.String, java.lang.Object> currentFiles, scala.collection.mutable.HashMap<java.lang.String, java.lang.Object> currentJars, scala.collection.mutable.HashMap<java.lang.String, java.lang.Object> currentArchives, scala.Option<java.lang.String> replClassDirUri)  { throw new RuntimeException(); }
  /** Increment the reference count, indicating a task is using this session. */
  public  void acquire ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.HashMap<java.lang.String, java.lang.Object> currentArchives ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.HashMap<java.lang.String, java.lang.Object> currentFiles ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.HashMap<java.lang.String, java.lang.Object> currentJars ()  { throw new RuntimeException(); }
  /** Mark this session as evicted. If no tasks are using it, clean up immediately. */
  public  void markEvicted ()  { throw new RuntimeException(); }
  /** Decrement the reference count. If evicted and no more tasks, clean up. */
  public  void release ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> replClassDirUri ()  { throw new RuntimeException(); }
  public  java.lang.ClassLoader replClassLoader ()  { throw new RuntimeException(); }
  public  java.lang.String sessionUUID ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.MutableURLClassLoader urlClassLoader ()  { throw new RuntimeException(); }
}
