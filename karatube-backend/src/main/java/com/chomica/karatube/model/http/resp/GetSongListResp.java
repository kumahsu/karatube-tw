package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.http.SongDetail;

public class GetSongListResp extends HttpResponse {
   // ---------------------------------------------------------------
   private QueryListData<SongDetail> data;
   
   // ---------------------------------------------------------------
   public GetSongListResp(QueryListData<SongDetail> data) {
      super(StatusCode.SUCCESS);
      this.data = data;
   }
   
   // ---------------------------------------------------------------
   public QueryListData<SongDetail> getData() {
      return this.data;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }
}
