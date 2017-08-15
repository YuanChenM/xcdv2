package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class SLIM0236ProducerLaboratoryParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实验室ID")
    private Long laboratoryId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "面积")
    private java.math.BigDecimal acreage;
    @ApiModelProperty(value = "功能")
    private String effect;
    @ApiModelProperty(value = "投资")
    private java.math.BigDecimal inverstnent;
    @ApiModelProperty(value = "人员")
    private String member;
    @ApiModelProperty(value = "实验室照片URL")
    private String labPicUrl;
    @ApiModelProperty(value = "品控组织架构图URL")
    private String orgFrameImgUrl;
    @ApiModelProperty(value = "质量控制系统图URL")
    private String qualityCtrlImgUrl;
    @ApiModelProperty(value = "版本")
    private Integer version;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public BigDecimal getInverstnent() {
        return inverstnent;
    }

    public void setInverstnent(BigDecimal inverstnent) {
        this.inverstnent = inverstnent;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getLabPicUrl() {
        return labPicUrl;
    }

    public void setLabPicUrl(String labPicUrl) {
        this.labPicUrl = labPicUrl;
    }

    public String getOrgFrameImgUrl() {
        return orgFrameImgUrl;
    }

    public void setOrgFrameImgUrl(String orgFrameImgUrl) {
        this.orgFrameImgUrl = orgFrameImgUrl;
    }

    public String getQualityCtrlImgUrl() {
        return qualityCtrlImgUrl;
    }

    public void setQualityCtrlImgUrl(String qualityCtrlImgUrl) {
        this.qualityCtrlImgUrl = qualityCtrlImgUrl;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
