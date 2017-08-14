package com.bms.linv.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wang_haichun on 2017/4/17.
 */
public class LINV0113IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "物流区域ID")
    private List<String> logisticsId;
    @ApiModelProperty(value = "销售平台")
    private List<String> salePlatform;
    @ApiModelProperty(value = "货主ID")
    private List<String> ownerId;
    @ApiModelProperty(value = "货主类型")
    private List<String> ownerType;
    @ApiModelProperty(value = "货主名称")
    private String ownerName;
    @ApiModelProperty(value = "商品ID")
    private List<String> commodityId;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "单位")
    private List<String> uom;
    @ApiModelProperty(value = "库存类型")
    private List<String> ivType;
    @ApiModelProperty(value = "商品库存类型")
    private List<String> comoIvType;

    public List<String> getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(List<String> logisticsId) {
        this.logisticsId = logisticsId;
    }

    public List<String> getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(List<String> salePlatform) {
        this.salePlatform = salePlatform;
    }

    public List<String> getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(List<String> ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(List<String> ownerType) {
        this.ownerType = ownerType;
    }

    public List<String> getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(List<String> commodityId) {
        this.commodityId = commodityId;
    }

    public List<String> getUom() {
        return uom;
    }

    public void setUom(List<String> uom) {
        this.uom = uom;
    }

    public List<String> getIvType() {
        return ivType;
    }

    public void setIvType(List<String> ivType) {
        this.ivType = ivType;
    }

    public List<String> getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(List<String> comoIvType) {
        this.comoIvType = comoIvType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
}
