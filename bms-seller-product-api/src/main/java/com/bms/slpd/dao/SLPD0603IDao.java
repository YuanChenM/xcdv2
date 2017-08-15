package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

public interface SLPD0603IDao extends BaseDao {

    /**
     * <p>修改原种种源标准指标</p>
     */
    int modifyOrgStds(UpdateEntity updateEntity);

}