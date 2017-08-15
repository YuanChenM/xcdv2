package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1203IParam;
import com.bms.slpd.bean.result.SLPD1203IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1203IService extends BaseService {
    /**
     * 批量查询物流区商品
     */
    @Transactional
    SLPD1203IResult updateLgcsCommodities(SLPD1203IParam param);
}
