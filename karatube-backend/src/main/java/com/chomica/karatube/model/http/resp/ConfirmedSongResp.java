package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.model.http.SongDetail;

public class ConfirmedSongResp extends HttpResponse {
   // ---------------------------------------------------------------
   private SongDetail data;
   
   // ---------------------------------------------------------------
   public ConfirmedSongResp(SongDetail data) {
      super(StatusCode.SUCCESS);
      this.data = data;
   }
   
   // ---------------------------------------------------------------
   public SongDetail getData() {
      return this.data;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }
}
