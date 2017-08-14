package com.batch.order.bean.result;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by liutao on 2017/3/10.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"orderId", "originalorderId", "orderType",  "whCode", "whName","needPay","buyerId", "buyerName", "ver", "receiver", "distributionResults"})
public class ORDR0303BResult implements Serializable {

    private Long orderId;

    private String orderCode;

    private Long originalorderId;

    private String orderType;

    private String buyerId;

    private String buyerName;

    private String whCode;

    private String whName;

    private Integer ver;

    private ORDR0303BReceiverResult receiver;

    private List<ORDR0303BDistributionResult> distributionResults;

    private String name;

    private String tel;

    private String wx;

    private String qq;

    private String province;

    private String city;

    private String district;

    private String addr;

    private String addr2;

    private String addrkey;

    private String deliveryAreaCode;

    private String needPay;

    private BigDecimal orderAmount;

    private BigDecimal receiveAmount;

    /** 是否使用账期 */
    private Boolean useNetFlg;

    /** 支付状态 */
    private String paymentStu;

    @XmlTransient
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @XmlTransient
    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    @XmlElement(name = "SHIPID", defaultValue = "")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @XmlElement(name = "ORDERID", defaultValue = "")
    public Long getOriginalorderId() {
        return originalorderId;
    }

    public void setOriginalorderId(Long originalorderId) {
        this.originalorderId = originalorderId;
    }

    @XmlElement(name = "ORDERTYPE", defaultValue = "")
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @XmlElement(name = "BUYERSID", defaultValue = "")
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @XmlElement(name = "BUYERSNAME", defaultValue = "")
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @XmlElement(name = "VER", defaultValue = "")
    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @XmlElement(name = "RECEIVER", defaultValue = "")
    public ORDR0303BReceiverResult getReceiver() {
        return receiver;
    }

    public void setReceiver(ORDR0303BReceiverResult receiver) {
        this.receiver = receiver;
    }

    @XmlElementWrapper(name = "LINES")
    @XmlElement(name = "LINE")
    public List<ORDR0303BDistributionResult> getDistributionResults() {
        return distributionResults;
    }

    public void setDistributionResults(List<ORDR0303BDistributionResult> distributionResults) {
        this.distributionResults = distributionResults;
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

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @XmlTransient
    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    @XmlTransient
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @XmlTransient
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @XmlTransient
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @XmlTransient
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @XmlTransient
    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    @XmlTransient
    public String getAddrkey() {
        return addrkey;
    }

    public void setAddrkey(String addrkey) {
        this.addrkey = addrkey;
    }

    @XmlTransient
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @XmlElement(name = "NEED_PAY", defaultValue = "")
    public String getNeedPay() {
        return needPay;
    }

    public void setNeedPay(String needPay) {
        this.needPay = needPay;
    }

    @XmlTransient
    public String getDeliveryAreaCode() {
        return deliveryAreaCode;
    }

    public void setDeliveryAreaCode(String deliveryAreaCode) {
        this.deliveryAreaCode = deliveryAreaCode;
    }

    @XmlTransient
    public Boolean getUseNetFlg() {
        return useNetFlg;
    }

    public void setUseNetFlg(Boolean useNetFlg) {
        this.useNetFlg = useNetFlg;
    }

    @XmlTransient
    public String getPaymentStu() {
        return paymentStu;
    }

    public void setPaymentStu(String paymentStu) {
        this.paymentStu = paymentStu;
    }
}
