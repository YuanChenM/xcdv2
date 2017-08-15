package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimProducerFactory;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0225IDao extends BaseDao {

    /**
     * 新增生产商工厂
     */
    int saveProducerFactories(List<SlimProducerFactory> producerFactories);

}
