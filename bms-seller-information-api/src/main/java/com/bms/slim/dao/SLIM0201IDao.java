package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimProducer;
import com.framework.boot.base.BaseDao;

import java.util.List;
import java.util.Map;

public interface SLIM0201IDao extends BaseDao {

    /**
     * 新增卖家生产商
     */
    int saveSellerProducers(List<SlimProducer> producers);
    /**
     * 新增卖家生产商关联信息
     */
    int saveSellerProducerRelations(Map<String, Object> map);

    /**
     * 新增生产商联系人
     */
    int saveProducerContact(SlimContact contact);

}
