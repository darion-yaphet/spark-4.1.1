package org.apache.spark.deploy.history;
/**
 * Test suite for the History Server using RocksDB as the event log storage backend.
 * Extends HistoryServerSuite and focuses on validating RocksDB-specific behaviors.
 * <p>
 * To generate golden files for this backend:
 * <pre><code>
 *   SPARK_GENERATE_GOLDEN_FILES=1 build/sbt "core/testOnly org.apache.spark.deploy.history.RocksDBBackendHistoryServerSuite"
 * </code></pre>
 */
public  class RocksDBBackendHistoryServerSuite extends org.apache.spark.deploy.history.HistoryServerSuite {
  public   RocksDBBackendHistoryServerSuite ()  { throw new RuntimeException(); }
  protected  scala.Enumeration.Value diskBackend ()  { throw new RuntimeException(); }
}
