package com.bms.order.fms.services.impl;

import com.bms.order.constant.enumeration.BizType;
import com.bms.order.constant.enumeration.OrderPlaceType;
import com.bms.order.constant.enumeration.PaymentStu;
import com.bms.order.fms.bean.*;
import com.bms.order.fms.constant.FmsMasterDataDef;
import com.bms.order.fms.dao.FmsBuyerOrderDao;
import com.bms.order.fms.services.FmsBuyerOrderService;
import com.bms.order.fms.services.OmsCommonService;
import com.bms.order.fms.services.OmsOrderOriginService;
import com.bms.order.fms.services.OmsOrderPaymentService;
import com.bms.order.fms.utils.FmsDataUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * 买家订单ServiceImpl
 */
@Service
public class FmsBuyerOrderServiceImpl extends BaseServiceImpl implements FmsBuyerOrderService {

    @Autowired
    private FmsBuyerOrderDao fmsBuyerOrderDao;
    @Autowired
    private OmsCommonService omsCommonService;
    @Autowired
    private OmsOrderOriginService omsOrderOriginService;
    @Autowired
    private OmsOrderPaymentService omsOrderPaymentService;

    @Override
    public BaseDao getBaseDao() {
        return fmsBuyerOrderDao;
    }

    /**
     * 取得买家订单数据
     */
    @Override
    public List<FmsBuyerOrderBean> getBuyerOrder(FmsOrderParam param){
        List<FmsBuyerOrderBean> fmsBuyerOrderBeans = fmsBuyerOrderDao.findBuyerOrder(param);
        for (FmsBuyerOrderBean buyerOrder: fmsBuyerOrderBeans) {
            if(buyerOrder != null){
                //setBuyAmount(buyerOrder);//使用买家订单总金额
                buyerOrder.setOrderedDateMir(FmsDataUtil.ConvertDate(buyerOrder.getOrderPlaceDate()));
                //setBuyer(buyerOrder);//customerNumber使用买家编码，不需要查询买家帐号了
                setAgent(buyerOrder);
                setConstantAndMasterData(buyerOrder);

                param.setPushOrderId(buyerOrder.getOmsOrderId());
                setBuyerOrderDetail(buyerOrder, param);

                //清空买家ID数据
                buyerOrder.setCustomerOrgNumber(null);
                //清空买手ID数据
                buyerOrder.setAgentId(null);
                //清空日期型的下单日期
                buyerOrder.setOrderPlaceDate(null);
            }
        }
        return fmsBuyerOrderBeans;
    }

    /**
     * 设置买家付款总金额
     */
    private void setBuyAmount(FmsBuyerOrderBean buyerOrder){
        buyerOrder.setBuyAmount(new BigDecimal(0));
        if (buyerOrder.getOmsOrderId() == null){
            return;
        }
        List<OmsOrderPayment> orderPayments = omsOrderPaymentService.getOrderTotalPayment(buyerOrder.getOmsOrderId());
        if(!CollectionUtils.isEmpty(orderPayments)){
            buyerOrder.setBuyAmount(orderPayments.get(0).getPaymentAmount());
        }
    }

    /**
     * 设置买家订单的买家信息
     */
    private void setBuyer(FmsBuyerOrderBean buyerOrder){
        if (StringUtils.isEmpty(buyerOrder.getCustomerOrgNumber())){
            return;
        }
        OmsBuyer omsBuyer = new OmsBuyer();
        omsBuyer.setBuyerId(buyerOrder.getCustomerOrgNumber());
        omsBuyer = omsCommonService.getBuyer(omsBuyer);
        buyerOrder.setCustomerNumber(omsBuyer.getAccountName());
    }

    /**
     * 设置买家订单中的买手信息
     */
    private void setAgent(FmsBuyerOrderBean buyerOrder){
        if (StringUtils.isEmpty(buyerOrder.getAgentId())){
            return;
        }
        OmsAgentDistribution omsAgentDistribution = new OmsAgentDistribution();
        omsAgentDistribution.setAgentId(buyerOrder.getAgentId());
        omsAgentDistribution = omsCommonService.getAgentDistribution(omsAgentDistribution);
        buyerOrder.setStationNumber(omsAgentDistribution.getDistributionCode());
        if(StringUtils.isEmpty(buyerOrder.getSalesNumber())){
            OmsAgent omsAgent = new OmsAgent();
            omsAgent.setAgentId(buyerOrder.getAgentId());
            omsAgent = omsCommonService.getAgent(omsAgent);
            buyerOrder.setSalesNumber(omsAgent.getAgentCode());
        }
    }

