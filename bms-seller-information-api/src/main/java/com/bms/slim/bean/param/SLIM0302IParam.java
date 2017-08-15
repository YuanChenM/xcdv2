package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 */
@ApiModel(value = "SLIM0302IParam",
        description = "查询卖家品牌接口入参")
public class SLIM0302IParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "卖家品牌IDList")
    private List<Long> sellerBrandIds;
    @ApiModelProperty(value = "实体卖家IDList")
    private List<Long> entitySellerIds;
    @ApiModelProperty(value = "品牌ID")
    private List<Long> brandIds;
    @ApiModelProperty(value = "品牌版权类型，1：自有品牌，2：代理品牌")
    private String copyrightType;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;


    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    public List<Long> getSellerBrandIds() {
        return sellerBrandIds;
    }

    public void setSellerBrandIds(List<Long> sellerBrandIds) {
        this.sellerBrandIds = sellerBrandIds;
    }

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCopyrightType() {
        return copyrightType;
    }

    public void setCopyrightType(String copyrightType) {
        this.copyrightType = copyrightType;
    }
}
