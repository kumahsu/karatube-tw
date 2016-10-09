package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class EnvInsertSongResp extends HttpResponse {
   // ---------------------------------------------------------------
   public EnvInsertSongResp() {
      super(StatusCode.SUCCESS);
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }

}
