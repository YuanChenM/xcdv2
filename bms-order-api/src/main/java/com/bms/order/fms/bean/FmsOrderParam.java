package com.bms.order.fms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * OMS推送订单到FMS的Param
 */
@ApiModel(value = "FmsOrderParam", description = "OMS推送订单到FMS的Param")
public class FmsOrderParam implements Serializable {

    private static final long serialVersionUID = -2524291584368197225L;


    @ApiModelProperty(value = "云冻品前台订单号")
    private String backNo;
    @ApiModelProperty(value = "推送的OMS订单ID")
    private Long pushOrderId;
    @ApiModelProperty(value = "推送的OMS订单配送明细ID")
    private Long[] pushDistributionDetailIds;
    @ApiModelProperty(value = "推送的OMS订单编码")
    private String pushOrderCode;
    @ApiModelProperty(value = "Fms连接条件设定")
    private FmsUrlBean fmsUrlBean;
    @ApiModelProperty(value = "测试模式Flg")
    private String testFlg;
    @ApiModelProperty(value = "异步推送Flg")
    private String asyncFlg;

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

    /**
     * Getter method for property <tt>pushDistributionDetailIds</tt>.
     *
     * @return property value of pushDistributionDetailIds
     */
    public Long[] getPushDistributionDetailIds() {
        return pushDistributionDetailIds;
    }

    /**
     * Setter method for property <tt>pushDistributionDetailIds</tt>.
     *
     * @param pushDistributionDetailIds value to be assigned to property pushDistributionDetailIds
     */
    public void setPushDistributionDetailIds(Long[] pushDistributionDetailIds) {
        this.pushDistributionDetailIds = pushDistributionDetailIds;
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

    public String getAsyncFlg() {
        return asyncFlg;
    }

    public void setAsyncFlg(String asyncFlg) {
        this.asyncFlg = asyncFlg;
    }
}

