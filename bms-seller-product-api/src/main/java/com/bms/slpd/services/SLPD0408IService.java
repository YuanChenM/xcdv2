package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0408IParam;
import com.bms.slpd.bean.result.SLPD0408IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 修改品牌绑定关系
 */
public interface SLPD0408IService extends BaseService {
    /**
     * 修改品牌绑定关系
     */
    @Transactional
    SLPD0408IResult updateBrandOwnerRelations(SLPD0408IParam requestParam);


}