package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0803IParam;
import com.bms.slpd.bean.result.SLPD0803IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0803IService extends BaseService {

    /**
     * <p>修改(卖家)单品品牌(规格)生产商</p>
     */
    @Transactional
    SLPD0803IResult modifySellerCommoditys(SLPD0803IParam param);

}