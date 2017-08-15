package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0508IManufacturerProductParam", description = "审核制造产品API的入参")
public class SLPD0508IManufacturerProductParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "单品品牌规格制造商ID")
	private Long manufacturerProductId;
	@ApiModelProperty(value = "审核状态，0：未审核，1：准入，2：禁止准入")
	private String auditStu;
	@ApiModelProperty(value = "审核备注")
	private String auditRemark;
	@ApiModelProperty(value = "版本")
	private Integer version;

	public Long getManufacturerProductId() {
		return manufacturerProductId;
	}

	public void setManufacturerProductId(Long manufacturerProductId) {
		this.manufacturerProductId = manufacturerProductId;
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
