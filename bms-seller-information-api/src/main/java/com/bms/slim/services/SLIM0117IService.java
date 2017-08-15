package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0117IParam;
import com.bms.slim.bean.result.field.SLIM0117ISellerContractPermissionResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0117IService extends BaseService {

    /**
     * 分页查询卖家合同信息准入
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0117ISellerContractPermissionResult> findSCPs(SLIM0117IParam param);
}
