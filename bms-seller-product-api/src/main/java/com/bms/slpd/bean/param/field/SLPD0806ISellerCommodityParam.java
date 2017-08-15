package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0806ISellerCommodityParam", description = "批量添加卖家单品品牌(规格)生产商货号及商品ID接口的入参")
public class SLPD0806ISellerCommodityParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "卖家单品品牌(规格)生产商ID")
	private Long sellerCommodityId;
	@ApiModelProperty(value = "产品ID")
	private Integer version;

	public Long getSellerCommodityId() {
		return sellerCommodityId;
	}

	public void setSellerCommodityId(Long sellerCommodityId) {
		this.sellerCommodityId = sellerCommodityId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
