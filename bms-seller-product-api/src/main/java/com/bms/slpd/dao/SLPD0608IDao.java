package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.param.SLPD0608IParam;
import com.bms.slpd.bean.result.field.SLPD0608IDifMctStdResult;
import com.bms.slpd.bean.result.field.SLPD0608IMctStdResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0608IDao extends BaseDao {

    /**
     * 查询档案卡
     */
    List<SLPD0608IMctStdResult> findMctStds(SLPD0608IParam param);

    /**
     * 查询差异卡
     */
    List<SLPD0608IDifMctStdResult> findMctDifStds(SLPD0608IParam param);

    /**
     * 设置查询参数
     */
    List<SlpdProduct> findSlpdProducts(SLPD0608IParam param);
}
