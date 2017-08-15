package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerHonorCertificate;
import com.framework.boot.base.BaseDao;

public interface SLIM0224IDao extends BaseDao {

    /**
     * 修改生产商荣誉证书
     */
    int updateProducerHonorCertificate(UpdateEntity<SlimProducerHonorCertificate, BaseTarget> updateEntity);

}
