package com.chomica.karatube.dao;

import java.util.List;

public interface IBaseJpaDAO<T> {
   // ---------------------------------------------------------------
   public List<T> findAll();
   public T findById(Object id);

   // ---------------------------------------------------------------
   public T save(T entity);
   public void delete(T entity);

   // ---------------------------------------------------------------
   public void addToManaged(T entity);
   public void detached(T entity);
   public void flush();
}
