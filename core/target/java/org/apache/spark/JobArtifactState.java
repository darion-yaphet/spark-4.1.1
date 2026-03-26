package org.apache.spark;
/**
 * Job artifact state. For example, Spark Connect client sets the state specifically
 * for the current client.
 * <p>
 * param:  uuid UUID to use in the current context of jab artifact set. Usually this is from
 *             a Spark Connect client.
 * param:  replClassDirUri The URI for the directory that stores REPL classes.
 */
  class JobArtifactState implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String uuid ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> replClassDirUri ()  { throw new RuntimeException(); }
  // not preceding
  public   JobArtifactState (java.lang.String uuid, scala.Option<java.lang.String> replClassDirUri)  { throw new RuntimeException(); }
}
