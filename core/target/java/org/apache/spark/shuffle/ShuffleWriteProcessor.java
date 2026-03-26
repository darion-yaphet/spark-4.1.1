package org.apache.spark.shuffle;
/**
 * The interface for customizing shuffle write process. The driver create a ShuffleWriteProcessor
 * and put it into {@link ShuffleDependency}, and executors use it in each ShuffleMapTask.
 */
  class ShuffleWriteProcessor implements java.io.Serializable, org.apache.spark.internal.Logging {
  public   ShuffleWriteProcessor ()  { throw new RuntimeException(); }
  /**
   * Create a {@link ShuffleWriteMetricsReporter} from the task context. As the reporter is a
   * per-row operator, here need a careful consideration on performance.
   * @param context (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.shuffle.ShuffleWriteMetricsReporter createMetricsReporter (org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  /**
   * The write process for particular partition, it controls the life circle of {@link ShuffleWriter}
   * get from {@link ShuffleManager} finally return the {@link MapStatus} for this task.
   * @param inputs (undocumented)
   * @param dep (undocumented)
   * @param mapId (undocumented)
   * @param mapIndex (undocumented)
   * @param context (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.scheduler.MapStatus write (scala.collection.Iterator<java.lang.Object> inputs, org.apache.spark.ShuffleDependency<?, ?, ?> dep, long mapId, int mapIndex, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
}
