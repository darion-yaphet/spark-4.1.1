package org.apache.spark.ui;
  class SparkUICssErrorHandler extends org.htmlunit.DefaultCssErrorHandler {
  public   SparkUICssErrorHandler ()  { throw new RuntimeException(); }
  public  void error (org.htmlunit.cssparser.parser.CSSParseException e)  { throw new RuntimeException(); }
  public  void fatalError (org.htmlunit.cssparser.parser.CSSParseException e)  { throw new RuntimeException(); }
  public  void warning (org.htmlunit.cssparser.parser.CSSParseException e)  { throw new RuntimeException(); }
}
