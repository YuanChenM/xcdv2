package com.bms.order.fms.bean;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * oms内部子系统-订单供货明细
 */
public class OmsOrderSellerDetail implements Serializable {
    private static final long serialVersionUID = 3281942367512654473L;
    //买家分批订单明细
    private Long orderDetailId;
    //商品库存类型
    private String comoInventoryType;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getComoInentoryType() {
        return comoInventoryType;
    }

    public void setComoInentoryType(String comoInentoryType) {
        this.comoInventoryType = comoInentoryType;
    }
}

