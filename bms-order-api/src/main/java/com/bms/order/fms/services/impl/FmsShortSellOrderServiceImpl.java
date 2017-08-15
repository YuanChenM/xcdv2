package com.bms.order.fms.services.impl;

import com.bms.order.constant.enumeration.BizType;
import com.bms.order.fms.bean.*;
import com.bms.order.fms.constant.FmsMasterDataDef;
import com.bms.order.fms.dao.FmsShortSellOrderDao;
import com.bms.order.fms.dao.OmsOrderOriginDao;
import com.bms.order.fms.services.FmsShortSellOrderService;
import com.bms.order.fms.services.OmsCommonService;
import com.bms.order.fms.utils.FmsDataUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuan_chen on 2017/4/22 0012.
 *
 * 买手合伙人囤货订单ServiceImpl
 */
@Service
public class FmsShortSellOrderServiceImpl extends BaseServiceImpl implements FmsShortSellOrderService {

    @Autowired
    private FmsShortSellOrderDao fmsShortSellOrderDao;
    @Autowired
    private OmsCommonService omsCommonService;
    @Autowired
    private OmsOrderOriginDao omsOrderOriginDao;

    @Override
    public BaseDao getBaseDao() {
        return fmsShortSellOrderDao;
    }

    @Override
    public List<FmsShortSellOrderBean> getShortSellOrder(FmsOrderParam param){
        List<FmsShortSellOrderBean> fmsShortSellOrderBeans = fmsShortSellOrderDao.findShortSellOrder(param);
        for (FmsShortSellOrderBean shortSellOrder: fmsShortSellOrderBeans) {
            if(shortSellOrder != null){
                shortSellOrder.setOrderedDate(FmsDataUtil.ConvertDate(shortSellOrder.getOrderPlaceDate()));
                setConstantAndMasterData(shortSellOrder);
                setShortSellOrderDetail(shortSellOrder);

                //清空日期型的下单日期
                shortSellOrder.setOrderPlaceDate(null);
            }
        }
        return fmsShortSellOrderBeans;
    }

    /**
     * 设置买手合伙人囤货订单的常量和基础数据
     */
    private void setConstantAndMasterData(FmsShortSellOrderBean shortSellOrder){
        //常量
        shortSellOrder.setTransactionalCurrCode(FmsMasterDataDef.MONEY_UNIT.CNY);
        shortSellOrder.setOrderSource(FmsMasterDataDef.ORDER_SOUCE.OMS);
        //FMS MasterData
        shortSellOrder.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.SELL_SHORT_ORDER);

        //无法提供的写死数据
        shortSellOrder.setLoanAmount(BigDecimal.ZERO);
        if(shortSellOrder.getCapitalAmount() == null){
            shortSellOrder.setCapitalAmount(BigDecimal.ZERO);
        }
    }

    private void setShortSellOrderDetail(FmsShortSellOrderBean shortSellOrder){
        if (shortSellOrder.getOmsOrderId() != null){
            List<FmsShortSellOrderDetail> details = fmsShortSellOrderDao.findShortSellOrderDetail(shortSellOrder);
            if(!CollectionUtils.isEmpty(details)){
                for (FmsShortSellOrderDetail detail:details) {
                    detail.setOrderQuantityUom(FmsDataUtil.ConvertGoodsUnit(detail.getOrderQuantityUom()));
                    setOrderStock(shortSellOrder, detail);
                }
                shortSellOrder.setLine(details);
                return;
            }
        }
        shortSellOrder.setLine(new ArrayList<FmsShortSellOrderDetail>());
    }

    /**
     * 设置沽货订单溯源信息
     */
    private void setOrderStock(FmsShortSellOrderBean order, FmsShortSellOrderDetail orderDetail){
        //作成溯源查询参数
        OmsProductInventoryParam productInventoryParam = new OmsProductInventoryParam();
        //设置出货货权人ID为供货方ID
        productInventoryParam.setOwnerId(order.getSourceId());
        //设置收货货权人ID为下单的买家ID
        productInventoryParam.setTargetId(order.getCustomerOrgNumber());
        //设置业务类型为沽货囤货（007）
        productInventoryParam.setBizType(BizType.AlgorithmicStore.getCode());
        //设置业务单ID为OMS沽货订单ID
        productInventoryParam.setTransactionId(order.getOmsOrderId());
        //设置业务单号为OMS沽货订单编码
        productInventoryParam.setTransactionNo(order.getOmsOrderNumber());
        //设置业务明细单号为沽货订单明细ID
        productInventoryParam.setTransactionDetailId(orderDetail.getLineNum());
        //调用商品库存溯源接口
        OmsProductInventoryBean productInventoryBean = omsCommonService.getOrderStock(productInventoryParam);
        //判断是否溯源到数据
        if(productInventoryBean == null){
            return;
        }
        List<OmsProductInventoryDetail> productInventoryDetails = productInventoryBean.getSrcList();
        if(CollectionUtils.isEmpty(productInventoryDetails)){
            return;
        }
        List<FmsShortSellOrderStock> stocks = new ArrayList<>();
        FmsShortSellOrderStock stock;
        Map<Long, Integer> stockMap = new HashMap<>();
        int lineNum = 1;
        for (OmsProductInventoryDetail productInventoryDetail :productInventoryBean.getSrcList()) {
            stock = new FmsShortSellOrderStock();
            stock.setLineNum(lineNum);
            stock.setProductId(StringUtils.toString(productInventoryDetail.getSrcCommodityId()));
            stock.setStockorderOrderId(productInventoryDetail.getSrcTransactionId());
            stock.setStockorderOrderNumber(productInventoryDetail.getSrcTransactionNo());
            stock.setOrderedQuantity(productInventoryDetail.getSrcDealQty());
            if(!StringUtils.isEmpty(productInventoryDetail.getSrcTransactionNo())){
                List<OmsOrderOrigin> editStocks;
                String type1 = StringUtils.left(productInventoryDetail.getSrcTransactionNo(), 1);
                String type2 = StringUtils.left(productInventoryDetail.getSrcTransactionNo(), 4);
                if(StringUtils.equals(type1, "D")){
                    stock.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.AGENT_BID_ORDER);
                }else if(StringUtils.equals(type2, "MSDD")){
                    stock.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.AGENT_ORDER);
                }else if(StringUtils.equals(type2, "MSXQ")){
                    stock.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.AGENT_ORDER);
                    editStocks = omsOrderOriginDao.findAgentOrder(productInventoryDetail);
                    if(!CollectionUtils.isEmpty(editStocks)){
                        stock.setStockorderOrderId(editStocks.get(0).getOrderId());
                        stock.setStockorderOrderNumber(editStocks.get(0).getOrderCode());
                        stock.setProductId(StringUtils.toString(editStocks.get(0).getCommodityId()));
                    }
                }else{
                    stock.setOrderType(FmsMasterDataDef.FMS_ORDER_TYPE.SELL_SHORT_ORDER);
                }
            }

            if(stockMap.containsKey(stock.getStockorderOrderId())){
                int index = stockMap.get(stock.getStockorderOrderId());
                BigDecimal qty = stock.getOrderedQuantity().add(stocks.get(index).getOrderedQuantity());
                stocks.get(index).setOrderedQuantity(qty);
            }else {
                stockMap.put(stock.getStockorderOrderId(), lineNum - 1);
                stocks.add(stock);
                lineNum++;
            }
        }
        orderDetail.setSubLine(stocks);
    }
}

