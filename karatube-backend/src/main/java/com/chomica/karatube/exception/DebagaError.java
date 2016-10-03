package com.chomica.karatube.exception;

import com.chomica.karatube.constant.StatusCode;

public class DebagaError extends ChomicaException {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = 1266214751321681598L;

   // ---------------------------------------------------------------
   public DebagaError(String message) {
      super(StatusCode.SYSTEM_RUNTIME_ERROR, message);
   }
}
