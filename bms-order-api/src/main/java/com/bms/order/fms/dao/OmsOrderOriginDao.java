package com.bms.order.fms.dao;

import com.bms.order.fms.bean.OmsOrderOrigin;
import com.bms.order.fms.bean.OmsOrderSellerDetail;
import com.bms.order.fms.bean.OmsProductInventoryDetail;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * 买家订单Dao
 */
public interface OmsOrderOriginDao extends BaseDao {
    List<OmsOrderSellerDetail> findOrderSellerDetail(OmsOrderOrigin param);
    List<OmsOrderOrigin> findAgentOrder(OmsProductInventoryDetail param);
}
