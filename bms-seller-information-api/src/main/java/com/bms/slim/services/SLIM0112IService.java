package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0112IParam;
import com.bms.slim.bean.result.SLIM0112IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0112IService extends BaseService {

    /**
     * 修改卖家代理商供应资质
     */
    @Transactional
    SLIM0112IResult updateAgentSupplyQualification(SLIM0112IParam slim0112IParam);

}
