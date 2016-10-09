package com.chomica.karatube.constant;

import com.chomica.karatube.exception.TypeNotFoundException;

public enum ConfirmedType {
   // ---------------------------------------------------------------
   NEW(0),
   CONFIREMED(1),
   FAKE(2)
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
   public static ConfirmedType getType(int code) throws TypeNotFoundException {
      for(ConfirmedType type : ConfirmedType.values()) {
         if(type.code == code) {
            return type;
         }
      }
      throw new TypeNotFoundException("ConfirmedType", code);
   }
}
