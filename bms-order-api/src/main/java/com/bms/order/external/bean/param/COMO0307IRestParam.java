package com.bms.order.external.bean.param;

import com.bms.order.common.rest.param.RestBean;

/**
 * Created by Administrator on 2017/2/23.
 */
public class COMO0307IRestParam extends RestBean {
    /**
     *
     */
    private static final long serialVersionUID = 4966684673548754807L;

    /* 商品ID集合 */
    private String[] commodityId;
    /* 物流区ID */
    private Long lgcsAreaId;
    /**
     * 卖家ID或买手ID
     */
    private Long[] ownerId;
    /* 生产商ID集合 */
    private Long[] producerId;
    /**
     *  货权人类型
     */
   private  String ownerTypeId;


    public String[] getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String[] commodityId) {
        this.commodityId = commodityId;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public Long[] getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long[] ownerId) {
        this.ownerId = ownerId;
    }

    public Long[] getProducerId() {
        return producerId;
    }

    public void setProducerId(Long[] producerId) {
        this.producerId = producerId;
    }

    public String getOwnerTypeId() {
        return ownerTypeId;
    }

    public void setOwnerTypeId(String ownerTypeId) {
        this.ownerTypeId = ownerTypeId;
    }
}
