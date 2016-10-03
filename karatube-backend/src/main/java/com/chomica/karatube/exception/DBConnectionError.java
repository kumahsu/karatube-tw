package com.chomica.karatube.exception;

import com.chomica.karatube.constant.StatusCode;

public class DBConnectionError extends ChomicaException {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = 676828187940939302L;
   
   // ---------------------------------------------------------------
   private Exception origin;
   
   // ---------------------------------------------------------------
   public DBConnectionError(String message, Exception origin) {
      super(StatusCode.DB_CONNECTION_ERROR, message);
      this.origin = origin;
   }
   
   // ---------------------------------------------------------------
   public Exception getOriginException() {
      return this.origin;
   }
}
