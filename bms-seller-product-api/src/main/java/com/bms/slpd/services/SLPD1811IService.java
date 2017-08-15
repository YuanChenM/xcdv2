package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1811IParam;
import com.bms.slpd.bean.result.SLPD1811IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1811IService extends BaseService {

    /**
     * 删除代理商单品品牌规格生产商
     */
    @Transactional
    SLPD1811IResult deleteAgentProducts(SLPD1811IParam slpd1811IParam);

}