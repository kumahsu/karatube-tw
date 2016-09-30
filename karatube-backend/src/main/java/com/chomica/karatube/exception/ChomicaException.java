package com.chomica.karatube.exception;

import com.chomica.karatube.constant.StatusCode;

public abstract class ChomicaException extends RuntimeException {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = 4241978163001179904L;
   
   // ---------------------------------------------------------------
   private StatusCode status;
   
   // ---------------------------------------------------------------
   public ChomicaException(StatusCode status, String message) {
      super(message);
      this.status = status;
   }
   
   // ---------------------------------------------------------------
   public StatusCode getStatus() {
      return this.status;
   }
}
