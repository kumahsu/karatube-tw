package com.chomica.karatube.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.chomica.karatube.constant.SingerType;
import com.chomica.karatube.dao.ISingerDAO;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.entity.SingerEntity;
import com.chomica.karatube.util.DaoUtil;
import com.chomica.karatube.util.HQL;

@Component("singerDao")
public class SingerDAO extends BaseJpaDAO<SingerEntity> implements ISingerDAO {
   // ---------------------------------------------------------------
   public SingerDAO() {
      super(SingerEntity.class);
   }
   
   // ---------------------------------------------------------------
   @Override
   public QueryListData<SingerEntity> findSingersByCondition(Integer start, 
                                                               Integer size, 
                                                               SingerType type, 
                                                               String keywords) 
   {
      HQL.Builder<SingerEntity> sql = new HQL.Builder<SingerEntity>(); 
      sql.select(super.clazz)
         .where(HQL.equals("type", type.code()));
      
      if(keywords != null) {
         String condition = "%" + keywords + "%";
         sql.andBind(HQL.like("name", condition))
            .or(HQL.like("keywords", condition)).endBind();
      }
      
      TypedQuery<SingerEntity> query = sql.toHql(super.em);
      return DaoUtil.getPagedResult(query, start, size);
   }
}
