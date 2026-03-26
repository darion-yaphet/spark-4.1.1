package org.apache.spark.deploy;
/**
 * Provides a hook to set the application failure details in some external system.
 */
public  interface SparkDiagnosticsSetter {
  /**
   * Set the failure details.
   * @param throwable (undocumented)
   * @param conf (undocumented)
   */
  public  void setDiagnostics (java.lang.Throwable throwable, org.apache.spark.SparkConf conf)  ;
  /**
   * Whether this implementation of the SparkDiagnosticsSetter supports setting the exit
   * exception for this application.
   * @param clusterManagerUrl (undocumented)
   * @return (undocumented)
   */
  public  boolean supports (java.lang.String clusterManagerUrl)  ;
}
