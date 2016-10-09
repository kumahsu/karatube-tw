package com.chomica.karatube.util;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chomica.karatube.model.QueryListData;

public class DaoUtil {
    //---------------------------------------------------------------
    private static final Logger logger = LoggerFactory.getLogger(DaoUtil.class);
    
    //---------------------------------------------------------------
    public static void setSqlParams(Query query, Map<String, ? extends Object> paramMap) {
        for (String paramName : paramMap.keySet()) {
            query.setParameter(paramName, paramMap.get(paramName));
        }
    }
    
    public static <T> QueryListData<T> getPagedResult(TypedQuery<T> query, 
                                                        Integer start, 
                                                        Integer size)
    {
       if(start != null) { query.setFirstResult(start); }
       if(size != null) { query.setMaxResults(size); }
       
       int totalCount = query.getMaxResults();
       List<T> result = query.getResultList();
       return new QueryListData<T>(size, totalCount, start, result);
    }
    
    public static <T> T getSingleResult(TypedQuery<T> query) {
        List<T> result = query.getResultList();
        if(result == null) {
            logger.warn("Try to get SINGLE result, but get: null");
            return null;
        }
        else if(result.size() != 1) {
            logger.warn("Try to get SINGLE result, but get: {} results", result.size());
            return null;
        }
        return result.iterator().next();
    }
}

