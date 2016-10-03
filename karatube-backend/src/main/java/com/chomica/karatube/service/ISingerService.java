package com.chomica.karatube.service;

import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.vo.SingerVO;

public interface ISingerService {
   public SingerVO createSinger(SingerVO singer);
   public SingerVO udpateSinger(SingerVO singer);
   public void deleteSinger(String singer_id);
   
   public SingerVO findSingerById(String singer_id);
   public QueryListData<SingerVO> findSingers(Integer start, Integer size, Integer type, String keyword);
}
