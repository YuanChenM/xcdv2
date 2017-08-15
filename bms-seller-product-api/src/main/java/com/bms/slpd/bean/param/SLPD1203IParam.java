package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD1203ILgcsProductParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1203IParam", description = "物流区商品批量上下线接口入参")
public class SLPD1203IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物流区商品集合")
    private List<SLPD1203ILgcsProductParam> lgcsCommodityParams;

    @ApiModelProperty(value = "上下架状态，1：上架，2：下架")
    private String shelfStu;

    public List<SLPD1203ILgcsProductParam> getLgcsCommodityParams() {
        return lgcsCommodityParams;
    }

    public void setLgcsCommodityParams(List<SLPD1203ILgcsProductParam> lgcsCommodityParams) {
        this.lgcsCommodityParams = lgcsCommodityParams;
    }

    public String getShelfStu() {
        return shelfStu;
    }

    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }
}
