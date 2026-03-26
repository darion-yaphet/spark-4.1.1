package org.apache.spark.api.python;
public  class PythonWorkerUtils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PythonWorkerUtils$ MODULE$ = null;
  public   PythonWorkerUtils$ ()  { throw new RuntimeException(); }
  /**
   * Write a string in UTF-8 charset.
   * <p>
   * It will be read by <code>UTF8Deserializer.loads</code> in Python.
   * @param str (undocumented)
   * @param dataOut (undocumented)
   */
  public  void writeUTF (java.lang.String str, java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
  /**
   * Write a byte array.
   * <p>
   * It will be read by <code>FramedSerializer._read_with_length</code> in Python.
   * @param bytes (undocumented)
   * @param dataOut (undocumented)
   */
  public  void writeBytes (byte[] bytes, java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
  /**
   * Write a Python version to check if the Python version is expected.
   * <p>
   * It will be read and checked by <code>worker_util.check_python_version</code>.
   * @param pythonVer (undocumented)
   * @param dataOut (undocumented)
   */
  public  void writePythonVersion (java.lang.String pythonVer, java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
  /**
   * Write Spark files to set up them in the worker.
   * <p>
   * It will be read and used by <code>worker_util.setup_spark_files</code>.
   * @param jobArtifactUUID (undocumented)
   * @param pythonIncludes (undocumented)
   * @param dataOut (undocumented)
   */
  public  void writeSparkFiles (scala.Option<java.lang.String> jobArtifactUUID, scala.collection.immutable.Set<java.lang.String> pythonIncludes, java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
  /**
   * Write broadcasted variables to set up them in the worker.
   * <p>
   * It will be read and used by 'worker_util.setup_broadcasts<code>.
   * @param broadcastVars (undocumented)
   * @param worker (undocumented)
   * @param env (undocumented)
   * @param dataOut (undocumented)
   */
  public  void writeBroadcasts (scala.collection.immutable.Seq<org.apache.spark.broadcast.Broadcast<org.apache.spark.api.python.PythonBroadcast>> broadcastVars, org.apache.spark.api.python.PythonWorker worker, org.apache.spark.SparkEnv env, java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
  /**
   * Write PythonFunction to the worker.
   * @param func (undocumented)
   * @param dataOut (undocumented)
   */
  public  void writePythonFunction (org.apache.spark.api.python.PythonFunction func, java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
  /**
   * Read a string in UTF-8 charset.
   * @param dataIn (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String readUTF (java.io.DataInputStream dataIn)  { throw new RuntimeException(); }
  /**
   * Read a string in UTF-8 charset with the given byte length.
   * @param length (undocumented)
   * @param dataIn (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String readUTF (int length, java.io.DataInputStream dataIn)  { throw new RuntimeException(); }
  /**
   * Read a byte array.
   * @param dataIn (undocumented)
   * @return (undocumented)
   */
  public  byte[] readBytes (java.io.DataInputStream dataIn)  { throw new RuntimeException(); }
  /**
   * Read a byte array with the given byte length.
   * @param length (undocumented)
   * @param dataIn (undocumented)
   * @return (undocumented)
   */
  public  byte[] readBytes (int length, java.io.DataInputStream dataIn)  { throw new RuntimeException(); }
  /**
   * Receive accumulator updates from the worker.
   * <p>
   * The updates are sent by <code>worker_util.send_accumulator_updates</code>.
   * @param maybeAccumulator (undocumented)
   * @param dataIn (undocumented)
   */
  public  void receiveAccumulatorUpdates (scala.Option<org.apache.spark.util.CollectionAccumulator<byte[]>> maybeAccumulator, java.io.DataInputStream dataIn)  { throw new RuntimeException(); }
}
