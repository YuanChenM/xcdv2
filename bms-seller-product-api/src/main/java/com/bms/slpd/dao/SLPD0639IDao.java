package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

public interface SLPD0639IDao extends BaseDao {

    /**
     * <p>修改通用质量标准指标差异</p>
     */
    int batchModify(UpdateEntity updateEntity);

}