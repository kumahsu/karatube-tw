package com.chomica.karatube.dao;

import java.util.List;

import com.chomica.karatube.model.entity.IEntity;
import com.chomica.karatube.model.entity.QueryListEntity;

public interface IBaseJpaDAO<T extends IEntity> {
   // ---------------------------------------------------------------
   public List<T> findAll();
   public QueryListEntity<T> findAll(Integer start, Integer size);
   public T findById(Object id);

   // ---------------------------------------------------------------
   public T save(T entity);
   public void delete(T entity);

   // ---------------------------------------------------------------
   public void addToManaged(T entity);
   public void detached(T entity);
   public void flush();
}
