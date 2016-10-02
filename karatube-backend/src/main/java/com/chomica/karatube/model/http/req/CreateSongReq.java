package com.chomica.karatube.model.http.req;

public class CreateSongReq extends HttpRequest {
   // ---------------------------------------------------------------
   private String name;
   private int category;
   private String singer_id;
   private String tube_id;
   
   // ---------------------------------------------------------------
   public CreateSongReq() { }
   public CreateSongReq(String name, int category, String singer_id, String tube_id) {
      this.name = name;
      this.category = category;
      this.singer_id = singer_id;
      this.tube_id = tube_id;
   }
   
   // ---------------------------------------------------------------
   public void setName(String name) {
      this.name = name;
   }
   public void setCategory(int category) {
      this.category = category;
   }
   public void setSinger_id(String singer_id) {
      this.singer_id = singer_id;
   }
   public void setTube_id(String tube_id) {
      this.tube_id = tube_id;
   }
   
   // ---------------------------------------------------------------
   public String getName() {
      return name;
   }
   public int getCategory() {
      return category;
   }
   public String getSinger_id() {
      return singer_id;
   }
   public String getTube_id() {
      return tube_id;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpRequest instance() {
      return this;
   }
}
