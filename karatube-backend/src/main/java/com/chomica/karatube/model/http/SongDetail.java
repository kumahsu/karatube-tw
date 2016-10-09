package com.chomica.karatube.model.http;

import com.chomica.karatube.util.JsonUtil;

public class SongDetail implements IHttpModel {
   // ---------------------------------------------------------------
   private String id;
   private String name;
   private int category;
   private String singer_id;
   private String singer_name;
   private String tube_id;
   private int confirmed;
   
   // ---------------------------------------------------------------
   public SongDetail() { }
   public SongDetail(String id, String name, int category, String singer_id, 
                     String singer_name, String tube_id, int confirmed) 
   {
      this.id = id;
      this.name = name;
      this.category = category;
      this.singer_id = singer_id;
      this.singer_name = singer_name;
      this.tube_id = tube_id;
      this.confirmed = confirmed;
   }
   
   // ---------------------------------------------------------------
   public void setId(String id) {
      this.id = id;
   }
   public void setName(String name) {
      this.name = name;
   }
   public void setCategory(int category) {
      this.category = category;
   }
   public void setSinger_id(String singer_id) {
      this.singer_id = singer_id;
   }
   public void setSinger_name(String singer_name) {
      this.singer_name = singer_name;
   }
   public void setTube_id(String tube_id) {
      this.tube_id = tube_id;
   }
   public void setConfirmed(int confirmed) {
      this.confirmed = confirmed;
   }
   
   // ---------------------------------------------------------------
   public String getId() {
      return id;
   }
   public String getName() {
      return name;
   }
   public int getCategory() {
      return category;
   }
   public String getSinger_id() {
      return singer_id;
   }
   public String getSinger_name() {
      return singer_name;
   }
   public String getTube_id() {
      return tube_id;
   }
   public int getConfirmed() {
      return confirmed;
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
