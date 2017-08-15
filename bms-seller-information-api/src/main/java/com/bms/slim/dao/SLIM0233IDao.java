package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerStorageCapacity;
import com.framework.boot.base.BaseDao;

public interface SLIM0233IDao extends BaseDao {

    /**
     * 修改生产商库容
     */
    int updateProducerStorageCapacities(UpdateEntity<SlimProducerStorageCapacity, BaseTarget> updateEntity);

}
