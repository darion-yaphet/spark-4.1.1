package org.apache.spark.deploy.history;
/**
 * Abstract base class for testing the History Server, including mechanisms to compare
 * responses from the JSON metrics API against predefined "golden files". This suite
 * establishes a framework for validating API behaviors across different storage backends.
 * <p>
 * Test cases added here will be executed against all concrete implementations. For backend-specific
 * validations, subclasses should override relevant setup methods or add specialized tests.
 * <p>
 * The test suite supports two operational modes:
 * 1. Validation Mode (default): Compares API responses against existing golden files.
 * 2. Generation Mode: Generates new golden files when SPARK_GENERATE_GOLDEN_FILES=1 is set.
 * <p>
 * To generate golden files, run the following SBT command with the environment variable set:
 * <pre><code>
 *   SPARK_GENERATE_GOLDEN_FILES=1 build/sbt "core/testOnly &lt;sub class&gt;"
 * </code></pre>
 * <p>
 * Note: New golden files should be carefully reviewed to ensure they align with Spark's
 * public API specifications. Changes to metrics should be made with caution, as they
 * are considered part of Spark's public interface.
 */
public abstract class HistoryServerSuite extends org.apache.spark.SparkFunSuite implements org.scalatest.BeforeAndAfter, org.scalatest.matchers.must.Matchers, org.scalatestplus.mockito.MockitoSugar, org.apache.spark.JsonTestUtils, org.scalatest.concurrent.Eventually, org.scalatestplus.selenium.WebBrowser, org.apache.spark.LocalSparkContext, org.apache.spark.util.ResetSystemProperties {
  static public  scala.Tuple3<java.lang.Object, scala.Option<java.io.InputStream>, scala.Option<java.lang.String>> connectAndGetInputStream (java.net.URL url)  { throw new RuntimeException(); }
  static public  java.lang.String sanitizePath (java.lang.String path)  { throw new RuntimeException(); }
  public  java.util.Properties oldProperties ()  { throw new RuntimeException(); }
  public  org.apache.spark.SparkContext sc ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.Point$ Point ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.Dimension$ Dimension ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.CookiesNoun cookies ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.go$ go ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.IdQuery$ IdQuery ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.NameQuery$ NameQuery ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.XPathQuery$ XPathQuery ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.ClassNameQuery$ ClassNameQuery ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.CssSelectorQuery$ CssSelectorQuery ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.LinkTextQuery$ LinkTextQuery ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.PartialLinkTextQuery$ PartialLinkTextQuery ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.TagNameQuery$ TagNameQuery ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.click$ click ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.ActiveElementTarget activeElement ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.AlertTarget alertBox ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.DefaultContentTarget defaultContent ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.add$ add ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.delete$ delete ()  { throw new RuntimeException(); }
  public  org.scalatestplus.selenium.WebBrowser.capture$ capture ()  { throw new RuntimeException(); }
  public  org.scalatest.concurrent.AbstractPatienceConfiguration.PatienceConfig$ PatienceConfig ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.must.Matchers.KeyWord key ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.must.Matchers.ValueWord value ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.must.Matchers.AWord a ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.must.Matchers.AnWord an ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.must.Matchers.TheSameInstanceAsPhrase theSameInstanceAs ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.must.Matchers.RegexWord regex ()  { throw new RuntimeException(); }
  public  org.scalactic.Explicitly.DecidedWord decided ()  { throw new RuntimeException(); }
  public  org.scalactic.Explicitly.DeterminedWord determined ()  { throw new RuntimeException(); }
  public  org.scalactic.Explicitly.TheAfterWord after ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.FullyMatchWord fullyMatch ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.StartWithWord startWith ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.EndWithWord endWith ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.IncludeWord include ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.HaveWord have ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.BeWord be ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.ContainWord contain ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.NotWord not ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.LengthWord length ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.SizeWord size ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.SortedWord sorted ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.DefinedWord defined ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.ExistWord exist ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.ReadableWord readable ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.WritableWord writable ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.EmptyWord empty ()  { throw new RuntimeException(); }
  public  org.scalatest.verbs.CompileWord compile ()  { throw new RuntimeException(); }
  public  org.scalatest.verbs.TypeCheckWord typeCheck ()  { throw new RuntimeException(); }
  public  org.scalatest.matchers.dsl.MatchPatternWord matchPattern ()  { throw new RuntimeException(); }
  public   HistoryServerSuite ()  { throw new RuntimeException(); }
  protected abstract  scala.Enumeration.Value diskBackend ()  ;
  public  java.io.File getExpRoot ()  { throw new RuntimeException(); }
  public  void init (scala.collection.immutable.Seq<scala.Tuple2<java.lang.String, java.lang.String>> extraConf)  { throw new RuntimeException(); }
  public  void stop ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<scala.Tuple2<java.lang.String, java.lang.String>> cases ()  { throw new RuntimeException(); }
  public  void doDownloadTest (java.lang.String appId, scala.Option<java.lang.Object> attemptId)  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, java.lang.String> getRedirectUrl (java.net.URL url)  { throw new RuntimeException(); }
  public  java.net.URL buildPageAttemptUrl (java.lang.String appId, scala.Option<java.lang.Object> attemptId)  { throw new RuntimeException(); }
  public  scala.Tuple3<java.lang.Object, scala.Option<java.lang.String>, scala.Option<java.lang.String>> getContentAndCode (java.lang.String path, int port)  { throw new RuntimeException(); }
  public  java.lang.String getUrl (java.lang.String path)  { throw new RuntimeException(); }
  public  java.net.URL generateURL (java.lang.String path)  { throw new RuntimeException(); }
}
