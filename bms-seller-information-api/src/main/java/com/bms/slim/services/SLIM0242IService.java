package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0242IParam;
import com.bms.slim.bean.result.SLIM0242IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0242IService extends BaseService {

    /**
     * 修改卖家生产商
     */
    @Transactional
    SLIM0242IResult updateProducers(SLIM0242IParam slim0242IParam);

}
