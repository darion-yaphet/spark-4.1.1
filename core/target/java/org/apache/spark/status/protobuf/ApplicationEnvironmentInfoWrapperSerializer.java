package org.apache.spark.status.protobuf;
  class ApplicationEnvironmentInfoWrapperSerializer implements org.apache.spark.status.protobuf.ProtobufSerDe<org.apache.spark.status.ApplicationEnvironmentInfoWrapper> {
  public   ApplicationEnvironmentInfoWrapperSerializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.ApplicationEnvironmentInfoWrapper deserialize (byte[] bytes)  { throw new RuntimeException(); }
    org.apache.spark.status.api.v1.ResourceProfileInfo deserializeResourceProfileInfo (org.apache.spark.status.protobuf.StoreTypes.ResourceProfileInfo info)  { throw new RuntimeException(); }
  public  byte[] serialize (org.apache.spark.status.ApplicationEnvironmentInfoWrapper input)  { throw new RuntimeException(); }
    org.apache.spark.status.protobuf.StoreTypes.ResourceProfileInfo serializeResourceProfileInfo (org.apache.spark.status.api.v1.ResourceProfileInfo info)  { throw new RuntimeException(); }
}
