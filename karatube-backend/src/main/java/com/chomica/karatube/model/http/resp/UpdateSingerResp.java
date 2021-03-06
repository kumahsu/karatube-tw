package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.model.http.SingerDetail;

public class UpdateSingerResp extends HttpResponse {
   // ---------------------------------------------------------------
   private SingerDetail data;
   
   // ---------------------------------------------------------------
   public UpdateSingerResp(SingerDetail data) {
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
