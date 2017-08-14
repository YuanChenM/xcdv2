package com.bms.bypo.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhang_jian4 on 2017/01/06.
 */

@ApiModel(value = "ProductSaleRsParam", description = "产品销售信息")
public class ProductSaleRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "产品销售ID")
    private Long productSaleId;
    @ApiModelProperty(value = "调研产品ID")
    private Long researchProductId;
    @ApiModelProperty(value = "销售日")
    private Date saleDate;
    @ApiModelProperty(value = "销售量")
    private Integer saleAmount;
    @ApiModelProperty(value = "单价")
    private BigDecimal price;
    @ApiModelProperty(value = "价盘通道")
    private String priceChannel;
    @ApiModelProperty(value = "客户对象")
    private String customer;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;

    public Long getProductSaleId() {
        return productSaleId;
    }

    public void setProductSaleId(Long productSaleId) {
        this.productSaleId = productSaleId;
    }

    public Long getResearchProductId() {
        return researchProductId;
    }

    public void setResearchProductId(Long researchProductId) {
        this.researchProductId = researchProductId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPriceChannel() {
        return priceChannel;
    }

    public void setPriceChannel(String priceChannel) {
        this.priceChannel = priceChannel;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
