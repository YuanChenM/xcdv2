package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

public interface SLPD0503IDao extends BaseDao {

    /**
     * <p>修改品牌单品</p>
     */
    int batchModify(UpdateEntity updateEntity);

}