package com.chomica.karatube.service;

import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.vo.SongVO;

public interface ISongService {
   public SongVO createSong(SongVO song);
   public SongVO updateSong(SongVO song);
   public SongVO confirmedSong(SongVO song, Integer confirmed);
   public void deleteSong(String song_id);
   
   public SongVO findSongById(String song_id);
   public QueryListData<SongVO> findSongsBySingerId(Integer start,
                                                    Integer size, 
                                                    String singer_id);
   public QueryListData<SongVO> findSongsByCondition(Integer start,
                                                     Integer size, 
                                                     Integer category, 
                                                     String name);
}
