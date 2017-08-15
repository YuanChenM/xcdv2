package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0501IBreedResult", description = "品种")
public class SLPD0501IBreedResult implements Serializable {
	private static final long serialVersionUID = 1L;

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
}
