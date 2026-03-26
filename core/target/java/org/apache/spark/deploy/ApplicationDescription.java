package org.apache.spark.deploy;
  class ApplicationDescription implements scala.Product, java.io.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9)  ;
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxCores ()  { throw new RuntimeException(); }
  public  org.apache.spark.deploy.Command command ()  { throw new RuntimeException(); }
  public  java.lang.String appUiUrl ()  { throw new RuntimeException(); }
  public  org.apache.spark.resource.ResourceProfile defaultProfile ()  { throw new RuntimeException(); }
  public  scala.Option<java.net.URI> eventLogDir ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> eventLogCodec ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> initialExecutorLimit ()  { throw new RuntimeException(); }
  public  java.lang.String user ()  { throw new RuntimeException(); }
  // not preceding
  public   ApplicationDescription (java.lang.String name, scala.Option<java.lang.Object> maxCores, org.apache.spark.deploy.Command command, java.lang.String appUiUrl, org.apache.spark.resource.ResourceProfile defaultProfile, scala.Option<java.net.URI> eventLogDir, scala.Option<java.lang.String> eventLogCodec, scala.Option<java.lang.Object> initialExecutorLimit, java.lang.String user)  { throw new RuntimeException(); }
  public  int memoryPerExecutorMB ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> coresPerExecutor ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<org.apache.spark.resource.ResourceRequirement> resourceReqsPerExecutor ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
