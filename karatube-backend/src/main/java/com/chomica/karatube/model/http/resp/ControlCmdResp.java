package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class ControlCmdResp extends HttpResponse {
   // ---------------------------------------------------------------
   public ControlCmdResp() {
      super(StatusCode.SUCCESS);
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }

}
