package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.entity.target.SlpdProducerProductTarget;
import com.framework.boot.base.BaseDao;

public interface SLPD0703IDao extends BaseDao {
    /**
     * 修改单品品牌(规格)生产商
     */
    int updateProducerProduct(UpdateEntity<SlpdProducerProduct, SlpdProducerProductTarget> updateEntity);
}
