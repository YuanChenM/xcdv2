package com.bms.order.fms.dao;

import com.bms.order.fms.bean.OmsOrderPayment;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * 买家订单Dao
 */
public interface OmsOrderPaymentDao extends BaseDao {
    List<OmsOrderPayment> findOrderPayment(OmsOrderPayment param);
    List<OmsOrderPayment> findOrderTotalPayment(OmsOrderPayment param);
}
