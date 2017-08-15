package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0122IParam;
import com.bms.slim.bean.result.SLIM0122IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0122IService extends BaseService {

    /**
     * 新增卖家角色
     */
    @Transactional
    SLIM0122IResult addSellers(SLIM0122IParam slim0122IParam);

}
