package com.chomica.karatube.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chomica.karatube.constant.ConfirmedType;
import com.chomica.karatube.constant.SongCategory;
import com.chomica.karatube.constant.StatusCode;
import com.chomica.karatube.dao.ISongDAO;
import com.chomica.karatube.exception.BadRequestFieldException;
import com.chomica.karatube.exception.TypeNotFoundException;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.entity.SongEntity;
import com.chomica.karatube.model.vo.SongVO;
import com.chomica.karatube.service.ISongService;

public class SongService implements ISongService {
   // ---------------------------------------------------------------
   @Autowired
   @Qualifier("songDao")
   private ISongDAO songDao;
   
   // ---------------------------------------------------------------
   @Override
   public SongVO createSong(SongVO song) {
      return new SongVO(this.songDao.save(song
            .adaptor().toEntity()));
   }

   @Override
   public SongVO updateSong(SongVO song) {
      return new SongVO(this.songDao.save(song.adaptor().toEntity()));
   }
   
   @Override
   public SongVO confirmedSong(SongVO song, Integer confirmed) {
      if(confirmed == null) {
         throw new BadRequestFieldException(StatusCode.MISSING_FIELD, "confirmed");
      }
      ConfirmedType _confirmed = null;
      try {
         _confirmed = ConfirmedType.getType(confirmed);
      } catch (TypeNotFoundException e) {
         throw new BadRequestFieldException(StatusCode.INVALID_FIELD, "confirmed");
      }
      SongVO target = new SongVO(null, null, null, null, null, _confirmed, null, null);
      song = song.merge(target);
      return new SongVO(this.songDao.save(song.adaptor().toEntity()));
   }

   @Override
   public void deleteSong(String song_id) {
      this.songDao.delete(this.songDao.findById(song_id));
   }

   @Override
   public SongVO findSongById(String song_id) {
      return new SongVO(this.songDao.findById(song_id));
   }

   // ---------------------------------------------------------------
   private QueryListData<SongVO> adaptor(QueryListData<SongEntity> result) {
      List<SongVO> list = new LinkedList<SongVO>();
      for(SongEntity entity : result.getList()) {
         list.add(new SongVO(entity));
      }
      return new QueryListData<SongVO>(result.getSize(), result.getTotalCount(), result.getStart(), list);
   }
   
   // ---------------------------------------------------------------
   @Override
   public QueryListData<SongVO> findSongsBySingerId(Integer start,
                                                    Integer size,
                                                    String singer_id)
   {
      QueryListData<SongEntity> result = this.songDao.findSongsBySinger(start, size, singer_id);
      return this.adaptor(result);
   }

   @Override
   public QueryListData<SongVO> findSongsByCondition(Integer start, Integer size, Integer category, String name) {
      QueryListData<SongEntity> result;
      if(category == null) {
         result = this.songDao.findSongsByName(start, size, name);
      }
      else {
         SongCategory _category = null;
         try {
            _category = SongCategory.getCategory(category);
         } catch (TypeNotFoundException e) {
            throw new BadRequestFieldException(StatusCode.INVALID_FIELD, "song_category");
         }
         result = this.songDao.findSongsByCondition(start, size, _category, name);
      }
      return this.adaptor(result);
   }

}
