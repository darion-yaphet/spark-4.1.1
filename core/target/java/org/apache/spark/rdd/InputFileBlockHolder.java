package org.apache.spark.rdd;
/**
 * This holds file names of the current Spark task. This is used in HadoopRDD,
 * FileScanRDD, NewHadoopRDD and InputFileName function in Spark SQL.
 */
public  class InputFileBlockHolder {
  /**
   * The thread variable for the name of the current file being read. This is used by
   * the InputFileName function in Spark SQL.
   * <p>
   * @note <code>inputBlock</code> works somewhat complicatedly. It guarantees that <code>initialValue</code>
   * is called at the start of a task. Therefore, one atomic reference is created in the task
   * thread. After that, read and write happen to the same atomic reference across the parent and
   * children threads. This is in order to support a case where write happens in a child thread
   * but read happens at its parent thread, for instance, Python UDF execution. See SPARK-28153.
   * @param ref (undocumented)
   */
  static   void setThreadLocalValue (java.lang.Object ref)  { throw new RuntimeException(); }
  static   java.lang.Object getThreadLocalValue ()  { throw new RuntimeException(); }
  /**
   * Returns the holding file name or empty string if it is unknown.
   * @return (undocumented)
   */
  static public  org.apache.spark.unsafe.types.UTF8String getInputFilePath ()  { throw new RuntimeException(); }
  /**
   * Returns the starting offset of the block currently being read, or -1 if it is unknown.
   * @return (undocumented)
   */
  static public  long getStartOffset ()  { throw new RuntimeException(); }
  /**
   * Returns the length of the block being read, or -1 if it is unknown.
   * @return (undocumented)
   */
  static public  long getLength ()  { throw new RuntimeException(); }
  /**
   * Sets the thread-local input block.
   * <p>
   * Callers of this method must ensure a task completion listener has been registered to unset()
   * the thread local in the task thread.
   * @param filePath (undocumented)
   * @param startOffset (undocumented)
   * @param length (undocumented)
   */
  static public  void set (java.lang.String filePath, long startOffset, long length)  { throw new RuntimeException(); }
  /**
   * Clears the input file block to default value.
   */
  static public  void unset ()  { throw new RuntimeException(); }
  /**
   * Initializes thread local by explicitly getting the value. It triggers ThreadLocal's
   * initialValue in the parent thread.
   */
  static public  void initialize ()  { throw new RuntimeException(); }
}
