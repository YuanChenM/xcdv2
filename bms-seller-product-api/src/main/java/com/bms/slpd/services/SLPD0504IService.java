package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0504IParam;
import com.bms.slpd.bean.result.SLPD0504IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 *新增单品规格
 */
public interface SLPD0504IService extends BaseService {

    /**
     *新增单品规格
     */
    @Transactional
    SLPD0504IResult saveItemProperties(SLPD0504IParam slpd0504IParam);

}