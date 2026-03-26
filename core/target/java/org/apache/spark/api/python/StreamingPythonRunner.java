package org.apache.spark.api.python;
  class StreamingPythonRunner implements org.apache.spark.internal.Logging {
  public  class StreamingPythonRunnerInitializationCommunicationException extends org.apache.spark.SparkPythonException {
    public   StreamingPythonRunnerInitializationCommunicationException (java.lang.String errMessage)  { throw new RuntimeException(); }
  }
  public  class StreamingPythonRunnerInitializationTimeoutException extends org.apache.spark.SparkPythonException {
    public   StreamingPythonRunnerInitializationTimeoutException (java.lang.String errMessage)  { throw new RuntimeException(); }
  }
  public  class StreamingPythonRunnerInitializationException extends org.apache.spark.SparkPythonException {
    public   StreamingPythonRunnerInitializationException (int resFromPython, java.lang.String errMessage)  { throw new RuntimeException(); }
  }
  static public  org.apache.spark.api.python.StreamingPythonRunner apply (org.apache.spark.api.python.PythonFunction func, java.lang.String connectUrl, java.lang.String sessionId, java.lang.String workerModule)  { throw new RuntimeException(); }
  public   StreamingPythonRunner (org.apache.spark.api.python.PythonFunction func, java.lang.String connectUrl, java.lang.String sessionId, java.lang.String workerModule)  { throw new RuntimeException(); }
  protected  int bufferSize ()  { throw new RuntimeException(); }
  protected  long authSocketTimeout ()  { throw new RuntimeException(); }
  protected  java.util.Map<java.lang.String, java.lang.String> envVars ()  { throw new RuntimeException(); }
  protected  java.lang.String pythonExec ()  { throw new RuntimeException(); }
  protected  scala.Option<org.apache.spark.api.python.PythonWorker> pythonWorker ()  { throw new RuntimeException(); }
  protected  scala.Option<org.apache.spark.api.python.PythonWorkerFactory> pythonWorkerFactory ()  { throw new RuntimeException(); }
  protected  java.lang.String pythonVer ()  { throw new RuntimeException(); }
  /**
   * Initializes the Python worker for streaming functions. Sets up Spark Connect session
   * to be used with the functions.
   * @return (undocumented)
   */
  public  scala.Tuple2<java.io.DataOutputStream, java.io.DataInputStream> init ()  { throw new RuntimeException(); }
  /**
   * Stops the Python worker.
   */
  public  void stop ()  { throw new RuntimeException(); }
  /**
   * Returns whether the Python worker has been stopped.
   * @return Some(true) if the Python worker has been stopped.
   *         None if either the Python worker or the Python worker factory is not initialized.
   */
  public  scala.Option<java.lang.Object> isWorkerStopped ()  { throw new RuntimeException(); }
}
