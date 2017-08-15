package com.bms.order.fms.dao;

import com.bms.order.fms.bean.FmsBuyerCancelOrderBean;
import com.bms.order.fms.bean.FmsBuyerCancelOrderDetail;
import com.bms.order.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * 买家取消订单Dao
 */
public interface FmsBuyerCancelOrderDao extends BaseDao {
    List<FmsBuyerCancelOrderBean>  findBuyerCancelOrder(FmsOrderParam param);
    List<FmsBuyerCancelOrderDetail> findBuyerCancelOrderDetail(FmsBuyerCancelOrderBean param);
}
