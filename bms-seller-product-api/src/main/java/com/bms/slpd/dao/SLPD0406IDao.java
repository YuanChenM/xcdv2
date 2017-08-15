package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

/**
 * 修改品牌所有人信息
 */
public interface SLPD0406IDao extends BaseDao {
    /**
     * 修改品牌所有人信息
     */
    int updateSlpdBrandOwners(UpdateEntity var1);
}