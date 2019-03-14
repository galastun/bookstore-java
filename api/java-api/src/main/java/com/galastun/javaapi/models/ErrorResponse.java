package com.galastun.javaapi.models;

import java.util.HashMap;

public class ErrorResponse {
  private int code;
  private String message;

  public ErrorResponse(int _code, String _message) {
    code = _code;
    message = _message;
  }

  public HashMap<String, Object> toJson() {
    HashMap<String, Object> error = new HashMap<>();
    HashMap<String, Object> details = new HashMap<>();

    details.put("code", code);
    details.put("message", message);

    error.put("error", details);
    return error;
  }
}