package org.apache.spark.deploy;
public  interface SparkSubmitTestUtils extends org.scalatest.concurrent.TimeLimits {
  public  org.scalatest.concurrent.Signaler defaultSignaler ()  ;
  public  org.scalatest.time.Span defaultSparkSubmitTimeout ()  ;
  public  int runSparkSubmit (scala.collection.immutable.Seq<java.lang.String> args, scala.Option<java.lang.String> sparkHomeOpt, org.scalatest.time.Span timeout, boolean isSparkTesting, boolean expectFailure)  ;
}
