package com.chomica.karatube.model.http.resp.data;

import java.util.List;

import com.chomica.karatube.model.http.IHttpModel;
import com.chomica.karatube.util.JsonUtil;

public class QueryListData<T extends IHttpModel> {
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
   public int getStartIndex() {
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
