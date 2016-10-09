package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class EnvAddSongResp extends HttpResponse {
   // ---------------------------------------------------------------
   public EnvAddSongResp() {
      super(StatusCode.SUCCESS);
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }
}
