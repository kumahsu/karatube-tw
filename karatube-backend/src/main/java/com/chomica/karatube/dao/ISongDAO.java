package com.chomica.karatube.dao;

import com.chomica.karatube.constant.SongCategory;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.entity.SongEntity;

public interface ISongDAO extends IBaseJpaDAO<SongEntity> {
   // ---------------------------------------------------------------
   public QueryListData<SongEntity> findSongsBySinger(Integer start, 
                                                        Integer size, 
                                                        String singerId);
   public QueryListData<SongEntity> findSongsByName(Integer start, 
                                                      Integer size, 
                                                      String name);
   public QueryListData<SongEntity> findSongsByCondition(Integer start, 
                                                           Integer size, 
                                                           SongCategory category, 
                                                           String name);
}
