package com.batch.order.bean.result;

import com.batch.order.bean.entity.DistributionNotificationDetailEntity;
import com.framework.base.rest.entity.BaseEntity;

import java.util.List;

/**
 * Created by liutao on 2017/1/13.
 */
public class ORDR0301DistributionDetailResult extends BaseEntity{

    private Long buyerBatchOrderId;

    private String buyerBatchOrderStu;

    private Boolean isLateFlg;

    private List<ORDR0301DistributionDetailsResult> distributionDetailEntities;

    public Long getBuyerBatchOrderId() {
        return buyerBatchOrderId;
    }

    public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
        this.buyerBatchOrderId = buyerBatchOrderId;
    }

    public String getBuyerBatchOrderStu() {
        return buyerBatchOrderStu;
    }

    public void setBuyerBatchOrderStu(String buyerBatchOrderStu) {
        this.buyerBatchOrderStu = buyerBatchOrderStu;
    }

    public List<ORDR0301DistributionDetailsResult> getDistributionDetailEntities() {
        return distributionDetailEntities;
    }

    public void setDistributionDetailEntities(List<ORDR0301DistributionDetailsResult> distributionDetailEntities) {
        this.distributionDetailEntities = distributionDetailEntities;
    }

    public Boolean getLateFlg() {
        return isLateFlg;
    }

    public void setLateFlg(Boolean lateFlg) {
        isLateFlg = lateFlg;
    }
}
