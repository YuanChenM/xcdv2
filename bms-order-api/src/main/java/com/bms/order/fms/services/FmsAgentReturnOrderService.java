package com.bms.order.fms.services;

import com.bms.order.fms.bean.FmsAgentReturnOrderBean;
import com.bms.order.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27 0027.
 *
 * 买手合伙人囤货退货订单Service
 */
public interface FmsAgentReturnOrderService extends BaseService {
    @Transactional
    List<FmsAgentReturnOrderBean> getAgentReturnOrder(FmsOrderParam param);
}
