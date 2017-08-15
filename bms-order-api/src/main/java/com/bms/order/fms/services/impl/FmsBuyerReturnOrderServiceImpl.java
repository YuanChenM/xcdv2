package com.bms.order.fms.services.impl;

import com.bms.order.constant.enumeration.BizType;
import com.bms.order.fms.bean.*;
import com.bms.order.fms.constant.FmsMasterDataDef;
import com.bms.order.fms.dao.FmsBuyerReturnOrderDao;
import com.bms.order.fms.services.FmsBuyerReturnOrderService;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/22 0012.
 *
 * 买家退货订单ServiceImpl
 */
@Service
public class FmsBuyerReturnOrderServiceImpl extends BaseServiceImpl implements FmsBuyerReturnOrderService {

    @Autowired
    private FmsBuyerReturnOrderDao fmsBuyerReturnOrderDao;
    @Autowired
    private OmsCommonService omsCommonService;
    @Autowired
    private OmsOrderOriginService omsOrderOriginService;
    @Autowired
    private OmsOrderPaymentService omsOrderPaymentService;

    @Override
    public BaseDao getBaseDao() {
        return fmsBuyerReturnOrderDao;
    }

    @Override
    public List<FmsBuyerReturnOrderBean> getBuyerReturnOrder(FmsOrderParam param){
        List<FmsBuyerReturnOrderBean> fmsBuyerOrderBeans = fmsBuyerReturnOrderDao.findBuyerReturnOrder(param);
        for (FmsBuyerReturnOrderBean returnOrderBean: fmsBuyerOrderBeans) {
            if(returnOrderBean != null){
                //TODO 买家订单退货没有BACK_NO，使用买家订单BACK_NO前面加RE临时实现
                returnOrderBean.setOrgsystemId("RE" + returnOrderBean.getOrgsystemId());
                //设置下单日期为买家退货订单申请时间
                returnOrderBean.setOrderPlaceDatetime(FmsDataUtil.ConvertDate(returnOrderBean.getOrderPlaceDate()));

                setPaymentType(returnOrderBean);
                setBuyerReturnOrderDetail(returnOrderBean);
                setAgent(returnOrderBean);
                setConstantAndMasterData(returnOrderBean);

                //清空日期型的下单日期
                returnOrderBean.setOrderPlaceDate(null);
                //清空买手ID数据
                returnOrderBean.setAgentId(null);
            }
        }
        return fmsBuyerOrderBeans;
    }

    /**
     * 设置买家支付类型
     */
    private void setPaymentType(FmsBuyerReturnOrderBean returnOrderBean){
        if (returnOrderBean.getOmsOrderId() == null){
            return;
        }
        List<OmsOrderPayment> orderPayments = omsOrderPaymentService.getOrderPayment(returnOrderBean.getOmsOrderId());
        if(!CollectionUtils.isEmpty(orderPayments)){
            returnOrderBean.setPaymentType(orderPayments.get(0).getPaymentWay());
        }
    }

    /**
     * 设置买家订单中的买手信息
     */
    private void setAgent(FmsBuyerReturnOrderBean returnOrderBean){
        if (StringUtils.isEmpty(returnOrderBean.getAgentId())){
            return;
        }
        OmsAgentDistribution omsAgentDistribution = new OmsAgentDistribution();
        omsAgentDistribution.setAgentId(returnOrderBean.getAgentId());
        omsAgentDistribution = omsCommonService.getAgentDistribution(omsAgentDistribution);
        returnOrderBean.setWhCode(omsAgentDistribution.getDistributionCode());
        if(StringUtils.isEmpty(returnOrderBean.getBsId())){
            OmsAgent omsAgent = new OmsAgent();
            omsAgent.setAgentId(returnOrderBean.getAgentId());
            omsAgent = omsCommonService.getAgent(omsAgent);
            returnOrderBean.setBsId(omsAgent.getAgentCode());
        }
    }

