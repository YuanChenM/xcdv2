package com.bms.order.external.bean.param;

import com.bms.order.common.rest.param.RestBean;

/**
 * Created by Administrator on 2017/2/23.
 */
public class SLPD0805IRestParam extends RestBean {
    /**
     * 
     */
    private static final long serialVersionUID = 4966684673548754807L;

    /* 商品ID集合 */
    private String[] commodityIds;
    /* 卖家ID集合 */
    private String[] sellerIds;
    /* 生产商ID集合 */
    private Long[] producerIds;

    public String[] getCommodityIds() {
        return commodityIds;
    }

    public void setCommodityIds(String[] commodityIds) {
        this.commodityIds = commodityIds;
    }

    public String[] getSellerIds() {
        return sellerIds;
    }

    public void setSellerIds(String[] sellerIds) {
        this.sellerIds = sellerIds;
    }

    public Long[] getProducerIds() {
        return producerIds;
    }

    public void setProducerIds(Long[] producerIds) {
        this.producerIds = producerIds;
    }
}
