package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0501IDifSftStdResult", description = "安全标准指标差异")
public class SLPD0501IDifSftStdResult extends SLPDFileCardResult {

	@ApiModelProperty("安全标准指标ID")
	private Long sftDifStdId;
	@ApiModelProperty("安全标准指标类型")
	private String sftStdType;
	@ApiModelProperty("安全标准指标类型")
	private String sftStdTypeStr;
	@ApiModelProperty("合格差异值")
	private String sftOkDifVal;
	@ApiModelProperty("不合格差异值")
	private String sftNgDifVal;
	@ApiModelProperty("安全指标类型ID")
	private String remark;

	public Long getSftDifStdId() {
		return sftDifStdId;
	}

	public void setSftDifStdId(Long sftDifStdId) {
		this.sftDifStdId = sftDifStdId;
	}

	public String getSftStdType() {
		return sftStdType;
	}

	public void setSftStdType(String sftStdType) {
		this.sftStdType = sftStdType;
	}

	public String getSftStdTypeStr() {
		return sftStdTypeStr;
	}

	public void setSftStdTypeStr(String sftStdTypeStr) {
		this.sftStdTypeStr = sftStdTypeStr;
	}

	public String getSftOkDifVal() {
		return sftOkDifVal;
	}

	public void setSftOkDifVal(String sftOkDifVal) {
		this.sftOkDifVal = sftOkDifVal;
	}

	public String getSftNgDifVal() {
		return sftNgDifVal;
	}

	public void setSftNgDifVal(String sftNgDifVal) {
		this.sftNgDifVal = sftNgDifVal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
