package org.apache.spark.storage;
/**
 * Base class representing a log line.
 * <p>
 * param:  eventTime timestamp in milliseconds when the log is written
 * param:  sequenceId sequence ID of the log line
 * param:  message log message
 */
public  interface LogLine {
  public  long eventTime ()  ;
  public  long sequenceId ()  ;
  public  java.lang.String message ()  ;
}
