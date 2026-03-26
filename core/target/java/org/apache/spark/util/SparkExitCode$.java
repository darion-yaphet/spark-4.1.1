package org.apache.spark.util;
public  class SparkExitCode$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkExitCode$ MODULE$ = null;
  public   SparkExitCode$ ()  { throw new RuntimeException(); }
  /** Successful termination. */
  public  int EXIT_SUCCESS ()  { throw new RuntimeException(); }
  /** Failed termination. */
  public  int EXIT_FAILURE ()  { throw new RuntimeException(); }
  /** Exception indicate invalid usage of some shell built-in command. */
  public  int ERROR_MISUSE_SHELL_BUILTIN ()  { throw new RuntimeException(); }
  /** Exception appears when the computer cannot find the specified path. */
  public  int ERROR_PATH_NOT_FOUND ()  { throw new RuntimeException(); }
  /** Exit due to executor failures exceeds the threshold. */
  public  int EXCEED_MAX_EXECUTOR_FAILURES ()  { throw new RuntimeException(); }
  /** The default uncaught exception handler was reached. */
  public  int UNCAUGHT_EXCEPTION ()  { throw new RuntimeException(); }
  /** The default uncaught exception handler was called and an exception was encountered while
   * @return (undocumented)
   logging the exception. */
  public  int UNCAUGHT_EXCEPTION_TWICE ()  { throw new RuntimeException(); }
  /** The default uncaught exception handler was reached, and the uncaught exception was an
   * @return (undocumented)
   OutOfMemoryError. */
  public  int OOM ()  { throw new RuntimeException(); }
  /** Exit due to ClassNotFoundException or NoClassDefFoundError. */
  public  int CLASS_NOT_FOUND ()  { throw new RuntimeException(); }
  /** Exit because the driver is running over the given threshold. */
  public  int DRIVER_TIMEOUT ()  { throw new RuntimeException(); }
  /** Exception indicate command not found. */
  public  int ERROR_COMMAND_NOT_FOUND ()  { throw new RuntimeException(); }
}
