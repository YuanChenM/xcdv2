package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0704IResult", description = "批量审核单品品牌(规格)生产商API的出参")
public class SLPD0704IResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "提示信息")
	private String[] messages;
	@ApiModelProperty(value = "执行条数")
	private int count;

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
