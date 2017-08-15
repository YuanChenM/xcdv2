package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0243IParam;
import com.bms.slim.bean.result.SLIM0243IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0243IService extends BaseService {

    /**
     * 新增卖家生产商关联
     */
    @Transactional
    SLIM0243IResult saveSellerProducers(SLIM0243IParam slim0243IParam);

}
