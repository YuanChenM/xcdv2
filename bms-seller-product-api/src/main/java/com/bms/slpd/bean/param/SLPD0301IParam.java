package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0301IParam", description = "批量查询单品API的入参")
public class SLPD0301IParam extends BaseRestPaginationParam {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "true：查询档案卡和差异卡，false：不查询")
	private boolean fileCardFlg;

	@ApiModelProperty(value = "单品ID集合")
	private List<Long> itemIds;
	@ApiModelProperty(value = "单品编码集合")
	private List<String> itemCodes;
	@ApiModelProperty(value = "单品SKU集合")
	private List<String> itemSkus;
	@ApiModelProperty(value = "单品名称")
	private String itemName;
	@ApiModelProperty(value = "审核状态")
	private Boolean auditStu;
	@ApiModelProperty(value = "删除标识")
	private Boolean delFlg;
	@ApiModelProperty(value = "特征")
	private String specification;

	@ApiModelProperty(value = "品种ID集合")
	private List<Long> breedIds;
	@ApiModelProperty(value = "品种编码集合")
	private List<String> breedCodes;
	@ApiModelProperty(value = "品种SKU集合")
	private List<String> breedSkus;
	@ApiModelProperty(value = "品种标准市场销售名")
	private String breedSalesName;

	@ApiModelProperty(value = "一级分类ID集合")
	private List<Long> classesIds;
	@ApiModelProperty(value = "一级分类编码集合")
	private List<String> classesCodes;
	@ApiModelProperty(value = "一级分类名称")
	private String classesName;

	@ApiModelProperty(value = "二级分类ID集合")
	private List<Long> machiningIds;
	@ApiModelProperty(value = "二级分类编码集合")
	private List<String> machiningCodes;
	@ApiModelProperty(value = "二级分类名称")
	private String machiningName;

	public boolean isFileCardFlg() {
		return fileCardFlg;
	}

	public void setFileCardFlg(boolean fileCardFlg) {
		this.fileCardFlg = fileCardFlg;
	}

	public List<Long> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
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

	public List<Long> getBreedIds() {
		return breedIds;
	}

	public void setBreedIds(List<Long> breedIds) {
		this.breedIds = breedIds;
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

	public List<Long> getClassesIds() {
		return classesIds;
	}

	public void setClassesIds(List<Long> classesIds) {
		this.classesIds = classesIds;
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

	public List<Long> getMachiningIds() {
		return machiningIds;
	}

	public void setMachiningIds(List<Long> machiningIds) {
		this.machiningIds = machiningIds;
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

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
}
