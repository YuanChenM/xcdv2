/*
 * 2017/03/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>表AGIF_BUTLER_ADDRESS对应的实体AgifButlerAddress</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
@ApiModel(value = "ButlerAddressRsParam", description = "冻品管家地址信息Param")
public class ButlerAddressRsParam implements Serializable {
    @ApiModelProperty(value = "地址ID")
    private Long addrId;
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = "地址类型 0：户籍地址，1：工作地址，2：虚拟经营地址")
    private String addrType;
    @ApiModelProperty(value = "地址类型名称 户籍地址，工作地址，虚拟经营地址")
    private String addrTypeName;
    @ApiModelProperty(value = "省ID")
    private Long provinceId;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "城市（地区）ID")
    private Long cityId;
    @ApiModelProperty(value = "城市（地区）编码")
    private String cityCode;
    @ApiModelProperty(value = "城市（地区）名称")
    private String cityName;
    @ApiModelProperty(value = "区（县）ID")
    private Long districtId;
    @ApiModelProperty(value = "区（县）编码")
    private String districtCode;
    @ApiModelProperty(value = "区（县）名称")
    private String districtName;
    @ApiModelProperty(value = "街道（乡）ID")
    private Long streetId;
    @ApiModelProperty(value = "街道（乡）编码")
    private String streetCode;
    @ApiModelProperty(value = "街道（乡）名称")
    private String streetName;
    @ApiModelProperty(value = "详细地址")
    private String addrDetail;
    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * <p>默认构造函数</p>
     */
    public ButlerAddressRsParam() {
    }

    /**
     * <p>ADDR_ID</p>
     *
     * @return ADDR_ID
     */
    public Long getAddrId() {
        return addrId;
    }

    /**
     * <p>ADDR_ID</p>
     *
     * @param addrId ADDR_ID
     */
    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    /**
     * <p>BUTLER_ID</p>
     *
     * @return BUTLER_ID
     */
    public String getButlerId() {
        return butlerId;
    }

    /**
     * <p>BUTLER_ID</p>
     *
     * @param butlerId BUTLER_ID
     */
    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    /**
     * <p>0：户籍地址，1：工作地址，2：虚拟经营地址</p>
     *
     * @return 0：户籍地址，1：工作地址，2：虚拟经营地址
     */
    public String getAddrType() {
        return addrType;
    }

    /**
     * <p>0：户籍地址，1：工作地址，2：虚拟经营地址</p>
     *
     * @param addrType 0：户籍地址，1：工作地址，2：虚拟经营地址
     */
    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    /**
     * <p>户籍地址，工作地址，虚拟经营地址</p>
     *
     * @return 户籍地址，工作地址，虚拟经营地址
     */
    public String getAddrTypeName() {
        return addrTypeName;
    }

    /**
     * <p>户籍地址，工作地址，虚拟经营地址</p>
     *
     * @param addrTypeName 户籍地址，工作地址，虚拟经营地址
     */
    public void setAddrTypeName(String addrTypeName) {
        this.addrTypeName = addrTypeName;
    }

    /**
     * <p>PROVINCE_ID</p>
     *
     * @return PROVINCE_ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * <p>PROVINCE_ID</p>
     *
     * @param provinceId PROVINCE_ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * <p>PROVINCE_CODE</p>
     *
     * @return PROVINCE_CODE
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>PROVINCE_CODE</p>
     *
     * @param provinceCode PROVINCE_CODE
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * <p>PROVINCE_NAME</p>
     *
     * @return PROVINCE_NAME
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>PROVINCE_NAME</p>
     *
     * @param provinceName PROVINCE_NAME
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * <p>CITY_ID</p>
     *
     * @return CITY_ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * <p>CITY_ID</p>
     *
     * @param cityId CITY_ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * <p>CITY_CODE</p>
     *
     * @return CITY_CODE
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * <p>CITY_CODE</p>
     *
     * @param cityCode CITY_CODE
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * <p>CITY_NAME</p>
     *
     * @return CITY_NAME
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * <p>CITY_NAME</p>
     *
     * @param cityName CITY_NAME
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * <p>DISTRICT_ID</p>
     *
     * @return DISTRICT_ID
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * <p>DISTRICT_ID</p>
     *
     * @param districtId DISTRICT_ID
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * <p>DISTRICT_CODE</p>
     *
     * @return DISTRICT_CODE
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>DISTRICT_CODE</p>
     *
     * @param districtCode DISTRICT_CODE
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>DISTRICT_NAME</p>
     *
     * @return DISTRICT_NAME
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * <p>DISTRICT_NAME</p>
     *
     * @param districtName DISTRICT_NAME
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * <p>STREET_ID</p>
     *
     * @return STREET_ID
     */
    public Long getStreetId() {
        return streetId;
    }

    /**
     * <p>STREET_ID</p>
     *
     * @param streetId STREET_ID
     */
    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    /**
     * <p>STREET_CODE</p>
     *
     * @return STREET_CODE
     */
    public String getStreetCode() {
        return streetCode;
    }

    /**
     * <p>STREET_CODE</p>
     *
     * @param streetCode STREET_CODE
     */
    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    /**
     * <p>STREET_NAME</p>
     *
     * @return STREET_NAME
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * <p>STREET_NAME</p>
     *
     * @param streetName STREET_NAME
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * <p>ADDR_DETAIL</p>
     *
     * @return ADDR_DETAIL
     */
    public String getAddrDetail() {
        return addrDetail;
    }

    /**
     * <p>ADDR_DETAIL</p>
     *
     * @param addrDetail ADDR_DETAIL
     */
    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

}
