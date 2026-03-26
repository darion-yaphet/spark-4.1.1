package org.apache.spark.resource;
public  class ResourceAmountUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ResourceAmountUtils$ MODULE$ = null;
  public   ResourceAmountUtils$ ()  { throw new RuntimeException(); }
  /**
   * Using "double" to do the resource calculation may encounter a problem of precision loss. Eg
   * <p>
   * scala&amp;gt; val taskAmount = 1.0 / 9
   * taskAmount: Double = 0.1111111111111111
   * <p>
   * scala&amp;gt; var total = 1.0
   * total: Double = 1.0
   * <p>
   * scala&amp;gt; for (i &amp;lt;- 1 to 9 ) {
   * |   if (total &amp;gt;= taskAmount) {
   * |           total -= taskAmount
   * |           println(s"assign $taskAmount for task $i, total left: $total")
   * |   } else {
   * |           println(s"ERROR Can't assign $taskAmount for task $i, total left: $total")
   * |   }
   * | }
   * assign 0.1111111111111111 for task 1, total left: 0.8888888888888888
   * assign 0.1111111111111111 for task 2, total left: 0.7777777777777777
   * assign 0.1111111111111111 for task 3, total left: 0.6666666666666665
   * assign 0.1111111111111111 for task 4, total left: 0.5555555555555554
   * assign 0.1111111111111111 for task 5, total left: 0.44444444444444425
   * assign 0.1111111111111111 for task 6, total left: 0.33333333333333315
   * assign 0.1111111111111111 for task 7, total left: 0.22222222222222204
   * assign 0.1111111111111111 for task 8, total left: 0.11111111111111094
   * ERROR Can't assign 0.1111111111111111 for task 9, total left: 0.11111111111111094
   * <p>
   * So we multiply ONE_ENTIRE_RESOURCE to convert the double to long to avoid this limitation.
   * Double can display up to 16 decimal places, so we set the factor to
   * 10, 000, 000, 000, 000, 000L.
   * @return (undocumented)
   */
  public final  long ONE_ENTIRE_RESOURCE ()  { throw new RuntimeException(); }
  public  boolean isOneEntireResource (long amount)  { throw new RuntimeException(); }
  public  long toInternalResource (double amount)  { throw new RuntimeException(); }
  public  double toFractionalResource (long amount)  { throw new RuntimeException(); }
}
