package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.framework.boot.base.BaseDao;

public interface SLPD0806IDao extends BaseDao {

    //获取卖家最大货号
    String getMaxArticleNo(SlpdSellerCommodity slpdSellerCommodity);

    //获取最大商品ID
    String getMaxCommodityId(SlpdSellerCommodity slpdSellerCommodity);

    //根据ID查询数据基本信息
    SlpdSellerCommodity findSellerCommodityById(Long sellerCommodityId);

}
