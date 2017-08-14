package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/5/18.
 */
public class LINV0119ICommodityParam implements Serializable {
    @ApiModelProperty(value = "商品ID")
    private String commodityId;
    @ApiModelProperty(value = "单位")
    private String uom;
    @ApiModelProperty(value = "出仓仓库的库存类型，减少库存的仓库")
    private String fromInvStatus;
    @ApiModelProperty(value = "入仓仓库的库存类型，增加库存的仓库")
    private String toInvStatus;
    @ApiModelProperty(value = "调整数量")
    private String adjustQty;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getFromInvStatus() {
        return fromInvStatus;
    }

    public void setFromInvStatus(String fromInvStatus) {
        this.fromInvStatus = fromInvStatus;
    }

    public String getToInvStatus() {
        return toInvStatus;
    }

    public void setToInvStatus(String toInvStatus) {
        this.toInvStatus = toInvStatus;
    }

    public String getAdjustQty() {
        return adjustQty;
    }

    public void setAdjustQty(String adjustQty) {
        this.adjustQty = adjustQty;
    }
}
