package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1807IParam;
import com.bms.slpd.bean.result.SLPD1807IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1807IService extends BaseService {

    /**
     * 批量新增制造商单品品牌规格生产商
     */
    @Transactional
    SLPD1807IResult saveManufacturerProducts(SLPD1807IParam slpd1807iParam);

}