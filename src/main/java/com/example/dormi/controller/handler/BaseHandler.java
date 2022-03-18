package com.example.dormi.controller.handler;

import javax.servlet.http.HttpServletRequest;

public class BaseHandler {

  protected HttpServletRequest request;

  boolean emptyParam(String str) {
    if(str == null || str.isEmpty()) {
      return true;
    }
    return false;
  }

  boolean emptyParam(int v) {
    if(v == 0) {
      return true;
    }
    return false;
  }

  boolean emptyParam(long v) {
    if(v == 0) {
      return true;
    }
    return false;
  }

  boolean emptyParam(double v) {
    if(v == 0) {
      return true;
    }
    return false;
  }

  public void setHttpServletRequest(HttpServletRequest request) {
    this.request = request;
  }
}
