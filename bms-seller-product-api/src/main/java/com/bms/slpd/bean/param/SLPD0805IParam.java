package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0805IParam", description = "批量查询商品清单API的入参")
public class SLPD0805IParam extends BaseRestPaginationParam {
	private static final long serialVersionUID = 1L;

	/*@ApiModelProperty(value = "卖家单品品牌生产商ID集合")
	private List<Long> sellerCommodityIds;
	@ApiModelProperty(value = "卖家单品品牌(规格)生产商编码集合")
	private List<String> sellerCommodityCodes;*/
	@ApiModelProperty(value = "卖家单品品牌(规格)生产商SKU集合")
	private List<String> sellerCommoditySkus;
	/*@ApiModelProperty(value = "卖家单品品牌(规格)生产商审核状态集合")
	private List<String> auditStus;*/
	/*@ApiModelProperty(value = "删除标识")
	private Boolean delFlg;*/

	@ApiModelProperty(value = "货号集合")
	private List<String> articleNos;
	@ApiModelProperty(value = "商品ID集合")
	private List<String> commodityIds;
	@ApiModelProperty(value = "销售类型")
	private String saleType;

	@ApiModelProperty(value = "卖家ID集合")
	private List<Long> sellerIds;
	@ApiModelProperty(value = "卖家编码集合")
	private List<String> sellerCodes;
	@ApiModelProperty(value = "实体卖家ID集合")
	private List<Long> entitySellerIds;
	@ApiModelProperty(value = "卖家名称")
	private String sellerName;

	/*@ApiModelProperty(value = "单品品牌(规格)生产商ID集合")
	private List<Long> producerProductIds;*/
	@ApiModelProperty(value = "单品品牌(规格)生产商SKU集合")
	private List<String> producerProductSkus;
	/*@ApiModelProperty(value = "单品品牌(规格)生产商审核状态集合")
	private List<String> producerProductAuditStus;*/

	@ApiModelProperty(value = "生产商ID集合")
	private List<Long> producerIds;
	@ApiModelProperty(value = "生产商编码集合")
	private List<String> producerCodes;
	@ApiModelProperty(value = "生产商名称")
	private String producerName;

	@ApiModelProperty(value = "产品ID集合")
	private List<String> productIds;
	@ApiModelProperty(value = "质量等级集合")
	private List<String> qualityGradeTypes;
	/*@ApiModelProperty(value = "产品审核状态集合")
	private List<String> productAuditStus;*/

	/*@ApiModelProperty(value = "单品品牌规格ID集合")
	private List<Long> brandItemPropertyIds;*/

	/*@ApiModelProperty(value = "单品品牌ID集合")
	private List<Long> brandItemIds;*/
	@ApiModelProperty(value = "单品品牌SKU集合")
	private List<String> brandItemSkus;

	/*@ApiModelProperty(value = "品牌ID集合")
	private List<Long> brandIds;*/
	@ApiModelProperty(value = "品牌编码集合")
	private List<String> brandCodes;
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	@ApiModelProperty(value = "品牌类型集合")
	private List<String> brandTypes;

	/*@ApiModelProperty(value = "单品ID集合")
	private List<Long> itemIds;*/
	@ApiModelProperty(value = "单品编码集合")
	private List<String> itemCodes;
	@ApiModelProperty(value = "单品SKU集合")
	private List<String> itemSkus;
	@ApiModelProperty(value = "单品名称")
	private String itemName;

	/*@ApiModelProperty(value = "品种ID集合")
	private List<Long> breedIds;*/
	@ApiModelProperty(value = "品种编码集合")
	private List<String> breedCodes;
	@ApiModelProperty(value = "品种SKU集合")
	private List<String> breedSkus;
	@ApiModelProperty(value = "品种标准市场销售名")
	private String breedSalesName;

	/*@ApiModelProperty(value = "二级分类ID集合")
	private List<Long> machiningIds;*/
	@ApiModelProperty(value = "二级分类编码集合")
	private List<String> machiningCodes;
	@ApiModelProperty(value = "二级分类名称")
	private String machiningName;

