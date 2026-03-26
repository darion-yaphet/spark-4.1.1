package org.apache.spark.internal.config;
public  class Deploy {
  static public  class WorkerSelectionPolicy$ extends scala.Enumeration {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final WorkerSelectionPolicy$ MODULE$ = null;
    public   WorkerSelectionPolicy$ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value CORES_FREE_ASC ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value CORES_FREE_DESC ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value MEMORY_FREE_ASC ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value MEMORY_FREE_DESC ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value WORKER_ID ()  { throw new RuntimeException(); }
  }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> RECOVERY_MODE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> RECOVERY_COMPRESSION_CODEC ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> RECOVERY_MODE_FACTORY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> RECOVERY_DIRECTORY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> RECOVERY_TIMEOUT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> ZOOKEEPER_URL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> ZOOKEEPER_DIRECTORY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> RETAINED_APPLICATIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> RETAINED_DRIVERS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REAPER_ITERATIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_EXECUTOR_RETRIES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SPREAD_OUT_DRIVERS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SPREAD_OUT_APPS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> WORKER_SELECTION_POLICY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DEFAULT_CORES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_DRIVERS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> APP_NUMBER_MODULO ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DRIVER_ID_PATTERN ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> APP_ID_PATTERN ()  { throw new RuntimeException(); }
}