    /**
     * 设置买家订单的常量和基础数据
     */
    private void setConstantAndMasterData(FmsBuyerOrderBean buyerOrder){
        //常量
        buyerOrder.setTransactionalCurrCode(FmsMasterDataDef.MONEY_UNIT.CNY);
        buyerOrder.setOrderSource(FmsMasterDataDef.ORDER_SOUCE.OMS);
        //FMS MasterData
        buyerOrder.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.BUYER_ORDER);
        buyerOrder.setOmsStatus(FmsMasterDataDef.FMS_STATUS.ORDER_ALREADY);

        //A类订单时为买家付款，设置买手垫付会员金额为0
        if(StringUtils.equals(buyerOrder.getOrderPlaceType(), OrderPlaceType.A_TYPE.getCode())){
            buyerOrder.setMemberPerPayfor(BigDecimal.ZERO);
        }else {
            //暂定：B类订单的发货却未付款的情况，是货到付款，为买家付款，设置买手垫付会员金额为0
            if(StringUtils.equals(buyerOrder.getOrderPaymentStu(), PaymentStu.NOT_PAYMENT.getCode())){
                buyerOrder.setMemberPerPayfor(BigDecimal.ZERO);
            }
        }
    }

    /**
     * 设置买家订单的详细信息
     */
    private void setBuyerOrderDetail(FmsBuyerOrderBean buyerOrder, FmsOrderParam param){
        List<FmsBuyerOrderDetail> fmsBuyerOrderDetails = new ArrayList<>();
        if (buyerOrder.getOmsOrderId() != null){
            List<OmsBuyerOrderDetail> details = fmsBuyerOrderDao.findBuyerOrderDetail(param);
            if(!CollectionUtils.isEmpty(details)){
                OmsOrderOrigin omsOrderOrigin = createOmsOrderOrigin(buyerOrder);
                for (OmsBuyerOrderDetail detail:details) {
                    setBuyerOrderStock(omsOrderOrigin, detail);
                    detail.setInvSource(FmsDataUtil.ConvertToInvSource(detail.getSellSideType()));
                    detail.setOrderQuantityUom(FmsDataUtil.ConvertGoodsUnit(detail.getOrderQuantityUom()));
                    setManufacturerAndProducer(detail);
                    //将明细数据添加进主数据
                    fmsBuyerOrderDetails.add(BeanUtils.toBean(detail, FmsBuyerOrderDetail.class));
                }
            }
        }
        buyerOrder.setLine(fmsBuyerOrderDetails);
    }

    /**
     * 设置订单明细中的制造商和生产商信息
     */
    private void setManufacturerAndProducer(OmsBuyerOrderDetail detail){
        if (StringUtils.isEmpty(detail.getItemSku())){
            return;
        }
        OmsManufacturerSkuParam param = new OmsManufacturerSkuParam();
        param.setManufacturerProductSku(detail.getItemSku());
        OmsManufacturerProduct omsManufacturerProduct = omsCommonService.getManufacturer(param);
        if(StringUtils.isEmpty(detail.getManufacturerCode())){
            detail.setManufacturerCode(omsManufacturerProduct.getEntitySellerCode());
            detail.setManufacturerName(omsManufacturerProduct.getFullName());
        }
        if(StringUtils.isEmpty(detail.getProducerCode())){
            List<OmsProducerProduct> omsProducerProducts = omsManufacturerProduct.getProducerProducts();
            if(!CollectionUtils.isEmpty(omsProducerProducts)){
                detail.setProducerCode(omsProducerProducts.get(0).getEntitySellerCode());
                detail.setProducerName(omsProducerProducts.get(0).getFullName());
            }
        }
    }

    /**
     * 创建Oms买家订单溯源用bean
     */
    private OmsOrderOrigin createOmsOrderOrigin(FmsBuyerOrderBean order){
        OmsOrderOrigin omsOrderOrigin = new OmsOrderOrigin();
        omsOrderOrigin.setBuyerId(order.getCustomerOrgNumber());
        omsOrderOrigin.setOrderId(order.getOmsOrderId());
        omsOrderOrigin.setOrderCode(order.getOmsOrderNumber());
        //设置业务类型为009买手销售
        omsOrderOrigin.setBizType(BizType.AgentSale.getCode());
        omsOrderOrigin.setBuyerOrderId(order.getOmsOrderId());
        omsOrderOriginService.setOrderSellerDetail(omsOrderOrigin);
        return omsOrderOrigin;
    }

    /**
     * 设置订单溯源信息
     */
    private void setBuyerOrderStock(OmsOrderOrigin omsOrderOrigin, OmsBuyerOrderDetail detail){
        omsOrderOrigin.setOrderDetailId(detail.getOrderDetailId());
        omsOrderOrigin.setSellSideId(detail.getSellSideId());
        omsOrderOrigin.setDetailId(detail.getSendDetailId());
        List<FmsBuyerOrderStock> fmsBuyerOrderStocks = omsOrderOriginService.getFmsBuyerOrderStocks(omsOrderOrigin);
        detail.setSubLine(fmsBuyerOrderStocks);
    }
}

