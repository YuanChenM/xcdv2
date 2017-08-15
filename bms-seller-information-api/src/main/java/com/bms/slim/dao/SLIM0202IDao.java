package com.bms.slim.dao;

import com.bms.slim.bean.param.SLIM0202IParam;
import com.framework.boot.base.BaseDao;

public interface SLIM0202IDao extends BaseDao {

    /**
     * 查询卖家生产商
     */
    int findSellerProducerRelation(SLIM0202IParam slim0202IParam);

}
