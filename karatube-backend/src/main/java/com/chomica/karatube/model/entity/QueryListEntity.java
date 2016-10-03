package com.chomica.karatube.model.entity;

import java.util.List;

import com.chomica.karatube.util.JsonUtil;

public class QueryListEntity<T extends IEntity> {
   // ---------------------------------------------------------------
   private int size;
   private int totalCount;
   private int start;
   private List<T> list;
   
   // ---------------------------------------------------------------
   public QueryListEntity(int size, int totalCount, int start, List<T> list) {
      this.size = size;
      this.totalCount = totalCount;
      this.start = start;
      this.list = list;
   }

   // ---------------------------------------------------------------
   public int getSize() {
      return size;
   }
   public int getTotalCount() {
      return totalCount;
   }
   public int getStart() {
      return start;
   }
   public List<T> getList() {
      return list;
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
