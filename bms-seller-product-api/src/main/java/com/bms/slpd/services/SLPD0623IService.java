package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0623IParam;
import com.bms.slpd.bean.result.SLPD0623IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0623IService extends BaseService {

    /**
     * <p>修改包装标准指标</p>
     */
    @Transactional
    SLPD0623IResult modifyPkgStds(SLPD0623IParam param);

}