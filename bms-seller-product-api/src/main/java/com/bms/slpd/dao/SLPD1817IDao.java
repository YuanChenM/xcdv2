package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.entity.target.SlpdProductTarget;
import com.framework.boot.base.BaseDao;

public interface SLPD1817IDao extends BaseDao {

    /**
     * 修改产品
     */
    int updateProduct(UpdateEntity<SlpdProduct, SlpdProductTarget> updateEntity);
}
