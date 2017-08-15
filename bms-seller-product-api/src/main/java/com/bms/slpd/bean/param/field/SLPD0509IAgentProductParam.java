package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0509IAgentProductParam", description = "审核代理商制造产品API的入参")
public class SLPD0509IAgentProductParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "单品品牌规格代理商ID")
	private Long asProductId;
	@ApiModelProperty(value = "审核状态，0：未审核，1：准入，2：禁止准入")
	private String auditStu;
	@ApiModelProperty(value = "审核备注")
	private String auditRemark;
	@ApiModelProperty(value = "版本")
	private Integer version;

	public Long getAsProductId() {
		return asProductId;
	}

	public void setAsProductId(Long asProductId) {
		this.asProductId = asProductId;
	}

	public String getAuditStu() {
		return auditStu;
	}

	public void setAuditStu(String auditStu) {
		this.auditStu = auditStu;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
