package com.bms.slim.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0238ProducerTestEquipmentyResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "检测设备ID")
    private Long testEqpId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "设备名称")
    private String testEqpName;
    @ApiModelProperty(value = "设备主要用途")
    private String testEqpUse;
    @ApiModelProperty(value = "设备照片")
    private String testEqpPicUrl;
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer version;

    public Long getTestEqpId() {
        return testEqpId;
    }

    public void setTestEqpId(Long testEqpId) {
        this.testEqpId = testEqpId;
    }

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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
