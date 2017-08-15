package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD1806IManufacturerProducerProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD1814IResult", description = "查询代理商未绑定的制造商产品生产商API的出参")
public class SLPD1814IResult extends BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "提示信息")
	private String[] messages;

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}
}
