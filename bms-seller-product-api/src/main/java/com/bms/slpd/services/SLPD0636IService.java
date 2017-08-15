package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0636IParam;
import com.bms.slpd.bean.result.SLPD0636IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0636IService extends BaseService {

    /**
     * 修改加工质量标准差异
     */
    @Transactional
    SLPD0636IResult updateTncDifStds(SLPD0636IParam requestParam);


}