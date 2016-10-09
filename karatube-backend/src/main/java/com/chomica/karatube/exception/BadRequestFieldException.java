package com.chomica.karatube.exception;

import com.chomica.karatube.constant.StatusCode;

public class BadRequestFieldException extends ChomicaException {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = -8576885421920054881L;
   
   // ---------------------------------------------------------------
   private String fieldName;
   
   // ---------------------------------------------------------------
   private static final String getMessage(String statusMsg, String fieldName) {
      StringBuilder str = new StringBuilder();
      str.append(statusMsg).append(fieldName);
      return str.toString();
   }
   
   // ---------------------------------------------------------------
   public BadRequestFieldException(StatusCode status, String fieldName) {
      super(status, getMessage(status.message(), fieldName));
      this.fieldName = fieldName;
   }
   
   // ---------------------------------------------------------------
   public String getFieldName() {
      return this.fieldName;
   }
}
