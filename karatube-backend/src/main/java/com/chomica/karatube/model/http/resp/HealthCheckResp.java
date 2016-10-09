package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class HealthCheckResp extends HttpResponse {
   // ---------------------------------------------------------------
   public HealthCheckResp() {
      super(StatusCode.SUCCESS);
   }

   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }
}
