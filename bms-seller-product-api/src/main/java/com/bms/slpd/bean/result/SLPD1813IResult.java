package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD1813IResult", description = "查询制造商未绑定的产品生产商API的出参")
public class SLPD1813IResult extends BaseRestPaginationResult<SLPD1805IProductProducerResult> {
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
