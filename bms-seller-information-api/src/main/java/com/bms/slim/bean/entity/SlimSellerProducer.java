/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_SELLER_PRODUCER对应的实体SlimSellerProducer</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSellerProducer extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家下属生产商ID */
    private Long sellerProducerId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 生产商ID */
    private Long producerId;

    /**
     * <p>默认构造函数</p>
     */
    public SlimSellerProducer() {
    }

    /**
     * <p>卖家下属生产商ID</p>
     *
     * @return 卖家下属生产商ID
     */
    public Long getSellerProducerId() {
        return sellerProducerId;
    }

    /**
     * <p>卖家下属生产商ID</p>
     *
     * @param sellerProducerId 卖家下属生产商ID
     */
    public void setSellerProducerId(Long sellerProducerId) {
        this.sellerProducerId = sellerProducerId;
    }
    /**
     * <p>实体卖家ID</p>
     *
     * @return 实体卖家ID
     */
    public Long getEntitySellerId() {
        return entitySellerId;
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @param entitySellerId 实体卖家ID
     */
    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
    /**
     * <p>生产商ID</p>
     *
     * @return 生产商ID
     */
    public Long getProducerId() {
        return producerId;
    }

    /**
     * <p>生产商ID</p>
     *
     * @param producerId 生产商ID
     */
    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

}
