package com.batch.order.bean.result;

import com.batch.order.bean.entity.DistributionNotificationEntity;

import java.util.List;

/**
 * Created by liutao on 2017/1/13.
 */
public class ORDR0302DistributionResult extends DistributionNotificationEntity {
    /** 是否使用账期 */
    private Boolean useNetFlg;

    /** 支付状态 */
    private String paymentStu;

    private List<ORDR0302DistributionDetailResult> detailEntities;

    public List<ORDR0302DistributionDetailResult> getDetailEntities() {
        return detailEntities;
    }

    public void setDetailEntities(List<ORDR0302DistributionDetailResult> detailEntities) {
        this.detailEntities = detailEntities;
    }

    public Boolean getUseNetFlg() {
        return useNetFlg;
    }

    public void setUseNetFlg(Boolean useNetFlg) {
        this.useNetFlg = useNetFlg;
    }

    public String getPaymentStu() {
        return paymentStu;
    }

    public void setPaymentStu(String paymentStu) {
        this.paymentStu = paymentStu;
    }
}
