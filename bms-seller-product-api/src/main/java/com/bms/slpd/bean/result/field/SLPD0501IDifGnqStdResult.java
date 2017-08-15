package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0501IDifGnqStdResult", description = "通用质量标准指标差异")
public class SLPD0501IDifGnqStdResult extends SLPDFileCardResult {

	@ApiModelProperty(value = "通用质量指标ID")
	private Long gnqDifStdId;
	@ApiModelProperty(value = "通用质量类型")
	private String gnqStdType;
	@ApiModelProperty(value = "通用质量类型")
	private String gnqStdTypeStr;
	@ApiModelProperty(value = "合格差异值")
	private String gnqOkDifVal;
	@ApiModelProperty(value = "不合格差异值")
	private String gnqNgDifVal;
	@ApiModelProperty(value = "备注")
	private String remark;

	public Long getGnqDifStdId() {
		return gnqDifStdId;
	}

	public void setGnqDifStdId(Long gnqDifStdId) {
		this.gnqDifStdId = gnqDifStdId;
	}

	public String getGnqStdType() {
		return gnqStdType;
	}

	public void setGnqStdType(String gnqStdType) {
		this.gnqStdType = gnqStdType;
	}

	public String getGnqStdTypeStr() {
		return gnqStdTypeStr;
	}

	public void setGnqStdTypeStr(String gnqStdTypeStr) {
		this.gnqStdTypeStr = gnqStdTypeStr;
	}

	public String getGnqOkDifVal() {
		return gnqOkDifVal;
	}

	public void setGnqOkDifVal(String gnqOkDifVal) {
		this.gnqOkDifVal = gnqOkDifVal;
	}

	public String getGnqNgDifVal() {
		return gnqNgDifVal;
	}

	public void setGnqNgDifVal(String gnqNgDifVal) {
		this.gnqNgDifVal = gnqNgDifVal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
