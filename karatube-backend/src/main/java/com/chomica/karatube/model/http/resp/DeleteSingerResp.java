package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class DeleteSingerResp extends HttpResponse {
   // ---------------------------------------------------------------
   public DeleteSingerResp() {
      super(StatusCode.SUCCESS);
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }

}
