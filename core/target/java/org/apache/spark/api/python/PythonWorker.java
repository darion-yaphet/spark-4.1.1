package org.apache.spark.api.python;
public  class PythonWorker implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.nio.channels.SocketChannel channel ()  { throw new RuntimeException(); }
  // not preceding
  public   PythonWorker (java.nio.channels.SocketChannel channel)  { throw new RuntimeException(); }
  public  java.nio.channels.Selector selector ()  { throw new RuntimeException(); }
  public  java.nio.channels.SelectionKey selectionKey ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.python.PythonWorker refresh ()  { throw new RuntimeException(); }
  public  void stop ()  { throw new RuntimeException(); }
}
