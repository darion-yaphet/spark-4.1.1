package org.apache.spark.util;
public  class MetricUtils {
  static public  java.lang.String SUM_METRIC ()  { throw new RuntimeException(); }
  static public  java.lang.String SIZE_METRIC ()  { throw new RuntimeException(); }
  static public  java.lang.String TIMING_METRIC ()  { throw new RuntimeException(); }
  static public  java.lang.String NS_TIMING_METRIC ()  { throw new RuntimeException(); }
  static public  java.lang.String AVERAGE_METRIC ()  { throw new RuntimeException(); }
  static public  boolean metricNeedsMax (java.lang.String metricsType)  { throw new RuntimeException(); }
  /**
   * A function that defines how we aggregate the final accumulator results among all tasks,
   * and represent it in string for a SQL physical operator.
   * @param metricsType (undocumented)
   * @param values (undocumented)
   * @param maxMetrics (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String stringValue (java.lang.String metricsType, long[] values, long[] maxMetrics)  { throw new RuntimeException(); }
}
