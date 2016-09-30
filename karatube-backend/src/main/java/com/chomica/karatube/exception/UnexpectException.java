package com.chomica.karatube.exception;

import com.chomica.karatube.constant.StatusCode;

public class UnexpectException extends ChomicaException {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = -1134740218482176799L;

   // ---------------------------------------------------------------
   public UnexpectException(StatusCode status, String message) {
      super(status, message);
   }
}
