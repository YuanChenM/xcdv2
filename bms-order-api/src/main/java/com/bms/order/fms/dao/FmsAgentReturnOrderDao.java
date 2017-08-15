package com.bms.order.fms.dao;

import com.bms.order.fms.bean.FmsAgentReturnOrderBean;
import com.bms.order.fms.bean.FmsAgentReturnOrderDetail;
import com.bms.order.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27.
 *
 * 买手囤货退货订单Dao
 */
public interface FmsAgentReturnOrderDao extends BaseDao {
    List<FmsAgentReturnOrderBean>  findAgentReturnOrder(FmsOrderParam param);
    List<FmsAgentReturnOrderDetail> findAgentReturnOrderDetail(FmsAgentReturnOrderBean param);
}
