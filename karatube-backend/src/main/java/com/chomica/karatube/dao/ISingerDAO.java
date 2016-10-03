package com.chomica.karatube.dao;

import com.chomica.karatube.constant.SingerType;
import com.chomica.karatube.model.entity.QueryListEntity;
import com.chomica.karatube.model.entity.SingerEntity;

public interface ISingerDAO extends IBaseJpaDAO<SingerEntity> {
   // ---------------------------------------------------------------
   public QueryListEntity<SingerEntity> findSingersByCondition(Integer start, 
                                                               Integer size, 
                                                               SingerType type, 
                                                               String keywords);
}
