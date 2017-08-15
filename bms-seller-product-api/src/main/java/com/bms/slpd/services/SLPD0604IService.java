package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0601IFedStdParam;
import com.bms.slpd.bean.result.SLPD0604IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 新增饲养指标档案卡
 */
public interface SLPD0604IService extends BaseService {
    /**
     * 新增饲养指标档案卡
     */
    @Transactional
    SLPD0604IResult saveFedStandards(List<SLPD0601IFedStdParam> fedStdParams);
}