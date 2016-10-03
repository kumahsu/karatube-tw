package com.chomica.karatube.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.chomica.karatube.exception.DebagaError;
import com.chomica.karatube.model.entity.IEntity;

public class HQL {
   //---------------------------------------------------------------
   public static HQL equals(String fieldName, Object value) {
      return new HQL(fieldName, "=", value);
   }
   public static HQL like(String fieldName, Object value) {
      return new HQL(fieldName, "LIKE", value);
   }
   
   //---------------------------------------------------------------
   private String argName;
   private String operator;
   private Object value;
   
   //---------------------------------------------------------------
   private HQL(String argName, String operator, Object value) {
      this.argName = argName;
      this.operator = operator;
      this.value = value;
   }
   
   //---------------------------------------------------------------
   String argName() {
      return this.argName;
   }
   String operator() {
      return this.operator;
   }
   Object value() {
      return this.value;
   }
   
   //---------------------------------------------------------------
   public static class Builder<T extends IEntity> {      
      //---------------------------------------------------------------
      private Class<T> clazz = null;
      private StringBuilder sql;
      private int bindCount;
      private Map<String, Object> args;
      
      //---------------------------------------------------------------
      public Builder() {
         this.sql = new StringBuilder();
         this.bindCount = 0;
         this.args = new HashMap<String, Object>();
      }
      
      //---------------------------------------------------------------
      public Builder<T> select(Class<T> clazz) {
         this.clazz = clazz;
         this.sql.append("SELECT target FROM ")
                 .append(this.clazz.getSimpleName())
                 .append(" target")
                 .append(" WHERE 1 = 1");
         return this;
      }
      
      //---------------------------------------------------------------
      private Builder<T> addCondition(String logic, HQL condition) {
         if(this.clazz == null) { throw new DebagaError("Can not use where when not select yet"); }
         this.sql.append(" ").append(logic)
                 .append(" target.").append(condition.argName).append(" ")
                 .append(condition.operator).append(" :").append(condition.argName);
         this.args.put(condition.argName(), condition.value());
         return this;
      }
      public Builder<T> where(HQL condition) {
         return this.addCondition("AND", condition);
      }
      public Builder<T> and(HQL condition) {
         return this.where(condition);
      }
      
      public Builder<T> or(HQL condition) {
         return this.addCondition("OR", condition);
      }
      
      public Builder<T> andBind(HQL condition) {
         this.addCondition("AND (", condition);
         this.bindCount++;
         return this;
      }
      public Builder<T> orBind(HQL condition) {
         this.bindCount++;
         this.addCondition("OR (", condition);
         return this;
      }
      public Builder<T> endBind() {
         this.bindCount--;
         this.sql.append(")");
         return this;
      }
      
      // ---------------------------------------------------------------
      public TypedQuery<T> toHql(EntityManager em) {
         if(this.bindCount != 0) {
            throw new DebagaError("Bind count mismatch");
         }
         TypedQuery<T> query = em.createQuery(this.sql.toString(), this.clazz);
         DaoUtil.setSqlParams(query, this.args);
         return query;
      }
      
      public Map<String, Object> getArgs() {
         return this.args;
      }
      @Override
      public String toString() {
         return this.sql.toString();
      }
   }
}
