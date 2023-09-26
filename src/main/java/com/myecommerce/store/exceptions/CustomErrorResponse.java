package com.myecommerce.store.exceptions;

import java.util.Date;

public class CustomErrorResponse {

  private String message;
  private Integer statusCode;
  private Date date;
  
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public CustomErrorResponse(String message, Integer statusCode, Date date) {
    this.date = date;
    this.message = message;
    this.statusCode = statusCode;
  }
}
