package com.chomica.karatube.model.vo;

import com.chomica.karatube.model.entity.IEntity;
import com.chomica.karatube.model.http.IHttpModel;

public interface IVoModel {
   public IAdaptor<? extends IHttpModel, ? extends IEntity> adaptor();
}
