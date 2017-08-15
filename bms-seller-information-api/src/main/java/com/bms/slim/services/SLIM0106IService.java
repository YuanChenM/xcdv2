package com.bms.slim.services;


import com.bms.slim.bean.param.SLIM0106IParam;
import com.bms.slim.bean.result.SLIM0106IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0106IService extends BaseService {

    /**
     * 根据entitySellerId修改卖家经营资质
     */
    @Transactional
    SLIM0106IResult updateSBQ(SLIM0106IParam entitySellerId);
}
