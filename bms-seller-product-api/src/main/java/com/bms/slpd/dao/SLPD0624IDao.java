package com.bms.slpd.dao;

import com.bms.slpd.bean.param.SLPD0624IParam;
import com.bms.slpd.bean.result.field.SLPD0624IDifPkgStdResult;
import com.bms.slpd.bean.result.field.SLPD0624IPkgStdResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0624IDao extends BaseDao {
    /**
     * 查询包装档案卡
     */
    List<SLPD0624IPkgStdResult> findPkgStds(SLPD0624IParam itemId);

    /**
     * 查询包装差异卡
     */
    List<SLPD0624IDifPkgStdResult> findPkgDifStds(SLPD0624IParam productId);
}
