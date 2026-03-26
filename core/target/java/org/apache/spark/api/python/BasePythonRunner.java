package org.apache.spark.api.python;
/**
 * A helper class to run Python mapPartition/UDFs in Spark.
 * <p>
 * funcs is a list of independent Python functions, each one of them is a list of chained Python
 * functions (from bottom to top).
 */
 abstract class BasePythonRunner<IN extends java.lang.Object, OUT extends java.lang.Object> implements org.apache.spark.internal.Logging {
  /**
   * Responsible for writing the data from the PythonRDD's parent iterator to the
   * Python process.
   */
  public abstract class Writer {
    public   Writer (org.apache.spark.SparkEnv env, org.apache.spark.api.python.PythonWorker worker, scala.collection.Iterator<IN> inputIterator, int partitionIndex, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
    /**
     * Gateway to call BarrierTaskContext methods.
     * @param requestMethod (undocumented)
     * @param sock (undocumented)
     * @param message (undocumented)
     */
    public  void barrierAndServe (int requestMethod, java.nio.channels.SocketChannel sock, java.lang.String message)  { throw new RuntimeException(); }
    public  void close (java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
    /** Contains the throwable thrown while writing the parent iterator to the Python process. */
    public  scala.Option<java.lang.Throwable> exception ()  { throw new RuntimeException(); }
    public  void open (java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
    /**
     * Writes a command section to the stream connected to the Python worker.
     * @param dataOut (undocumented)
     */
    protected abstract  void writeCommand (java.io.DataOutputStream dataOut)  ;
    /**
     * Writes input data to the stream connected to the Python worker.
     * Returns true if any data was written to the stream, false if the input is exhausted.
     * @param dataOut (undocumented)
     * @return (undocumented)
     */
    public abstract  boolean writeNextInputToStream (java.io.DataOutputStream dataOut)  ;
    public  void writeUTF (java.lang.String str, java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
  }
  public abstract class ReaderIterator implements scala.collection.Iterator<OUT> {
    public   ReaderIterator (java.io.DataInputStream stream, org.apache.spark.api.python.BasePythonRunner<IN, OUT>.Writer writer, long startTime, org.apache.spark.SparkEnv env, org.apache.spark.api.python.PythonWorker worker, scala.Option<java.lang.Object> pid, java.util.concurrent.atomic.AtomicBoolean releasedOrClosed, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
    protected  void handleEndOfDataSection ()  { throw new RuntimeException(); }
    protected  scala.PartialFunction<java.lang.Throwable, OUT> handleException ()  { throw new RuntimeException(); }
    protected  org.apache.spark.api.python.PythonException handlePythonException ()  { throw new RuntimeException(); }
    protected  void handleTimingData ()  { throw new RuntimeException(); }
    public  boolean hasNext ()  { throw new RuntimeException(); }
    public  OUT next ()  { throw new RuntimeException(); }
    /**
     * Reads next object from the stream.
     * When the stream reaches end of data, needs to process the following sections,
     * and then returns null.
     * @return (undocumented)
     */
    protected abstract  OUT read ()  ;
  }
  /**
   * It is necessary to have a monitor thread for python workers if the user cancels with
   * interrupts disabled. In that case we will need to explicitly kill the worker, otherwise the
   * threads can block indefinitely.
   */
  public  class MonitorThread extends java.lang.Thread {
    public   MonitorThread (org.apache.spark.SparkEnv env, org.apache.spark.api.python.PythonWorker worker, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
    public  void run ()  { throw new RuntimeException(); }
  }
  public  class ReaderInputStream extends java.io.InputStream {
    public   ReaderInputStream (org.apache.spark.api.python.PythonWorker worker, org.apache.spark.api.python.BasePythonRunner<IN, OUT>.Writer writer, scala.Option<java.lang.ProcessHandle> handle, boolean faultHandlerEnabled, long idleTimeoutSeconds, boolean killOnIdleTimeout)  { throw new RuntimeException(); }
    public  int read ()  { throw new RuntimeException(); }
    public  int read (byte[] b, int off, int len)  { throw new RuntimeException(); }
  }
  // not preceding
  static   java.io.File faultHandlerLogDir ()  { throw new RuntimeException(); }
  static   java.nio.file.Path faultHandlerLogPath (int pid)  { throw new RuntimeException(); }
  static   scala.Option<java.lang.String> tryReadFaultHandlerLog (boolean faultHandlerEnabled, scala.Option<java.lang.Object> pid)  { throw new RuntimeException(); }
  static   org.apache.spark.internal.MessageWithContext pythonWorkerStatusMessageWithContext (scala.Option<java.lang.ProcessHandle> handle, org.apache.spark.api.python.PythonWorker worker, boolean hasInputs)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.Logging.LogStringContext LogStringContext (scala.StringContext sc)  { throw new RuntimeException(); }
  static protected  void withLogContext (java.util.Map<java.lang.String, java.lang.String> context, scala.Function0<scala.runtime.BoxedUnit> body)  { throw new RuntimeException(); }
  static protected  org.apache.spark.internal.MDC MDC (org.apache.spark.internal.LogKey key, Object value)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logInfo (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logDebug (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logTrace (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logWarning (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (org.apache.spark.internal.LogEntry entry)  { throw new RuntimeException(); }
  static protected  void logError (org.apache.spark.internal.LogEntry entry, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void logBasedOnLevel (org.slf4j.event.Level level, scala.Function0<org.apache.spark.internal.MessageWithContext> f)  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs ()  { throw new RuntimeException(); }
  protected  int evalType ()  { throw new RuntimeException(); }
  protected  int[][] argOffsets ()  { throw new RuntimeException(); }
  protected  scala.Option<java.lang.String> jobArtifactUUID ()  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Map<java.lang.String, org.apache.spark.util.AccumulatorV2<java.lang.Object, java.lang.Object>> metrics ()  { throw new RuntimeException(); }
  // not preceding
  public   BasePythonRunner (scala.collection.immutable.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs, int evalType, int[][] argOffsets, scala.Option<java.lang.String> jobArtifactUUID, scala.collection.immutable.Map<java.lang.String, org.apache.spark.util.AccumulatorV2<java.lang.Object, java.lang.Object>> metrics)  { throw new RuntimeException(); }
  protected  int bufferSize ()  { throw new RuntimeException(); }
  protected  boolean timelyFlushEnabled ()  { throw new RuntimeException(); }
  protected  long timelyFlushTimeoutNanos ()  { throw new RuntimeException(); }
  protected  long authSocketTimeout ()  { throw new RuntimeException(); }
  protected  boolean faultHandlerEnabled ()  { throw new RuntimeException(); }
  protected  long idleTimeoutSeconds ()  { throw new RuntimeException(); }
  protected  boolean killOnIdleTimeout ()  { throw new RuntimeException(); }
  protected  long tracebackDumpIntervalSeconds ()  { throw new RuntimeException(); }
  protected  boolean killWorkerOnFlushFailure ()  { throw new RuntimeException(); }
  protected  boolean hideTraceback ()  { throw new RuntimeException(); }
  protected  boolean simplifiedTraceback ()  { throw new RuntimeException(); }
  protected  java.util.Map<java.lang.String, java.lang.String> envVars ()  { throw new RuntimeException(); }
  protected  java.lang.String pythonExec ()  { throw new RuntimeException(); }
  protected  java.lang.String pythonVer ()  { throw new RuntimeException(); }
  protected  int batchSizeForPythonUDF ()  { throw new RuntimeException(); }
  protected  org.apache.spark.util.CollectionAccumulator<byte[]> accumulator ()  { throw new RuntimeException(); }
    scala.Option<java.nio.channels.ServerSocketChannel> serverSocketChannel ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<OUT> compute (scala.collection.Iterator<IN> inputIterator, int partitionIndex, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  protected abstract  org.apache.spark.api.python.BasePythonRunner<IN, OUT>.Writer newWriter (org.apache.spark.SparkEnv env, org.apache.spark.api.python.PythonWorker worker, scala.collection.Iterator<IN> inputIterator, int partitionIndex, org.apache.spark.TaskContext context)  ;
  protected abstract  scala.collection.Iterator<OUT> newReaderIterator (java.io.DataInputStream stream, org.apache.spark.api.python.BasePythonRunner<IN, OUT>.Writer writer, long startTime, org.apache.spark.SparkEnv env, org.apache.spark.api.python.PythonWorker worker, scala.Option<java.lang.Object> pid, java.util.concurrent.atomic.AtomicBoolean releasedOrClosed, org.apache.spark.TaskContext context)  ;
}
