package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

/**
 * 修改通用质量标准指标档案卡
 */
public interface SLPD0615IDao extends BaseDao {

    /**
     * 修改通用质量标准指标档案卡
     */
    int updateGnqStandards(UpdateEntity var1);
}