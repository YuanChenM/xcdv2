package com.batch.order.bean.result;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by liutao on 2017/3/10.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"name","tel","wx","qq","email","province","city","district","addr","addr2","addrkey","deliveryType"})
public class ORDR0301BReceiverResult {

    private String name;

    private String tel;

    private String wx;

    private String qq;

    private String email;

    private String province;

    private String city;

    private String district;

    private String addr;

    private String addr2;

    private String addrkey;

    private String deliveryType;

    @XmlElement(name = "NAME",defaultValue = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "TEL",defaultValue = "")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @XmlElement(name = "WX",defaultValue = "")
    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    @XmlElement(name = "QQ",defaultValue = "")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @XmlElement(name = "EMAIL",defaultValue = "")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name = "PROVINCE",defaultValue = "")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @XmlElement(name = "CITY",defaultValue = "")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "DISTRICT",defaultValue = "")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @XmlElement(name = "ADDR",defaultValue = "")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @XmlElement(name = "ADDR2",defaultValue = "")
    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    @XmlElement(name = "ADDRKEY",defaultValue = "")
    public String getAddrkey() {
        return addrkey;
    }

    public void setAddrkey(String addrkey) {
        this.addrkey = addrkey;
    }

    @XmlElement(name = "DELIVERY_TYPE",defaultValue = "")
    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
