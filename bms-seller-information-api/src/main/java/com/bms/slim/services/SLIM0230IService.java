package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0230IParam;
import com.bms.slim.bean.result.SLIM0230IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0230IService extends BaseService {

    /**
     * 修改生产商车间
     */
    @Transactional
    SLIM0230IResult updateProducerWorkShops(SLIM0230IParam slim0230IParam);

}
