package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "SLPD0501IBrandItemPropertyResult", description = "单品品牌规格")
public class SLPD0501IBrandItemPropertyResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "单品品牌规格ID")
	private Long brandItemPropertyId;
	@ApiModelProperty(value = "质量等级")
	private String qualityGradeType;
	@ApiModelProperty(value = "质量等级中文描述")
	private String qualityGradeTypeStr;
	@ApiModelProperty(value = "货源，1：国产，2：进口")
	private String sourceType;
	@ApiModelProperty(value = "货源")
	private String sourceTypeStr;
	@ApiModelProperty(value = "毛重（克）")
	private BigDecimal grossWeight;
	@ApiModelProperty(value = "净重（克）")
	private BigDecimal netWeight;
	@ApiModelProperty(value = "包装规格")
	private String packageSpecification;
	@ApiModelProperty(value = "包装数量")
	private String packageQuantity;
	@ApiModelProperty(value = "纸箱尺寸（cm），长*宽*高")
	private String cartonDimension;
	@ApiModelProperty(value = "纸箱长度（cm）")
	private BigDecimal cartonLength;
	@ApiModelProperty(value = "纸箱宽度（cm）")
	private BigDecimal cartonWidth;
	@ApiModelProperty(value = "纸箱高度（cm）")
	private BigDecimal cartonHeight;
	@ApiModelProperty(value = "托盘堆码数（箱）")
	private Integer palletStackingLimit;
	@ApiModelProperty(value = "审核状态，0：待审核，1：正式")
	private Boolean auditStu;

	@ApiModelProperty(value = "删除标识")
	private Boolean delFlg;
	@ApiModelProperty(value = "新建人ID")
	private String crtId;
	@ApiModelProperty(value = "新建时间")
	private Date crtTime;
	@ApiModelProperty(value = "修改人ID")
	private String updId;
	@ApiModelProperty(value = "修改时间")
	private Date updTime;
	@ApiModelProperty(value = "版本")
	private Integer version;

	@ApiModelProperty(value = "单品品牌ID")
	private Long brandItemId;
	@ApiModelProperty(value = "单品品牌SKU")
	private String brandItemSku;

	@ApiModelProperty(value = "品牌")
	private SLPD0501IBrandResult brand;
	@ApiModelProperty(value = "单品")
	private SLPD0501IItemResult item;

	public String getQualityGradeType() {
		return qualityGradeType;
	}

	public void setQualityGradeType(String qualityGradeType) {
		this.qualityGradeType = qualityGradeType;
	}

	public BigDecimal getCartonLength() {
		return cartonLength;
	}

	public void setCartonLength(BigDecimal cartonLength) {
		this.cartonLength = cartonLength;
	}

	public BigDecimal getCartonWidth() {
		return cartonWidth;
	}

	public void setCartonWidth(BigDecimal cartonWidth) {
		this.cartonWidth = cartonWidth;
	}

	public BigDecimal getCartonHeight() {
		return cartonHeight;
	}

	public void setCartonHeight(BigDecimal cartonHeight) {
		this.cartonHeight = cartonHeight;
	}

	public Long getBrandItemPropertyId() {
		return brandItemPropertyId;
	}

	public void setBrandItemPropertyId(Long brandItemPropertyId) {
		this.brandItemPropertyId = brandItemPropertyId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceTypeStr() {
		return sourceTypeStr;
	}

	public void setSourceTypeStr(String sourceTypeStr) {
		this.sourceTypeStr = sourceTypeStr;
	}

	public BigDecimal getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(BigDecimal grossWeight) {
		this.grossWeight = grossWeight;
	}

	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public String getPackageSpecification() {
		return packageSpecification;
	}

	public void setPackageSpecification(String packageSpecification) {
		this.packageSpecification = packageSpecification;
	}

	public String getPackageQuantity() {
		return packageQuantity;
	}

	public void setPackageQuantity(String packageQuantity) {
		this.packageQuantity = packageQuantity;
	}

	public String getCartonDimension() {
		return cartonDimension;
	}

	public void setCartonDimension(String cartonDimension) {
		this.cartonDimension = cartonDimension;
	}

	public Integer getPalletStackingLimit() {
		return palletStackingLimit;
	}

	public void setPalletStackingLimit(Integer palletStackingLimit) {
		this.palletStackingLimit = palletStackingLimit;
	}

	public Boolean getAuditStu() {
		return auditStu;
	}

	public void setAuditStu(Boolean auditStu) {
		this.auditStu = auditStu;
	}

	public Boolean getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Boolean delFlg) {
		this.delFlg = delFlg;
	}

	public String getCrtId() {
		return crtId;
	}

	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public String getUpdId() {
		return updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getBrandItemId() {
		return brandItemId;
	}

	public void setBrandItemId(Long brandItemId) {
		this.brandItemId = brandItemId;
	}

	public String getBrandItemSku() {
		return brandItemSku;
	}

	public void setBrandItemSku(String brandItemSku) {
		this.brandItemSku = brandItemSku;
	}

	public SLPD0501IBrandResult getBrand() {
		return brand;
	}

	public void setBrand(SLPD0501IBrandResult brand) {
		this.brand = brand;
	}

	public SLPD0501IItemResult getItem() {
		return item;
	}

	public void setItem(SLPD0501IItemResult item) {
		this.item = item;
	}

	public String getQualityGradeTypeStr() {
		return qualityGradeTypeStr;
	}

	public void setQualityGradeTypeStr(String qualityGradeTypeStr) {
		this.qualityGradeTypeStr = qualityGradeTypeStr;
	}
}
