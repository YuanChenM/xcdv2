package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

public interface SLPD0612IDao extends BaseDao {

    /**
     * <p>修改加工质量标准</p>
     */
    int batchModify(UpdateEntity updateEntity);

}