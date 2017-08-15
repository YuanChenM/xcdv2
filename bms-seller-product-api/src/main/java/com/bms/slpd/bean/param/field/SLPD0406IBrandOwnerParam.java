package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLPD0406IBrandOwnerParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌所有人ID")
    private Long brandOwnerId;
    @ApiModelProperty(value = "品牌所有人编码")
    private String brandOwnerCode;
    @ApiModelProperty(value = "品牌所有人名称")
    private String ownerName;
    @ApiModelProperty(value = "品牌所有人类型")
    private String ownerType;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getBrandOwnerId() {
        return brandOwnerId;
    }

    public void setBrandOwnerId(Long brandOwnerId) {
        this.brandOwnerId = brandOwnerId;
    }

    public String getBrandOwnerCode() {
        return brandOwnerCode;
    }

    public void setBrandOwnerCode(String brandOwnerCode) {
        this.brandOwnerCode = brandOwnerCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
