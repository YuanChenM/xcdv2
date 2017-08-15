package com.bms.order.fms.services.impl;

import com.bms.order.fms.bean.FmsAgentOrderBean;
import com.bms.order.fms.bean.FmsAgentOrderDetail;
import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.bean.OmsOrderPayment;
import com.bms.order.fms.constant.FmsMasterDataDef;
import com.bms.order.fms.dao.FmsAgentOrderDao;
import com.bms.order.fms.services.FmsAgentOrderService;
import com.bms.order.fms.services.OmsOrderPaymentService;
import com.bms.order.fms.utils.FmsDataUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/22 0012.
 *
 * 买手合伙人囤货订单ServiceImpl
 */
@Service
public class FmsAgentOrderServiceImpl extends BaseServiceImpl implements FmsAgentOrderService {

    @Autowired
    private FmsAgentOrderDao fmsAgentOrderDao;
    @Autowired
    private OmsOrderPaymentService omsOrderPaymentService;

    @Override
    public BaseDao getBaseDao() {
        return fmsAgentOrderDao;
    }

    @Override
    public List<FmsAgentOrderBean> getAgentOrder(FmsOrderParam param){
        List<FmsAgentOrderBean> fmsAgentOrderBeans = fmsAgentOrderDao.findAgentOrder(param);
        for (FmsAgentOrderBean agentOrder: fmsAgentOrderBeans) {
            if(agentOrder != null){
                agentOrder.setOrderedDateMir(FmsDataUtil.ConvertDate(agentOrder.getOrderPlaceDate()));
                setConstantAndMasterData(agentOrder);
                setPaymentType(agentOrder);
                setAgentOrderDetail(agentOrder);
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
    private void setPaymentType(FmsAgentOrderBean agentOrder){
        if (agentOrder.getOmsOrderId() == null){
            return;
        }
        List<OmsOrderPayment> orderPayments = omsOrderPaymentService.getOrderPayment(agentOrder.getOmsOrderId());
        if(!CollectionUtils.isEmpty(orderPayments)){
            agentOrder.setPaymentType(orderPayments.get(0).getPaymentWay());
            agentOrder.setMemberPer(orderPayments.get(0).getPaymentAmount());
        }
    }

    /**
     * 设置买手合伙人囤货订单的常量和基础数据
     */
    private void setConstantAndMasterData(FmsAgentOrderBean agentOrder){
        //常量
        agentOrder.setTransactionalCurrCode(FmsMasterDataDef.MONEY_UNIT.CNY);
        agentOrder.setOrderSource(FmsMasterDataDef.ORDER_SOUCE.OMS);
        //FMS MasterData
        agentOrder.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.AGENT_ORDER);
        agentOrder.setStatus(FmsMasterDataDef.FMS_STATUS.ORDER_ALREADY);

        //无法提供的写死数据
        agentOrder.setMemberPer(BigDecimal.ZERO);
        agentOrder.setLoanPer(BigDecimal.ZERO);
    }

    private void setAgentOrderDetail(FmsAgentOrderBean agentOrder){
        if (agentOrder.getOmsOrderId() != null){
            List<FmsAgentOrderDetail> details = fmsAgentOrderDao.findAgentOrderDetail(agentOrder);
            if(!CollectionUtils.isEmpty(details)){
                for (FmsAgentOrderDetail detail:details) {
                    detail.setOrderQuantityUom(FmsDataUtil.ConvertGoodsUnit(detail.getOrderQuantityUom()));
                }
                agentOrder.setLine(details);
                return;
            }
        }
        agentOrder.setLine(new ArrayList<FmsAgentOrderDetail>());
    }
}

