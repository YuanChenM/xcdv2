package com.batch.order.bean.entity;

import com.batch.order.util.BeanUtils;

public class BuyernullForcastDeliverDetailAttachedHistoryEntity extends BuyernullForcastDeliverDetailAttachedEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 履历ID
     */
    private Long historyId;

    public Long getHistoryId() {
        return this.historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public BuyernullForcastDeliverDetailAttachedHistoryEntity(BuyernullForcastDeliverDetailAttachedEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
