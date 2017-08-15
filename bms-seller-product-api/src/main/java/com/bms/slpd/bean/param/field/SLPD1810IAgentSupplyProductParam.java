package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD1810IAgentSupplyProductParam", description = "单品品牌规格代理商")
public class SLPD1810IAgentSupplyProductParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品品牌规格制造商ID")
    private Long manufacturerProductId;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;

    public Long getManufacturerProductId() {
        return manufacturerProductId;
    }

    public void setManufacturerProductId(Long manufacturerProductId) {
        this.manufacturerProductId = manufacturerProductId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
}
