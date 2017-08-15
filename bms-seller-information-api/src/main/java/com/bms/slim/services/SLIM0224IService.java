package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0224IParam;
import com.bms.slim.bean.result.SLIM0224IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0224IService extends BaseService {

    /**
     * 修改生产商荣誉证书
     */
    @Transactional
    SLIM0224IResult updateProducerHonorCertificate(SLIM0224IParam slim0224IParam);

}
