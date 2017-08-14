package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by wang_haichun on 2017/3/29.
 */
public class ComoManufactureRsResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商名称")
    private String producerName;
    @ApiModelProperty(value = "生产商ID")
    private String producerId;
    @ApiModelProperty(value = "生产商编码")
    private String producerCode;
    @ApiModelProperty(value = "生产日期")
    private String manufactureDate;
    @ApiModelProperty(value = "储存条件")
    private String storageCondition;
    @ApiModelProperty(value = "保质期")
    private String shelfLife;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "生产商省份")
    private String provinceName;
    @ApiModelProperty(value = "生产商地区（市县）")
    private String cityName;
    @ApiModelProperty(value = "地址")
    private String addressName;
    @ApiModelProperty(value = "电话")
    private String telephone;
    @ApiModelProperty(value = "ISO9001质量管理体系认证证书认证标准")
    private String qltCertificate;
    @ApiModelProperty(value = "产品等级")
    private String qualityGradeTypeName;

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQltCertificate() {
        return qltCertificate;
    }

    public void setQltCertificate(String qltCertificate) {
        this.qltCertificate = qltCertificate;
    }

    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    public void setQualityGradeTypeName(String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
    }
}
