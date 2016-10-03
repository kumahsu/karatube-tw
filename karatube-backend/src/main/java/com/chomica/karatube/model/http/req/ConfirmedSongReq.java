package com.chomica.karatube.model.http.req;

public class ConfirmedSongReq extends HttpRequest {
   // ---------------------------------------------------------------
   private int type;
   
   // ---------------------------------------------------------------
   public ConfirmedSongReq() { }
   public ConfirmedSongReq(int type) {
      this.type = type;
   }
   
   // ---------------------------------------------------------------
   public void setType(int type) {
      this.type = type;
   }
   
   // ---------------------------------------------------------------
   public int getType() {
      return this.type;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpRequest instance() {
      return this;
   }

}
