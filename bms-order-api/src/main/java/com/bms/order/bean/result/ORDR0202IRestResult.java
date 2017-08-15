package com.bms.order.bean.result;
import com.framework.base.rest.entity.BaseEntity;
/**
 *订单分拆结果取消接口Result
 *@author peng_hao
 */
public class ORDR0202IRestResult extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //分批订单明细ID
    private Long batchOrderDetailId;

    //确认结果：True代表取消成功，False代表取消失败
    private boolean confirmed;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Long getBatchOrderDetailId() {
        return batchOrderDetailId;
    }

    public void setBatchOrderDetailId(Long batchOrderDetailId) {
        this.batchOrderDetailId = batchOrderDetailId;
    }
}
