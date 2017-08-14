package com.batch.bybatch.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class BuyerOrderParam implements Serializable{

    // 用户ID
    private String[] buyerId;
    /**下单时间开始*/
    private Date orderPlaceDateTimeFrom;
    /**下单时间结束*/
    private Date orderPlaceDateTimeTo;

    private String[] buyerOrderStu;
    //订单完成时间开始
    private Date updTimeFrom;
    //订单完成时间结束
    private Date updTimeTo;

    public String[] getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String[] buyerId) {
        this.buyerId = buyerId;
    }

    public Date getOrderPlaceDateTimeFrom() {
        return orderPlaceDateTimeFrom;
    }

    public void setOrderPlaceDateTimeFrom(Date orderPlaceDateTimeFrom) {
        this.orderPlaceDateTimeFrom = orderPlaceDateTimeFrom;
    }

    public String[] getBuyerOrderStu() {
        return buyerOrderStu;
    }

    public void setBuyerOrderStu(String[] buyerOrderStu) {
        this.buyerOrderStu = buyerOrderStu;
    }

    public Date getOrderPlaceDateTimeTo() {
        return orderPlaceDateTimeTo;
    }

    public void setOrderPlaceDateTimeTo(Date orderPlaceDateTimeTo) {
        this.orderPlaceDateTimeTo = orderPlaceDateTimeTo;
    }

    public Date getUpdTimeFrom() {
        return updTimeFrom;
    }

    public void setUpdTimeFrom(Date updTimeFrom) {
        this.updTimeFrom = updTimeFrom;
    }

    public Date getUpdTimeTo() {
        return updTimeTo;
    }

    public void setUpdTimeTo(Date updTimeTo) {
        this.updTimeTo = updTimeTo;
    }
}
