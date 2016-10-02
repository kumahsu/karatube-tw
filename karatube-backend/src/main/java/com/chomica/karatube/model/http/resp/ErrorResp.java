package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;

public class ErrorResp extends HttpResponse {
   // ---------------------------------------------------------------
   public ErrorResp(StatusCode status) {
      super(status);
   }

   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }
}
