package com.bms.puch.fms.services;

import com.bms.puch.fms.bean.FmsAgentBidOrderBean;
import com.bms.puch.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27 0027.
 *
 * 买手合伙人竞价订单Service
 */
public interface FmsAgentBidOrderService extends BaseService {
    @Transactional
    List<FmsAgentBidOrderBean> getAgentBidOrder(FmsOrderParam param);
}
