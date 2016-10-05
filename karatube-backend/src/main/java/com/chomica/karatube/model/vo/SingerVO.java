package com.chomica.karatube.model.vo;

import com.chomica.karatube.constant.SingerType;
import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.exception.BadRequestFieldException;
import com.chomica.karatube.exception.DebagaError;
import com.chomica.karatube.exception.TypeNotFoundException;
import com.chomica.karatube.model.entity.SingerEntity;
import com.chomica.karatube.model.http.SingerDetail;
import com.chomica.karatube.util.JsonUtil;
import com.chomica.karatube.util.MergeUtil;

public class SingerVO implements IVoModel{
   // ---------------------------------------------------------------
   public class Adaptor implements IAdaptor<SingerDetail, SingerEntity> {
      private SingerVO vo;
      
      // ---------------------------------------------------------------
      private Adaptor(SingerVO vo) {
         this.vo = vo;
      }
      
      // ---------------------------------------------------------------
      public SingerVO getVO() {
         return this.vo;
      }
      
      // ---------------------------------------------------------------
      @Override
      public SingerDetail toHttpModel() {
         return new SingerDetail(this.vo.getId(),
                                 this.vo.getName(), 
                                 this.vo.getType().code(), 
                                 this.vo.getKeywords());
      }
      @Override
      public SingerEntity toEntity() {
         return new SingerEntity(this.vo.getId(), 
                                 this.vo.getName(), 
                                 this.vo.getType().code(),
                                 this.vo.getKeywords(),
                                 this.vo.getCreateTime(), 
                                 this.vo.getLastUpdateTime());
      }
   }
   
   // ---------------------------------------------------------------
   private String id;
   private String name;
   private SingerType type;
   private String keywords;
   private Long createTime;
   private Long lastUpdateTime;
   private Adaptor adaptor;
   
   // ---------------------------------------------------------------
   public SingerVO(String id, String name, SingerType type, String keywords, Long createTime, Long lastUpdateTime) {
      this.id = id;
      this.name = name;
      this.type = type;
      this.keywords = keywords;
      this.createTime = createTime;
      this.lastUpdateTime = lastUpdateTime;
      this.adaptor = new Adaptor(this);
   }
   SingerVO(String id, String name) {
      this(id, name, null, null, null, null);
   }
   public SingerVO(SingerDetail detail) {
      this.setId(detail.getId());
      this.setName(detail.getName());
      this.setType(detail.getType());
      this.setKeywords(detail.getKeywords());
      this.setCreateTime(System.currentTimeMillis());
      this.setLastUpdateTime(null);
      this.adaptor = new Adaptor(this);
   }
   public SingerVO(SingerEntity entity) {
      this.setId(entity.getId());
      this.setName(entity.getName());
      this.setType(entity.getType());
      this.setKeywords(entity.getKeywords());
      this.setCreateTime(entity.getCreateTime());
      this.setLastUpdateTime(entity.getLastUpdateTime());
      this.adaptor = new Adaptor(this);
   }
   
   // ---------------------------------------------------------------
   public SingerVO merge(SingerVO target, boolean update) {
      this.id = MergeUtil.merge(this.id, target.getId());
      this.name = MergeUtil.merge(this.name, target.getName());
      this.type = MergeUtil.merge(this.type, target.getType());
      this.keywords = MergeUtil.merge(this.keywords, target.getKeywords());
      if(update) {
         if(target.getLastUpdateTime() == null) {
            throw new DebagaError("Update Singer but last update time is null");
         }
         this.lastUpdateTime = target.getLastUpdateTime();
      }
      return this;
   }
   public SingerVO merge(SingerVO target) {
      return this.merge(target, false);
   }
   
   // ---------------------------------------------------------------
   private void setId(String id) {
      this.id = id;
   }
   private void setName(String name) {
      this.name = name;
   }
   private void setType(Integer type) {
      try {
         this.type = SingerType.getType(type);
      } catch (TypeNotFoundException e) {
         throw new BadRequestFieldException(StatusCode.INVALID_FIELD, "singer_type");
      }
   }
   private void setKeywords(String keywords) {
      this.keywords = keywords;
   }
   private void setCreateTime(Long createTime) {
      this.createTime = createTime;
   }
   private void setLastUpdateTime(Long lastUpdateTime) {
      this.lastUpdateTime = lastUpdateTime;
   }

   // ---------------------------------------------------------------
   public String getId() {
      return id;
   }
   public String getName() {
      return name;
   }
   public SingerType getType() {
      return type;
   }
   public String getKeywords() {
      return keywords;
   }
   public Long getCreateTime() {
      return createTime;
   }
   public Long getLastUpdateTime() {
      return lastUpdateTime;
   }
   public Adaptor adaptor() {
      return this.adaptor;
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
