package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.param.field.SLPD1816IProductParam;
import com.bms.slpd.bean.param.field.SLPD1816ISearchProductParam;
import com.bms.slpd.bean.result.field.SLPD1816IProductResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD1816IDao extends BaseDao {

    /**
     *根据插入的单品规格查询对应的产品信息
     */
    List<SLPD1816IProductResult> searchProductInfo(SLPD1816ISearchProductParam productParam);

    /**
     * 查询新增的产品是否已经存在
     */
    List<SlpdProduct> findExistProducts(List<SLPD1816IProductParam> productParam);

    /**
     *查询产品表产品Id最大值
     */
    String findMaxProductId();

}