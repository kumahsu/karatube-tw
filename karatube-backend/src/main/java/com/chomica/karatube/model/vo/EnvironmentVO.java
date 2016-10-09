package com.chomica.karatube.model.vo;

import org.springframework.web.socket.WebSocketSession;

public class EnvironmentVO {
   // ---------------------------------------------------------------
   private String id;
   private String pairCode;
   private PlaylistQueueVO playlist;
   private PlaylistQueueVO history;
   private Boolean isIdle;
   private WebSocketSession session;
   
   // ---------------------------------------------------------------
   public EnvironmentVO(String id, String pairCode, WebSocketSession session) {
      this.id = id;
      this.pairCode = pairCode;
      this.playlist = new PlaylistQueueVO();
      this.history = new PlaylistQueueVO();
      this.isIdle = Boolean.TRUE;
      this.session = session;
   }
   
   // ---------------------------------------------------------------
   public String getId() {
      return this.id;
   }
   public String getPairCode() {
      return this.pairCode;
   }
   public Boolean isIdle() {
      return this.isIdle;
   }
   public WebSocketSession getSession() {
      return this.session;
   }
   public PlaylistQueueVO getPlaylist() {
      return this.playlist;
   }
   public PlaylistQueueVO getHistory() {
      return this.history;
   }

   // ---------------------------------------------------------------
   public void idle() {
      this.isIdle = Boolean.TRUE;
   }
   public void awake() {
      this.isIdle = Boolean.FALSE;
   }
   public void clearPairCode() {
      this.pairCode = null;
   }
   public boolean hasPairCode() {
      return this.pairCode != null;
   }
   public String regenPairCode() {
      //TODO: to implement random pair code
      return "0000";
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      StringBuilder str = new StringBuilder();
      str.append("{")
         .append("\"env_id\":\"").append(this.id).append("\",")
         .append("\"pair_code\":\"").append(this.pairCode).append("\"")
         .append("}");
      return str.toString();
   }
}
