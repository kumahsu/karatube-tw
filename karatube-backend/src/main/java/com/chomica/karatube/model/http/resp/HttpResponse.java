package com.chomica.karatube.model.http.resp;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.util.JsonUtil;

public abstract class HttpResponse {
   // ---------------------------------------------------------------
   protected int status;
   protected String message;
   
   // ---------------------------------------------------------------
   protected HttpResponse(int status, String message) {
      this.status = status;
      this.message = message;
   }
   protected HttpResponse(StatusCode status) {
      this(status.code(), status.message());
   }
   
   // ---------------------------------------------------------------
   public int getStatus() {
      return this.status;
   }
   public String getMessage() {
      return this.message;
   }
   
   // ---------------------------------------------------------------
   protected abstract HttpResponse instance();
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this.instance());
   }
}
