package com.bms.order.fms.services.impl;

import com.bms.order.constant.enumeration.ComoIvType;
import com.bms.order.constant.enumeration.SellSideType;
import com.bms.order.fms.bean.*;
import com.bms.order.fms.dao.OmsOrderOriginDao;
import com.bms.order.fms.services.OmsCommonService;
import com.bms.order.fms.services.OmsOrderOriginService;
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
 * Created by yuan_chen on 2017/5/6
 *
 * OMS买家订单溯源services
 */
@Service
public class OmsOrderOriginServiceImpl extends BaseServiceImpl implements OmsOrderOriginService {

    @Autowired
    private OmsOrderOriginDao omsOrderOriginDao;
    @Autowired
    private OmsCommonService omsCommonService;

    @Override
    public BaseDao getBaseDao() {
        return omsOrderOriginDao;
    }

    /**
     * 获得买家订单溯源信息
     */
    public List<FmsBuyerOrderStock> getFmsBuyerOrderStocks(OmsOrderOrigin omsOrderOrigin){
        List<FmsBuyerOrderStock> stocks = new ArrayList<>();
        OmsProductInventoryBean productInventoryBean = getProductInventory(omsOrderOrigin);
        if(productInventoryBean == null){
            return stocks;
        }
        FmsBuyerOrderStock stock;
        Map<Long, Integer> stockMap = new HashMap<>();
        int lineNum = 1;
        for (OmsProductInventoryDetail productInventoryDetail :productInventoryBean.getSrcList()) {
            stock = new FmsBuyerOrderStock();
            stock.setLineNum(lineNum);
            stock.setProductId(StringUtils.toString(productInventoryDetail.getSrcCommodityId()));
            stock.setStockorderOrderId(productInventoryDetail.getSrcTransactionId());
            stock.setStockorderOrderNumber(productInventoryDetail.getSrcTransactionNo());
            if(productInventoryDetail.getSrcDealPrice() == null || BigDecimal.ZERO.equals(productInventoryDetail.getSrcDealPrice())){
                stock.setStockorderPrice(productInventoryBean.getDealPrice());
            }else{
                stock.setStockorderPrice(productInventoryDetail.getSrcDealPrice());
            }
            stock.setStockorderQuantity(productInventoryDetail.getSrcDealQty());

            if(stockMap.containsKey(stock.getStockorderOrderId())){
                int index = stockMap.get(stock.getStockorderOrderId());
                BigDecimal qty = stock.getStockorderQuantity().add(stocks.get(index).getStockorderQuantity());
                stocks.get(index).setStockorderQuantity(qty);
            }else {
                stockMap.put(stock.getStockorderOrderId(), lineNum - 1);
                stocks.add(stock);
                lineNum++;
            }
        }
        return stocks;
    }

    /**
     * 获得买家退货订单溯源信息
     */
    public List<FmsBuyerReturnOrderStock> getFmsBuyerReturnOrderStocks(OmsOrderOrigin omsOrderOrigin){
        List<FmsBuyerReturnOrderStock> stocks = new ArrayList<>();
        OmsProductInventoryBean productInventoryBean = getProductInventory(omsOrderOrigin);
        if(productInventoryBean == null){
            return stocks;
        }
        FmsBuyerReturnOrderStock stock;
        Map<Long, Integer> stockMap = new HashMap<>();
        int lineNum = 1;
        for (OmsProductInventoryDetail productInventoryDetail :productInventoryBean.getSrcList()) {
            stock = new FmsBuyerReturnOrderStock();
            stock.setLineNum(lineNum);
            stock.setProductId(StringUtils.toString(productInventoryDetail.getSrcCommodityId()));
            stock.setStockorderOrderId(productInventoryDetail.getSrcTransactionId());
            stock.setStockorderOrderNumber(productInventoryDetail.getSrcTransactionNo());
            stock.setReturnQty(productInventoryDetail.getSrcDealQty());

            if(stockMap.containsKey(stock.getStockorderOrderId())){
                BigDecimal returnQty = stock.getReturnQty();
                returnQty = returnQty.abs();

                int index = stockMap.get(stock.getStockorderOrderId());
                BigDecimal sumQty = stocks.get(index).getReturnQty();
                sumQty = sumQty.abs();

                //取得returnQty的绝对值
                BigDecimal qty = sumQty.add(returnQty);
                stocks.get(index).setReturnQty(qty);
            }else {
                stockMap.put(stock.getStockorderOrderId(), lineNum - 1);
                stock.setReturnQty(stock.getReturnQty().abs());
                stocks.add(stock);
                lineNum++;
            }
        }
        return stocks;
    }

