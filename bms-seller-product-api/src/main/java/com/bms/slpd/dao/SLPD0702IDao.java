package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.param.wrapper.SlpdProductProducerParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0702IDao extends BaseDao {
    /**
     * 新增单品品牌(规格)生产商
     */
    int saveProducerProducts(List<SlpdProducerProduct> slpdProducerProducts);

    /**
     * 新增单品品牌排他
     */
    List<SlpdProducerProduct> findProducerProduct(List<SlpdProductProducerParam> slpdProducerProducts);
}
