package com.bms.puch.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/3/16.
 */
@ApiModel(value = "OrderParam",
        description = "入库主表")
@XmlRootElement(name = "order")
public class OrderParam implements Serializable {


    @ApiModelProperty(value = "订单列表")
    @XmlElement(name = "orderCode")
    private String orderCode;

    @ApiModelProperty(value = "订单列表")
    @XmlElement(name = "orderType")
    private String orderType;

    @ApiModelProperty(value = "计划入库明细列表")
    @XmlElement(name = "scheduleList")
    private List<ScheduleParam> scheduleList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public List<ScheduleParam> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<ScheduleParam> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
