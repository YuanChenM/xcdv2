package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.bms.slpd.bean.param.wrapper.SlpdSellerCommodityParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0801IDao extends BaseDao {

    List<SlpdSellerCommodity> findSellerProductProducers(List<SlpdSellerCommodityParam> param);

}