package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0111IParam;
import com.bms.slim.bean.result.field.SLIM0111AgentSupplyQualificationResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0111IService extends BaseService {

    /**
     * 查询卖家代理商供应资质
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0111AgentSupplyQualificationResult> findAgentSupplyQualification(SLIM0111IParam slim0111IParam);

}
