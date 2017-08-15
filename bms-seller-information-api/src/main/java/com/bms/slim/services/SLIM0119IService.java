package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0119IParam;
import com.bms.slim.bean.result.SLIM0119IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0119IService extends BaseService {

    /**
     * 新增卖家电商经营团队
     */
    @Transactional
    SLIM0119IResult addSellerBusinessTeams(SLIM0119IParam slim0119IParam);

}
