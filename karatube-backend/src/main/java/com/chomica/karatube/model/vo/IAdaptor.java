package com.chomica.karatube.model.vo;

import com.chomica.karatube.model.entity.IEntity;
import com.chomica.karatube.model.http.IHttpModel;

public interface IAdaptor<M extends IHttpModel, E extends IEntity> {
   public M toHttpModel();
   public E toEntity(); 
}
