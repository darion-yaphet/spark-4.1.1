package org.apache.spark.broadcast;
/** A broadcast variable. Broadcast variables allow the programmer to keep a
 * read-only variable cached on each machine rather than shipping a copy of it
 * with tasks. They can be used, for example, to give every node a copy of a
 * large input dataset in an efficient manner. Spark also attempts to
 * distribute broadcast variables using efficient broadcast algorithms to
 * reduce communication cost. &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x3002;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x5141;&#x8bb8;&#x7f16;&#x7a0b;&#x4eba;&#x5458;&#x5728;&#x6bcf;&#x53f0;&#x673a;&#x5668;&#x4e0a;&#x7f13;&#x5b58;&#x4e00;&#x4e2a;&#x53ea;&#x8bfb;&#x53d8;&#x91cf;&#xff0c;&#x800c;&#x4e0d;&#x662f;&#x968f;&#x4efb;&#x52a1;&#x4e00;&#x8d77;&#x53d1;&#x9001;&#x5176;&#x526f;&#x672c;&#x3002;
 * &#x4f8b;&#x5982;&#xff0c;&#x5b83;&#x4eec;&#x53ef;&#x4ee5;&#x7528;&#x4e8e;&#x4ee5;&#x9ad8;&#x6548;&#x7684;&#x65b9;&#x5f0f;&#x4e3a;&#x6bcf;&#x4e2a;&#x8282;&#x70b9;&#x63d0;&#x4f9b;&#x5927;&#x578b;&#x8f93;&#x5165;&#x6570;&#x636e;&#x96c6;&#x7684;&#x526f;&#x672c;&#x3002; Spark &#x8fd8;&#x5c1d;&#x8bd5;&#x4f7f;&#x7528;&#x9ad8;&#x6548;&#x7684;&#x5e7f;&#x64ad;&#x7b97;&#x6cd5;&#x5206;&#x53d1;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#xff0c;&#x4ee5;&#x964d;&#x4f4e;&#x901a;&#x4fe1;&#x6210;&#x672c;&#x3002;
 * <p>
 * Broadcast variables are created from a variable <code>v</code> by calling
 * {@link org.apache.spark.SparkContext#broadcast}. The broadcast variable is a
 * wrapper around <code>v</code>, and its value can be accessed by calling the <code>value</code>
 * method. The interpreter session below shows this: &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x901a;&#x8fc7;&#x8c03;&#x7528;
 * {@link org.apache.spark.SparkContext#broadcast} &#x4ece;&#x53d8;&#x91cf; <code>v</code> &#x521b;&#x5efa;&#x3002; &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x662f;&#x5bf9; <code>v</code>
 * &#x7684;&#x5305;&#x88c5;&#xff0c;&#x5176;&#x503c;&#x53ef;&#x4ee5;&#x901a;&#x8fc7;&#x8c03;&#x7528; <code>value</code> &#x65b9;&#x6cd5;&#x8bbf;&#x95ee;&#x3002; &#x4e0b;&#x9762;&#x7684;&#x89e3;&#x91ca;&#x5668;&#x4f1a;&#x8bdd;&#x5c55;&#x793a;&#x4e86;&#x8fd9;&#x4e00;&#x70b9;&#xff1a;
 * <p>
 * <pre><code>
 * scala&gt; val broadcastVar = sc.broadcast(Array(1, 2, 3))
 * broadcastVar: org.apache.spark.broadcast.Broadcast[Array[Int} = Broadcast(0)
 *
 * scala&gt; broadcastVar.value
 * res0: Array[Int] = Array(1, 2, 3)
 * </code></pre>
 * <p>
 * After the broadcast variable is created, it should be used instead of the
 * value <code>v</code> in any functions run on the cluster so that <code>v</code> is not shipped to
 * the nodes more than once. In addition, the object <code>v</code> should not be modified
 * after it is broadcast in order to ensure that all nodes get the same value
 * of the broadcast variable (e.g. if the variable is shipped to a new node
 * later). &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x521b;&#x5efa;&#x540e;&#xff0c;&#x5728;&#x96c6;&#x7fa4;&#x4e0a;&#x8fd0;&#x884c;&#x7684;&#x4efb;&#x4f55;&#x51fd;&#x6570;&#x4e2d;&#x90fd;&#x5e94;&#x4f7f;&#x7528;&#x5b83;&#x6765;&#x4ee3;&#x66ff;&#x503c; <code>v</code>&#xff0c;&#x8fd9;&#x6837; <code>v</code> &#x5c31;&#x4e0d;&#x4f1a;&#x591a;&#x6b21;&#x8fd0;&#x9001;&#x5230;&#x8282;&#x70b9;&#x3002; &#x6b64;&#x5916;&#xff0c;&#x5bf9;&#x8c61; <code>v</code>
 * &#x5728;&#x5e7f;&#x64ad;&#x540e;&#x4e0d;&#x5e94;&#x88ab;&#x4fee;&#x6539;&#xff0c;&#x4ee5;&#x786e;&#x4fdd;&#x6240;&#x6709;&#x8282;&#x70b9;&#x83b7;&#x5f97;&#x76f8;&#x540c;&#x7684;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x503c;&#xff08;&#x4f8b;&#x5982;&#xff0c;&#x5982;&#x679c;&#x8be5;&#x53d8;&#x91cf;&#x7a0d;&#x540e;&#x88ab;&#x53d1;&#x9001;&#x5230;&#x65b0;&#x8282;&#x70b9;&#xff09;&#x3002;
 * <p>
 * param:  id
 *   A unique identifier for the broadcast variable. &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x7684;&#x552f;&#x4e00;&#x6807;&#x8bc6;&#x7b26;&#x3002;
 * @tparam T
 *   Type of the data contained in the broadcast variable. &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x4e2d;&#x6240;&#x542b;&#x6570;&#x636e;&#x7684;&#x7c7b;&#x578b;&#x3002;
 */
