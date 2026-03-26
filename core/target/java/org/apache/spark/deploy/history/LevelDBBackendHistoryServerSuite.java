package org.apache.spark.deploy.history;
/**
 * Test suite for the History Server using LevelDB as the event log storage backend.
 * Extends HistoryServerSuite and focuses on validating LevelDB-specific behaviors.
 * <p>
 * To generate golden files for this backend:
 * <pre><code>
 *   SPARK_GENERATE_GOLDEN_FILES=1 build/sbt "core/testOnly org.apache.spark.deploy.history.LevelDBBackendHistoryServerSuite"
 * </code></pre>
 */
public  class LevelDBBackendHistoryServerSuite extends org.apache.spark.deploy.history.HistoryServerSuite {
  public   LevelDBBackendHistoryServerSuite ()  { throw new RuntimeException(); }
  protected  scala.Enumeration.Value diskBackend ()  { throw new RuntimeException(); }
}
