package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0406IParam;
import com.bms.slpd.bean.result.SLPD0406IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 修改品牌所有人信息
 */
public interface SLPD0406IService extends BaseService {
    /**
     * 修改品牌所有人信息
     */
    @Transactional
    SLPD0406IResult updateSlpdBrandOwners(SLPD0406IParam requestParam);


}