public abstract class Broadcast<T extends java.lang.Object> implements java.io.Serializable, org.apache.spark.internal.Logging {
  // not preceding
  public   Broadcast (long id, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  /** Check if this broadcast is valid. If not valid, exception is thrown.
   * &#x68c0;&#x67e5;&#x6b64;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x662f;&#x5426;&#x6709;&#x6548;&#x3002;&#x5982;&#x679c;&#x65e0;&#x6548;&#xff0c;&#x5219;&#x629b;&#x51fa;&#x5f02;&#x5e38;&#x3002;
   */
  protected  void assertValid ()  { throw new RuntimeException(); }
  /** Destroy all data and metadata related to this broadcast variable. Use this
   * with caution; once a broadcast variable has been destroyed, it cannot be
   * used again. &#x9500;&#x6bc1;&#x4e0e;&#x6b64;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x76f8;&#x5173;&#x7684;&#x6240;&#x6709;&#x6570;&#x636e;&#x548c;&#x5143;&#x6570;&#x636e;&#x3002;&#x8bf7;&#x8c28;&#x614e;&#x4f7f;&#x7528;&#xff1b; &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x4e00;&#x65e6;&#x88ab;&#x9500;&#x6bc1;&#xff0c;&#x5c31;&#x65e0;&#x6cd5;&#x518d;&#x6b21;&#x4f7f;&#x7528;&#x3002;
   */
  public  void destroy ()  { throw new RuntimeException(); }
  /** Destroy all data and metadata related to this broadcast variable. Use this
   * with caution; once a broadcast variable has been destroyed, it cannot be
   * used again.
   * <p>
   * &#x9500;&#x6bc1;&#x4e0e;&#x6b64;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x76f8;&#x5173;&#x7684;&#x6240;&#x6709;&#x6570;&#x636e;&#x548c;&#x5143;&#x6570;&#x636e;&#x3002;&#x8bf7;&#x8c28;&#x614e;&#x4f7f;&#x7528;&#xff1b; &#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x4e00;&#x65e6;&#x88ab;&#x9500;&#x6bc1;&#xff0c;&#x5c31;&#x65e0;&#x6cd5;&#x518d;&#x6b21;&#x4f7f;&#x7528;&#x3002;
   * @param blocking
   *   Whether to block until destroy has completed &#x662f;&#x5426;&#x963b;&#x585e;&#x76f4;&#x5230;&#x9500;&#x6bc1;&#x5b8c;&#x6210;&#x3002;
   */
    void destroy (boolean blocking)  { throw new RuntimeException(); }
  /** Actually destroy all data and metadata related to this broadcast variable.
   * Implementation of Broadcast class must define their own logic to destroy
   * their own state. &#x5b9e;&#x9645;&#x4e0a;&#x9500;&#x6bc1;&#x4e0e;&#x6b64;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x76f8;&#x5173;&#x7684;&#x6240;&#x6709;&#x6570;&#x636e;&#x548c;&#x5143;&#x6570;&#x636e;&#x3002; Broadcast &#x7c7b;&#x7684;&#x5b9e;&#x73b0;&#x5fc5;&#x987b;&#x5b9a;&#x4e49;&#x5176;&#x5404;&#x81ea;&#x9500;&#x6bc1;&#x81ea;&#x8eab;&#x72b6;&#x6001;&#x7684;&#x903b;&#x8f91;&#x3002;
   * @param blocking (undocumented)
   */
  protected abstract  void doDestroy (boolean blocking)  ;
  /** Actually unpersist the broadcasted value on the executors. Concrete
   * implementations of Broadcast class must define their own logic to
   * unpersist their own data. &#x5b9e;&#x9645;&#x4e0a;&#x4ece; Executor &#x4e0a;&#x53d6;&#x6d88;&#x5e7f;&#x64ad;&#x503c;&#x7684;&#x6301;&#x4e45;&#x5316;&#x3002;Broadcast
   * &#x7c7b;&#x7684;&#x5177;&#x4f53;&#x5b9e;&#x73b0;&#x5fc5;&#x987b;&#x5b9a;&#x4e49;&#x5176;&#x5404;&#x81ea;&#x53d6;&#x6d88; &#x6301;&#x4e45;&#x5316;&#x6570;&#x636e;&#x7684;&#x903b;&#x8f91;&#x3002;
   * @param blocking (undocumented)
   */
  protected abstract  void doUnpersist (boolean blocking)  ;
  /** Actually get the broadcasted value. Concrete implementations of Broadcast
   * class must define their own way to get the value. &#x5b9e;&#x9645;&#x83b7;&#x53d6;&#x5e7f;&#x64ad;&#x503c;&#x3002;Broadcast
   * &#x7c7b;&#x7684;&#x5177;&#x4f53;&#x5b9e;&#x73b0;&#x5fc5;&#x987b;&#x5b9a;&#x4e49;&#x5176;&#x5404;&#x81ea;&#x83b7;&#x53d6;&#x8be5;&#x503c;&#x7684;&#x65b9;&#x5f0f;&#x3002;
   * @return (undocumented)
   */
  protected abstract  T getValue ()  ;
  public  long id ()  { throw new RuntimeException(); }
  /** Whether this Broadcast is actually usable. This should be false once
   * persisted state is removed from the driver. &#x6b64;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x662f;&#x5426;&#x5b9e;&#x9645;&#x53ef;&#x7528;&#x3002;&#x4e00;&#x65e6;&#x4ece; Driver
   * &#x4e2d;&#x79fb;&#x9664;&#x6301;&#x4e45;&#x5316;&#x72b6;&#x6001;&#xff0c;&#x6b64;&#x503c;&#x5e94;&#x4e3a; false&#x3002;
   * @return (undocumented)
   */
    boolean isValid ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /** Asynchronously delete cached copies of this broadcast on the executors. If
   * the broadcast is used after this is called, it will need to be re-sent to
   * each executor. &#x5f02;&#x6b65;&#x5730;&#x4ece; Executor &#x4e0a;&#x5220;&#x9664;&#x6b64;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x7684;&#x7f13;&#x5b58;&#x526f;&#x672c;&#x3002; &#x5982;&#x679c;&#x5728;&#x8c03;&#x7528;&#x6b64;&#x65b9;&#x6cd5;&#x540e;&#x4ecd;&#x4f7f;&#x7528;&#x8be5;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#xff0c;&#x5219;&#x9700;&#x8981;&#x5c06;&#x5176;&#x91cd;&#x65b0;&#x53d1;&#x9001;&#x5230;&#x5404;&#x4e2a;
   * Executor&#x3002;
   */
  public  void unpersist ()  { throw new RuntimeException(); }
  /** Delete cached copies of this broadcast on the executors. If the broadcast
   * is used after this is called, it will need to be re-sent to each executor.
   * &#x4ece; Executor &#x4e0a;&#x5220;&#x9664;&#x6b64;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#x7684;&#x7f13;&#x5b58;&#x526f;&#x672c;&#x3002;&#x5982;&#x679c;&#x5728;&#x8c03;&#x7528;&#x6b64;&#x65b9;&#x6cd5;&#x540e;&#x4ecd;&#x4f7f;&#x7528;&#x8be5;&#x5e7f;&#x64ad;&#x53d8;&#x91cf;&#xff0c; &#x5219;&#x9700;&#x8981;&#x5c06;&#x5176;&#x91cd;&#x65b0;&#x53d1;&#x9001;&#x5230;&#x5404;&#x4e2a; Executor&#x3002;
   * @param blocking
   *   Whether to block until unpersisting has completed &#x662f;&#x5426;&#x963b;&#x585e;&#x76f4;&#x5230;&#x53d6;&#x6d88;&#x6301;&#x4e45;&#x5316;&#x5b8c;&#x6210;&#x3002;
   */
  public  void unpersist (boolean blocking)  { throw new RuntimeException(); }
  /** Get the broadcasted value. &#x83b7;&#x53d6;&#x5e7f;&#x64ad;&#x503c;&#x3002;
   * @return (undocumented)
   */
  public  T value ()  { throw new RuntimeException(); }
}
