package org.apache.spark.util;
/**
 * Serializes SparkListener events to/from JSON.  This protocol provides strong backwards-
 * and forwards-compatibility guarantees: any version of Spark should be able to read JSON output
 * written by any other version, including newer versions.
 * <p>
 * JsonProtocolSuite contains backwards-compatibility tests which check that the current version of
 * JsonProtocol is able to read output written by earlier versions.  We do not currently have tests
 * for reading newer JSON output with older Spark versions.
 * <p>
 * To ensure that we provide these guarantees, follow these rules when modifying these methods:
 * <p>
 *  - Never delete any JSON fields.
 *  - Any new JSON fields should be optional; use <code>jsonOption</code> when reading these fields
 *    in <code>*FromJson</code> methods.
 */
public  class JsonProtocol {
  static protected  com.fasterxml.jackson.databind.ObjectMapper mapper ()  { throw new RuntimeException(); }
  static   org.apache.spark.util.JsonProtocolOptions defaultOptions ()  { throw new RuntimeException(); }
  /** ------------------------------------------------- *
   * JSON serialization methods for SparkListenerEvents |
   * @param event (undocumented)
   * @return (undocumented)
   * -------------------------------------------------- */
  static public  java.lang.String sparkEventToJsonString (org.apache.spark.scheduler.SparkListenerEvent event)  { throw new RuntimeException(); }
  static public  java.lang.String sparkEventToJsonString (org.apache.spark.scheduler.SparkListenerEvent event, org.apache.spark.util.JsonProtocolOptions options)  { throw new RuntimeException(); }
  static public  void writeSparkEventToJson (org.apache.spark.scheduler.SparkListenerEvent event, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options)  { throw new RuntimeException(); }
  static public  void stageSubmittedToJson (org.apache.spark.scheduler.SparkListenerStageSubmitted stageSubmitted, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options)  { throw new RuntimeException(); }
  static public  void stageCompletedToJson (org.apache.spark.scheduler.SparkListenerStageCompleted stageCompleted, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options)  { throw new RuntimeException(); }
  static public  void taskStartToJson (org.apache.spark.scheduler.SparkListenerTaskStart taskStart, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options)  { throw new RuntimeException(); }
  static public  void taskGettingResultToJson (org.apache.spark.scheduler.SparkListenerTaskGettingResult taskGettingResult, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options)  { throw new RuntimeException(); }
  static public  void taskEndToJson (org.apache.spark.scheduler.SparkListenerTaskEnd taskEnd, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options)  { throw new RuntimeException(); }
  static public  void jobStartToJson (org.apache.spark.scheduler.SparkListenerJobStart jobStart, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options)  { throw new RuntimeException(); }
  static public  void jobEndToJson (org.apache.spark.scheduler.SparkListenerJobEnd jobEnd, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void environmentUpdateToJson (org.apache.spark.scheduler.SparkListenerEnvironmentUpdate environmentUpdate, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void blockManagerAddedToJson (org.apache.spark.scheduler.SparkListenerBlockManagerAdded blockManagerAdded, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void blockManagerRemovedToJson (org.apache.spark.scheduler.SparkListenerBlockManagerRemoved blockManagerRemoved, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void unpersistRDDToJson (org.apache.spark.scheduler.SparkListenerUnpersistRDD unpersistRDD, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void applicationStartToJson (org.apache.spark.scheduler.SparkListenerApplicationStart applicationStart, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void applicationEndToJson (org.apache.spark.scheduler.SparkListenerApplicationEnd applicationEnd, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void resourceProfileAddedToJson (org.apache.spark.scheduler.SparkListenerResourceProfileAdded profileAdded, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void executorAddedToJson (org.apache.spark.scheduler.SparkListenerExecutorAdded executorAdded, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void executorRemovedToJson (org.apache.spark.scheduler.SparkListenerExecutorRemoved executorRemoved, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void logStartToJson (org.apache.spark.scheduler.SparkListenerLogStart logStart, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void executorMetricsUpdateToJson (org.apache.spark.scheduler.SparkListenerExecutorMetricsUpdate metricsUpdate, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void stageExecutorMetricsToJson (org.apache.spark.scheduler.SparkListenerStageExecutorMetrics metrics, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void blockUpdateToJson (org.apache.spark.scheduler.SparkListenerBlockUpdated blockUpdate, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  /** ------------------------------------------------------------------- *
   * JSON serialization methods for classes SparkListenerEvents depend on |
   * @param stageInfo (undocumented)
   * @param g (undocumented)
   * @param options (undocumented)
   * @param includeAccumulables (undocumented)
   * -------------------------------------------------------------------- */
  static public  void stageInfoToJson (org.apache.spark.scheduler.StageInfo stageInfo, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options, boolean includeAccumulables)  { throw new RuntimeException(); }
  static public  void taskInfoToJson (org.apache.spark.scheduler.TaskInfo taskInfo, com.fasterxml.jackson.core.JsonGenerator g, org.apache.spark.util.JsonProtocolOptions options, boolean includeAccumulables)  { throw new RuntimeException(); }
  static   scala.collection.immutable.Set<java.lang.String> accumulableExcludeList ()  { throw new RuntimeException(); }
  static public  void accumulablesToJson (scala.collection.Iterable<org.apache.spark.scheduler.AccumulableInfo> accumulables, com.fasterxml.jackson.core.JsonGenerator g, boolean includeTaskMetricsAccumulators)  { throw new RuntimeException(); }
  static public  void accumulableInfoToJson (org.apache.spark.scheduler.AccumulableInfo accumulableInfo, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  /**
   * Serialize the value of an accumulator to JSON.
   * <p>
   * For accumulators representing internal task metrics, this looks up the relevant
   * {@link AccumulatorParam} to serialize the value accordingly. For all other accumulators,
   * this will simply serialize the value as a string.
   * <p>
   * The behavior here must match that of {@link accumValueFromJson}. Exposed for testing.
   * @param name (undocumented)
   * @param value (undocumented)
   * @param g (undocumented)
   * @param fieldName (undocumented)
   */
  static   void accumValueToJson (scala.Option<java.lang.String> name, Object value, com.fasterxml.jackson.core.JsonGenerator g, scala.Option<java.lang.String> fieldName)  { throw new RuntimeException(); }
  static public  void taskMetricsToJson (org.apache.spark.executor.TaskMetrics taskMetrics, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  /** Convert executor metrics to JSON. */
  static public  void executorMetricsToJson (org.apache.spark.executor.ExecutorMetrics executorMetrics, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void taskEndReasonToJson (org.apache.spark.TaskEndReason taskEndReason, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void blockManagerIdToJson (org.apache.spark.storage.BlockManagerId blockManagerId, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void jobResultToJson (org.apache.spark.scheduler.JobResult jobResult, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void rddInfoToJson (org.apache.spark.storage.RDDInfo rddInfo, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void storageLevelToJson (org.apache.spark.storage.StorageLevel storageLevel, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void blockStatusToJson (org.apache.spark.storage.BlockStatus blockStatus, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void executorInfoToJson (org.apache.spark.scheduler.cluster.ExecutorInfo executorInfo, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void blockUpdatedInfoToJson (org.apache.spark.storage.BlockUpdatedInfo blockUpdatedInfo, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void executorResourceRequestToJson (org.apache.spark.resource.ExecutorResourceRequest execReq, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void executorResourceRequestMapToJson (scala.collection.Map<java.lang.String, org.apache.spark.resource.ExecutorResourceRequest> m, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void taskResourceRequestToJson (org.apache.spark.resource.TaskResourceRequest taskReq, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void taskResourceRequestMapToJson (scala.collection.Map<java.lang.String, org.apache.spark.resource.TaskResourceRequest> m, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  /** ------------------------------ *
   * Util JSON serialization methods |
   * @param name (undocumented)
   * @param m (undocumented)
   * @param g (undocumented)
   * ------------------------------- */
  static public  void writeMapField (java.lang.String name, scala.collection.Map<java.lang.String, java.lang.String> m, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void propertiesToJson (java.util.Properties properties, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void UUIDToJson (java.util.UUID id, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void stackTraceToJson (java.lang.StackTraceElement[] stackTrace, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  void exceptionToJson (java.lang.Exception exception, com.fasterxml.jackson.core.JsonGenerator g)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerEvent sparkEventFromJson (java.lang.String json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerEvent sparkEventFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerStageSubmitted stageSubmittedFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerStageCompleted stageCompletedFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerTaskStart taskStartFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerTaskGettingResult taskGettingResultFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  /** Extract the executor metrics from JSON. */
  static public  org.apache.spark.executor.ExecutorMetrics executorMetricsFromJson (com.fasterxml.jackson.databind.JsonNode maybeJson)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerTaskEnd taskEndFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerJobStart jobStartFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerJobEnd jobEndFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerResourceProfileAdded resourceProfileAddedFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.resource.ExecutorResourceRequest executorResourceRequestFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.resource.TaskResourceRequest taskResourceRequestFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  scala.collection.Map<java.lang.String, org.apache.spark.resource.TaskResourceRequest> taskResourceRequestMapFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  scala.collection.Map<java.lang.String, org.apache.spark.resource.ExecutorResourceRequest> executorResourceRequestMapFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerEnvironmentUpdate environmentUpdateFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerBlockManagerAdded blockManagerAddedFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerBlockManagerRemoved blockManagerRemovedFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerUnpersistRDD unpersistRDDFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerApplicationStart applicationStartFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerApplicationEnd applicationEndFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerExecutorAdded executorAddedFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerExecutorRemoved executorRemovedFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerLogStart logStartFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerExecutorMetricsUpdate executorMetricsUpdateFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerStageExecutorMetrics stageExecutorMetricsFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.SparkListenerBlockUpdated blockUpdateFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  /** --------------------------------------------------------------------- *
   * JSON deserialization methods for classes SparkListenerEvents depend on |
   * @param json (undocumented)
   * @return (undocumented)
   * ---------------------------------------------------------------------- */
  static public  org.apache.spark.scheduler.StageInfo stageInfoFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.TaskInfo taskInfoFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.AccumulableInfo accumulableInfoFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  /**
   * Deserialize the value of an accumulator from JSON.
   * <p>
   * For accumulators representing internal task metrics, this looks up the relevant
   * {@link AccumulatorParam} to deserialize the value accordingly. For all other
   * accumulators, this will simply deserialize the value as a string.
   * <p>
   * The behavior here must match that of {@link accumValueToJson}. Exposed for testing.
   * @param name (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  static   Object accumValueFromJson (scala.Option<java.lang.String> name, com.fasterxml.jackson.databind.JsonNode value)  { throw new RuntimeException(); }
  static public  org.apache.spark.executor.TaskMetrics taskMetricsFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.TaskEndReason taskEndReasonFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.storage.BlockManagerId blockManagerIdFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.JobResult jobResultFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.storage.RDDInfo rddInfoFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.storage.StorageLevel storageLevelFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.storage.BlockStatus blockStatusFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.scheduler.cluster.ExecutorInfo executorInfoFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  org.apache.spark.storage.BlockUpdatedInfo blockUpdatedInfoFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  scala.collection.Map<java.lang.String, org.apache.spark.resource.ResourceInformation> resourcesMapFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  /** -------------------------------- *
   * Util JSON deserialization methods |
   * @param json (undocumented)
   * @return (undocumented)
   * --------------------------------- */
  static public  scala.collection.Map<java.lang.String, java.lang.String> mapFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  java.util.Properties propertiesFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  java.util.UUID UUIDFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  java.lang.StackTraceElement[] stackTraceFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  java.lang.Exception exceptionFromJson (com.fasterxml.jackson.databind.JsonNode json)  { throw new RuntimeException(); }
  static public  java.lang.String toJsonString (scala.Function1<com.fasterxml.jackson.core.JsonGenerator, scala.runtime.BoxedUnit> block)  { throw new RuntimeException(); }
  static protected abstract  void org$apache$spark$util$JsonUtils$_setter_$mapper_$eq (com.fasterxml.jackson.databind.ObjectMapper x$1)  ;
}
