package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0101IEntitySellerParam", description = "实体卖家")
public class SLIM0101IEntitySellerParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家全称")
    private String fullName;
    @ApiModelProperty(value = "卖家简称")
    private String shortName;
    @ApiModelProperty(value = "国家编码")
    private String countryCode;
    @ApiModelProperty(value = "国家")
    private String countryName;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "省")
    private String provinceName;
    @ApiModelProperty(value = "市编码")
    private String cityCode;
    @ApiModelProperty(value = "市")
    private String cityName;
    @ApiModelProperty(value = "固定电话")
    private String tel;
    @ApiModelProperty(value = "传真号")
    private String fax;
    @ApiModelProperty(value = "网站及微信公众号")
    private String mediaPlatform;
	@ApiModelProperty(value = "详细地址")
	private String address;
    @ApiModelProperty(value = "卖家联系人参数集合")
    private List<SLIM0101IContactParam> contactParams;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMediaPlatform() {
		return mediaPlatform;
	}

	public void setMediaPlatform(String mediaPlatform) {
		this.mediaPlatform = mediaPlatform;
	}

	public List<SLIM0101IContactParam> getContactParams() {
		return contactParams;
	}

	public void setContactParams(List<SLIM0101IContactParam> contactParams) {
		this.contactParams = contactParams;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
