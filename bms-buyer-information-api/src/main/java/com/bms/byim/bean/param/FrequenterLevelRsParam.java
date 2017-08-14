package com.bms.byim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by yuan_zhifei on 2017/3/21.
 */
@ApiModel(value = "FrequenterLevelRsParam", description = "常客买家定级信息参数")
public class FrequenterLevelRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "常客买家等级编码")
    private String frequenterLevelCode;
    @ApiModelProperty(value = "常客等级（频次）")
    private String frequenterLevelF;
    @ApiModelProperty(value = "常客等级（量级）")
    private String frequenterLevelA;
    @ApiModelProperty(value = "频次")
    private String frequency;
    @ApiModelProperty(value = "量级")
    private String amount;
    @ApiModelProperty(value = "日期")
    private Date crtTime;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getFrequenterLevelCode() {
        return frequenterLevelCode;
    }

    public void setFrequenterLevelCode(String frequenterLevelCode) {
        this.frequenterLevelCode = frequenterLevelCode;
    }

    public String getFrequenterLevelF() {
        return frequenterLevelF;
    }

    public void setFrequenterLevelF(String frequenterLevelF) {
        this.frequenterLevelF = frequenterLevelF;
    }

    public String getFrequenterLevelA() {
        return frequenterLevelA;
    }

    public void setFrequenterLevelA(String frequenterLevelA) {
        this.frequenterLevelA = frequenterLevelA;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}
