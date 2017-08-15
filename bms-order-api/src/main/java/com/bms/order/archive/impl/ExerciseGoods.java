package com.bms.order.archive.impl;

import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Completable;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.enumeration.OperatorType;

import java.math.BigDecimal;

/**
 * 行权用Entity（货权人、商品、数量）
 * 
 * @author li_huiqian
 *
 */
public class ExerciseGoods extends AbstractArchive implements Completable {

    /**
     * 货权人ID
     */
    private String ownerId;

    /**
     * 商品Id
     */
    private String goodsId;

    /**
     * 商品数量
     */
    private BigDecimal qty;

    @Override
    public void complete(boolean allowDelete) {
        // TODO Auto-generated method stub
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}
