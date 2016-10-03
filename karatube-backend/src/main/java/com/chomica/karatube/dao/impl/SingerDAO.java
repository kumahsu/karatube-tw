package com.chomica.karatube.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.chomica.karatube.constant.SingerType;
import com.chomica.karatube.dao.ISingerDAO;
import com.chomica.karatube.model.entity.QueryListEntity;
import com.chomica.karatube.model.entity.SingerEntity;
import com.chomica.karatube.util.HQL;

@Component("singerDao")
public class SingerDAO extends BaseJpaDAO<SingerEntity> implements ISingerDAO {
   // ---------------------------------------------------------------
   public SingerDAO() {
      super(SingerEntity.class);
   }
   
   // ---------------------------------------------------------------
   @Override
   public QueryListEntity<SingerEntity> findSingersByCondition(Integer start, 
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
      
      if(start != null) { query.setFirstResult(start); }
      if(size != null) { query.setMaxResults(size); }
      
      int totalCount = query.getMaxResults();
      List<SingerEntity> result = query.getResultList();
      return new QueryListEntity<SingerEntity>(size, totalCount, start, result);
   }
}
