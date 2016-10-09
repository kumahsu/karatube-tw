package com.chomica.karatube.dao;

import com.chomica.karatube.constant.SingerType;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.entity.SingerEntity;

public interface ISingerDAO extends IBaseJpaDAO<SingerEntity> {
   // ---------------------------------------------------------------
   public QueryListData<SingerEntity> findSingersByCondition(Integer start, 
                                                               Integer size, 
                                                               SingerType type, 
                                                               String keywords);
}
