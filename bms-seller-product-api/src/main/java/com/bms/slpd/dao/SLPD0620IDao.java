package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

public interface SLPD0620IDao extends BaseDao {

    /**
     * <p>修改储存运输标准指标</p>
     */
    int batchModify(UpdateEntity updateEntity);
}