package com.batch.bybatch.bean.result;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class BuyerOrderResult implements Serializable{

    /** 订单：买家订单ID */
    private Long buyerOrderId;

    /** 订单：买家订单编号 */
    private String buyerOrderCode;

    /** 订单：订单类型 [CodeMaster A类分批订单，A类标准订单，B类分批订单，B类标准订单] */
    private String orderType;

    /** 订单：销售平台 [CodeMaster 美侍客等] */
    private String salePlatformType;

    /** 订单：订单来源 [CodeMaster APP、客户端等] */
    private String orderSourceType;

    /** 订单：是否分批 */
    private Boolean batchFlg;

    /** 下单：下单时间 [订单日期] */
    private Date orderPlaceDatetime;

    /** 买家ID */
    private String buyerId;

    /** 买家分批订单 */
    private List<BuyerOrderBatchResutl> batchOrders;


    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getBuyerOrderCode() {
        return buyerOrderCode;
    }

    public void setBuyerOrderCode(String buyerOrderCode) {
        this.buyerOrderCode = buyerOrderCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSalePlatformType() {
        return salePlatformType;
    }

    public void setSalePlatformType(String salePlatformType) {
        this.salePlatformType = salePlatformType;
    }

    public String getOrderSourceType() {
        return orderSourceType;
    }

    public void setOrderSourceType(String orderSourceType) {
        this.orderSourceType = orderSourceType;
    }

    public Boolean getBatchFlg() {
        return batchFlg;
    }

    public void setBatchFlg(Boolean batchFlg) {
        this.batchFlg = batchFlg;
    }

    public List<BuyerOrderBatchResutl> getBatchOrders() {
        return batchOrders;
    }

    public void setBatchOrders(List<BuyerOrderBatchResutl> batchOrders) {
        this.batchOrders = batchOrders;
    }

    public Date getOrderPlaceDatetime() {
        return orderPlaceDatetime;
    }

    public void setOrderPlaceDatetime(Date orderPlaceDatetime) {
        this.orderPlaceDatetime = orderPlaceDatetime;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
