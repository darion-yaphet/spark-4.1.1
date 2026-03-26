package org.apache.spark.api.python;
/**
 * Manages Python UDF log capture and routing to per-worker log writers.
 * <p>
 * This class handles the parsing of Python worker output streams and routes
 * log messages to appropriate rolling log writers based on worker PIDs.
 * Works for both daemon and non-daemon modes.
 */
  class PythonWorkerLogCapture implements org.apache.spark.internal.Logging {
  public   PythonWorkerLogCapture (java.lang.String sessionId, java.lang.String logMarker)  { throw new RuntimeException(); }
  /**
   * Creates an InputStream wrapper that captures Python UDF logs from the given stream.
   * <p>
   * @param inputStream The input stream to wrap (typically daemon stdout or worker stdout)
   * @return A wrapped InputStream that captures and routes log messages
   */
  public  java.io.InputStream wrapInputStream (java.io.InputStream inputStream)  { throw new RuntimeException(); }
  /**
   * Removes and closes the log writer for a specific worker.
   * <p>
   * @param workerId The worker ID (typically PID as string)
   */
  public  void removeAndCloseWorkerLogWriter (java.lang.String workerId)  { throw new RuntimeException(); }
  /**
   * Closes all active worker log writers.
   */
  public  void closeAllWriters ()  { throw new RuntimeException(); }
}
