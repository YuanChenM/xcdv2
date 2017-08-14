package com.bms.como.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public class ComoInfoRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "商品主键ID")
    private Long commodityId;
    @ApiModelProperty(value = "产品主键ID")
    private Long productPid;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "销售状态ID,若不传，取默认销售状态")
    private Long salesStatusId;
    @ApiModelProperty(value = "销售状态描述")
    private String salesStatusDesc;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "有效状态，若不传，默认有效")
    private Boolean isValid;
    @ApiModelProperty(value = "是否为产品的默认商品，缺省为否")
    private Boolean isDefault;
    @ApiModelProperty(value = "是否开放给买手，缺省为是")
    private Boolean isOpenToAgent;
    @ApiModelProperty(value = "销售单位集合")
    private List<UomRsParam> uomList;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getProductPid() {
        return productPid;
    }

    public void setProductPid(Long productPid) {
        this.productPid = productPid;
    }

    public Long getSalesStatusId() {
        return salesStatusId;
    }

    public void setSalesStatusId(Long salesStatusId) {
        this.salesStatusId = salesStatusId;
    }

    public String getSalesStatusDesc() {
        return salesStatusDesc;
    }

    public void setSalesStatusDesc(String salesStatusDesc) {
        this.salesStatusDesc = salesStatusDesc;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<UomRsParam> getUomList() {
        return uomList;
    }

    public void setUomList(List<UomRsParam> uomList) {
        this.uomList = uomList;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getIsOpenToAgent() {
        return isOpenToAgent;
    }

    public void setIsOpenToAgent(Boolean isOpenToAgent) {
        this.isOpenToAgent = isOpenToAgent;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
