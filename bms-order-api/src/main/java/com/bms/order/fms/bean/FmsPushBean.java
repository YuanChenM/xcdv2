package com.bms.order.fms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/4/28
 *
 * FmsPushBean
 */
@ApiModel(value = "FmsPushBean", description = "OmsToFms的推送内容和结果")
public class FmsPushBean implements Serializable {
    private static final long serialVersionUID = 5544395295280167843L;
    @ApiModelProperty(value = "返回信息")
    private String resultMessage;
    @ApiModelProperty(value = "fms返回的信息")
    private FmsResult fmsResult;

    @ApiModelProperty(value = "对fms发起请求的内容")
    private FmsRequestData requestData;
    @ApiModelProperty(value = "对fms发起请求的配置")
    private FmsUrlBean fmsUrlBean;
    @ApiModelProperty(value = "对fms发起推送的类型")
    private String pushType;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public FmsResult getFmsResult() {
        return fmsResult;
    }

    public void setFmsResult(FmsResult fmsResult) {
        this.fmsResult = fmsResult;
    }

    public FmsRequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(FmsRequestData requestData) {
        this.requestData = requestData;
    }

    public FmsUrlBean getFmsUrlBean() {
        return fmsUrlBean;
    }

    public void setFmsUrlBean(FmsUrlBean fmsUrlBean) {
        this.fmsUrlBean = fmsUrlBean;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }
}
