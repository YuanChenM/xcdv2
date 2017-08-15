package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.poi.util.LongField;

import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "SLPD1901IParam", description = "批量查询净重列表API的入参")
public class SLPD1901IParam extends BaseRestPaginationParam {
	@ApiModelProperty(value = "单品ID集合")
	private List<Long> itemIds;
	@ApiModelProperty(value = "净重编码集合")
	private List<String> netWeightCodes;
	@ApiModelProperty(value = "净重")
	private BigDecimal netWeight;
	@ApiModelProperty(value = "删除标识")
	private Boolean delFlg;

	public List<Long> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}

	public List<String> getNetWeightCodes() {
		return netWeightCodes;
	}

	public void setNetWeightCodes(List<String> netWeightCodes) {
		this.netWeightCodes = netWeightCodes;
	}

	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public Boolean getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Boolean delFlg) {
		this.delFlg = delFlg;
	}
}
