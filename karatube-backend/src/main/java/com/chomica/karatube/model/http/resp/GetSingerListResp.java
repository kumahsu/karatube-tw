package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.http.SingerDetail;

public class GetSingerListResp extends HttpResponse {
   // ---------------------------------------------------------------
   private QueryListData<SingerDetail> data;
   
   public GetSingerListResp(QueryListData<SingerDetail> data) {
      super(StatusCode.SUCCESS);
      this.data = data;
   }
   
   // ---------------------------------------------------------------
   public QueryListData<SingerDetail> getData() {
      return this.data;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpResponse instance() {
      return this;
   }
}
