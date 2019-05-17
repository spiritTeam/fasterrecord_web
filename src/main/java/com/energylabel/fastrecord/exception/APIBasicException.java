package com.energylabel.fastrecord.exception;

public class APIBasicException extends RuntimeException {
  /**
   * 
   */
  private static final long serialVersionUID = 8898398969931487136L;
  private String code;
  private String message;

  public APIBasicException(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public APIBasicException(String code, String message, Throwable e) {
    super(message, e);
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
