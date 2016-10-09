package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectEnvResp extends HttpResponse {
   // ---------------------------------------------------------------
   @JsonProperty("env_id")
   private String envId;
   
   // ---------------------------------------------------------------
   public ConnectEnvResp(String envId) {
      super(StatusCode.SUCCESS);
      this.envId = envId;
   }
   
   // ---------------------------------------------------------------
   public void setEnvId(String envId) {
      this.envId = envId;
   }
   
   // ---------------------------------------------------------------
   public String getEnvId() {
      return this.envId;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }

}
