package com.chomica.karatube.model.http.req;

public class CreateSingerReq extends HttpRequest {
   // ---------------------------------------------------------------
   private String name;
   private Integer type;
   private String keywords;
   
   // ---------------------------------------------------------------
   public CreateSingerReq() { }
   public CreateSingerReq(String name, Integer type, String keywords) {
      this.name = name;
      this.type = type;
      this.keywords = keywords;
   }
   
   // ---------------------------------------------------------------
   public void setName(String name) {
      this.name = name;
   }
   public void setType(Integer type) {
      this.type = type;
   }
   public void setKeywords(String keywords) {
      this.keywords = keywords;
   }
   
   // ---------------------------------------------------------------
   public String getName() {
      return name;
   }
   public Integer getType() {
      return type;
   }
   public String getKeywords() {
      return keywords;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpRequest instance() {
      return this;
   }
}
