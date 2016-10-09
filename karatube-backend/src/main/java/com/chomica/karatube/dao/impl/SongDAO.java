package com.chomica.karatube.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.chomica.karatube.constant.SongCategory;
import com.chomica.karatube.dao.ISongDAO;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.entity.SongEntity;
import com.chomica.karatube.util.DaoUtil;
import com.chomica.karatube.util.HQL;

@Component("songDao")
public class SongDAO extends BaseJpaDAO<SongEntity> implements ISongDAO {
   // ---------------------------------------------------------------
   public SongDAO() {
      super(SongEntity.class);
   }

   // ---------------------------------------------------------------
   @Override
   public QueryListData<SongEntity> findSongsBySinger(Integer start, 
                                                        Integer size, 
                                                        String singerId) {
      HQL.Builder<SongEntity> builder = new HQL.Builder<SongEntity>();
      builder.select(super.clazz)
             .where(HQL.equals("singer.singer_id", singerId));
      TypedQuery<SongEntity> query = builder.toHql(super.em);
      return DaoUtil.getPagedResult(query, start, size);
   }

   @Override
   public QueryListData<SongEntity> findSongsByName(Integer start, 
                                                      Integer size, 
                                                      String name) {
      String condition = "%" + name + "%";
      HQL.Builder<SongEntity> builder = new HQL.Builder<SongEntity>();
      builder.select(super.clazz)
             .where(HQL.like("song_name", condition));
      TypedQuery<SongEntity> query = builder.toHql(super.em);
      return DaoUtil.getPagedResult(query, start, size);
   }
   
   @Override
   public QueryListData<SongEntity> findSongsByCondition(Integer start, 
                                                           Integer size, 
                                                           SongCategory category,
                                                           String name)
   {
      HQL.Builder<SongEntity> builder = new HQL.Builder<SongEntity>();
      builder.select(super.clazz)
             .where(HQL.equals("song_category", category.code()));
      if(name != null) {
         String condition = "%" + name + "%";
         builder.and(HQL.like("song_name", condition));
      }
      TypedQuery<SongEntity> query = builder.toHql(super.em);
      return DaoUtil.getPagedResult(query, start, size);
   }
}
