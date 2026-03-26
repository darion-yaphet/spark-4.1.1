package org.apache.spark.metrics.sink;
/**
 * :: DeveloperApi ::
 * This exposes the metrics of the given registry with Prometheus format.
 * <p>
 * The output is consistent with /metrics/json result in terms of item ordering
 * and with the previous result of Spark JMX Sink + Prometheus JMX Converter combination
 * in terms of key string format.
 * <p>
 * This is used by Spark MetricsSystem internally and Spark K8s operator.
 */
  class PrometheusServlet implements org.apache.spark.metrics.sink.Sink {
  // not preceding
  public   PrometheusServlet (java.util.Properties property, com.codahale.metrics.MetricRegistry registry)  { throw new RuntimeException(); }
  public  java.lang.String SERVLET_KEY_PATH ()  { throw new RuntimeException(); }
  public  org.eclipse.jetty.servlet.ServletContextHandler[] getHandlers (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  public  java.lang.String getMetricsSnapshot (jakarta.servlet.http.HttpServletRequest request)  { throw new RuntimeException(); }
  public  java.lang.String getMetricsSnapshot ()  { throw new RuntimeException(); }
  public  java.util.Properties property ()  { throw new RuntimeException(); }
  public  com.codahale.metrics.MetricRegistry registry ()  { throw new RuntimeException(); }
  public  void report ()  { throw new RuntimeException(); }
  public  java.lang.String servletPath ()  { throw new RuntimeException(); }
  public  void start ()  { throw new RuntimeException(); }
  public  void stop ()  { throw new RuntimeException(); }
}
