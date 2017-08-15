package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0213ShBjTjRegistrationParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long sbtRegId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "单位名称")
    private String workunitName;
    @ApiModelProperty(value = "产品品类名称")
    private String productCategoryName;
    @ApiModelProperty(value = "登记日期")
    private Date regDate;
    @ApiModelProperty(value = "进沪(京、津)登记URL")
    private String sbtRegUrl;

    public Long getSbtRegId() {
        return sbtRegId;
    }

    public void setSbtRegId(Long sbtRegId) {
        this.sbtRegId = sbtRegId;
    }

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getWorkunitName() {
        return workunitName;
    }

    public void setWorkunitName(String workunitName) {
        this.workunitName = workunitName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getSbtRegUrl() {
        return sbtRegUrl;
    }

    public void setSbtRegUrl(String sbtRegUrl) {
        this.sbtRegUrl = sbtRegUrl;
    }
}
