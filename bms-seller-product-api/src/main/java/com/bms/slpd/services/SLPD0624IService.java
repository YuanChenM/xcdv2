package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0624IParam;
import com.bms.slpd.bean.result.SLPD0624IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0624IService extends BaseService {
    /**
     * 查询安全标准指标档案卡
     */
    @Transactional(readOnly = true)
    SLPD0624IResult findPkgStdsAndDifStds(SLPD0624IParam requestParam);
}
