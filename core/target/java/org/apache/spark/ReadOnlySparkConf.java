package org.apache.spark;
public  interface ReadOnlySparkConf {
  /**
   * Wrapper method for get() methods which require some specific value format. This catches
   * any {@link NumberFormatException} or {@link IllegalArgumentException} and re-raises it with the
   * incorrectly configured key in the exception message.
   * @param key (undocumented)
   * @param getValue (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T catchIllegalValue (java.lang.String key, scala.Function0<T> getValue)  ;
  /** Does the configuration contain a given parameter? */
  public  boolean contains (java.lang.String key)  ;
  /** Does the configuration have the typed config entry? */
  public  boolean contains (org.apache.spark.internal.config.ConfigEntry<?> entry)  ;
  /** Get a parameter; throws a NoSuchElementException if it's not set */
  public  java.lang.String get (java.lang.String key)  ;
  /** Get a parameter, falling back to a default if not set */
  public  java.lang.String get (java.lang.String key, java.lang.String defaultValue)  ;
  /**
   * Retrieves the value of a pre-defined configuration entry.
   * <p>
   * - This is an internal Spark API.
   * - The return type if defined by the configuration entry.
   * - This will throw an exception is the config is not optional and the value is not set.
   * @param entry (undocumented)
   * @return (undocumented)
   */
   <T extends java.lang.Object> T get (org.apache.spark.internal.config.ConfigEntry<T> entry)  ;
  /** Get all parameters as a list of pairs */
  public  scala.Tuple2<java.lang.String, java.lang.String>[] getAll ()  ;
  /**
   * Get a parameter as a boolean, falling back to a default if not set
   * <p>
   * @throws IllegalArgumentException If the value cannot be interpreted as a boolean
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  boolean getBoolean (java.lang.String key, boolean defaultValue)  ;
  /**
   * Get a parameter as a double, falling back to a default if not ste
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as a double
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  double getDouble (java.lang.String key, double defaultValue)  ;
  /**
   * Get a parameter as an integer, falling back to a default if not set
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as an integer
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  int getInt (java.lang.String key, int defaultValue)  ;
  /**
   * Get a parameter as a long, falling back to a default if not set
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as a long
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  long getLong (java.lang.String key, long defaultValue)  ;
  /** Get a parameter as an Option */
  public  scala.Option<java.lang.String> getOption (java.lang.String key)  ;
  /**
   * Get a size parameter as bytes; throws a NoSuchElementException if it's not set. If no
   * suffix is provided then bytes are assumed.
   * <p>
   * @throws java.util.NoSuchElementException If the size parameter is not set
   * @throws NumberFormatException            If the value cannot be interpreted as bytes
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsBytes (java.lang.String key)  ;
  /**
   * Get a size parameter as bytes, falling back to a default if not set. If no
   * suffix is provided then bytes are assumed.
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as bytes
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsBytes (java.lang.String key, java.lang.String defaultValue)  ;
  /**
   * Get a size parameter as bytes, falling back to a default if not set.
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as bytes
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsBytes (java.lang.String key, long defaultValue)  ;
  /**
   * Get a size parameter as Gibibytes; throws a NoSuchElementException if it's not set. If no
   * suffix is provided then Gibibytes are assumed.
   * <p>
   * @throws java.util.NoSuchElementException If the size parameter is not set
   * @throws NumberFormatException            If the value cannot be interpreted as Gibibytes
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsGb (java.lang.String key)  ;
  /**
   * Get a size parameter as Gibibytes, falling back to a default if not set. If no
   * suffix is provided then Gibibytes are assumed.
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as Gibibytes
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsGb (java.lang.String key, java.lang.String defaultValue)  ;
  /**
   * Get a size parameter as Kibibytes; throws a NoSuchElementException if it's not set. If no
   * suffix is provided then Kibibytes are assumed.
   * <p>
   * @throws java.util.NoSuchElementException If the size parameter is not set
   * @throws NumberFormatException            If the value cannot be interpreted as Kibibytes
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsKb (java.lang.String key)  ;
  /**
   * Get a size parameter as Kibibytes, falling back to a default if not set. If no
   * suffix is provided then Kibibytes are assumed.
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as Kibibytes
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsKb (java.lang.String key, java.lang.String defaultValue)  ;
  /**
   * Get a size parameter as Mebibytes; throws a NoSuchElementException if it's not set. If no
   * suffix is provided then Mebibytes are assumed.
   * <p>
   * @throws java.util.NoSuchElementException If the size parameter is not set
   * @throws NumberFormatException            If the value cannot be interpreted as Mebibytes
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsMb (java.lang.String key)  ;
  /**
   * Get a size parameter as Mebibytes, falling back to a default if not set. If no
   * suffix is provided then Mebibytes are assumed.
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as Mebibytes
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  long getSizeAsMb (java.lang.String key, java.lang.String defaultValue)  ;
  /**
   * Get a time parameter as milliseconds; throws a NoSuchElementException if it's not set. If no
   * suffix is provided then milliseconds are assumed.
   * <p>
   * @throws java.util.NoSuchElementException If the time parameter is not set
   * @throws NumberFormatException            If the value cannot be interpreted as milliseconds
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  long getTimeAsMs (java.lang.String key)  ;
  /**
   * Get a time parameter as milliseconds, falling back to a default if not set. If no
   * suffix is provided then milliseconds are assumed.
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as milliseconds
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  long getTimeAsMs (java.lang.String key, java.lang.String defaultValue)  ;
  /**
   * Get a time parameter as seconds; throws a NoSuchElementException if it's not set. If no
   * suffix is provided then seconds are assumed.
   * <p>
   * @throws java.util.NoSuchElementException If the time parameter is not set
   * @throws NumberFormatException            If the value cannot be interpreted as seconds
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  long getTimeAsSeconds (java.lang.String key)  ;
  /**
   * Get a time parameter as seconds, falling back to a default if not set. If no
   * suffix is provided then seconds are assumed.
   * <p>
   * @throws NumberFormatException If the value cannot be interpreted as seconds
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  long getTimeAsSeconds (java.lang.String key, java.lang.String defaultValue)  ;
  /**
   * By using this instead of System.getenv(), environment variables can be mocked
   * in unit tests.
   * @param name (undocumented)
   * @return (undocumented)
   */
    java.lang.String getenv (java.lang.String name)  ;
}
