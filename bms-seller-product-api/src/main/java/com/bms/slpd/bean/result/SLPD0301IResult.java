package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0301IItemResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0301IResult", description = "批量查询单品API的出参")
public class SLPD0301IResult extends BaseRestPaginationResult<SLPD0301IItemResult> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "提示消息")
	private String[] messages;

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}
}
