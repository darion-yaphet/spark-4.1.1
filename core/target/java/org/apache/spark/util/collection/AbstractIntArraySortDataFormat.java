package org.apache.spark.util.collection;
public abstract class AbstractIntArraySortDataFormat<K extends java.lang.Object> extends org.apache.spark.util.collection.SortDataFormat<K, int[]> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   AbstractIntArraySortDataFormat ()  { throw new RuntimeException(); }
  /** Allocates a new structure that can hold up to 'length' elements. */
  public  int[] allocate (int length)  { throw new RuntimeException(); }
  public  void copyElement (int[] src, int srcPos, int[] dst, int dstPos)  { throw new RuntimeException(); }
  /** Copy a range of elements starting at src(srcPos) to dest, starting at destPos. */
  public  void copyRange (int[] src, int srcPos, int[] dst, int dstPos, int length)  { throw new RuntimeException(); }
  public  void swap (int[] data, int pos0, int pos1)  { throw new RuntimeException(); }
}
