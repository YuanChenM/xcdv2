package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0102IParam", description = "批量查询卖家API的参数")
public class SLIM0102IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实体卖家ID集合")
    private List<Long> entitySellerIds;
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
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
    private Boolean delFlg;

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
