package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0617IParam;
import com.bms.slpd.bean.result.SLPD0617IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0617IService extends BaseService {
    /**
     * 查询安全标准指标档案卡
     */
    @Transactional(readOnly = true)
    SLPD0617IResult findSftStdsAndDifStds(SLPD0617IParam requestParam);
}
