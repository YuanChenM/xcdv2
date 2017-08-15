package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1808IParam;
import com.bms.slpd.bean.result.SLPD1808IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1808IService extends BaseService {

    /**
     * 删除制造商单品品牌规格生产商
     */
    @Transactional
    SLPD1808IResult deleteManufacturerProducts(SLPD1808IParam slpd1808iParam);

}