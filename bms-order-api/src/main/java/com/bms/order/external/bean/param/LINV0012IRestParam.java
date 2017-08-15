package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/2.
 */
public class LINV0012IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    //物流区域ID
    private String[] logisticsId;
    //销售平台
    private String[] salesPlatform;
    //商品ID
    private String[] commodityId;
    //买手ID
    private String[] saleId;
    //单位
    private String[] uom;
    //库存类型
    private String[] ivType;

    public String[] getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String[] logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String[] getSalesPlatform() {
        return salesPlatform;
    }

    public void setSalesPlatform(String[] salesPlatform) {
        this.salesPlatform = salesPlatform;
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
}
