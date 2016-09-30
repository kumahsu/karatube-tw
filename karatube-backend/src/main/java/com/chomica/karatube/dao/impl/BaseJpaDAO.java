package com.chomica.karatube.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.chomica.karatube.dao.IBaseJpaDAO;

public class BaseJpaDAO<T extends Serializable> implements IBaseJpaDAO<T> {
   // ---------------------------------------------------------------
   @Autowired
   protected EntityManager em;

   // ---------------------------------------------------------------
   protected Class<T> clazz;
   
   // ---------------------------------------------------------------
   protected BaseJpaDAO(Class<T> clazz) {
       this.clazz = clazz;
   }
   
   // ---------------------------------------------------------------
   public List<T> findAll() {
      CriteriaQuery<T> criteria = em.getCriteriaBuilder().createQuery(this.clazz);
      criteria.from(this.clazz);
      TypedQuery<T> query = em.createQuery(criteria);
      return query.getResultList();
   }
   public T findById(Object id) {
      return em.find(this.clazz, id);
   }

   // ---------------------------------------------------------------
   public T save(T entity) {
      return em.merge(entity);
   }
   public void delete(T entity) {
      em.remove(entity);
   }

   // ---------------------------------------------------------------
   public void addToManaged(T entity) {
      em.persist(entity);
   }
   public void detached(T entity){
      em.detach(entity);
   }
   public void flush(){
      em.flush();
   }
}