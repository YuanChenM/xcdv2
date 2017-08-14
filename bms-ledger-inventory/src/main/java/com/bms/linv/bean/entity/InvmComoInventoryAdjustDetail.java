/*
 * 2017/04/14 自动生成 新规作成
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * <p>
 * 表invm_como_inventory_adjust_detail对应的实体InvmComoInventoryAdjustDetail
 * </p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmComoInventoryAdjustDetail extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 产品库存调整明细ID */
    private Long detailId;
    /** 调整ID */
    private Long comoAdjustId;
    /** 调出商品库存身份 */
    private String storeNoFrom;
    /** 调入商品库存身份 */
    private String storeNoTo;
    /** 调整数量 */
    private BigDecimal adjustQty;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getComoAdjustId() {
        return comoAdjustId;
    }

    public void setComoAdjustId(Long comoAdjustId) {
        this.comoAdjustId = comoAdjustId;
    }

    public String getStoreNoFrom() {
        return storeNoFrom;
    }

    public void setStoreNoFrom(String storeNoFrom) {
        this.storeNoFrom = storeNoFrom;
    }

    public String getStoreNoTo() {
        return storeNoTo;
    }

    public void setStoreNoTo(String storeNoTo) {
        this.storeNoTo = storeNoTo;
    }

    public BigDecimal getAdjustQty() {
        return adjustQty;
    }

    public void setAdjustQty(BigDecimal adjustQty) {
        this.adjustQty = adjustQty;
    }
}
