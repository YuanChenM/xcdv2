package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0227IParam;
import com.bms.slim.bean.result.SLIM0227IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0227IService extends BaseService {

    /**
     * 修改生产商工厂
     */
    @Transactional
    SLIM0227IResult updateProducerFactory(SLIM0227IParam slim0227IParam);

}
