package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD1806IManufacturerProducerProductResult", description = "制造商单品品牌规格生产商")
public class SLPD1806IManufacturerProducerProductResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "单品品牌规格制造商ID")
	private Long manufacturerProductId;
	@ApiModelProperty(value = "单品品牌规格制造商Sku")
	private String manufacturerProductSku;
	@ApiModelProperty(value = "单品品牌规格制造商编码")
	private String manufacturerProductCode;
	@ApiModelProperty(value = "单品品牌规格制造商BraCode")
	private String manufacturerProductBarCode;
	@ApiModelProperty(value = "单品品牌规格生产商ID")
	private Long producerProductId;
	@ApiModelProperty(value = "产品ID")
	private String productId;
	@ApiModelProperty(value = "实体卖家ID")
	private Long entitySellerId;
	@ApiModelProperty(value = "实体卖家")
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

	@ApiModelProperty(value = "单品品牌规格生产商集合")
	private List<SLPD1805IProductProducerResult> producerProducts;

	public Long getManufacturerProductId() {
		return manufacturerProductId;
	}

	public void setManufacturerProductId(Long manufacturerProductId) {
		this.manufacturerProductId = manufacturerProductId;
	}

	public String getManufacturerProductSku() {
		return manufacturerProductSku;
	}

	public void setManufacturerProductSku(String manufacturerProductSku) {
		this.manufacturerProductSku = manufacturerProductSku;
	}

	public Long getProducerProductId() {
		return producerProductId;
	}

	public void setProducerProductId(Long producerProductId) {
		this.producerProductId = producerProductId;
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

	public List<SLPD1805IProductProducerResult> getProducerProducts() {
		return producerProducts;
	}

	public void setProducerProducts(List<SLPD1805IProductProducerResult> producerProducts) {
		this.producerProducts = producerProducts;
	}

	public String getManufacturerProductCode() {
		return manufacturerProductCode;
	}

	public void setManufacturerProductCode(String manufacturerProductCode) {
		this.manufacturerProductCode = manufacturerProductCode;
	}

	public String getManufacturerProductBarCode() {
		return manufacturerProductBarCode;
	}

	public void setManufacturerProductBarCode(String manufacturerProductBarCode) {
		this.manufacturerProductBarCode = manufacturerProductBarCode;
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
}
