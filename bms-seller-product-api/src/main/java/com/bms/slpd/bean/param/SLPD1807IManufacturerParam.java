package com.bms.slpd.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD1807IManufacturerParam", description = "制造商单品品牌规格生产商")
public class SLPD1807IManufacturerParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "制造商ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "产品生产商ID")
    private Long producerProductId;
    @ApiModelProperty(value = "产品Id")
    private String productId;

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public Long getProducerProductId() {
        return producerProductId;
    }

    public void setProducerProductId(Long producerProductId) {
        this.producerProductId = producerProductId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
