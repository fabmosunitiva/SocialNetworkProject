package org.unitiva.exception;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResponseObject {
    private String message;

    public ResponseObject() {
    }

    public ResponseObject(String message) {
      this.message = message;
    }
  
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }  }