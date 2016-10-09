package com.chomica.karatube.model.http.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvInsertSongReq extends HttpRequest {
   // ---------------------------------------------------------------
   @JsonProperty("song_id")
   private String songId;
   
   // ---------------------------------------------------------------
   public EnvInsertSongReq() { }
   public EnvInsertSongReq(String songId) {
      this.songId = songId;
   }
   
   // ---------------------------------------------------------------
   public void setSongId(String songId) {
      this.songId = songId;
   }
   
   // ---------------------------------------------------------------
   public String getSongId() {
      return this.songId;
   }
   
   // ---------------------------------------------------------------
   @Override
   protected HttpRequest instance() {
      return this;
   }

}
