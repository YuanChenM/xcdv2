package com.bms.order.bean.result;
import com.framework.base.rest.entity.BaseEntity;
import com.framework.base.rest.result.BaseRestResult;
/**
 *订单分拆结果确认接口Result
 *@author li_huiqian
 */
public class ORDR0203IRestResult extends BaseEntity {
    private static final long serialVersionUID = 1L;


    private Long batchOrderId;


    private boolean confirmed;


    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Long getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(Long batchOrderId) {
        this.batchOrderId = batchOrderId;
    }
}
