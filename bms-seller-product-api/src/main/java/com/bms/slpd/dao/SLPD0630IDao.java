package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

public interface SLPD0630IDao extends BaseDao {

    /**
     * <p>修改饲养标准指标差异</p>
     */
    int batchModify(UpdateEntity updateEntity);

}