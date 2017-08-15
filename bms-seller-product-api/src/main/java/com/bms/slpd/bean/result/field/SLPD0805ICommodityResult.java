package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0805ICommodityResult", description = "商品")
public class SLPD0805ICommodityResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    private String commodityId;
    @ApiModelProperty(value = "商品标题")
    private String saleTitle;

    @ApiModelProperty(value = "物流区集合")
    private List<SLPD0805ILgcsResult> lgcs;

    @ApiModelProperty(value = "产品信息")
    private SLPD0805IProductResult product;


    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public List<SLPD0805ILgcsResult> getLgcs() {
        return lgcs;
    }

    public void setLgcs(List<SLPD0805ILgcsResult> lgcs) {
        this.lgcs = lgcs;
    }

    public SLPD0805IProductResult getProduct() {
        return product;
    }

    public void setProduct(SLPD0805IProductResult product) {
        this.product = product;
    }

    public String getSaleTitle() {
        return saleTitle;
    }

    public void setSaleTitle(String saleTitle) {
        this.saleTitle = saleTitle;
    }
}
