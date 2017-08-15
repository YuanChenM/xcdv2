package com.bms.order.bean.param;

import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.PriceChannelNotificationDetail;
import com.bms.order.archive.impl.list.DistributionNotificationDetailList;
import com.bms.order.archive.impl.list.DistributionNotificationList;
import com.bms.order.archive.impl.list.PriceChannelNotificationDetailList;
import com.bms.order.common.rest.param.RestBean;
import com.bms.order.common.rest.param.RestFilter;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单信息及对应价盘查询接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0402IFilterParam extends RestBean {

    private List<ORDR0402IFilterOrderParam> orderList;

    public DistributionNotificationList generateDistributionNotification(Long[] shipId){
        DistributionNotificationList distributionNotificationlist= DistributionNotificationList.build(null).forComplete(shipId);
        return distributionNotificationlist;
    }

    public List<ORDR0402IFilterOrderParam> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ORDR0402IFilterOrderParam> orderList) {
        this.orderList = orderList;
    }
}
