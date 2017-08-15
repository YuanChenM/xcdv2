package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0603IParam;
import com.bms.slpd.bean.result.SLPD0603IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0603IService extends BaseService {

    /**
     * <p>修改原种种源标准指标</p>
     */
    @Transactional
    SLPD0603IResult modifyOrgStds(SLPD0603IParam param);

}