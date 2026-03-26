package org.apache.spark.util;
/**
 * This thread pool executor throttles the submission of new tasks by using a semaphore.
 * Task submissions require permits, task completions release permits.
 * <p>
 * NOTE: {@link invoke*} methods are not supported, you should either use the {@link submit} methods
 * or the {@link execute} method.
 * <p>
 * This is inspired by
 * <a href="https://github.com/apache/incubator-retired-s4/blob/0.6.0-Final/subprojects/s4-comm/src/main/java/org/apache/s4/comm/staging/BlockingThreadPoolExecutorService.java">
 * Apache S4 BlockingThreadPoolExecutorService</a>
 */
  class BlockingThreadPoolExecutorService implements java.util.concurrent.ExecutorService {
  public   BlockingThreadPoolExecutorService (int nThreads, int workQueueSize, java.util.concurrent.ThreadFactory threadFactory)  { throw new RuntimeException(); }
  public  boolean awaitTermination (long timeout, java.util.concurrent.TimeUnit unit)  { throw new RuntimeException(); }
  public  void execute (java.lang.Runnable command)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> java.util.List<java.util.concurrent.Future<T>> invokeAll (java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> java.util.List<java.util.concurrent.Future<T>> invokeAll (java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks, long timeout, java.util.concurrent.TimeUnit unit)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> T invokeAny (java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> T invokeAny (java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks, long timeout, java.util.concurrent.TimeUnit unit)  { throw new RuntimeException(); }
  public  boolean isShutdown ()  { throw new RuntimeException(); }
  public  boolean isTerminated ()  { throw new RuntimeException(); }
  public  void shutdown ()  { throw new RuntimeException(); }
  public  java.util.List<java.lang.Runnable> shutdownNow ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> java.util.concurrent.Future<T> submit (java.util.concurrent.Callable<T> task)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> java.util.concurrent.Future<T> submit (java.lang.Runnable task, T result)  { throw new RuntimeException(); }
  public  java.util.concurrent.Future<?> submit (java.lang.Runnable task)  { throw new RuntimeException(); }
}
