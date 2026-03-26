package org.apache.spark.status.api.v1;
public  interface ApiRequestContext {
  public  jakarta.servlet.http.HttpServletRequest httpRequest ()  ;
  public  jakarta.servlet.ServletContext servletContext ()  ;
  public  org.apache.spark.status.api.v1.UIRoot uiRoot ()  ;
}
