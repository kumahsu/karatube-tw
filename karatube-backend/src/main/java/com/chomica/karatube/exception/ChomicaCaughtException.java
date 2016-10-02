package com.chomica.karatube.exception;

import com.chomica.karatube.constant.StatusCode;

public abstract class ChomicaCaughtException extends Exception {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = -2334445126208007543L;

   // ---------------------------------------------------------------
   protected StatusCode status;
   
   // ---------------------------------------------------------------
   public ChomicaCaughtException(StatusCode status, String message) {
      super(message);
      this.status = status;
   }
   
   // ---------------------------------------------------------------
   public StatusCode getStatus() {
      return this.status;
   }
}
