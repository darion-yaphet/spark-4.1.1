package org.apache.spark.util;
/**
 * A lock-free implementation of a lazily-initialized variable.
 * If there are concurrent initializations then the <code>compute()</code> function may be invoked
 * multiple times. However, only a single <code>compute()</code> result will be stored and all readers
 * will receive the same result object instance.
 * <p>
 * This may be helpful for avoiding deadlocks in certain scenarios where exactly-once
 * value computation is not a hard requirement.
 * <p>
 * @note
 * This helper class has additional requirements on the compute function:
 *   1) The compute function MUST not return null;
 *   2) The computation failure is not cached.
 * <p>
 * @note
 *   Scala 3 uses a different implementation of lazy vals which doesn't have this problem.
 *   Please refer to <a
 *   href="https://docs.scala-lang.org/scala3/reference/changed-features/lazy-vals-init.html">Lazy
 *   Vals Initialization</a> for more details.
 */
  class BestEffortLazyVal<T extends java.lang.Object> implements java.io.Serializable {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree().setOriginal(Select(Ident(scala), TypeName("AnyRef")))))
  public   BestEffortLazyVal (scala.Function0<T> compute)  { throw new RuntimeException(); }
  public  T apply ()  { throw new RuntimeException(); }
}
