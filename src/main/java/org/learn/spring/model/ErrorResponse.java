package org.learn.spring.model;

public class ErrorResponse {

  private String message;

  public String getMessage() { return message; }

  public void setMessage(String message) { this.message = message; }

  public static ErrorResponse of(String message){
    return new ErrorResponse(){{
      setMessage(message);
    }};
  }
}
