package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0609IParam;
import com.bms.slpd.bean.result.SLPD0609IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0609IService extends BaseService {
    /**
     * 修改加工技术档案卡
     *
     */
    @Transactional
    SLPD0609IResult updateMctStds(SLPD0609IParam requestParam);

}