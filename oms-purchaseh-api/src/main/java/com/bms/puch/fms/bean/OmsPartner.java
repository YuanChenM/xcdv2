package com.bms.puch.fms.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/4.
 */
public class OmsPartner implements Serializable {
    private static final long serialVersionUID = 7890593822262089054L;
    @ApiModelProperty(value = "合伙人ID")
    private String partnerId;
    @ApiModelProperty(value = "合伙人编码")
    private String partnerCode;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }
}
