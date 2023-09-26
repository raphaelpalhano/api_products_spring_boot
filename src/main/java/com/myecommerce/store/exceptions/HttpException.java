package com.myecommerce.store.exceptions;

import java.util.Date;


public class HttpException extends RuntimeException  {
  private Integer statusCode;
  private Date date;
  private String message;

  public HttpException(String message, Integer statusCode) {
    super(message);
    this.date = new Date();
    this.message = message;
    this.statusCode = statusCode;
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

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}