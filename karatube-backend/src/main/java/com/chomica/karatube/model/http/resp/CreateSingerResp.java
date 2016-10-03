package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.model.http.SingerDetail;

public class CreateSingerResp extends HttpResponse {
   // ---------------------------------------------------------------
   private SingerDetail data;
   
   // ---------------------------------------------------------------
   public CreateSingerResp(SingerDetail data) {
      super(StatusCode.SUCCESS);
      this.data = data;
   }
   
   // ---------------------------------------------------------------
   public SingerDetail getData() {
      return this.data;
   }

   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }
}
