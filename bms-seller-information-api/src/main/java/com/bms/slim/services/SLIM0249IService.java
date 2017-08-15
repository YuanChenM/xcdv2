package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0249IParam;
import com.bms.slim.bean.result.SLIM0249IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0249IService extends BaseService {

    /**
     * 修改卖方单位角色
     */
    @Transactional
    SLIM0249IResult updateSellerRoles(SLIM0249IParam slim0249IParam);

}
