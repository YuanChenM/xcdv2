package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

/*
 *修改品牌
 */
public interface SLPD0402IDao extends BaseDao {
    /**
     * 修改品牌
     */
    int updateBrands(UpdateEntity var1);
}