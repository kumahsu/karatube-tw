package com.chomica.karatube.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.chomica.karatube.util.JsonUtil;

@Entity
@Table(name = "song")
public class Song implements IEntity {
   // ---------------------------------------------------------------
   private static final long serialVersionUID = -5959747587393149699L;

   // ---------------------------------------------------------------
   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @Column(name = "song_id", unique = true, nullable = false)
   private String id;
   
   @Column(name = "song_name", nullable = false)
   private String name;
   
   @Column(name = "song_category")
   private int category;
   
   @ManyToOne
   @JoinColumn(name="singer_id")
   private Singer singer;

   // ---------------------------------------------------------------
   @Column(name = "tube_id", nullable = false)
   private String tubeId;
   
   @Column(name = "confirmed", nullable = false)
   private int confirmed;
   
   // ---------------------------------------------------------------
   @Column(name = "create_time", nullable = false)
   private Long createTime;
   
   @Column(name = "last_update_time")
   private Long lastUpdateTime;
   
   // ---------------------------------------------------------------
   public Song() { }
   public Song(String id, String name, int category, Singer singer, String tubeId, int confirmed, Long createTime, Long lastUpdateTime) {
      this.id = id;
      this.name = name;
      this.category = category;
      this.singer = singer;
      this.tubeId = tubeId;
      this.confirmed = confirmed;
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
   public void setCategory(int category) {
      this.category = category;
   }
   public void setSinger(Singer singer) {
      this.singer = singer;
   }
   public void setTubeId(String tubeId) {
      this.tubeId = tubeId;
   }
   public void setConfirmed(int confirmed) {
      this.confirmed = confirmed;
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
   public int getCategory() {
      return category;
   }
   public Singer getSinger() {
      return singer;
   }
   public String getTubeId() {
      return tubeId;
   }
   public int getConfirmed() {
      return confirmed;
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
