package com.chomica.karatube.model;

import java.util.List;

import com.chomica.karatube.util.JsonUtil;

public class QueryListData<T> {
   // ---------------------------------------------------------------
   private int size;
   private int totalCount;
   private int startIndex;
   private List<T> list;
   
   // ---------------------------------------------------------------
   public QueryListData() { }
   public QueryListData(int size, int totalCount, int startIndex, List<T> list) {
      this.size = size;
      this.totalCount = totalCount;
      this.startIndex = startIndex;
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
      return startIndex;
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