    /**
     * 从库存系统查询出溯源信息
     */
    private OmsProductInventoryBean getProductInventory(OmsOrderOrigin omsOrderOrigin){
        if(!StringUtils.equals(omsOrderOrigin.getSellSideType(), SellSideType.PLATFORM_TYPE.getCode())){
            Map<Long, String> comoInventoryTypeMap = omsOrderOrigin.getComoInventoryTypeMap();
            if(comoInventoryTypeMap.containsKey(omsOrderOrigin.getOrderDetailId())){
                String comoInventoryType = comoInventoryTypeMap.get(omsOrderOrigin.getOrderDetailId());
                //作成溯源查询参数
                OmsProductInventoryParam productInventoryParam = new OmsProductInventoryParam();
                //设置出货货权人ID为供货方ID
                productInventoryParam.setOwnerId(StringUtils.toString(omsOrderOrigin.getSellSideId()));
                //设置收货货权人ID为下单的买家ID
                productInventoryParam.setTargetId(omsOrderOrigin.getBuyerId());
                //设置业务类型
                productInventoryParam.setBizType(omsOrderOrigin.getBizType());
                //设置业务单ID为订单ID
                productInventoryParam.setTransactionId(omsOrderOrigin.getOrderId());
                //设置业务单号为订单编码
                productInventoryParam.setTransactionNo(omsOrderOrigin.getOrderCode());
                //设置业务明细单号
                productInventoryParam.setTransactionDetailId(omsOrderOrigin.getDetailId());
                //调用商品库存溯源接口
                OmsProductInventoryBean productInventoryBean = omsCommonService.getOrderStock(productInventoryParam);

                //判断是否溯源到数据
                List<OmsProductInventoryDetail> productInventoryDetails;
                if(productInventoryBean == null){
                    return null;
                }
                productInventoryDetails = productInventoryBean.getSrcList();
                if(CollectionUtils.isEmpty(productInventoryDetails)){
                    return null;
                }
                String srcNo = StringUtils.EMPTY;
                //判断是否需要修改溯源到的数据
                if(StringUtils.equals(comoInventoryType, ComoIvType.Actual.getCode())){
                    //A类囤货（实物）溯源,不需要修改数据，直接利用
                    //退货再销售,为实物销售,但是溯源行权单,需要做第二层溯源
                    srcNo = productInventoryDetails.get(0).getSrcTransactionNo();
                    srcNo = StringUtils.left(srcNo, 4);
                }
                if(StringUtils.equals(comoInventoryType, ComoIvType.Virtual.getCode()) || StringUtils.equals(srcNo, "MSXQ")){
                    //B类囤货（货权）溯源
                    //修改行权ID和行权编码为囤货订单ID和囤货订单编码
                    List<OmsOrderOrigin> editStocks;
                    for (OmsProductInventoryDetail detail:productInventoryDetails) {
                        editStocks = omsOrderOriginDao.findAgentOrder(detail);
                        if(!CollectionUtils.isEmpty(editStocks)){
                            detail.setSrcTransactionId(editStocks.get(0).getOrderId());
                            detail.setSrcTransactionNo(editStocks.get(0).getOrderCode());
                            detail.setSrcCommodityId(editStocks.get(0).getCommodityId());
                            detail.setSrcDealPrice(editStocks.get(0).getCommodityPrice());
                        }
                    }
                }
                return productInventoryBean;
            }
        }
        return null;
    }

    /**
     * 取得每个分批订单明细中的销售的商品的库存类型（实物，货权）
     */
    public OmsOrderOrigin setOrderSellerDetail(OmsOrderOrigin omsOrderOrigin){
        Map<Long, String> comoInventoryTypeMap = new HashMap<>();
        List<OmsOrderSellerDetail> orderSellerDetails = omsOrderOriginDao.findOrderSellerDetail(omsOrderOrigin);
        if(!CollectionUtils.isEmpty(orderSellerDetails)){
            for (OmsOrderSellerDetail orderSellerDetail:orderSellerDetails) {
                if(!comoInventoryTypeMap.containsKey(orderSellerDetail.getOrderDetailId())){
                    comoInventoryTypeMap.put(orderSellerDetail.getOrderDetailId(),
                            orderSellerDetail.getComoInentoryType());
                }
            }
        }
        omsOrderOrigin.setComoInventoryTypeMap(comoInventoryTypeMap);
        return omsOrderOrigin;
    }
}

