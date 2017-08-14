package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * Created by wu_honglei on 2016/12/29.
 */
public class ORDR0605IEntity extends BaseEntity {
    //买手订单
    private BsOrderEntity bsOrderEntity ;

    //买手订单附表
    private BsOrderAttachedEntity bsOrderAttachedEntity;

    //买手订单明细
    private BsOrderDetailEntity bsOrderDetailEntity;

    //买手订单明细附表
    private BsOrderDetailAttachedEntity bsOrderDetailAttachedEntity;

    //买手囤货分拆单
    private BsStockpileSplitDetailEntity bsStockDetailEntity;

    //买手囤货分拆单附表
    private BsStockpileSplitDetailAttachedEntity bsStockDetailAttachedEntity;


    public BsOrderEntity getBsOrderEntity() {
        return bsOrderEntity;
    }

    public void setBsOrderEntity(BsOrderEntity bsOrderEntity) {
        this.bsOrderEntity = bsOrderEntity;
    }

    public BsOrderDetailEntity getBsOrderDetailEntity() {
        return bsOrderDetailEntity;
    }

    public void setBsOrderDetailEntity(BsOrderDetailEntity bsOrderDetailEntity) {
        this.bsOrderDetailEntity = bsOrderDetailEntity;
    }

    public BsStockpileSplitDetailEntity getBsStockDetailEntity() {
        return bsStockDetailEntity;
    }

    public void setBsStockDetailEntity(BsStockpileSplitDetailEntity bsStockDetailEntity) {
        this.bsStockDetailEntity = bsStockDetailEntity;
    }

    public BsOrderAttachedEntity getBsOrderAttachedEntity() {
        return bsOrderAttachedEntity;
    }

    public void setBsOrderAttachedEntity(BsOrderAttachedEntity bsOrderAttachedEntity) {
        this.bsOrderAttachedEntity = bsOrderAttachedEntity;
    }

    public BsOrderDetailAttachedEntity getBsOrderDetailAttachedEntity() {
        return bsOrderDetailAttachedEntity;
    }

    public void setBsOrderDetailAttachedEntity(BsOrderDetailAttachedEntity bsOrderDetailAttachedEntity) {
        this.bsOrderDetailAttachedEntity = bsOrderDetailAttachedEntity;
    }

    public BsStockpileSplitDetailAttachedEntity getBsStockDetailAttachedEntity() {
        return bsStockDetailAttachedEntity;
    }

    public void setBsStockDetailAttachedEntity(BsStockpileSplitDetailAttachedEntity bsStockDetailAttachedEntity) {
        this.bsStockDetailAttachedEntity = bsStockDetailAttachedEntity;
    }
}
