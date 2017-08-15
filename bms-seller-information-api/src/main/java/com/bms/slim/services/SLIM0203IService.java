package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0203IParam;
import com.bms.slim.bean.result.SLIM0203IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0203IService extends BaseService {

    /**
     * 修改卖家生产商
     */
    @Transactional
    SLIM0203IResult updateSellerProducers(SLIM0203IParam slim0203IParam);

    /**
     * 修改卖家生产商关联
     */
    @Transactional
    SLIM0203IResult updateSellerProducerRelation(SLIM0203IParam slim0203IParam);

}
