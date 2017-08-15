package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0114IParam", description = "批量查询卖家代理商供应资质接口入参")
public class SLIM0114IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "制造商供应资质ID集合")
    private List<Long> msqIds;
    @ApiModelProperty(value = "实体卖家ID集合")
    private List<Long> entitySellerIds;
    /*@ApiModelProperty(value = "受托生产商名称")
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
    private String foodBizLicUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getMsqIds() {
        return msqIds;
    }

    public void setMsqIds(List<Long> msqIds) {
        this.msqIds = msqIds;
    }

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    /*public String getEntrustedProducerName() {
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
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
