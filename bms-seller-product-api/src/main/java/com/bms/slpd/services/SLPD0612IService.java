package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0612IParam;
import com.bms.slpd.bean.result.SLPD0612IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0612IService extends BaseService {

    /**
     * <p>修改加工质量标准</p>
     */
    @Transactional
    SLPD0612IResult modifyTncStds(SLPD0612IParam param);

}