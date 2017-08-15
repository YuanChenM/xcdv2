package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0806ISellerCommodityParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0806IParam", description = "批量添加卖家单品品牌(规格)生产商货号及商品ID接口的入参")
public class SLPD0806IParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数集合")
	private List<SLPD0806ISellerCommodityParam> sellerCommodityParams;

	public List<SLPD0806ISellerCommodityParam> getSellerCommodityParams() {
		return sellerCommodityParams;
	}

	public void setSellerCommodityParams(List<SLPD0806ISellerCommodityParam> sellerCommodityParams) {
		this.sellerCommodityParams = sellerCommodityParams;
	}

}
