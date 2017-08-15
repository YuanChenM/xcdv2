package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimProducerHonorCertificate;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0222IDao extends BaseDao {

    /**
     * 新增生产商荣誉证书
     */
    int saveProducerHonorCertificates(List<SlimProducerHonorCertificate> producerHonorCertificates);

}
