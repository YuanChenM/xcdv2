package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0109IParam;
import com.bms.slim.bean.result.SLIM0109IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0109IService extends BaseService {

    /**
     * 修改卖家经营团队
     */
    @Transactional
    SLIM0109IResult updateSellerManagementTeams(SLIM0109IParam slim0109IParam);

}
