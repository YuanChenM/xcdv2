package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

public interface SLPD0623IDao extends BaseDao {

    /**
     * <p>修改包装标准指标</p>
     */
    int batchModify(UpdateEntity updateEntity);
}