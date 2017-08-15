package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLIM0115ManufactureSupplyQualificationParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "制造商供应资质ID")
    private Long msqId;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "受托生产商名称")
    private String entrustedProducerName;
    @ApiModelProperty(value = "OEM生产商名称")
    private String oemProducerName;
    @ApiModelProperty(value = "OEM有效期限")
    private String oemValidPeriod;
    @ApiModelProperty(value = "生产商OEM协议URL")
    private String oemProtocolUrl;
    @ApiModelProperty(value = "食品经营许可证编号")
    private String foodBizLicNo;
    @ApiModelProperty(value = "食品经营许可证有效期限")
    private String fblValidPeriod;
    @ApiModelProperty(value = "食品经营许可证URL")
    private String foodBizLicUrl;
    @ApiModelProperty(value = "版本")
    private Integer version;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public Long getMsqId() {
        return msqId;
    }

    public void setMsqId(Long msqId) {
        this.msqId = msqId;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public String getEntrustedProducerName() {
        return entrustedProducerName;
    }

    public void setEntrustedProducerName(String entrustedProducerName) {
        this.entrustedProducerName = entrustedProducerName;
    }

    public String getOemProducerName() {
        return oemProducerName;
    }

    public void setOemProducerName(String oemProducerName) {
        this.oemProducerName = oemProducerName;
    }

    public String getOemValidPeriod() {
        return oemValidPeriod;
    }

    public void setOemValidPeriod(String oemValidPeriod) {
        this.oemValidPeriod = oemValidPeriod;
    }

    public String getOemProtocolUrl() {
        return oemProtocolUrl;
    }

    public void setOemProtocolUrl(String oemProtocolUrl) {
        this.oemProtocolUrl = oemProtocolUrl;
    }

    public String getFoodBizLicNo() {
        return foodBizLicNo;
    }

    public void setFoodBizLicNo(String foodBizLicNo) {
        this.foodBizLicNo = foodBizLicNo;
    }

    public String getFblValidPeriod() {
        return fblValidPeriod;
    }

    public void setFblValidPeriod(String fblValidPeriod) {
        this.fblValidPeriod = fblValidPeriod;
    }

    public String getFoodBizLicUrl() {
        return foodBizLicUrl;
    }

    public void setFoodBizLicUrl(String foodBizLicUrl) {
        this.foodBizLicUrl = foodBizLicUrl;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
