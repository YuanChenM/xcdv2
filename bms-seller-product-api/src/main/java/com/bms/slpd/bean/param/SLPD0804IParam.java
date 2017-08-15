package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0804ISellerCommodityParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0804IParam", description = "批量审核卖家单品品牌(规格)生产商API的入参")
public class SLPD0804IParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数集合")
	private List<SLPD0804ISellerCommodityParam> sellerCommodityParams;

	public List<SLPD0804ISellerCommodityParam> getSellerCommodityParams() {
		return sellerCommodityParams;
	}

	public void setSellerCommodityParams(List<SLPD0804ISellerCommodityParam> sellerCommodityParams) {
		this.sellerCommodityParams = sellerCommodityParams;
	}

}
