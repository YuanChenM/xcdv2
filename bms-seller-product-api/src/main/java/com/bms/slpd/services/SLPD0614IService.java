package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0614IParam;
import com.bms.slpd.bean.result.SLPD0614IResult;
import com.bms.slpd.bean.result.field.SLPD0614IDifGnqStdResult;
import com.bms.slpd.bean.result.field.SLPD0614IGnqStdResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 查询通用质量标准指标档案卡与差异卡
 */
public interface SLPD0614IService extends BaseService {

    /**
     * 查询通用质量标准指标差异卡
     */
    @Transactional
    List<SLPD0614IDifGnqStdResult> searchDif(Serializable var1);

    /**
     * 查询通用质量标准指标档案卡
     */
    @Transactional
    List<SLPD0614IGnqStdResult> searchStd(Serializable var1);

    /**
     * 查询通用质量标准指标档案卡与差异卡
     */
    @Transactional
    SLPD0614IResult findDifAndStdGnq(SLPD0614IParam param);

}