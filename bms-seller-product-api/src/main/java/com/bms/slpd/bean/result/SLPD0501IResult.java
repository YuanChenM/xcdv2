package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0501IProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0501IResult", description = "批量查询产品API的出参")
public class SLPD0501IResult extends BaseRestPaginationResult<SLPD0501IProductResult> {
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
