package org.apache.spark.api.python;
/**
 * Sends decrypted broadcast data to python worker.  See {@link PythonRunner} for entire protocol.
 */
  class EncryptedPythonBroadcastServer extends org.apache.spark.security.SocketAuthServer<scala.runtime.BoxedUnit> implements org.apache.spark.internal.Logging {
  // not preceding
  public   EncryptedPythonBroadcastServer (org.apache.spark.SparkEnv env, scala.collection.immutable.Seq<scala.Tuple2<java.lang.Object, java.lang.String>> idsAndFiles)  { throw new RuntimeException(); }
  public  org.apache.spark.SparkEnv env ()  { throw new RuntimeException(); }
  public  void handleConnection (java.nio.channels.SocketChannel socket)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<scala.Tuple2<java.lang.Object, java.lang.String>> idsAndFiles ()  { throw new RuntimeException(); }
  public  void waitTillBroadcastDataSent ()  { throw new RuntimeException(); }
}
