package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0201IParam;
import com.bms.slim.bean.result.SLIM0201IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0201IService extends BaseService {

    /**
     * 新增卖家生产商
     */
    @Transactional
    SLIM0201IResult saveSellerProducers(SLIM0201IParam slim0201IParam);

}
