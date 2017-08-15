package com.bms.slpd.bean.param;


import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.param.BaseRestPagingParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0405IParam", description = "查询品牌所有人信息入参")
public class SLPD0405IParam extends BaseRestPaginationParam{

    @ApiModelProperty(value = "品牌IDList")
    private List<Long> brandIds;
    @ApiModelProperty(value = "品牌所有人IDList")
    private List<Long> brandOwnerIds;
    @ApiModelProperty(value = "品牌所有人编码")
    private String brandOwnerCode;
    @ApiModelProperty(value = "品牌所有人名称")
    private String ownerName;
    @ApiModelProperty(value = "品牌所有人类型")
    private String ownerType;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }

    public List<Long> getBrandOwnerIds() {
        return brandOwnerIds;
    }

    public void setBrandOwnerIds(List<Long> brandOwnerIds) {
        this.brandOwnerIds = brandOwnerIds;
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
}
