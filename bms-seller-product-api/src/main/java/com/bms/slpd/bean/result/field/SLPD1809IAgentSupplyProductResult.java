package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1809IAgentSupplyProductResult", description = "单品品牌规格代理商")
public class SLPD1809IAgentSupplyProductResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "单品品牌规格代理商ID")
	private Long asProductId;
	@ApiModelProperty(value = "单品品牌规格代理商CODE")
	private String asProductCode;
	@ApiModelProperty(value = "单品品牌规格代理商SKU")
	private String asProductSku;
	@ApiModelProperty(value = "单品品牌规格制造商ID")
	private Long manufacturerProductId;
	@ApiModelProperty(value = "产品ID")
	private String productId;
	@ApiModelProperty(value = "实体卖家ID")
	private Long entitySellerId;
	@ApiModelProperty(value = "实体卖家CODE")
	private String entitySellerCode;
	@ApiModelProperty(value = "实体卖家名称")
	private String fullName;
	@ApiModelProperty(value = "审核状态")
	private String auditStu;
	@ApiModelProperty(value = "审核状态")
	private String auditStuStr;
	@ApiModelProperty(value = "删除标识")
	private Boolean delFlg;
	@ApiModelProperty(value = "版本")
	private Integer version;

	@ApiModelProperty(value = "制造商单品品牌规格生产商集合")
	private List<SLPD1806IManufacturerProducerProductResult> manufacturerProducerProducts;


	public Long getAsProductId() {
		return asProductId;
	}

	public void setAsProductId(Long asProductId) {
		this.asProductId = asProductId;
	}

	public String getAsProductCode() {
		return asProductCode;
	}

	public void setAsProductCode(String asProductCode) {
		this.asProductCode = asProductCode;
	}

	public String getAsProductSku() {
		return asProductSku;
	}

	public void setAsProductSku(String asProductSku) {
		this.asProductSku = asProductSku;
	}

	public Long getManufacturerProductId() {
		return manufacturerProductId;
	}

	public void setManufacturerProductId(Long manufacturerProductId) {
		this.manufacturerProductId = manufacturerProductId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getEntitySellerId() {
		return entitySellerId;
	}

	public void setEntitySellerId(Long entitySellerId) {
		this.entitySellerId = entitySellerId;
	}

	public String getEntitySellerCode() {
		return entitySellerCode;
	}

	public void setEntitySellerCode(String entitySellerCode) {
		this.entitySellerCode = entitySellerCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAuditStu() {
		return auditStu;
	}

	public void setAuditStu(String auditStu) {
		this.auditStu = auditStu;
	}

	public String getAuditStuStr() {
		return auditStuStr;
	}

	public void setAuditStuStr(String auditStuStr) {
		this.auditStuStr = auditStuStr;
	}

	public Boolean getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Boolean delFlg) {
		this.delFlg = delFlg;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<SLPD1806IManufacturerProducerProductResult> getManufacturerProducerProducts() {
		return manufacturerProducerProducts;
	}

	public void setManufacturerProducerProducts(List<SLPD1806IManufacturerProducerProductResult> manufacturerProducerProducts) {
		this.manufacturerProducerProducts = manufacturerProducerProducts;
	}
}
