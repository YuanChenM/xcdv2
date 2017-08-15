package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0222IParam;
import com.bms.slim.bean.result.SLIM0222IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0222IService extends BaseService {

    /**
     * 新增生产商荣誉证书
     */
    @Transactional
    SLIM0222IResult addProducerHonorCertificate(SLIM0222IParam slim0222IParam);

}
