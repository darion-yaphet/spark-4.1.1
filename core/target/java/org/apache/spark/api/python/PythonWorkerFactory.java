package org.apache.spark.api.python;
  class PythonWorkerFactory implements org.apache.spark.internal.Logging {
  static public  int PROCESS_WAIT_TIMEOUT_MS ()  { throw new RuntimeException(); }
  static public  long IDLE_WORKER_TIMEOUT_NS ()  { throw new RuntimeException(); }
  static   java.lang.String defaultDaemonModule ()  { throw new RuntimeException(); }
  public  boolean useDaemonEnabled ()  { throw new RuntimeException(); }
  // not preceding
  public   PythonWorkerFactory (java.lang.String pythonExec, java.lang.String workerModule, java.lang.String daemonModule, scala.collection.immutable.Map<java.lang.String, java.lang.String> envVars, boolean useDaemonEnabled)  { throw new RuntimeException(); }
  public   PythonWorkerFactory (java.lang.String pythonExec, java.lang.String workerModule, scala.collection.immutable.Map<java.lang.String, java.lang.String> envVars, boolean useDaemonEnabled)  { throw new RuntimeException(); }
  public  java.net.InetAddress daemonHost ()  { throw new RuntimeException(); }
    scala.collection.mutable.Queue<org.apache.spark.api.python.PythonWorker> idleWorkers ()  { throw new RuntimeException(); }
  public  scala.Tuple2<org.apache.spark.api.python.PythonWorker, scala.Option<java.lang.ProcessHandle>> create ()  { throw new RuntimeException(); }
  /**
   * Launch a worker by executing worker.py (by default) directly and telling it to connect to us.
   * @param blockingMode (undocumented)
   * @return (undocumented)
   */
    scala.Tuple2<org.apache.spark.api.python.PythonWorker, scala.Option<java.lang.ProcessHandle>> createSimpleWorker (boolean blockingMode)  { throw new RuntimeException(); }
  public  void stop ()  { throw new RuntimeException(); }
  public  void stopWorker (org.apache.spark.api.python.PythonWorker worker)  { throw new RuntimeException(); }
  public  void releaseWorker (org.apache.spark.api.python.PythonWorker worker)  { throw new RuntimeException(); }
  public  boolean isWorkerStopped (org.apache.spark.api.python.PythonWorker worker)  { throw new RuntimeException(); }
}
