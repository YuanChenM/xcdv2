package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0507IProductParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0507IParam", description = "批量审核产品API的入参")
public class SLPD0507IParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数集合")
	private List<SLPD0507IProductParam> productParams;

	public List<SLPD0507IProductParam> getProductParams() {
		return productParams;
	}

	public void setProductParams(List<SLPD0507IProductParam> productParams) {
		this.productParams = productParams;
	}
}
