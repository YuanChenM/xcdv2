package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimProducer;
import com.bms.slim.bean.entity.SlimSellerProducer;
import com.bms.slim.bean.param.SLIM0203IParam;
import com.framework.boot.base.BaseDao;

public interface SLIM0203IDao extends BaseDao {

    /**
     * 修改卖家生产商
     */
    int udpateSellerProducer(UpdateEntity<SlimProducer, BaseTarget> updateEntity);

    /**
     * 解绑卖家和生产商信息
     */
    int updateSellerProducerRelation(UpdateEntity<SlimSellerProducer, BaseTarget> updateEntity);

    /**
     * 修改卖家联系人信息
     */
    int updateProducerContact(UpdateEntity<SlimContact, BaseTarget> updateEntity);

    /**
     * 查询卖家生产商关联信息
     */
    int findSellerProducerRelation(SLIM0203IParam slim0203IParam);

}
