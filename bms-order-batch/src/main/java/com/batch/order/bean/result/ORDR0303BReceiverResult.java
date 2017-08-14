package com.batch.order.bean.result;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by liutao on 2017/3/10.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"name","tel","wx","qq","province","city","district","addr","addr2","addrkey","deliveryAreaCode"})
public class ORDR0303BReceiverResult {

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

    @XmlElement(name = "NAME",defaultValue = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "PHONE",defaultValue = "")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @XmlElement(name = "WECHAT",defaultValue = "")
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

    @XmlElement(name = "ADD_KEY",defaultValue = "")
    public String getAddrkey() {
        return addrkey;
    }

    public void setAddrkey(String addrkey) {
        this.addrkey = addrkey;
    }

    @XmlElement(name = "DELIVERY_AREA_CODE",defaultValue = "")
    public String getDeliveryAreaCode() {
        return deliveryAreaCode;
    }

    public void setDeliveryAreaCode(String deliveryAreaCode) {
        this.deliveryAreaCode = deliveryAreaCode;
    }
}
