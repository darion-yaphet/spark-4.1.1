package org.apache.spark;
/**
 * This suite creates an external shuffle server and routes all shuffle fetches through it.
 * Note that failures in this suite may arise due to changes in Spark that invalidate expectations
 * set up in <code>ExternalShuffleBlockHandler</code>, such as changing the format of shuffle files or how
 * we hash files into folders.
 */
public  class SslExternalShuffleServiceSuite extends org.apache.spark.ExternalShuffleServiceSuite {
  public   SslExternalShuffleServiceSuite ()  { throw new RuntimeException(); }
  public  void initializeHandlers ()  { throw new RuntimeException(); }
}
