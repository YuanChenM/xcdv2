package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class CommodityUomRsResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品销售单位设定信息表
     * COMO_COMMODITY_UOM
     */
//    @ApiModelProperty(value = "主键-销售单位设定ID")
//    private Long uomSid;
    @ApiModelProperty(value = "商品ID")
    private Long commodityId;
    @ApiModelProperty(value = "销售单位")
    private String uom;
    @ApiModelProperty(value = "是否默认")
    private boolean isIsDefault;
//    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
//    private Boolean delFlg;
//    @ApiModelProperty(value = "新建人ID")
//    private String crtId;
//    @ApiModelProperty(value = "新建时间")
//    private Date crtTime;
//    @ApiModelProperty(value = "修改人ID")
//    private String updId;
//    @ApiModelProperty(value = "修改时间")
//    private Date updTime;
//    @ApiModelProperty(value = "版本")
//    private Integer version;

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public boolean isIsDefault() {
        return isIsDefault;
    }

    public void setIsDefault(boolean isIsDefault) {
        this.isIsDefault = isIsDefault;
    }
}
