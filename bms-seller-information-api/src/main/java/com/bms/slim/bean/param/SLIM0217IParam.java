package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0217IParam", description = "批量查询生产商生产资质-食品生产许可证接口入参")
public class SLIM0217IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-食品生产许可证Id集合")
    private List<Long> fplIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    /*@ApiModelProperty(value = "证书编号")
    private String certNo;
    @ApiModelProperty(value = "品类范围")
    private String categoryRange;
    @ApiModelProperty(value = "有效期")
    private String validPeriod;
    @ApiModelProperty(value = "食品生产许可证URL")
    private String foodProdLicUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getFplIds() {
        return fplIds;
    }

    public void setFplIds(List<Long> fplIds) {
        this.fplIds = fplIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    /*public String getCertNo() {
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
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
