package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLIM0237ProducerTestEquipmentParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "设备名称")
    private String testEqpName;
    @ApiModelProperty(value = "设备主要用途")
    private String testEqpUse;
    @ApiModelProperty(value = "设备照片")
    private String testEqpPicUrl;

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getTestEqpName() {
        return testEqpName;
    }

    public void setTestEqpName(String testEqpName) {
        this.testEqpName = testEqpName;
    }

    public String getTestEqpUse() {
        return testEqpUse;
    }

    public void setTestEqpUse(String testEqpUse) {
        this.testEqpUse = testEqpUse;
    }

    public String getTestEqpPicUrl() {
        return testEqpPicUrl;
    }

    public void setTestEqpPicUrl(String testEqpPicUrl) {
        this.testEqpPicUrl = testEqpPicUrl;
    }
}
