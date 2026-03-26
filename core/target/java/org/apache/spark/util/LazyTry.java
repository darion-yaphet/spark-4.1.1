package org.apache.spark.util;
/**
 * Wrapper utility for a lazy val, with two differences compared to scala behavior:
 * <p>
 * 1. Non-retrying in case of failure. This wrapper stores the exception in a Try, and will re-throw
 *    it on the access to <code>get</code>.
 *    In scala, when a <code>lazy val</code> field initialization throws an exception, the field remains
 *    uninitialized, and initialization will be re-attempted on the next access. This also can lead
 *    to performance issues, needlessly computing something towards a failure, and also can lead to
 *    duplicated side effects.
 * <p>
 * 2. Resolving locking issues.
 *    In scala, when a <code>lazy val</code> field is initialized, it grabs the synchronized lock on the
 *    enclosing object instance. This can lead both to performance issues, and deadlocks.
 *    For example:
 *     a) Thread 1 entered a synchronized method, grabbing a coarse lock on the parent object.
 *     b) Thread 2 get spawned off, and tries to initialize a lazy value on the same parent object
 *        This causes scala to also try to grab a lock on the parent object.
 *     c) If thread 1 waits for thread 2 to join, a deadlock occurs.
 *    This wrapper will only grab a lock on the wrapper itself, and not the parent object.
 * <p>
 * param:  initialize The block of code to initialize the lazy value.
 * @param <T>  type of the lazy value.
 */
  class LazyTry<T extends java.lang.Object> implements java.io.Serializable {
  /**
   * Create a new LazyTry instance.
   * <p>
   * @param initialize The block of code to initialize the lazy value.
   * @tparam T type of the lazy value.
   * @return a new LazyTry instance.
   */
  static public <T extends java.lang.Object> org.apache.spark.util.LazyTry<T> apply (scala.Function0<T> initialize)  { throw new RuntimeException(); }
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   LazyTry (scala.Function0<T> initialize)  { throw new RuntimeException(); }
  /**
   * Get the lazy value. If the initialization block threw an exception, it will be re-thrown here.
   * The exception will be re-thrown with the current caller's stacktrace.
   * An exception with stack trace from when the exception was first thrown can be accessed with
   * <code></code><code>
   * ex.getSuppressed.find { e =&gt;
   *   e.getMessage == org.apache.spark.util.Utils.TRY_WITH_CALLER_STACKTRACE_FULL_STACKTRACE
   * }
   * </code><code></code>
   * @return (undocumented)
   */
  public  T get ()  { throw new RuntimeException(); }
}
