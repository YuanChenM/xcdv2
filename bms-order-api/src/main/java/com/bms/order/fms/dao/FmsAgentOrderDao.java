package com.bms.order.fms.dao;

import com.bms.order.fms.bean.FmsAgentOrderBean;
import com.bms.order.fms.bean.FmsAgentOrderDetail;
import com.bms.order.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27
 *
 * 买手囤货订单Dao
 */
public interface FmsAgentOrderDao extends BaseDao {
    List<FmsAgentOrderBean>  findAgentOrder(FmsOrderParam param);
    List<FmsAgentOrderDetail> findAgentOrderDetail(FmsAgentOrderBean param);
}