	/*@ApiModelProperty(value = "一级分类ID集合")
	private List<Long> classesIds;*/
	@ApiModelProperty(value = "一级分类编码集合")
	private List<String> classesCodes;
	@ApiModelProperty(value = "一级分类名称")
	private String classesName;

	public List<String> getSellerCommoditySkus() {
		return sellerCommoditySkus;
	}

	public void setSellerCommoditySkus(List<String> sellerCommoditySkus) {
		this.sellerCommoditySkus = sellerCommoditySkus;
	}

	/*public Boolean getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Boolean delFlg) {
		this.delFlg = delFlg;
	}*/

	public List<String> getArticleNos() {
		return articleNos;
	}

	public void setArticleNos(List<String> articleNos) {
		this.articleNos = articleNos;
	}

	public List<String> getCommodityIds() {
		return commodityIds;
	}

	public void setCommodityIds(List<String> commodityIds) {
		this.commodityIds = commodityIds;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public List<Long> getSellerIds() {
		return sellerIds;
	}

	public void setSellerIds(List<Long> sellerIds) {
		this.sellerIds = sellerIds;
	}

	public List<String> getSellerCodes() {
		return sellerCodes;
	}

	public void setSellerCodes(List<String> sellerCodes) {
		this.sellerCodes = sellerCodes;
	}

	public List<Long> getEntitySellerIds() {
		return entitySellerIds;
	}

	public void setEntitySellerIds(List<Long> entitySellerIds) {
		this.entitySellerIds = entitySellerIds;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public List<String> getProducerProductSkus() {
		return producerProductSkus;
	}

	public void setProducerProductSkus(List<String> producerProductSkus) {
		this.producerProductSkus = producerProductSkus;
	}

	public List<Long> getProducerIds() {
		return producerIds;
	}

	public void setProducerIds(List<Long> producerIds) {
		this.producerIds = producerIds;
	}

	public List<String> getProducerCodes() {
		return producerCodes;
	}

	public void setProducerCodes(List<String> producerCodes) {
		this.producerCodes = producerCodes;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public List<String> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<String> productIds) {
		this.productIds = productIds;
	}

	public List<String> getQualityGradeTypes() {
		return qualityGradeTypes;
	}

	public void setQualityGradeTypes(List<String> qualityGradeTypes) {
		this.qualityGradeTypes = qualityGradeTypes;
	}

	public List<String> getBrandItemSkus() {
		return brandItemSkus;
	}

	public void setBrandItemSkus(List<String> brandItemSkus) {
		this.brandItemSkus = brandItemSkus;
	}

	public List<String> getBrandCodes() {
		return brandCodes;
	}

	public void setBrandCodes(List<String> brandCodes) {
		this.brandCodes = brandCodes;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<String> getBrandTypes() {
		return brandTypes;
	}

	public void setBrandTypes(List<String> brandTypes) {
		this.brandTypes = brandTypes;
	}

	public List<String> getItemCodes() {
		return itemCodes;
	}

	public void setItemCodes(List<String> itemCodes) {
		this.itemCodes = itemCodes;
	}

	public List<String> getItemSkus() {
		return itemSkus;
	}

	public void setItemSkus(List<String> itemSkus) {
		this.itemSkus = itemSkus;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public List<String> getBreedCodes() {
		return breedCodes;
	}

	public void setBreedCodes(List<String> breedCodes) {
		this.breedCodes = breedCodes;
	}

	public List<String> getBreedSkus() {
		return breedSkus;
	}

	public void setBreedSkus(List<String> breedSkus) {
		this.breedSkus = breedSkus;
	}

	public String getBreedSalesName() {
		return breedSalesName;
	}

	public void setBreedSalesName(String breedSalesName) {
		this.breedSalesName = breedSalesName;
	}

	public List<String> getMachiningCodes() {
		return machiningCodes;
	}

	public void setMachiningCodes(List<String> machiningCodes) {
		this.machiningCodes = machiningCodes;
	}

	public String getMachiningName() {
		return machiningName;
	}

	public void setMachiningName(String machiningName) {
		this.machiningName = machiningName;
	}

	public List<String> getClassesCodes() {
		return classesCodes;
	}

	public void setClassesCodes(List<String> classesCodes) {
		this.classesCodes = classesCodes;
	}

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
}
