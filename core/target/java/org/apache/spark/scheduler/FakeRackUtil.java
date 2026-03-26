package org.apache.spark.scheduler;
public  class FakeRackUtil {
  static public  int numBatchInvocation ()  { throw new RuntimeException(); }
  static public  int numSingleHostInvocation ()  { throw new RuntimeException(); }
  static public  void cleanUp ()  { throw new RuntimeException(); }
  static public  void assignHostToRack (java.lang.String host, java.lang.String rack)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Seq<scala.Option<java.lang.String>> getRacksForHosts (scala.collection.immutable.Seq<java.lang.String> hosts)  { throw new RuntimeException(); }
}
