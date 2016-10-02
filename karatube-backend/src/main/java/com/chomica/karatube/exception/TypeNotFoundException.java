package com.chomica.karatube.exception;

import com.chomica.karatube.constant.StatusCode;

public class TypeNotFoundException extends ChomicaCaughtException {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = 844074600719491132L;

   // ---------------------------------------------------------------
   private static String getMessage(String typeName, int typeCode) {
      StringBuilder str = new StringBuilder();
      str.append("Can not find ").append(typeName).append(" by code: ").append(typeCode);
      return str.toString();
   }
   
   // ---------------------------------------------------------------
   private String typeName;
   private int typeCode;
   
   // ---------------------------------------------------------------
   public TypeNotFoundException(String typeName, int typeCode) {
      super(StatusCode.TYPE_NOT_FOUND, getMessage(typeName, typeCode));
      this.typeName = typeName;
      this.typeCode = typeCode;
   }
   
   // ---------------------------------------------------------------
   public String typeName() {
      return this.typeName;
   }
   public int typeCode() {
      return this.typeCode;
   }
}
