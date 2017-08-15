package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0627IParam;
import com.bms.slpd.bean.result.SLPD0627IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;


public interface SLPD0627IService extends BaseService {

    /**
     * 修改原种种源标准指标差异
     */
    @Transactional
    SLPD0627IResult updateOrgDifStds(SLPD0627IParam requestParam);

}