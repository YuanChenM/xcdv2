package com.bms.order.bean.result;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang_jianzhou on 2017/1/4.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"distributionNotificationId", "orderId", "cancelPersonId",  "cancelPersonName", "cancelDatetime","cancelReason","whCode", "whName", "remark"})
public class ORDR0302IXMLResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long distributionNotificationId;

    private Long orderId;

    private String cancelPersonId;

    private String cancelPersonName;

    private String cancelDatetime;

    private String remark;

    private String cancelReason;

    private String whCode;

    private String whName;

    @XmlElement(name = "CANCELREASON", defaultValue = "")
    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    @XmlElement(name = "SHIPID", defaultValue = "")
    public Long getDistributionNotificationId() {
        return distributionNotificationId;
    }

    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }


    @XmlElement(name = "CANCELMANID", defaultValue = "")
    public String getCancelPersonId() {
        return cancelPersonId;
    }

    public void setCancelPersonId(String cancelPersonId) {
        this.cancelPersonId = cancelPersonId;
    }

    @XmlElement(name = "CANCELMANNAME", defaultValue = "")
    public String getCancelPersonName() {
        return cancelPersonName;
    }

    public void setCancelPersonName(String cancelPersonName) {
        this.cancelPersonName = cancelPersonName;
    }

    @XmlElement(name = "CANCELTIME", defaultValue = "")
    public String getCancelDatetime() {
        return cancelDatetime;
    }

    public void setCancelDatetime(String cancelDatetime) {
        this.cancelDatetime = cancelDatetime;
    }

    @XmlElement(name = "REMARK", defaultValue = "")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @XmlElement(name = "WH_CODE", defaultValue = "")
    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    @XmlElement(name = "WH_NAME", defaultValue = "")
    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    @XmlElement(name = "ORDERID", defaultValue = "")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
