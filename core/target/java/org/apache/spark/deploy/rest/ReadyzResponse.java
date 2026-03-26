package org.apache.spark.deploy.rest;
/**
 * A response to a readyz request in the REST application submission protocol.
 */
  class ReadyzResponse extends org.apache.spark.deploy.rest.SubmitRestProtocolResponse {
  public   ReadyzResponse ()  { throw new RuntimeException(); }
  protected  void doValidate ()  { throw new RuntimeException(); }
}
