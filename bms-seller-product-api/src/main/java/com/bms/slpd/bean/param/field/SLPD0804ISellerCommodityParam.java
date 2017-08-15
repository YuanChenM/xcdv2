package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0804ISellerCommodityParam", description = "批量审核卖家单品品牌(规格)生产商API的入参")
public class SLPD0804ISellerCommodityParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "卖家单品品牌(规格)生产商ID")
	private Long sellerCommodityId;
	@ApiModelProperty(value = "审核状态，0：未注册，1：审核中，2：准入，3：禁止准入，4 ：黑名单")
	private String auditStu;
	@ApiModelProperty(value = "审核备注")
	private String auditRemark;
	@ApiModelProperty(value = "版本")
	private Integer version;

	public Long getSellerCommodityId() {
		return sellerCommodityId;
	}

	public void setSellerCommodityId(Long sellerCommodityId) {
		this.sellerCommodityId = sellerCommodityId;
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
