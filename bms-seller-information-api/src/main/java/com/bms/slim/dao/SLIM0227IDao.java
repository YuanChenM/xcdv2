package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerFactory;
import com.framework.boot.base.BaseDao;

public interface SLIM0227IDao extends BaseDao {

    /**
     * 修改生产商工厂
     */
    int updateProducerFactory(UpdateEntity<SlimProducerFactory, BaseTarget> updateEntity);

}
