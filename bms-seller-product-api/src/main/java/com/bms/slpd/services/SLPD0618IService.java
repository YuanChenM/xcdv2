package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0618IParam;
import com.bms.slpd.bean.result.SLPD0618IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;


public interface SLPD0618IService extends BaseService {

    /**
     * 修改安全标准档案卡
     */
    @Transactional
    SLPD0618IResult updateMctStds(SLPD0618IParam requestParam);

}