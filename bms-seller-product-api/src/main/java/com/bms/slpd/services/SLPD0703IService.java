package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0703IParam;
import com.bms.slpd.bean.result.SLPD0703IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0703IService extends BaseService {

    /**
     * 修改单品品牌(规格)生产商
     */
    @Transactional
    SLPD0703IResult updateProducerProducts(SLPD0703IParam requestParam);

}