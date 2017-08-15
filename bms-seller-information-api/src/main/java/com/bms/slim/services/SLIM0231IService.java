package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0231IParam;
import com.bms.slim.bean.result.SLIM0231IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0231IService extends BaseService {

    /**
     * 新增生产商库容
     */
    @Transactional
    SLIM0231IResult addProducerStorageCapacities(SLIM0231IParam slim0231IParam);

}
