package org.apache.spark.util;
public  class MetricUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MetricUtils$ MODULE$ = null;
  public   MetricUtils$ ()  { throw new RuntimeException(); }
  public  java.lang.String SUM_METRIC ()  { throw new RuntimeException(); }
  public  java.lang.String SIZE_METRIC ()  { throw new RuntimeException(); }
  public  java.lang.String TIMING_METRIC ()  { throw new RuntimeException(); }
  public  java.lang.String NS_TIMING_METRIC ()  { throw new RuntimeException(); }
  public  java.lang.String AVERAGE_METRIC ()  { throw new RuntimeException(); }
  public  boolean metricNeedsMax (java.lang.String metricsType)  { throw new RuntimeException(); }
  /**
   * A function that defines how we aggregate the final accumulator results among all tasks,
   * and represent it in string for a SQL physical operator.
   * @param metricsType (undocumented)
   * @param values (undocumented)
   * @param maxMetrics (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String stringValue (java.lang.String metricsType, long[] values, long[] maxMetrics)  { throw new RuntimeException(); }
}
