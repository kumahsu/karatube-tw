package com.chomica.karatube.model.http.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectEnvReq extends HttpRequest {
   // ---------------------------------------------------------------
   @JsonProperty("pair_code")
   private String pairCode;
   
   // ---------------------------------------------------------------
   public ConnectEnvReq() { }
   public ConnectEnvReq(String pairCode) {
      this.pairCode = pairCode;
   }
   
   // ---------------------------------------------------------------
   public void setPairCode(String pairCode) {
      this.pairCode = pairCode;
   }
   
   // ---------------------------------------------------------------
   public String getPairCode() {
      return this.pairCode;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpRequest instance() {
      return this;
   }

}
