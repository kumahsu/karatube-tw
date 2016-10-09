package com.chomica.karatube.model.http.req;

public class EchoReq extends HttpRequest {
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
   protected HttpRequest instance() {
      return this;
   }
}
