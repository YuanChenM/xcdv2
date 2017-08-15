package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimProducer;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0241IDao extends BaseDao {

    /**
     * 新增平台生产商
     */
    int saveProducers(List<SlimProducer> producers);

    /**
     * 新增生产商联系人
     */
    int saveProducerContact(SlimContact contact);

}
