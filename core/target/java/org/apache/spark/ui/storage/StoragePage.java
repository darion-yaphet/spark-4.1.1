package org.apache.spark.ui.storage;
/** Page showing list of RDD's currently stored in the cluster */
  class StoragePage extends org.apache.spark.ui.WebUIPage {
  public   StoragePage (org.apache.spark.ui.SparkUITab parent, org.apache.spark.status.AppStatusStore store)  { throw new RuntimeException(); }
    scala.collection.immutable.Seq<scala.xml.Node> rddTable (jakarta.servlet.http.HttpServletRequest request, scala.collection.immutable.Seq<org.apache.spark.status.api.v1.RDDStorageInfo> rdds)  { throw new RuntimeException(); }
    scala.collection.immutable.Seq<scala.xml.Node> receiverBlockTables (scala.collection.immutable.Seq<org.apache.spark.status.StreamBlockData> blocks)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<scala.xml.Node> render (jakarta.servlet.http.HttpServletRequest request)  { throw new RuntimeException(); }
    scala.Tuple2<java.lang.String, java.lang.Object> streamBlockStorageLevelDescriptionAndSize (org.apache.spark.status.StreamBlockData block)  { throw new RuntimeException(); }
  /** Tooltips for header fields of the RDD table */
  public  scala.collection.immutable.Seq<scala.Option<java.lang.String>> tooltips ()  { throw new RuntimeException(); }
}
