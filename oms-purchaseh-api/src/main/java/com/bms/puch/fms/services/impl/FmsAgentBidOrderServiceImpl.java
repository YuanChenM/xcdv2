package com.bms.puch.fms.services.impl;

import com.bms.puch.fms.bean.*;
import com.bms.puch.fms.constant.FmsMasterDataDef;
import com.bms.puch.fms.dao.FmsAgentBidOrderDao;
import com.bms.puch.fms.services.FmsAgentBidOrderService;
import com.bms.puch.fms.services.OmsCommonService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/22 0012.
 * <p>
 * 买手合伙人竞价订单ServiceImpl
 */
@Service
public class FmsAgentBidOrderServiceImpl extends BaseServiceImpl implements FmsAgentBidOrderService {

    @Autowired
    private FmsAgentBidOrderDao fmsAgentBidOrderDao;
    @Autowired
    private OmsCommonService omsCommonService;

    @Override
    public BaseDao getBaseDao() {
        return fmsAgentBidOrderDao;
    }

    @Override
    public List<FmsAgentBidOrderBean> getAgentBidOrder(FmsOrderParam param) {
        List<FmsAgentBidOrderBean> fmsAgentBidOrderBeans = fmsAgentBidOrderDao.findAgentBidOrder(param);
        for (FmsAgentBidOrderBean agentBidOrder : fmsAgentBidOrderBeans) {
            if (agentBidOrder != null) {
                setAgentCode(agentBidOrder);
                setAgentBidOrderDetail(agentBidOrder);
                if(!CollectionUtils.isEmpty(agentBidOrder.getLine())){
                    agentBidOrder.setOrgSystemId(agentBidOrder.getLine().get(0).getOrgOrderCode());
                }
                //清空买手合伙人ID数据
                agentBidOrder.setCustomerOrgNumber(null);
            }
        }
        return fmsAgentBidOrderBeans;
    }

    private void setAgentBidOrderDetail(FmsAgentBidOrderBean agentBidOrder) {
        if (agentBidOrder.getOmsOrderId() != null) {
            List<FmsAgentBidOrderDetail> details = fmsAgentBidOrderDao.findAgentBidOrderDetail(agentBidOrder);
            if (!CollectionUtils.isEmpty(details)) {
                //agentBidOrder.setOrderType(details.get(NumberConst.IntDef.INT_ZERO).getOrderType());
                agentBidOrder.setOrderedDateMir(DateUtils.formatDateTime(details.get(NumberConst.IntDef.INT_ZERO).getInboundDate()));
                for (FmsAgentBidOrderDetail agentBidOrderDetail : details) {
                    if ("001".equals(agentBidOrderDetail.getOrderQuantityUom()) || "箱".equals(agentBidOrderDetail.getOrderQuantityUom())) {
                        agentBidOrderDetail.setOrderQuantityUom(FmsMasterDataDef.FMS_UNIT_TYPE.U_BOX);
                    }else if("002".equals(agentBidOrderDetail.getOrderQuantityUom()) || "千克".equals(agentBidOrderDetail.getOrderQuantityUom())) {
                        agentBidOrderDetail.setOrderQuantityUom(FmsMasterDataDef.FMS_UNIT_TYPE.U_KG);
                    }else {
                        agentBidOrderDetail.setOrderQuantityUom(FmsMasterDataDef.FMS_UNIT_TYPE.U_BA);
                    }
                    agentBidOrderDetail.setInboundDate(null);
                    agentBidOrderDetail.setOrderType(null);
                }
                setConstantParam(agentBidOrder);
                agentBidOrder.setLine(details);
                return;
            }
        }
        agentBidOrder.setLine(new ArrayList<FmsAgentBidOrderDetail>());
    }

    private void setConstantParam(FmsAgentBidOrderBean agentBidOrder) {
        agentBidOrder.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.AGENT_BID_ORDER);
        agentBidOrder.setOrderSource(FmsMasterDataDef.ORDER_SOUCE.OMS);
        agentBidOrder.setStatus(FmsMasterDataDef.FMS_STATUS.ORDER_ALREADY);
        agentBidOrder.setTransactionalCurrCode(FmsMasterDataDef.MONEY_UNIT.CNY);
        //agentBidOrder.setPaymentType("现金");
        agentBidOrder.setTerms(FmsMasterDataDef.TERMS_TYPE.DEFAULT);
        agentBidOrder.setOrderOrgsource("SRM");
    }

    private void setAgentCode(FmsAgentBidOrderBean agentBidOrder) {
        //获取买手合伙人编码
        OmsAgent omsAgent = new OmsAgent();
        omsAgent.setAgentId(agentBidOrder.getCustomerOrgNumber());
        omsAgent = omsCommonService.getAgent(omsAgent);
        OmsPartner omsPartner = new OmsPartner();
        omsPartner.setPartnerId(agentBidOrder.getCustomerOrgNumber());
        OmsPartner partner = omsCommonService.getPartner(omsPartner);
        if (omsAgent != null) {
            agentBidOrder.setCustomerNumber(omsAgent.getAgentCode());
        } else {
            if (partner != null) {
                agentBidOrder.setCustomerNumber(partner.getPartnerCode());
            }
        }

    }
}

