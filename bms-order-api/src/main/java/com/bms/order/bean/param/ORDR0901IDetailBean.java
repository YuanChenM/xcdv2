package com.bms.order.bean.param;

import com.bms.order.archive.impl.BsReturnDetail;
import com.bms.order.bean.entity.BsReturnDetailEntity;
import com.bms.order.common.rest.param.RestBean;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/2/27.
 */
public class ORDR0901IDetailBean extends RestBean {

    private static final long serialVersionUID = 1L;

    /**
     * 	买手囤货分拆单明细
     */
    private Long bsStockpileSplitDetailId;
    /**
     * 	商品ID
     */
    private String goodsId;
    /**
     * 	退货数量
     */
    private BigDecimal returnQty;

    private BigDecimal returnPriceUnit;
    /**
     * 退货明细退货原因
     */
    private Long detailReasonId;

    public Long getBsStockpileSplitDetailId() {
        return bsStockpileSplitDetailId;
    }

    public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
        this.bsStockpileSplitDetailId = bsStockpileSplitDetailId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    public Long getDetailReasonId() {
        return detailReasonId;
    }

    public void setDetailReasonId(Long detailReasonId) {
        this.detailReasonId = detailReasonId;
    }

    public BsReturnDetail generateBsReturnDetail(){
        BsReturnDetailEntity entity = new BsReturnDetailEntity();
        entity.setBsStockpileSplitDetailId(bsStockpileSplitDetailId);
        entity.setGoodsId(goodsId);
        entity.setReturnQty(returnQty);
        entity.setReasonId(detailReasonId);
        BsReturnDetail detail = BsReturnDetail.build(null).forCreate(entity);
        return detail;
    }

    public BigDecimal getReturnPriceUnit() {
        return returnPriceUnit;
    }

    public void setReturnPriceUnit(BigDecimal returnPriceUnit) {
        this.returnPriceUnit = returnPriceUnit;
    }
}
