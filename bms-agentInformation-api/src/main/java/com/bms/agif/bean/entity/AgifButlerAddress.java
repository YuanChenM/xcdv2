/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER_ADDRESS对应的实体AgifButlerAddress</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerAddress extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** ADDR_ID */
    private Long addrId;
    /** BUTLER_ID */
    private String butlerId;
    /** 0：户籍地址，1：工作地址，2：虚拟经营地址 */
    private String addrType;
    /** 户籍地址，工作地址，虚拟经营地址 */
    private String addrTypeName;
    /** PROVINCE_ID */
    private Long provinceId;
    /** PROVINCE_CODE */
    private String provinceCode;
    /** PROVINCE_NAME */
    private String provinceName;
    /** CITY_ID */
    private Long cityId;
    /** CITY_CODE */
    private String cityCode;
    /** CITY_NAME */
    private String cityName;
    /** DISTRICT_ID */
    private Long districtId;
    /** DISTRICT_CODE */
    private String districtCode;
    /** DISTRICT_NAME */
    private String districtName;
    /** STREET_ID */
    private Long streetId;
    /** STREET_CODE */
    private String streetCode;
    /** STREET_NAME */
    private String streetName;
    /** ADDR_DETAIL */
    private String addrDetail;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerAddress() {
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
