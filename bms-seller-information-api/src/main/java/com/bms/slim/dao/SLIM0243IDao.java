package com.bms.slim.dao;

import com.framework.boot.base.BaseDao;

import java.util.Map;

public interface SLIM0243IDao extends BaseDao {

    /**
     * 新增卖家生产商关联信息
     */
    int saveSellerProducers(Map<String, Object> map);

}
