package com.bms.order.fms.dao;

import com.bms.order.fms.bean.FmsBuyerOrderBean;
import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.bean.OmsBuyerOrderDetail;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * 买家订单Dao
 */
public interface FmsBuyerOrderDao extends BaseDao {
    List<FmsBuyerOrderBean>  findBuyerOrder(FmsOrderParam param);
    List<OmsBuyerOrderDetail> findBuyerOrderDetail(FmsOrderParam param);
}
