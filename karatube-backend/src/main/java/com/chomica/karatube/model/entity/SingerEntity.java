package com.chomica.karatube.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.chomica.karatube.util.JsonUtil;

@Entity
@Table(name = "singer")
public class SingerEntity implements IEntity {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = 702721159397293077L;

   // ---------------------------------------------------------------
   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @Column(name = "singer_id", unique = true, nullable = false)
   private String id;
   
   @Column(name = "singer_name", nullable = false)
   private String name;
   
   @Column(name = "singer_type")
   private int type;
   
   @Column(name = "keywords", nullable = true)
   private String keywords;

   // ---------------------------------------------------------------
   @Column(name = "create_time", nullable = false)
   private Long createTime;
   
   @Column(name = "last_update_time", nullable = true)
   private Long lastUpdateTime;
   
   // ---------------------------------------------------------------
   public SingerEntity() { }
   public SingerEntity(String id, String name, int type, String keywords, Long createTime, Long lastUpdateTime) {
      this.id = id;
      this.name = name;
      this.type = type;
      this.keywords = keywords;
      this.createTime = createTime;
      this.lastUpdateTime = lastUpdateTime;
   }
   
   // ---------------------------------------------------------------
   public void setId(String id) {
      this.id = id;
   }
   public void setName(String name) {
      this.name = name;
   }
   public void setType(int type) {
      this.type = type;
   }
   public void setKeywords(String keywords) {
      this.keywords = keywords;
   }
   public void setCreateTime(Long createTime) {
      this.createTime = createTime;
   }
   public void setLastUpdateTime(Long lastUpdateTime) {
      this.lastUpdateTime = lastUpdateTime;
   }
   
   // ---------------------------------------------------------------
   public String getId() {
      return id;
   }
   public String getName() {
      return name;
   }
   public int getType() {
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
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
