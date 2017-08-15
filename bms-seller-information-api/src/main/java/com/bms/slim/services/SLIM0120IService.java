package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0120IParam;
import com.bms.slim.bean.result.field.SLIM0120SellerBusinessTeamResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0120IService extends BaseService {

    /**
     * 查询卖家电商经营团队
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0120SellerBusinessTeamResult> findSellerBusinessTeams(SLIM0120IParam slim0120IParam);

}
