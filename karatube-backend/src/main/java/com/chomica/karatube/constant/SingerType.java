package com.chomica.karatube.constant;

import com.chomica.karatube.exception.TypeNotFoundException;

public enum SingerType {
   // ---------------------------------------------------------------
   UNDEFINE(0),
   MALE(1),
   FEMALE(2),
   GROUP(3),
   DUET(4)
   ;
   // ---------------------------------------------------------------
   private int code;
   
   // ---------------------------------------------------------------
   private SingerType(int code) {
      this.code = code;
   }
   
   // ---------------------------------------------------------------
   public int code() {
      return this.code;
   }
   
   // ---------------------------------------------------------------
   public static SingerType getType(int code) throws TypeNotFoundException {
      for(SingerType type : SingerType.values()) {
         if(type.code == code) {
            return type;
         }
      }
      throw new TypeNotFoundException("SingerType", code);
   }
}
