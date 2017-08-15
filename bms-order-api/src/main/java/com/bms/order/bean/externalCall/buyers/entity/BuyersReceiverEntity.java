package com.bms.order.bean.externalCall.buyers.entity;

import java.io.Serializable;

/**
 * Created by wang_jianzhou on 2017/1/6.
 */
public class BuyersReceiverEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收货人：收货人名称
     */
    private String receiverName;

    /**
     * 收货人：收货人电话
     */
    private String receiverPhone;

    /**
     * 收货人：收货人QQ
     */
    private String receiverQq;

    /**
     * 收货人：收货人微信
     */
    private String receiverWechat;

    /**
     * 收货人：收货人邮箱
     */
    private String receiverMail;

    /**
     * 收货地址：收货地址省
     */
    private String receiverProvince;

    /**
     * 收货地址：收货地址市
     */
    private String receiverCity;

    /**
     * 收货地址：收货地址区
     */
    private String receiverDistrict;

    /**
     * 收货地址：收货地址详细地址
     */
    private String receiverAddress;

    /**
     * 收货地址：辅助地址项目 [收货人详细地址管理Key]
     */
    private String receiverAssistAddress;

    /**
     * 收货地址：订单配送区域
     */
    private String deliveryArea;

    /**
     * 收货地址：准入通行车型
     */
    private String passTrafficModel;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverQq() {
        return receiverQq;
    }

    public void setReceiverQq(String receiverQq) {
        this.receiverQq = receiverQq;
    }

    public String getReceiverWechat() {
        return receiverWechat;
    }

    public void setReceiverWechat(String receiverWechat) {
        this.receiverWechat = receiverWechat;
    }

    public String getReceiverMail() {
        return receiverMail;
    }

    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverAssistAddress() {
        return receiverAssistAddress;
    }

    public void setReceiverAssistAddress(String receiverAssistAddress) {
        this.receiverAssistAddress = receiverAssistAddress;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getPassTrafficModel() {
        return passTrafficModel;
    }

    public void setPassTrafficModel(String passTrafficModel) {
        this.passTrafficModel = passTrafficModel;
    }

    @Override
    public String toString() {
        return "BuyersReceiverEntity{" + "receiverName='" + receiverName + '\'' + ", receiverPhone='" + receiverPhone
                + '\'' + ", receiverQq='" + receiverQq + '\'' + ", receiverWechat='" + receiverWechat + '\''
                + ", receiverMail='" + receiverMail + '\'' + ", receiverProvince='" + receiverProvince + '\''
                + ", receiverCity='" + receiverCity + '\'' + ", receiverDistrict='" + receiverDistrict + '\''
                + ", receiverAddress='" + receiverAddress + '\'' + ", receiverAssistAddress='" + receiverAssistAddress
                + '\'' + ", deliveryArea='" + deliveryArea + '\'' + ", passTrafficModel='" + passTrafficModel + '\''
                + '}';
    }
}
