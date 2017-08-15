package com.bms.order.bean.param;

import java.util.Date;

import com.bms.order.archive.impl.DistributionCancelNotification;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.bean.entity.DistributionCancelNotificationEntity;
import com.bms.order.common.rest.param.RestBean;
import com.bms.order.constant.enumeration.DistributionCancelType;

/**
 * 配送通知单取消接口Param
 *
 * @author li_huiqian
 */
public class ORDR0302IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = 4732806344049565650L;

    /** 配送通知单ID */
    private Long distributionNotificationId;

    /** 取消原因 */
    private String cancelReason;

    /** 取消人ID */
    private String cancelPersonId;

    /** 取消时间 */
    private Date cancelDatetime;

    private String cancelPersonName;

    private String cancelPersonType;

    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCancelPersonName() {
        return cancelPersonName;
    }

    public void setCancelPersonName(String cancelPersonName) {
        this.cancelPersonName = cancelPersonName;
    }

    public String getCancelPersonType() {
        return cancelPersonType;
    }

    public void setCancelPersonType(String cancelPersonType) {
        this.cancelPersonType = cancelPersonType;
    }

    public Long getDistributionNotificationId() {
        return distributionNotificationId;
    }

    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelPersonId() {
        return cancelPersonId;
    }

    public void setCancelPersonId(String cancelPersonId) {
        this.cancelPersonId = cancelPersonId;
    }

    public Date getCancelDatetime() {
        return cancelDatetime;
    }

    public void setCancelDatetime(Date cancelDatetime) {
        this.cancelDatetime = cancelDatetime;
    }

    public DistributionNotification generateDistributionNotification() {
        DistributionNotification distributionNotification = new DistributionNotification(distributionNotificationId);
        return distributionNotification;
    }

    public DistributionCancelNotification generateDistributionCancelNotification() {
        DistributionCancelNotificationEntity entity = new DistributionCancelNotificationEntity();
        entity.setCancelPersonId(cancelPersonId);
        entity.setCancelReason(cancelReason);
        entity.setCancelDatetime(cancelDatetime);
        entity.setDistributionNotificationId(distributionNotificationId);
        entity.setCancelPersonName(cancelPersonName);
        entity.setCancelPersonType(cancelPersonType);
        entity.setRemark(remark);
        entity.setSendFlg(false);
        entity.setCancelType(DistributionCancelType.DISTRIBUTION_CANCEL.getCode());
        DistributionCancelNotification distributionCancelNotification = new DistributionCancelNotification(entity);
        return distributionCancelNotification;
    }
}
