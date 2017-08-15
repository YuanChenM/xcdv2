package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0228IParam;
import com.bms.slim.bean.result.SLIM0228IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0228IService extends BaseService {

    /**
     * 新增生产商车间
     */
    @Transactional
    SLIM0228IResult addProducerWorkShops(SLIM0228IParam slim0228IParam);

}
