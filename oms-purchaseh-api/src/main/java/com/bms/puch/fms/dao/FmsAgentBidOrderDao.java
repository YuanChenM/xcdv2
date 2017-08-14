package com.bms.puch.fms.dao;

import com.bms.puch.fms.bean.FmsAgentBidOrderDetail;
import com.bms.puch.fms.bean.FmsAgentBidOrderBean;
import com.bms.puch.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27
 *
 * 买手合伙人竞价订单Dao
 */
public interface FmsAgentBidOrderDao extends BaseDao {
    List<FmsAgentBidOrderBean>  findAgentBidOrder(FmsOrderParam param);
    List<FmsAgentBidOrderDetail> findAgentBidOrderDetail(FmsAgentBidOrderBean param);
}
