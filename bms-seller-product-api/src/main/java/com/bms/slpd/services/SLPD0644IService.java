package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0644IParam;
import com.bms.slpd.bean.result.SLPD0644IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;


public interface SLPD0644IService extends BaseService {

    /**
     * 修改储存运输标准指标差异
     */
    @Transactional
    SLPD0644IResult updateTspDifStds(SLPD0644IParam requestParam);

}