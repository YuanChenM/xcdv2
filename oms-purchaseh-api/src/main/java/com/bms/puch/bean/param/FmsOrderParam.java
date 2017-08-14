package com.bms.puch.bean.param;

import com.bms.puch.fms.bean.FmsUrlBean;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/11.
 * <p>
 * OMS推送订单到FMS的Param
 */
public class FmsOrderParam implements Serializable {

    private static final long serialVersionUID = -2524291584368197225L;

    //云冻品前台订单号
    private String backNo;
    //推送的OMS订单ID
    private Long pushOrderId;
    //推送的OMS订单编码
    private String pushOrderCode;
    //Fms连接条件设定
    private FmsUrlBean fmsUrlBean;

    private String testFlg;

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public Long getPushOrderId() {
        return pushOrderId;
    }

    public void setPushOrderId(Long pushOrderId) {
        this.pushOrderId = pushOrderId;
    }

    public String getPushOrderCode() {
        return pushOrderCode;
    }

    public void setPushOrderCode(String pushOrderCode) {
        this.pushOrderCode = pushOrderCode;
    }

    public FmsUrlBean getFmsUrlBean() {
        return fmsUrlBean;
    }

    public void setFmsUrlBean(FmsUrlBean fmsUrlBean) {
        this.fmsUrlBean = fmsUrlBean;
    }

    public String getTestFlg() {
        return testFlg;
    }

    public void setTestFlg(String testFlg) {
        this.testFlg = testFlg;
    }
}

