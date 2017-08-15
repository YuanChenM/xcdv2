package com.bms.slpd.bean.param.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SlpdProductProducerParam", description = "新增单品品牌(规格)生产商接口入参")
public class SlpdProductProducerParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;

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
