package com.chomica.karatube.model.vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.exception.BadRequestFieldException;
import com.chomica.karatube.util.JsonUtil;

public class PlaylistQueueVO {
   // ---------------------------------------------------------------
   private List<SongVO> songs;
   
   // ---------------------------------------------------------------
   public PlaylistQueueVO() {
      this.songs = new ArrayList<SongVO>();
   }
   
   // ---------------------------------------------------------------
   public List<SongVO> getSongs() {
      List<SongVO> result = new LinkedList<SongVO>();
      result.addAll(this.songs);
      return result;
   }
   public List<SongVO> getSongs(Integer index, Integer size) {
      int start = 0;
      if(index != null) {
         start = index.intValue();
         if(start >= this.songs.size()) {
            throw new BadRequestFieldException(StatusCode.INVALID_FIELD, "index");
         }
      }
      int to = this.songs.size();
      if(size != null) {
         int last = start + to;
         if(last < to) {
            to = last;
         }
      }
      List<SongVO> result = this.songs.subList(start, to);
      return result;
   }
   
   // ---------------------------------------------------------------   
   public void push(SongVO song) {
      this.songs.add(song);
   }
   public SongVO peek() {
      return this.songs.get(0);
   }
   public SongVO pop() {
      if(this.songs.isEmpty()) {
         return null;
      }
      return this.songs.remove(0);
   }

   // ---------------------------------------------------------------
   public boolean remove(String songId) {
      for(SongVO song : this.songs) {
         if(song.getId().equals(songId)) {
            this.songs.remove(this.songs.indexOf(song));
            return true;
         }
      }
      return false;
   }
   public boolean insert(String songId) {
      for(SongVO song : this.songs) {
         if(song.getId().equals(songId)) {
            this.songs.remove(this.songs.indexOf(song));
            this.songs.add(0, song);
            return true;
         }
      }
      return false;
   }
   
   // ---------------------------------------------------------------
   public boolean hasNex() {
      return this.songs.iterator().hasNext();
   }
   public boolean isEmpty() {
      return this.songs.isEmpty();
   }
   public int size() {
      return this.songs.size();
   }
   
   // ---------------------------------------------------------------
   @Override
   public String toString() {
      return JsonUtil.writeObjectToJson(this);
   }
}
