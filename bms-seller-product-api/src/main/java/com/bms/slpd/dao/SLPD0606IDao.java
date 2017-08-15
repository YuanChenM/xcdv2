package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

/**
 * 修改饲养指标档案卡
 */
public interface SLPD0606IDao extends BaseDao {

    /**
     * 修改饲养指标档案卡
     */
    int updateFedStandards(UpdateEntity var1);
}