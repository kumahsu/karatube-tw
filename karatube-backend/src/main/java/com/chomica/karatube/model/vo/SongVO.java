package com.chomica.karatube.model.vo;

import com.chomica.karatube.constant.ConfirmedType;
import com.chomica.karatube.constant.SongCategory;
import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.exception.BadRequestFieldException;
import com.chomica.karatube.exception.DebagaError;
import com.chomica.karatube.exception.TypeNotFoundException;
import com.chomica.karatube.model.entity.SongEntity;
import com.chomica.karatube.model.http.SongDetail;
import com.chomica.karatube.util.JsonUtil;
import com.chomica.karatube.util.MergeUtil;

public class SongVO implements IVoModel {
   // ---------------------------------------------------------------
   public class Adaptor implements IAdaptor<SongDetail, SongEntity> {
      // ---------------------------------------------------------------
      private SongVO vo;
      
      // ---------------------------------------------------------------
      private Adaptor(SongVO vo) {
         this.vo = vo;
      }
      
      // ---------------------------------------------------------------
      public SongVO getVO() {
         return this.vo;
      }
      
      // ---------------------------------------------------------------
      @Override
      public SongDetail toHttpModel() {
         return new SongDetail(this.vo.getId(),
                               this.vo.getName(),
                               this.vo.getCategory().code(),
                               this.vo.getSinger().getId(),
                               this.vo.getSinger().getName(),
                               this.vo.getTube_id(),
                               this.vo.getConfirmed().code());
      }
      @Override
      public SongEntity toEntity() {
         return new SongEntity(this.vo.getId(),
                               this.vo.getName(),
                               this.vo.getCategory().code(),
                               this.vo.getSinger().adaptor().toEntity(),
                               this.vo.getTube_id(),
                               this.vo.getConfirmed().code(),
                               this.vo.getCreateTime(),
                               this.vo.getLastUpdateTime());
      }
   }
   
   // ---------------------------------------------------------------
   private String id;
   private String name;
   private SongCategory category;
   private SingerVO singer;
   private String tube_id;
   private ConfirmedType confirmed;
   private Long createTime;
   private Long lastUpdateTime;
   private Adaptor adaptor;
   
   // ---------------------------------------------------------------
   public SongVO(String id, String name, SongCategory category, SingerVO singer, 
                 String tube_id, ConfirmedType confirmed, Long createTime, Long lastUpdateTime) 
   {
      this.id = id;
      this.name = name;
      this.category = category;
      this.singer = singer;
      this.tube_id = tube_id;
      this.confirmed = confirmed;
      this.createTime = createTime;
      this.lastUpdateTime = lastUpdateTime;
      this.adaptor = new Adaptor(this);
   }
   public SongVO(SongDetail detail) {
      this.setId(detail.getId());
      this.setName(detail.getName());
      this.setCategory(detail.getCategory());
      this.setSinger(new SingerVO(detail.getSinger_id(), detail.getSinger_name()));
      this.setTube_id(detail.getTube_id());
      this.setConfirmed(detail.getConfirmed());
      this.setCreateTime(System.currentTimeMillis());
      this.setLastUpdateTime(null);
      this.adaptor = new Adaptor(this);
   }
   public SongVO(SongEntity entity) {
      this.setId(entity.getId());
      this.setName(entity.getName());
      this.setCategory(entity.getCategory());
      this.setSinger(new SingerVO(entity.getSinger()));
      this.setTube_id(entity.getTubeId());
      this.setConfirmed(entity.getConfirmed());
      this.setCreateTime(entity.getCreateTime());
      this.setLastUpdateTime(entity.getLastUpdateTime());
      this.adaptor = new Adaptor(this);
   }
   
   // ---------------------------------------------------------------
   public SongVO merge(SongVO target, boolean update) {
      this.id = MergeUtil.merge(this.id, target.getId());
      this.name = MergeUtil.merge(this.name, target.getName());
      this.category = MergeUtil.merge(this.category, target.getCategory());
      this.singer = this.singer.merge(target.getSinger(), false);
      this.tube_id = MergeUtil.merge(this.tube_id, target.getTube_id());
      this.confirmed = MergeUtil.merge(this.confirmed, target.getConfirmed());
      if(update) {
         if(target.getLastUpdateTime() == null) {
            throw new DebagaError("Update Song but last update time is null");
         }
         this.lastUpdateTime = target.lastUpdateTime;
      }
      return this;
   }
   public SongVO merge(SongVO target) {
      return this.merge(target, false);
   }
   
   // ---------------------------------------------------------------
   private void setId(String id) {
      this.id = id;
   }
   private void setName(String name) {
      this.name = name;
   }
   private void setCategory(Integer category) {
      try {
         this.category = SongCategory.getCategory(category);
      } catch (TypeNotFoundException e) {
         throw new BadRequestFieldException(StatusCode.INVALID_FIELD, "song_category");
      }
   }
   private void setSinger(SingerVO singer) {
      this.singer = singer;
   }
   private void setTube_id(String tube_id) {
      this.tube_id = tube_id;
   }
   private void setConfirmed(Integer confirmed) {
      try {
         this.confirmed = ConfirmedType.getType(confirmed);
      } catch (TypeNotFoundException e) {
         throw new BadRequestFieldException(StatusCode.INVALID_FIELD, "confirmed");
      }
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
   public SongCategory getCategory() {
      return category;
   }
   public SingerVO getSinger() {
      return singer;
   }
   public String getTube_id() {
      return tube_id;
   }
   public ConfirmedType getConfirmed() {
      return confirmed;
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
