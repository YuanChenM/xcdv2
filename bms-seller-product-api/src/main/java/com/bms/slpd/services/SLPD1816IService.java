package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1816IParam;
import com.bms.slpd.bean.result.SLPD1816IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1816IService extends BaseService {

    /**
     * <p>新增产品</p>
     */
    @Transactional
    SLPD1816IResult addProducts(SLPD1816IParam slpd1816IParam);

}