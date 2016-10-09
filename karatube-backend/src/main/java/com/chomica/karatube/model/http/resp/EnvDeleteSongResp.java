package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class EnvDeleteSongResp extends HttpResponse {
   // ---------------------------------------------------------------
   public EnvDeleteSongResp() {
      super(StatusCode.SUCCESS);
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }

}
