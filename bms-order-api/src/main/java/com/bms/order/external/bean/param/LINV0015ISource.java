package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0015ISource implements Serializable {
    //物流区域Id
    private Long logicAreaId;
    //销售平台
    private String salePlatform;
    //货主Id
    private String ownerId;
    //商品Id
    private String commodityId;
    //库存类型
    private String ivType;

    public Long getLogicAreaId() {
        return logicAreaId;
    }

    public void setLogicAreaId(Long logicAreaId) {
        this.logicAreaId = logicAreaId;
    }

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }
}
