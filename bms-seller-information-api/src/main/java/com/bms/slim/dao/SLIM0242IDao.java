package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimProducer;
import com.framework.boot.base.BaseDao;

public interface SLIM0242IDao extends BaseDao {

    /**
     * 修改平台生产商
     */
    int udpateProducer(UpdateEntity<SlimProducer, BaseTarget> updateEntity);

    /**
     * 修改联系人信息
     */
    int updateProducerContact(UpdateEntity<SlimContact, BaseTarget> updateEntity);


}
