package org.apache.spark.deploy.master;
public  interface MasterMessages extends java.io.Serializable {
  static public  class ElectedLeader$ implements scala.Product, java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ElectedLeader$ MODULE$ = null;
    public   ElectedLeader$ ()  { throw new RuntimeException(); }
  }
  static public  class RevokedLeadership$ implements scala.Product, java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final RevokedLeadership$ MODULE$ = null;
    public   RevokedLeadership$ ()  { throw new RuntimeException(); }
  }
  static public  class CheckForWorkerTimeOut$ implements scala.Product, java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final CheckForWorkerTimeOut$ MODULE$ = null;
    public   CheckForWorkerTimeOut$ ()  { throw new RuntimeException(); }
  }
  static public  class BeginRecovery implements scala.Product, java.io.Serializable {
    public  scala.collection.immutable.Seq<org.apache.spark.deploy.master.ApplicationInfo> storedApps ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Seq<org.apache.spark.deploy.master.WorkerInfo> storedWorkers ()  { throw new RuntimeException(); }
    // not preceding
    public   BeginRecovery (scala.collection.immutable.Seq<org.apache.spark.deploy.master.ApplicationInfo> storedApps, scala.collection.immutable.Seq<org.apache.spark.deploy.master.WorkerInfo> storedWorkers)  { throw new RuntimeException(); }
  }
  static public  class BeginRecovery$ extends scala.runtime.AbstractFunction2<scala.collection.immutable.Seq<org.apache.spark.deploy.master.ApplicationInfo>, scala.collection.immutable.Seq<org.apache.spark.deploy.master.WorkerInfo>, org.apache.spark.deploy.master.MasterMessages.BeginRecovery> implements java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final BeginRecovery$ MODULE$ = null;
    public   BeginRecovery$ ()  { throw new RuntimeException(); }
  }
  static public  class CompleteRecovery$ implements scala.Product, java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final CompleteRecovery$ MODULE$ = null;
    public   CompleteRecovery$ ()  { throw new RuntimeException(); }
  }
  static public  class BoundPortsRequest$ implements scala.Product, java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final BoundPortsRequest$ MODULE$ = null;
    public   BoundPortsRequest$ ()  { throw new RuntimeException(); }
  }
  static public  class BoundPortsResponse implements scala.Product, java.io.Serializable {
    public  int rpcEndpointPort ()  { throw new RuntimeException(); }
    public  int webUIPort ()  { throw new RuntimeException(); }
    public  scala.Option<java.lang.Object> restPort ()  { throw new RuntimeException(); }
    // not preceding
    public   BoundPortsResponse (int rpcEndpointPort, int webUIPort, scala.Option<java.lang.Object> restPort)  { throw new RuntimeException(); }
  }
  static public  class BoundPortsResponse$ extends scala.runtime.AbstractFunction3<java.lang.Object, java.lang.Object, scala.Option<java.lang.Object>, org.apache.spark.deploy.master.MasterMessages.BoundPortsResponse> implements java.io.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final BoundPortsResponse$ MODULE$ = null;
    public   BoundPortsResponse$ ()  { throw new RuntimeException(); }
  }
}
