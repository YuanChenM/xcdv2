package com.bms.order.fms.services.impl;

import com.bms.order.fms.bean.FmsAgentReturnOrderBean;
import com.bms.order.fms.bean.FmsAgentReturnOrderDetail;
import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.bean.OmsOrderPayment;
import com.bms.order.fms.constant.FmsMasterDataDef;
import com.bms.order.fms.dao.FmsAgentReturnOrderDao;
import com.bms.order.fms.services.FmsAgentReturnOrderService;
import com.bms.order.fms.services.OmsOrderPaymentService;
import com.bms.order.fms.utils.FmsDataUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/22 0012.
 *
 * 买手合伙人囤货退货订单ServiceImpl
 */
@Service
public class FmsAgentReturnOrderServiceImpl extends BaseServiceImpl implements FmsAgentReturnOrderService {

    @Autowired
    private FmsAgentReturnOrderDao fmsAgentReturnOrderDao;
    @Autowired
    private OmsOrderPaymentService omsOrderPaymentService;

    @Override
    public BaseDao getBaseDao() {
        return fmsAgentReturnOrderDao;
    }

    @Override
    public List<FmsAgentReturnOrderBean> getAgentReturnOrder(FmsOrderParam param){
        List<FmsAgentReturnOrderBean> fmsAgentOrderBeans = fmsAgentReturnOrderDao.findAgentReturnOrder(param);
        for (FmsAgentReturnOrderBean agentOrder: fmsAgentOrderBeans) {
            if(agentOrder != null){
                //TODO 买手囤货退货没有BACK_NO，使用买手订单BACK_NO前面加RE临时实现
                agentOrder.setOrgSystemId("RE" + agentOrder.getOrgSystemId());
                //退货下单日期使用申请日期
                agentOrder.setOrderedDateMir(FmsDataUtil.ConvertDate(agentOrder.getOrderPlaceDate()));

                setPaymentType(agentOrder);
                setConstantAndMasterData(agentOrder);
                setAgentReturnOrderDetail(agentOrder);

                //清空买手ID数据
                agentOrder.setCustomerOrgNumber(null);
                //清空日期型的下单日期
                agentOrder.setOrderPlaceDate(null);
            }
        }
        return fmsAgentOrderBeans;
    }

    /**
     * 设置买手囤货支付类型
     */
    private void setPaymentType(FmsAgentReturnOrderBean agentOrder){
        if (agentOrder.getOmsOrderId() == null){
            return;
        }
        List<OmsOrderPayment> orderPayments = omsOrderPaymentService.getOrderPayment(agentOrder.getOmsOrderId());
        if(!CollectionUtils.isEmpty(orderPayments)){
            agentOrder.setPaymentType(orderPayments.get(0).getPaymentWay());
        }
    }

    /**
     * 设置买手合伙人囤货退货订单的常量和基础数据
     */
    private void setConstantAndMasterData(FmsAgentReturnOrderBean agentOrder){
        //常量
        agentOrder.setTransactionalCurrCode(FmsMasterDataDef.MONEY_UNIT.CNY);
        agentOrder.setOrderSource(FmsMasterDataDef.ORDER_SOUCE.OMS);
        //FMS MasterData
        agentOrder.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.AGENT_RETURN_ORDER);
        agentOrder.setStatus(FmsMasterDataDef.FMS_STATUS.ORDER_ALREADY);
    }

    private void setAgentReturnOrderDetail(FmsAgentReturnOrderBean agentOrder){
        if (agentOrder.getOmsOrderId() != null){
            List<FmsAgentReturnOrderDetail> details = fmsAgentReturnOrderDao.findAgentReturnOrderDetail(agentOrder);
            if(!CollectionUtils.isEmpty(details)){
                for (FmsAgentReturnOrderDetail detail:details) {
                    detail.setReturnReason(FmsMasterDataDef.RETURN_REASON.DEFAULT);
                    detail.setOrderQuantityUom(FmsDataUtil.ConvertGoodsUnit(detail.getOrderQuantityUom()));
                }
                agentOrder.setLine(details);
                return;
            }
        }
        agentOrder.setLine(new ArrayList<FmsAgentReturnOrderDetail>());
    }
}

