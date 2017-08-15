package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0704IProducerProductParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0704IParam", description = "批量审核单品品牌(规格)生产商API的入参")
public class SLPD0704IParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数集合")
	private List<SLPD0704IProducerProductParam> producerProductParams;

	public List<SLPD0704IProducerProductParam> getProducerProductParams() {
		return producerProductParams;
	}

	public void setProducerProductParams(List<SLPD0704IProducerProductParam> producerProductParams) {
		this.producerProductParams = producerProductParams;
	}
}
