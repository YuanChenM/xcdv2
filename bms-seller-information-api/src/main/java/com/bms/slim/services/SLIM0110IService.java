package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0110IParam;
import com.bms.slim.bean.result.SLIM0110IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0110IService extends BaseService {

    /**
     * 新增卖家代理商供应资质
     */
    @Transactional
    SLIM0110IResult saveAgentSupplyQualification(SLIM0110IParam slim0110IParam);

}
