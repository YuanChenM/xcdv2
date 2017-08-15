package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0606IParam;
import com.bms.slpd.bean.result.SLPD0606IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/*
 *修改饲养指标档案卡
 */
public interface SLPD0606IService extends BaseService {

    /**
     * 修改饲养指标档案卡
     */
    @Transactional
    SLPD0606IResult updateFedStandards(SLPD0606IParam param);


}