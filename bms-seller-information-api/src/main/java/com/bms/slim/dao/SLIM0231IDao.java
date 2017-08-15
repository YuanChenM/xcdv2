package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimProducerStorageCapacity;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0231IDao extends BaseDao {

    /**
     * 新增生产商库容
     */
    int saveProducerStorageCapacities(List<SlimProducerStorageCapacity> producerStorageCapacities);

}
