package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.util.Date;
import java.util.List;

/**
 * Created by liutao on 2017/1/17.
 */
public class ORDR0501IRestParam extends RestBean {
    private Long orderId;

    private Long shipId;

    private String applyMan;

    private String applyTime;

    private String applyRemark;

    private String buyerId;

    private Integer ver;

    private List<ORDR0501IPaymentRestParam> paymentList;

    private Long returnReasonID;

    private String returnReasonName;

    private String receiptDate;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    private Integer isPaid;

    private List<ORDR0501IShipRestParam> shipList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getApplyMan() {
        return applyMan;
    }

    public void setApplyMan(String applyMan) {
        this.applyMan = applyMan;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public List<ORDR0501IPaymentRestParam> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<ORDR0501IPaymentRestParam> paymentList) {
        this.paymentList = paymentList;
    }

    public Long getReturnReasonID() {
        return returnReasonID;
    }

    public void setReturnReasonID(Long returnReasonID) {
        this.returnReasonID = returnReasonID;
    }

    public String getReturnReasonName() {
        return returnReasonName;
    }

    public void setReturnReasonName(String returnReasonName) {
        this.returnReasonName = returnReasonName;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public List<ORDR0501IShipRestParam> getShipList() {
        return shipList;
    }

    public void setShipList(List<ORDR0501IShipRestParam> shipList) {
        this.shipList = shipList;
    }
}
