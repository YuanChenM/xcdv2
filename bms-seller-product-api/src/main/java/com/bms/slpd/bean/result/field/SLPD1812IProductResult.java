package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "SLPD1812IProductResult", description = "产品")
public class SLPD1812IProductResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "产品ID")
	private String productId;
	@ApiModelProperty(value = "质量等级，1：A1，2：A2，3：A3")
	private String qualityGradeType;
	@ApiModelProperty(value = "质量等级")
	private String qualityGradeTypeStr;
	@ApiModelProperty(value = "品种ID")
	private Long breedId;
	@ApiModelProperty(value = "品种编码")
	private String breedCode;
	@ApiModelProperty(value = "品种SKU")
	private String breedSku;
	@ApiModelProperty(value = "品种标准市场销售名")
	private String breedSalesName;
	@ApiModelProperty(value = "品种学名")
	private String breedScientificName;
	@ApiModelProperty(value = "品种俗名")
	private String breedLocalName;

	@ApiModelProperty(value = "二级分类ID")
	private Long machiningId;
	@ApiModelProperty(value = "二级分类编码")
	private String machiningCode;
	@ApiModelProperty(value = "二级分类名称")
	private String machiningName;

	@ApiModelProperty(value = "一级分类ID")
	private Long classesId;
	@ApiModelProperty(value = "一级分类编码")
	private String classesCode;
	@ApiModelProperty(value = "一级分类名称")
	private String classesName;

	@ApiModelProperty(value = "单品Id")
	private Long itemId;
	@ApiModelProperty(value = "单品编码")
	private String itemCode;
	@ApiModelProperty(value = "单品SKU")
	private String itemSku;
	@ApiModelProperty(value = "单品名称")
	private String itemName;
	@ApiModelProperty(value = "规格")
	private String specification;
	@ApiModelProperty(value = "加工方式")
	private String processingMethod;
	@ApiModelProperty(value = "口味")
	private String taste;

	@ApiModelProperty(value = "品牌ID")
	private Long brandId;
	@ApiModelProperty(value = "品牌编码")
	private String brandCode;
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	@ApiModelProperty(value = "品牌分类")
	private String brandType;
	@ApiModelProperty(value = "品牌分类")
	private String brandTypeStr;

	@ApiModelProperty(value = "审核状态，0：未审核，1：准入，2：禁止准入")
	private String auditStu;
	@ApiModelProperty(value = "审核状态")
	private String auditStuStr;
	@ApiModelProperty(value = "审核备注")
	private String auditRemark;
	@ApiModelProperty(value = "审核履历，格式：0,未审核,admin,2017-01-25;")
	private String auditHistory;

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

	@ApiModelProperty(value = "单品规格ID")
	private Long itemPropertyId;
	@ApiModelProperty(value = "单品规格编码")
	private String itemPropertyCode;
	@ApiModelProperty(value = "单品品牌规格Sku")
	private String brandItemPropertySku;
	@ApiModelProperty(value = "货源，1：国产，2：进口")
	private String sourceType;
	@ApiModelProperty(value = "货源")
	private String sourceTypeStr;
	@ApiModelProperty(value = "毛重（克）")
	private BigDecimal grossWeight;
	@ApiModelProperty(value = "净重（克）")
	private BigDecimal netWeight;
	@ApiModelProperty(value = "净重编码")
	private String netWeightCode;
	@ApiModelProperty(value = "包装规格")
	private String packageSpecification;
	@ApiModelProperty(value = "包装数量")
	private Integer packageQuantity;
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
	private Boolean propertyAuditStu;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQualityGradeType() {
		return qualityGradeType;
	}

	public void setQualityGradeType(String qualityGradeType) {
		this.qualityGradeType = qualityGradeType;
	}

	public String getQualityGradeTypeStr() {
		return qualityGradeTypeStr;
	}

	public void setQualityGradeTypeStr(String qualityGradeTypeStr) {
		this.qualityGradeTypeStr = qualityGradeTypeStr;
	}

	public Long getBreedId() {
		return breedId;
	}

	public void setBreedId(Long breedId) {
		this.breedId = breedId;
	}

	public String getBreedCode() {
		return breedCode;
	}

	public void setBreedCode(String breedCode) {
		this.breedCode = breedCode;
	}

	public String getBreedSku() {
		return breedSku;
	}

	public void setBreedSku(String breedSku) {
		this.breedSku = breedSku;
	}

	public String getBreedSalesName() {
		return breedSalesName;
	}

	public void setBreedSalesName(String breedSalesName) {
		this.breedSalesName = breedSalesName;
	}

	public String getBreedScientificName() {
		return breedScientificName;
	}

	public void setBreedScientificName(String breedScientificName) {
		this.breedScientificName = breedScientificName;
	}

	public String getBreedLocalName() {
		return breedLocalName;
	}

	public void setBreedLocalName(String breedLocalName) {
		this.breedLocalName = breedLocalName;
	}

	public Long getMachiningId() {
		return machiningId;
	}

	public void setMachiningId(Long machiningId) {
		this.machiningId = machiningId;
	}

	public String getMachiningCode() {
		return machiningCode;
	}

	public void setMachiningCode(String machiningCode) {
		this.machiningCode = machiningCode;
	}

	public String getMachiningName() {
		return machiningName;
	}

	public void setMachiningName(String machiningName) {
		this.machiningName = machiningName;
	}

	public Long getClassesId() {
		return classesId;
	}

	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}

	public String getClassesCode() {
		return classesCode;
	}

	public void setClassesCode(String classesCode) {
		this.classesCode = classesCode;
	}

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemSku() {
		return itemSku;
	}

	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getProcessingMethod() {
		return processingMethod;
	}

	public void setProcessingMethod(String processingMethod) {
		this.processingMethod = processingMethod;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public String getBrandTypeStr() {
		return brandTypeStr;
	}

	public void setBrandTypeStr(String brandTypeStr) {
		this.brandTypeStr = brandTypeStr;
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

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getAuditHistory() {
		return auditHistory;
	}

	public void setAuditHistory(String auditHistory) {
		this.auditHistory = auditHistory;
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

	public Long getItemPropertyId() {
		return itemPropertyId;
	}

	public void setItemPropertyId(Long itemPropertyId) {
		this.itemPropertyId = itemPropertyId;
	}

	public String getItemPropertyCode() {
		return itemPropertyCode;
	}

	public void setItemPropertyCode(String itemPropertyCode) {
		this.itemPropertyCode = itemPropertyCode;
	}

	public String getBrandItemPropertySku() {
		return brandItemPropertySku;
	}

	public void setBrandItemPropertySku(String brandItemPropertySku) {
		this.brandItemPropertySku = brandItemPropertySku;
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

	public String getNetWeightCode() {
		return netWeightCode;
	}

	public void setNetWeightCode(String netWeightCode) {
		this.netWeightCode = netWeightCode;
	}

	public String getPackageSpecification() {
		return packageSpecification;
	}

	public void setPackageSpecification(String packageSpecification) {
		this.packageSpecification = packageSpecification;
	}

	public Integer getPackageQuantity() {
		return packageQuantity;
	}

	public void setPackageQuantity(Integer packageQuantity) {
		this.packageQuantity = packageQuantity;
	}

	public String getCartonDimension() {
		return cartonDimension;
	}

	public void setCartonDimension(String cartonDimension) {
		this.cartonDimension = cartonDimension;
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

	public Integer getPalletStackingLimit() {
		return palletStackingLimit;
	}

	public void setPalletStackingLimit(Integer palletStackingLimit) {
		this.palletStackingLimit = palletStackingLimit;
	}

	public Boolean getPropertyAuditStu() {
		return propertyAuditStu;
	}

	public void setPropertyAuditStu(Boolean propertyAuditStu) {
		this.propertyAuditStu = propertyAuditStu;
	}
}
