package com.chomica.karatube.model.http.req;

import com.chomica.karatube.util.JsonUtil;

public class EchoReq {
   // ---------------------------------------------------------------
   private String message;
   
   // ---------------------------------------------------------------
   public EchoReq() { }
   public EchoReq(String message) {
      this.message = message;
   }
   
   // ---------------------------------------------------------------
   public void setMessage(String message) {
      this.message = message;
   }
   
   // ---------------------------------------------------------------
   public String getMessage() {
      return this.message;
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
