package org.apache.spark.broadcast;
public  class TorrentBroadcast$ implements org.apache.spark.internal.Logging, java.io.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TorrentBroadcast$ MODULE$ = null;
  public   TorrentBroadcast$ ()  { throw new RuntimeException(); }
  /**
   * Serialize and divide an object into blocks.
   * &#x5c06;&#x5bf9;&#x8c61;&#x5e8f;&#x5217;&#x5316;&#x5e76;&#x5206;&#x5272;&#x6210;&#x591a;&#x4e2a;&#x5757;&#x3002;
   * @param obj (undocumented)
   * @param blockSize (undocumented)
   * @param serializer (undocumented)
   * @param compressionCodec (undocumented)
   * @param evidence$2 (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> java.nio.ByteBuffer[] blockifyObject (T obj, int blockSize, org.apache.spark.serializer.Serializer serializer, scala.Option<org.apache.spark.io.CompressionCodec> compressionCodec, scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
  /**
   * Deserialize and reconstruct an object from blocks.
   * &#x4ece;&#x4e00;&#x7cfb;&#x5217;&#x5757;&#x4e2d;&#x53cd;&#x5e8f;&#x5217;&#x5316;&#x5e76;&#x91cd;&#x5efa;&#x5bf9;&#x8c61;&#x3002;
   * @param blocks (undocumented)
   * @param serializer (undocumented)
   * @param compressionCodec (undocumented)
   * @param evidence$3 (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T unBlockifyObject (java.io.InputStream[] blocks, org.apache.spark.serializer.Serializer serializer, scala.Option<org.apache.spark.io.CompressionCodec> compressionCodec, scala.reflect.ClassTag<T> evidence$3)  { throw new RuntimeException(); }
  /**
   * Remove all persisted blocks associated with this torrent broadcast on the executors.
   * If removeFromDriver is true, also remove these persisted blocks on the driver.
   * &#x79fb;&#x9664; Executor &#x4e0a;&#x4e0e;&#x6b64; Torrent &#x5e7f;&#x64ad;&#x76f8;&#x5173;&#x7684;&#x6240;&#x6709;&#x6301;&#x4e45;&#x5316;&#x5757;&#x3002;
   * &#x5982;&#x679c; removeFromDriver &#x4e3a; true&#xff0c;&#x5219;&#x540c;&#x65f6;&#x79fb;&#x9664; Driver &#x4e0a;&#x7684;&#x8fd9;&#x4e9b;&#x6301;&#x4e45;&#x5316;&#x5757;&#x3002;
   * @param id (undocumented)
   * @param removeFromDriver (undocumented)
   * @param blocking (undocumented)
   */
  public  void unpersist (long id, boolean removeFromDriver, boolean blocking)  { throw new RuntimeException(); }
}
