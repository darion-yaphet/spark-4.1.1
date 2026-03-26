package org.apache.spark;
/**
 * Base abstract class for all unit tests in Spark for handling common functionality.
 * <p>
 * Thread audit happens normally here automatically when a new test suite created.
 * The only prerequisite for that is that the test class must extend {@link SparkFunSuite}.
 * <p>
 * It is possible to override the default thread audit behavior by setting enableAutoThreadAudit
 * to false and manually calling the audit methods, if desired. For example:
 * <p>
 * class MyTestSuite extends SparkFunSuite {
 * <p>
 *   override val enableAutoThreadAudit = false
 * <p>
 *   protected override def beforeAll(): Unit = {
 *     doThreadPreAudit()
 *     super.beforeAll()
 *   }
 * <p>
 *   protected override def afterAll(): Unit = {
 *     super.afterAll()
 *     doThreadPostAudit()
 *   }
 * }
 */
public abstract class SparkFunSuite extends org.scalatest.funsuite.AnyFunSuite implements org.scalatest.BeforeAndAfterAll, org.scalatest.BeforeAndAfterEach, org.apache.spark.ThreadAudit, org.scalatest.concurrent.TimeLimits, org.apache.spark.internal.Logging {
  public  class ExpectedContext implements scala.Product, java.io.Serializable {
    static public  org.apache.spark.SparkFunSuite.ExpectedContext apply (java.lang.String fragment, int start, int stop)  { throw new RuntimeException(); }
    static public  org.apache.spark.SparkFunSuite.ExpectedContext apply (java.lang.String fragment)  { throw new RuntimeException(); }
    static public  org.apache.spark.SparkFunSuite.ExpectedContext apply (java.lang.String objectType, java.lang.String objectName, int startIndex, int stopIndex, java.lang.String fragment)  { throw new RuntimeException(); }
    static public  org.apache.spark.SparkFunSuite.ExpectedContext apply (java.lang.String fragment, java.lang.String callSitePattern)  { throw new RuntimeException(); }
    public  org.apache.spark.QueryContextType contextType ()  { throw new RuntimeException(); }
    public  java.lang.String objectType ()  { throw new RuntimeException(); }
    public  java.lang.String objectName ()  { throw new RuntimeException(); }
    public  int startIndex ()  { throw new RuntimeException(); }
    public  int stopIndex ()  { throw new RuntimeException(); }
    public  java.lang.String fragment ()  { throw new RuntimeException(); }
    public  java.lang.String callSitePattern ()  { throw new RuntimeException(); }
    // not preceding
    public   ExpectedContext (org.apache.spark.QueryContextType contextType, java.lang.String objectType, java.lang.String objectName, int startIndex, int stopIndex, java.lang.String fragment, java.lang.String callSitePattern)  { throw new RuntimeException(); }
  }
  public  class ExpectedContext$ implements java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ExpectedContext$ MODULE$ = null;
    public   ExpectedContext$ ()  { throw new RuntimeException(); }
    public  org.apache.spark.SparkFunSuite.ExpectedContext apply (java.lang.String fragment, int start, int stop)  { throw new RuntimeException(); }
    public  org.apache.spark.SparkFunSuite.ExpectedContext apply (java.lang.String fragment)  { throw new RuntimeException(); }
    public  org.apache.spark.SparkFunSuite.ExpectedContext apply (java.lang.String objectType, java.lang.String objectName, int startIndex, int stopIndex, java.lang.String fragment)  { throw new RuntimeException(); }
    public  org.apache.spark.SparkFunSuite.ExpectedContext apply (java.lang.String fragment, java.lang.String callSitePattern)  { throw new RuntimeException(); }
  }
  public  class LogAppender extends org.apache.logging.log4j.core.appender.AbstractAppender {
    public   LogAppender (java.lang.String msg, int maxEvents)  { throw new RuntimeException(); }
    public  void append (org.apache.logging.log4j.core.LogEvent loggingEvent)  { throw new RuntimeException(); }
    public  void setThreshold (org.apache.logging.log4j.Level threshold)  { throw new RuntimeException(); }
    public  scala.collection.mutable.ArrayBuffer<org.apache.logging.log4j.core.LogEvent> loggingEvents ()  { throw new RuntimeException(); }
  }
  public  class LogAppender$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final LogAppender$ MODULE$ = null;
    public   LogAppender$ ()  { throw new RuntimeException(); }
  }
  public  org.apache.spark.SparkFunSuite.ExpectedContext$ ExpectedContext ()  { throw new RuntimeException(); }
  public   SparkFunSuite ()  { throw new RuntimeException(); }
  protected  void afterAll ()  { throw new RuntimeException(); }
  protected  void beforeAll ()  { throw new RuntimeException(); }
  /**
   * Checks an exception with an error condition against expected results.
   * @param exception     The exception to check
   * @param condition     The expected error condition identifying the error
   * @param sqlState      Optional the expected SQLSTATE, not verified if not supplied
   * @param parameters    A map of parameter names and values. The names are as defined
   *                      in the error-classes file.
   * @param matchPVals    Optionally treat the parameters value as regular expression pattern.
   *                      false if not supplied.
   * @param queryContext (undocumented)
   */
  protected  void checkError (org.apache.spark.SparkThrowable exception, java.lang.String condition, scala.Option<java.lang.String> sqlState, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, boolean matchPVals, org.apache.spark.SparkFunSuite.ExpectedContext[] queryContext)  { throw new RuntimeException(); }
  protected  void checkError (org.apache.spark.SparkThrowable exception, java.lang.String condition, java.lang.String sqlState, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  protected  void checkError (org.apache.spark.SparkThrowable exception, java.lang.String condition, java.lang.String sqlState, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.SparkFunSuite.ExpectedContext context)  { throw new RuntimeException(); }
  protected  void checkError (org.apache.spark.SparkThrowable exception, java.lang.String condition, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.SparkFunSuite.ExpectedContext context)  { throw new RuntimeException(); }
  protected  void checkError (org.apache.spark.SparkThrowable exception, java.lang.String condition, java.lang.String sqlState, org.apache.spark.SparkFunSuite.ExpectedContext context)  { throw new RuntimeException(); }
  protected  void checkError (org.apache.spark.SparkThrowable exception, java.lang.String condition, scala.Option<java.lang.String> sqlState, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.SparkFunSuite.ExpectedContext context)  { throw new RuntimeException(); }
  protected  void checkErrorMatchPVals (org.apache.spark.SparkThrowable exception, java.lang.String condition, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  protected  void checkErrorMatchPVals (org.apache.spark.SparkThrowable exception, java.lang.String condition, scala.Option<java.lang.String> sqlState, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.SparkFunSuite.ExpectedContext context)  { throw new RuntimeException(); }
  protected  void checkErrorTableAlreadyExists (org.apache.spark.SparkThrowable exception, java.lang.String tableName)  { throw new RuntimeException(); }
  protected  void checkErrorTableNotFound (org.apache.spark.SparkThrowable exception, java.lang.String tableName, org.apache.spark.SparkFunSuite.ExpectedContext queryContext)  { throw new RuntimeException(); }
  protected  void checkErrorTableNotFound (org.apache.spark.SparkThrowable exception, java.lang.String tableName)  { throw new RuntimeException(); }
  protected final  java.io.File copyAndGetResourceFile (java.lang.String fileName, java.lang.String suffix)  { throw new RuntimeException(); }
  protected  boolean enableAutoThreadAudit ()  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Seq<java.lang.String> excluded ()  { throw new RuntimeException(); }
  protected final  java.io.File getTestResourceFile (java.lang.String file)  { throw new RuntimeException(); }
  protected final  java.lang.String getTestResourcePath (java.lang.String file)  { throw new RuntimeException(); }
  /**
   * Get a Path relative to the root project. It is assumed that a spark home is set.
   * @param first (undocumented)
   * @param more (undocumented)
   * @return (undocumented)
   */
  protected final  java.nio.file.Path getWorkspaceFilePath (java.lang.String first, scala.collection.immutable.Seq<java.lang.String> more)  { throw new RuntimeException(); }
  protected <A extends java.lang.Object> void gridTest (java.lang.String testNamePrefix, scala.collection.immutable.Seq<org.scalatest.Tag> testTags, scala.collection.immutable.Seq<A> params, scala.Function1<A, scala.runtime.BoxedUnit> testFun)  { throw new RuntimeException(); }
  public  boolean invokeBeforeAllAndAfterAllEvenIfNoTestsAreExpected ()  { throw new RuntimeException(); }
  protected  void logForFailedTest ()  { throw new RuntimeException(); }
  protected <A extends java.lang.Object> void namedGridTest (java.lang.String testNamePrefix, scala.collection.immutable.Seq<org.scalatest.Tag> testTags, scala.collection.immutable.Map<java.lang.String, A> params, scala.Function1<A, scala.runtime.BoxedUnit> testFun)  { throw new RuntimeException(); }
  protected  boolean regenerateGoldenFiles ()  { throw new RuntimeException(); }
  /**
   * Note: this method doesn't support <code>BeforeAndAfter</code>. You must use <code>BeforeAndAfterEach</code> to
   * set up and tear down resources.
   * @param n (undocumented)
   * @param body (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T retry (int n, scala.Function0<T> body)  { throw new RuntimeException(); }
  protected  void test (java.lang.String testName, scala.collection.immutable.Seq<org.scalatest.Tag> testTags, scala.Function0<java.lang.Object> testBody, org.scalactic.source.Position pos)  { throw new RuntimeException(); }
  /**
   * Note: this method doesn't support <code>BeforeAndAfter</code>. You must use <code>BeforeAndAfterEach</code> to
   * set up and tear down resources.
   * @param s (undocumented)
   * @param n (undocumented)
   * @param body (undocumented)
   */
  public  void testRetry (java.lang.String s, int n, scala.Function0<scala.runtime.BoxedUnit> body)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.String> threadExcludeList ()  { throw new RuntimeException(); }
  /**
   * Log the suite name and the test name before and after each test.
   * <p>
   * Subclasses should never override this method. If they wish to run
   * custom code before and after each test, they should mix in the
   * {{org.scalatest.BeforeAndAfter}} trait instead.
   * @param test (undocumented)
   * @return (undocumented)
   */
  protected final  org.scalatest.Outcome withFixture (org.scalatest.TestSuite.NoArgTest test)  { throw new RuntimeException(); }
  /**
   * Adds a log appender and optionally sets a log level to the root logger or the logger with
   * the specified name, then executes the specified function, and in the end removes the log
   * appender and restores the log level if necessary.
   * @param appender (undocumented)
   * @param loggerNames (undocumented)
   * @param level (undocumented)
   * @param f (undocumented)
   */
  protected  void withLogAppender (org.apache.logging.log4j.core.appender.AbstractAppender appender, scala.collection.immutable.Seq<java.lang.String> loggerNames, scala.Option<org.apache.logging.log4j.Level> level, scala.Function0<scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /**
   * Creates a temporary directory containing a secret file, which is then passed to <code>f</code> and
   * will be deleted after <code>f</code> returns.
   * @param contents (undocumented)
   * @param f (undocumented)
   */
  protected  void withSecretFile (java.lang.String contents, scala.Function1<java.io.File, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /**
   * Sets all configurations specified in <code>pairs</code> in SparkEnv SparkConf, calls <code>f</code>, and then
   * restores all configurations.
   * @param pairs (undocumented)
   * @param f (undocumented)
   */
  protected  void withSparkEnvConfs (scala.collection.immutable.Seq<scala.Tuple2<java.lang.String, java.lang.String>> pairs, scala.Function0<scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /**
   * Creates a temporary directory, which is then passed to <code>f</code> and will be deleted after <code>f</code>
   * returns.
   * @param f (undocumented)
   */
  protected  void withTempDir (scala.Function1<java.io.File, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
}
