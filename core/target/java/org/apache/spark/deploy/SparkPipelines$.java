package org.apache.spark.deploy;
/**
 * Outer implementation of the spark-pipelines command line interface. Responsible for routing
 * spark-submit args to spark-submit, and pipeline-specific args to the inner Python CLI
 * implementation that loads the user code and submits it to the backend.
 */
public  class SparkPipelines$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkPipelines$ MODULE$ = null;
  public   SparkPipelines$ ()  { throw new RuntimeException(); }
  public  void main (java.lang.String[] args)  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Seq<java.lang.String> constructSparkSubmitArgs (java.lang.String pipelinesCliFile, java.lang.String[] args)  { throw new RuntimeException(); }
}
