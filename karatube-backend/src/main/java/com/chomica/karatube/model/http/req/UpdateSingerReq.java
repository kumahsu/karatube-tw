package com.chomica.karatube.model.http.req;

public class UpdateSingerReq {
   // ---------------------------------------------------------------
   private Integer type;
   private String keywords;
   
   // ---------------------------------------------------------------
   public UpdateSingerReq() { }
   public UpdateSingerReq(Integer type, String keywords) {
      this.type = type;
      this.keywords = keywords;
   }
   
   // ---------------------------------------------------------------
   public void setType(Integer type) {
      this.type = type;
   }
   public void setKeywords(String keywords) {
      this.keywords = keywords;
   }
   
   // ---------------------------------------------------------------
   public Integer getType() {
      return type;
   }
   public String getKeywords() {
      return keywords;
   }
}
