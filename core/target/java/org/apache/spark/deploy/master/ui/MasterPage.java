package org.apache.spark.deploy.master.ui;
  class MasterPage extends org.apache.spark.ui.WebUIPage {
  public   MasterPage (org.apache.spark.deploy.master.ui.MasterWebUI parent)  { throw new RuntimeException(); }
  public  org.apache.spark.deploy.DeployMessages.MasterStateResponse getMasterState ()  { throw new RuntimeException(); }
  public  void handleAppKillRequest (jakarta.servlet.http.HttpServletRequest request)  { throw new RuntimeException(); }
  public  void handleDriverKillRequest (jakarta.servlet.http.HttpServletRequest request)  { throw new RuntimeException(); }
  /** Index view listing applications and executors */
  public  scala.collection.immutable.Seq<scala.xml.Node> render (jakarta.servlet.http.HttpServletRequest request)  { throw new RuntimeException(); }
  public  org.json4s.JValue renderJson (jakarta.servlet.http.HttpServletRequest request)  { throw new RuntimeException(); }
}
