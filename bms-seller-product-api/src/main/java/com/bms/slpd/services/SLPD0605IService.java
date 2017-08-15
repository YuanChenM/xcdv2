package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0605IParam;
import com.bms.slpd.bean.result.SLPD0605IResult;
import com.bms.slpd.bean.result.field.SLPD0605IDifFedStdResult;
import com.bms.slpd.bean.result.field.SLPD0605IFedStdResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 查询饲养指标档案卡与差异卡
 */
public interface SLPD0605IService extends BaseService {
    /**
     * 查询饲养指标档案卡
     */
    @Transactional
    List<SLPD0605IFedStdResult> searchStd(Serializable var1);


    /**
     * 查询饲养指标差异卡
     */
    @Transactional
    List<SLPD0605IDifFedStdResult> searchDif(Serializable var1);

    /**
     * 查询饲养指标标准卡与差异卡
     */
    @Transactional
    SLPD0605IResult searchDifAndStdFeds(SLPD0605IParam param);
}