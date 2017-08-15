package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0233IParam;
import com.bms.slim.bean.result.SLIM0233IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0233IService extends BaseService {

    /**
     * 修改生产商库容
     */
    @Transactional
    SLIM0233IResult updateProducerStorageCapacities(SLIM0233IParam slim0233IParam);

}
