package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0508IManufacturerProductParam;
import com.bms.slpd.bean.param.field.SLPD0509IAgentProductParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0508IParam", description = "批量审核制造商生产商产品API的入参")
public class SLPD0508IParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数集合")
	private List<SLPD0508IManufacturerProductParam> manufacturerProductParams;

	public List<SLPD0508IManufacturerProductParam> getManufacturerProductParams() {
		return manufacturerProductParams;
	}

	public void setManufacturerProductParams(List<SLPD0508IManufacturerProductParam> manufacturerProductParams) {
		this.manufacturerProductParams = manufacturerProductParams;
	}
}
