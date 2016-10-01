package com.chomica.karatube.model.http;

import com.chomica.karatube.util.JsonUtil;

public class SingerDetail implements IHttpModel {
   // ---------------------------------------------------------------
   private String id;
   private String name;
   private Integer type;
   
   // ---------------------------------------------------------------
   public SingerDetail() { }
   public SingerDetail(String id, String name, Integer type) {
      this.id = id;
      this.name = name;
      this.type = type;
   }
   
   // ---------------------------------------------------------------
   public void setId(String id) {
      this.id = id;
   }
   public void setName(String name) {
      this.name = name;
   }
   public void setType(Integer type) {
      this.type = type;
   }
   
   // ---------------------------------------------------------------
   public String getId() {
      return id;
   }
   public String getName() {
      return name;
   }
   public Integer getType() {
      return type;
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
