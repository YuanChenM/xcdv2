package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0805ILgcsResult", description = "物流区信息")
public class SLPD0805ILgcsResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物流区商品ID")
    private Long lacId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "上下架状态，1：上架，2：下架")
    private String shelfStu;

    public Long getLacId() {
        return lacId;
    }

    public void setLacId(Long lacId) {
        this.lacId = lacId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getShelfStu() {
        return shelfStu;
    }

    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }
}
