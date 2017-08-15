package com.bms.order.fms.dao;

import com.bms.order.fms.bean.FmsBuyerReturnOrderBean;
import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.bean.OmsBuyerReturnOrderDetail;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 * <p>
 * 买家退货订单Dao
 */
public interface FmsBuyerReturnOrderDao extends BaseDao {
    List<FmsBuyerReturnOrderBean> findBuyerReturnOrder(FmsOrderParam param);
    List<OmsBuyerReturnOrderDetail> findBuyerReturnOrderDetail(FmsBuyerReturnOrderBean param);
}
