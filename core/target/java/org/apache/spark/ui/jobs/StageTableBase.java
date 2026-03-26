package org.apache.spark.ui.jobs;
  class StageTableBase {
  public   StageTableBase (org.apache.spark.status.AppStatusStore store, jakarta.servlet.http.HttpServletRequest request, scala.collection.immutable.Seq<org.apache.spark.status.api.v1.StageData> stages, java.lang.String tableHeaderID, java.lang.String stageTag, java.lang.String basePath, java.lang.String subPath, boolean isFairScheduler, boolean killEnabled, boolean isFailedStage)  { throw new RuntimeException(); }
  public  long currentTime ()  { throw new RuntimeException(); }
  public  int stagePage ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<scala.xml.Node> toNodeSeq ()  { throw new RuntimeException(); }
}
