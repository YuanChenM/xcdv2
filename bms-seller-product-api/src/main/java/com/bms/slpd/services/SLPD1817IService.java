package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1817IParam;
import com.bms.slpd.bean.result.SLPD1817IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1817IService extends BaseService {

    /**
     * 修改产品
     */
    @Transactional
    SLPD1817IResult updateProducts(SLPD1817IParam requestParam);

}