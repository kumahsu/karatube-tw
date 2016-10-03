package com.chomica.karatube.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.chomica.karatube.constant.SingerType;
import com.chomica.karatube.dao.ISingerDAO;
import com.chomica.karatube.exception.TypeNotFoundException;
import com.chomica.karatube.model.QueryListData;
import com.chomica.karatube.model.entity.QueryListEntity;
import com.chomica.karatube.model.entity.SingerEntity;
import com.chomica.karatube.model.vo.SingerVO;
import com.chomica.karatube.service.ISingerService;

@Component("singerService")
public class SingerService implements ISingerService {
   // ---------------------------------------------------------------
   @Autowired
   @Qualifier("singerDao")
   private ISingerDAO singerDao;
   
   // ---------------------------------------------------------------
   @Override
   public SingerVO createSinger(SingerVO singer) {
      SingerEntity result = this.singerDao.save(singer.adaptor().toEntity());
      return new SingerVO(result);
   }

   @Override
   public SingerVO udpateSinger(SingerVO singer) {
      SingerEntity result = this.singerDao.save(singer.adaptor().toEntity());
      return new SingerVO(result);
   }

   @Override
   public void deleteSinger(String singer_id) {
      this.singerDao.delete(this.singerDao.findById(singer_id));
   }

   @Override
   public SingerVO findSingerById(String singer_id) {
      SingerEntity result = this.singerDao.findById(singer_id);
      return new SingerVO(result);
   }
   
   // ---------------------------------------------------------------
   private QueryListData<SingerVO> adaptor(QueryListEntity<SingerEntity> result) {
      List<SingerVO> list = new LinkedList<SingerVO>();
      for(SingerEntity entity : result.getList()) {
         list.add(new SingerVO(entity));
      }
      return new QueryListData<SingerVO>(result.getSize(), result.getTotalCount(), result.getStart(), list);
   }
   private QueryListData<SingerVO> findAllSingers(Integer start, Integer size) {
      QueryListEntity<SingerEntity> result = this.singerDao.findAll(start, size);
      return this.adaptor(result);
   }
   
   // ---------------------------------------------------------------
   @Override
   public QueryListData<SingerVO> findSingers(Integer start, Integer size, Integer type, String keyword) {
      if(type == null) {
         return this.findAllSingers(start, size);
      }
      SingerType _type = null;
      try {
         _type = SingerType.getType(type);
      } catch (TypeNotFoundException e) {
         //TODO: throw invalid query exception
      }
      QueryListEntity<SingerEntity> result = this.singerDao.findSingersByCondition(start, size, _type, keyword);
      return this.adaptor(result);
   }
}
