package com.bms.slpd.bean.result.field;

import com.bms.slpd.bean.entity.SlpdBrandOwner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0501IBrandResult", description = "品牌")
public class SLPD0501IBrandResult implements Serializable {
	private static final long serialVersionUID = 1L;

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

	@ApiModelProperty(value = "品牌所有人名称")
	private String ownersName;
	@ApiModelProperty(value = "品牌所有人集合")
	private List<SlpdBrandOwner> brandOwnerList;

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

	public String getOwnersName() {
		return ownersName;
	}

	public void setOwnersName(String ownersName) {
		this.ownersName = ownersName;
	}

	public List<SlpdBrandOwner> getBrandOwnerList() {
		return brandOwnerList;
	}

	public void setBrandOwnerList(List<SlpdBrandOwner> brandOwnerList) {
		this.brandOwnerList = brandOwnerList;
	}
}
