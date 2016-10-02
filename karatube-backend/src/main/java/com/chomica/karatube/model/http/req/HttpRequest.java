package com.chomica.karatube.model.http.req;

import com.chomica.karatube.util.JsonUtil;

public abstract class HttpRequest {
   // ---------------------------------------------------------------
   protected abstract HttpRequest instance();
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
