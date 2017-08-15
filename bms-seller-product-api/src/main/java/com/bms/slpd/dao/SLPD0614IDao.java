package com.bms.slpd.dao;

import com.bms.slpd.bean.result.field.SLPD0614IDifGnqStdResult;
import com.bms.slpd.bean.result.field.SLPD0614IGnqStdResult;
import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * 查询通用质量标准指标档案卡
 */
public interface SLPD0614IDao extends BaseDao {

    /**
     * 查询通用质量标准指标差异卡
     */
    List<SLPD0614IDifGnqStdResult> searchDif(Serializable var1);

    /**
     * 查询通用质量标准指标档案卡
     */
    List<SLPD0614IGnqStdResult> searchStd(Serializable var1);


}