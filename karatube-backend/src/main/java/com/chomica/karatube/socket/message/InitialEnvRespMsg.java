package com.chomica.karatube.socket.message;

import com.chomica.karatube.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InitialEnvRespMsg {
   // ---------------------------------------------------------------
   @JsonProperty("env_id")
   private String envId;
   @JsonProperty("pair_code")
   private String pairCode;
   
   // ---------------------------------------------------------------
   public InitialEnvRespMsg(String envId, String pairCode) {
      this.envId = envId;
      this.pairCode = pairCode;
   }
   
   // ---------------------------------------------------------------
   public String getEnvId() {
      return envId;
   }
   public String getPairCode() {
      return pairCode;
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
