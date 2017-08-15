package com.bms.slpd.bean.result.field;

import com.bms.slpd.bean.entity.SlpdDiscussStd;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0201IMctStdResult", description = "加工技术标准指标")
public class SLPD0201IMctStdResult extends SLPDFileCardResult {

	@ApiModelProperty(value = "加工技术标准指标ID")
	private Long mctStdId;
	@ApiModelProperty(value = "加工技术标准指标类型")
	private String mctStdType;
	@ApiModelProperty(value = "加工技术标准指标类型")
	private String mctStdTypeStr;
	@ApiModelProperty(value = "合格值")
	private String mctOkVal;
	@ApiModelProperty(value = "不合格值")
	private String mctNgVal;
	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "论证信息集合")
	private List<SlpdDiscussStd> discussStdList;

	public Long getMctStdId() {
		return mctStdId;
	}

	public void setMctStdId(Long mctStdId) {
		this.mctStdId = mctStdId;
	}

	public String getMctStdType() {
		return mctStdType;
	}

	public void setMctStdType(String mctStdType) {
		this.mctStdType = mctStdType;
	}

	public String getMctStdTypeStr() {
		return mctStdTypeStr;
	}

	public void setMctStdTypeStr(String mctStdTypeStr) {
		this.mctStdTypeStr = mctStdTypeStr;
	}

	public String getMctOkVal() {
		return mctOkVal;
	}

	public void setMctOkVal(String mctOkVal) {
		this.mctOkVal = mctOkVal;
	}

	public String getMctNgVal() {
		return mctNgVal;
	}

	public void setMctNgVal(String mctNgVal) {
		this.mctNgVal = mctNgVal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<SlpdDiscussStd> getDiscussStdList() {
		return discussStdList;
	}

	public void setDiscussStdList(List<SlpdDiscussStd> discussStdList) {
		this.discussStdList = discussStdList;
	}
}
