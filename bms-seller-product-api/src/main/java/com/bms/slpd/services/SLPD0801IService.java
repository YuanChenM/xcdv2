package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0801IParam;
import com.bms.slpd.bean.result.SLPD0801IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0801IService extends BaseService {

    /**
     * <p>新增(卖家)单品品牌(规格)生产商注册</p>
     */
    @Transactional
    SLPD0801IResult addSellerCommodities(SLPD0801IParam slpd0801IParam);

}