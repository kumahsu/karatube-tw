package com.chomica.karatube.constant;

public enum ConfirmedType {
   // ---------------------------------------------------------------
   NEW(0),
   CONFIREMED(1),
   TO_BE_DELETE(2)
   ;
   
   // ---------------------------------------------------------------
   private int code;
   
   // ---------------------------------------------------------------
   private ConfirmedType(int code) {
      this.code = code;
   }
   
   // ---------------------------------------------------------------
   public int code() {
      return this.code;
   }
   
   // ---------------------------------------------------------------
   public static ConfirmedType getType(int code) {
      for(ConfirmedType type : ConfirmedType.values()) {
         if(type.code == code) {
            return type;
         }
      }
      return null;
   }
}
