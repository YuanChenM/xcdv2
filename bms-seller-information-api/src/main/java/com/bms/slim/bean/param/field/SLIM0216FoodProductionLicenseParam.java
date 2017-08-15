package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0216FoodProductionLicenseParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long fplId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "证书编号")
    private String certNo;
    @ApiModelProperty(value = "品类范围")
    private String categoryRange;
    @ApiModelProperty(value = "有效期")
    private String validPeriod;
    @ApiModelProperty(value = "食品生产许可证URL")
    private String foodProdLicUrl;

    public Long getFplId() {
        return fplId;
    }

    public void setFplId(Long fplId) {
        this.fplId = fplId;
    }

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCategoryRange() {
        return categoryRange;
    }

    public void setCategoryRange(String categoryRange) {
        this.categoryRange = categoryRange;
    }

    public String getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getFoodProdLicUrl() {
        return foodProdLicUrl;
    }

    public void setFoodProdLicUrl(String foodProdLicUrl) {
        this.foodProdLicUrl = foodProdLicUrl;
    }
}
