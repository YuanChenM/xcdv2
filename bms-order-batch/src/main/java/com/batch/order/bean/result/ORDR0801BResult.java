package com.batch.order.bean.result;

import com.framework.base.rest.entity.BaseEntity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by liutao on 2017/3/2.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"returnId","returnCode","orderId","shipId","buyerCode","buyerType","buyerName","buyerId","whCode", "logisticsZoneCode","ver","returnTime","returnType","details"})
public class ORDR0801BResult implements Serializable {

    private Long returnId;

    private String returnCode;

    private Long orderId;

    private String shipId;

    private String buyerCode;

    private String buyerType;

    private String buyerName;

    private String buyerId;

    private Integer ver;

    private String returnTime;

    private String returnType;

    private String logisticsZoneCode;

    private String whCode;

    private List<ORDR0801BDetailResult> details;

    @XmlElement(name = "RETURNID",defaultValue = "")
    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    @XmlElement(name = "RETURNCODE",defaultValue = "")
    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    @XmlElement(name = "ORDERID",defaultValue = "")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @XmlElement(name = "SHIPID",defaultValue = "")
    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    @XmlElement(name = "TARGETCOMPANY",defaultValue = "")
    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    @XmlElement(name = "COMPANYTYPE",defaultValue = "")
    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    @XmlElement(name = "BUYERSNAME",defaultValue = "")
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @XmlElement(name = "BUYERSID",defaultValue = "")
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @XmlElement(name = "VER",defaultValue = "")
    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @XmlElement(name = "REQUESTEDDATE",defaultValue = "")
    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    @XmlElement(name = "RETURNTYPE",defaultValue = "")
    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    @XmlElementWrapper(name="LINES")
    @XmlElement(name="LINE")
    public List<ORDR0801BDetailResult> getDetails() {
        return details;
    }

    public void setDetails(List<ORDR0801BDetailResult> details) {
        this.details = details;
    }

    @XmlElement(name = "BUYER_ZONE_CODE",defaultValue = "")
    public String getLogisticsZoneCode() {
        return logisticsZoneCode;
    }

    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }

    @XmlElement(name = "WH_CODE",defaultValue = "")
    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }
}