    /**
     * 设置买家订单的常量和基础数据
     */
    private void setConstantAndMasterData(FmsBuyerReturnOrderBean returnOrderBean){
        //常量
        returnOrderBean.setTransactionalCurrCode(FmsMasterDataDef.MONEY_UNIT.CNY);
        returnOrderBean.setOrderSource(FmsMasterDataDef.ORDER_SOUCE.OMS);
        //FMS MasterData
        returnOrderBean.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.BUYER_RETURN_ORDER);
    }

    private void setBuyerReturnOrderDetail(FmsBuyerReturnOrderBean buyerReturnOrder){
        List<FmsBuyerReturnOrderDetail> fmsBuyerReturnOrderDetails = new ArrayList<>();
        if (buyerReturnOrder.getOmsOrderId() != null){
            List<OmsBuyerReturnOrderDetail> details = fmsBuyerReturnOrderDao.findBuyerReturnOrderDetail(buyerReturnOrder);
            if(!CollectionUtils.isEmpty(details)){
                OmsOrderOrigin omsOrderOrigin = createOmsOrderOrigin(buyerReturnOrder);
                for (OmsBuyerReturnOrderDetail detail:details) {
                    detail.setReasonId(FmsMasterDataDef.RETURN_REASON.DEFAULT);
                    setOrderStock(omsOrderOrigin, detail);
                    detail.setSalesUnit(FmsDataUtil.ConvertGoodsUnit(detail.getSalesUnit()));
                    setManufacturerAndProducer(detail);
                    fmsBuyerReturnOrderDetails.add(BeanUtils.toBean(detail, FmsBuyerReturnOrderDetail.class));
                }
            }
        }
        buyerReturnOrder.setLine(fmsBuyerReturnOrderDetails);
    }


    /**
     * 设置订单明细中的制造商和生产商信息
     */
    private void setManufacturerAndProducer(OmsBuyerReturnOrderDetail detail){
        if (StringUtils.isEmpty(detail.getSku())){
            return;
        }
        OmsManufacturerSkuParam param = new OmsManufacturerSkuParam();
        param.setManufacturerProductSku(detail.getSku());
        OmsManufacturerProduct omsManufacturerProduct = omsCommonService.getManufacturer(param);
        if(StringUtils.isEmpty(detail.getMfrsCode())){
            detail.setMfrsCode(omsManufacturerProduct.getEntitySellerCode());
            detail.setMfrsName(omsManufacturerProduct.getFullName());
        }
        if(StringUtils.isEmpty(detail.getPdrsCode())){
            List<OmsProducerProduct> omsProducerProducts = omsManufacturerProduct.getProducerProducts();
            if(!CollectionUtils.isEmpty(omsProducerProducts)){
                detail.setPdrsCode(omsProducerProducts.get(0).getEntitySellerCode());
                detail.setPrdsName(omsProducerProducts.get(0).getFullName());
            }
        }
    }

    /**
     * 创建Oms买家订单溯源用bean
     */
    private OmsOrderOrigin createOmsOrderOrigin(FmsBuyerReturnOrderBean order){
        OmsOrderOrigin omsOrderOrigin = new OmsOrderOrigin();
        //omsOrderOrigin.setBuyerId(order.getBuyerId());
        omsOrderOrigin.setOrderId(order.getOmsOrderId());
        omsOrderOrigin.setOrderCode(order.getOmsOrderNumber());
        //设置业务类型为011买手销售退货
        omsOrderOrigin.setBizType(BizType.AgentSaleReturn.getCode());
        omsOrderOrigin.setBuyerOrderId(order.getBuyerOrderId());
        omsOrderOriginService.setOrderSellerDetail(omsOrderOrigin);
        return omsOrderOrigin;
    }

    /**
     * 设置订单溯源信息
     */
    private void setOrderStock(OmsOrderOrigin omsOrderOrigin, OmsBuyerReturnOrderDetail detail){
        omsOrderOrigin.setOrderDetailId(detail.getOrderDetailId());
        omsOrderOrigin.setDetailId(detail.getReturnDetailId());
        omsOrderOrigin.setSellSideId(detail.getSellSideId());
        List<FmsBuyerReturnOrderStock> stocks = omsOrderOriginService.getFmsBuyerReturnOrderStocks(omsOrderOrigin);
        detail.setSubLine(stocks);
    }
}

