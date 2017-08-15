package com.bms.slpd.bean.result.wrapper;


import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "SlpdBrandOwnerResult",
        description = "品牌所有人信息")
public class SlpdBrandOwnerResult extends BaseRestResult {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 品牌所有人ID
     */
    @ApiModelProperty(value = "品牌所有人ID")
    private Long brandOwnerId;
    /**
     * 品牌所有人编码
     */
    @ApiModelProperty(value = "品牌所有人ID")
    private String brandOwnerCode;
    /**
     * 品牌所有人名称（版权人）
     */
    @ApiModelProperty(value = "品牌所有人名称")
    private String ownerName;
    /**
     * 品牌所有人类型，1：生产商，2：制造商，3：卖家
     */
    @ApiModelProperty(value = "品牌所有人类型")
    private String ownerType;
    /**
     * 品牌ID
     */
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "创建Id")
    private String crtId;
    @ApiModelProperty(value = "创建时间")
    private Date crtTime;
    @ApiModelProperty(value = "更新Id")
    private String updId;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
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
