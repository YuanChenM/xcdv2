package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0225IParam;
import com.bms.slim.bean.result.SLIM0225IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0225IService extends BaseService {

    /**
     * 新增生产商工厂
     */
    @Transactional
    SLIM0225IResult addProducerFactory(SLIM0225IParam slim0225IParam);

}
