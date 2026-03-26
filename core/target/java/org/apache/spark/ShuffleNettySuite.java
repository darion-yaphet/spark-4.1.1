package org.apache.spark;
public abstract class ShuffleNettySuite extends org.apache.spark.ShuffleSuite implements org.scalatest.BeforeAndAfterAll {
  public   ShuffleNettySuite ()  { throw new RuntimeException(); }
  public  void beforeAll ()  { throw new RuntimeException(); }
  public  org.apache.spark.network.util.IOMode ioMode ()  { throw new RuntimeException(); }
  public  boolean shouldRunTests ()  { throw new RuntimeException(); }
  protected  void test (java.lang.String testName, scala.collection.immutable.Seq<org.scalatest.Tag> testTags, scala.Function0<java.lang.Object> testBody, org.scalactic.source.Position pos)  { throw new RuntimeException(); }
}
