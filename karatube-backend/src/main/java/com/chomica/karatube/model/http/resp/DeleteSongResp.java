package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class DeleteSongResp extends HttpResponse {
   // ---------------------------------------------------------------
   public DeleteSongResp() {
      super(StatusCode.SUCCESS);
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }

}
