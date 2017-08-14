package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/4/18.
 */
@ApiModel(value = "LINV0112IInvParam", description = "商品总库存查询")
public class LINV0112IInvParam implements Serializable{

    @ApiModelProperty(value = "物流区域ID")
    private String[] logisticsId;

    @ApiModelProperty(value = "销售平台")
    private String[] salePlatform;

    @ApiModelProperty(value = "商品ID")
    private String[] commodityId;

    @ApiModelProperty(value = "单位")
    private String[] uom;

    @ApiModelProperty(value = "库存类型")
    private String[] ivType;

    @ApiModelProperty(value = "买手ID集合")
    private String[] saleId;

    @ApiModelProperty(value = "合伙人ID集合")
    private List<String> partner;

    public String[] getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String[] logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String[] getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String[] salePlatform) {
        this.salePlatform = salePlatform;
    }

    public String[] getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String[] commodityId) {
        this.commodityId = commodityId;
    }

    public String[] getUom() {
        return uom;
    }

    public void setUom(String[] uom) {
        this.uom = uom;
    }

    public String[] getIvType() {
        return ivType;
    }

    public void setIvType(String[] ivType) {
        this.ivType = ivType;
    }

    public String[] getSaleId() {
        return saleId;
    }

    public void setSaleId(String[] saleId) {
        this.saleId = saleId;
    }

    public List<String> getPartner() {
        return partner;
    }

    public void setPartner(List<String> partner) {
        this.partner = partner;
    }
}
