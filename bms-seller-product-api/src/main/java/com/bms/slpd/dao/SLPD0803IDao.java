package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0803IDao extends BaseDao {

    /**
     * <p>修改(卖家)单品品牌(规格)生产商</p>TODO 验证,排他
     */
    int batchModify(UpdateEntity updateEntity);
    //更新产品审核信息 TODO 验证,排他
    int updateProductTypes(UpdateEntity updateEntity);
    //更新卖家产品生产商审核信息 TODO 验证,排他
    int updateSellerCommodityAudit(UpdateEntity updateEntity);
    //更新产品生产商审核信息 TODO 验证,排他
    int updateProducerProductTypes(UpdateEntity updateEntity);
    //获取卖家最大货号
    String getMaxCode(SlpdSellerCommodity slpdSellerCommodity);
    //根据卖家品牌生产商对象,查询相同卖家产品生产商(销售类型不同)是否存在货号
    String findSaleTypeInfo(SlpdSellerCommodity slpdSellerCommodity);
    //根据ID查询数据基本信息
    List<SlpdSellerCommodity> findSellerCommodityInfo(SlpdSellerCommodity slpdSellerCommodity);
}