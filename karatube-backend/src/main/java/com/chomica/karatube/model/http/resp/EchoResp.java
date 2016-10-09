package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class EchoResp extends HttpResponse {
   // ---------------------------------------------------------------
   private String data;
   
   // ---------------------------------------------------------------
   public EchoResp(String data) {
      super(StatusCode.SUCCESS);
      this.data = data;
   }
   
   // ---------------------------------------------------------------
   public String getData() {
      return this.data;
   }

   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }
}
