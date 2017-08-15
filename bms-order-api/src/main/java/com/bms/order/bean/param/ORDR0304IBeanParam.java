package com.bms.order.bean.param;

import com.bms.order.archive.impl.DistributionCancelNotification;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.bean.entity.DistributionCancelNotificationEntity;
import com.bms.order.common.rest.param.RestBean;
import com.framework.core.utils.DateUtils;

/**
 * 买手订单修改接口Param
 * 
 * @author li_huiqian
 *
 */
public class ORDR0304IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = 7587739776851257898L;

    private Long shipId;// 配送单Id
    private Long orderId;// 订单Id
    private String cancelPerson;
    private String remark;
    private String cancelTime;// 实际取消时间

    public DistributionNotification distributionNotification() {
        DistributionNotification distributionNotification = DistributionNotification.build(null)
                .forComplete(shipId);
        return distributionNotification;
    }

    public DistributionCancelNotification cancelResult() {
        DistributionCancelNotificationEntity entity = new DistributionCancelNotificationEntity();
        entity.setSuccessFlg(true);
        entity.setWmsCancelDatetime(DateUtils.parseDateTime(cancelTime));
        DistributionCancelNotification distributionCancelNotification = DistributionCancelNotification.build(null)
                .forCreate(entity);
        return distributionCancelNotification;
    }


    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCancelPerson() {
        return cancelPerson;
    }

    public void setCancelPerson(String cancelPerson) {
        this.cancelPerson = cancelPerson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
