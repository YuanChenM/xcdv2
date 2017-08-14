package com.bms.como.dao;

import com.bms.como.bean.result.CommodityDetailRsResult;
import com.bms.como.bean.result.CommodityUomRsResult;
import com.bms.como.bean.result.SaleListRsResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface ComoSaleListDao extends BaseDao {
    List<CommodityDetailRsResult> findDetailByCommodityId(List<SaleListRsResult> commodityResultList);

    List<CommodityUomRsResult> findUomByCommodityId(List<SaleListRsResult> commodityResultList);

}
