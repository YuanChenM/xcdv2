package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0806IResult", description = "批量添加卖家单品品牌(规格)生产商货号及商品ID接口的出参")
public class SLPD0806IResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "提示信息")
	private String[] messages;
	@ApiModelProperty(value = "执行条数")
	private int count;

	@ApiModelProperty(value = "商品Id集合")
	private List<String> commodityIds;

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

	public List<String> getCommodityIds() {
		return commodityIds;
	}

	public void setCommodityIds(List<String> commodityIds) {
		this.commodityIds = commodityIds;
	}
}
