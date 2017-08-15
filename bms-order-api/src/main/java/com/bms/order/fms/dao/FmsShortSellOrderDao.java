package com.bms.order.fms.dao;

import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.bean.FmsShortSellOrderBean;
import com.bms.order.fms.bean.FmsShortSellOrderDetail;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/28
 *
 * 估货订单Dao
 */
public interface FmsShortSellOrderDao extends BaseDao {
    List<FmsShortSellOrderBean>  findShortSellOrder(FmsOrderParam param);
    List<FmsShortSellOrderDetail> findShortSellOrderDetail(FmsShortSellOrderBean param);
}
