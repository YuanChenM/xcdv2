/*
 * 2017/03/23 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_inv_allocation_detail对应的实体ComoInvAllocationDetail</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoInvAllocationDetail extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 明细ID */
    private Long allocationDetailId;
    /** 划拨单ID */
    private Long allocationId;
    /** 商品ID */
    private Long targetCommodityId;
    /** 商品ID */
    private Long originalCommodityId;
    /** 货主类型 */
    private String ownerType;
    /** 货主ID */
    private String ownerId;
    /** 货主编码 */
    private String ownerCode;
    /** 货主名称 */
    private String ownerName;
    /** SKU编码 */
    private String skuCode;
    /** 采购批次 */
    private String lotNo;
    /** 单位 */
    private String uom;
    /** 库存状态 */
    private String inventoryStu;
    /** 库存数量 */
    private java.math.BigDecimal inventoryQty;
    /** 计划数量 */
    private java.math.BigDecimal planQty;
    /** 实际执行数量 */
    private java.math.BigDecimal factQty;

    /**
     * <p>默认构造函数</p>
     */
    public ComoInvAllocationDetail() {
    }

    /**
     * <p>明细ID</p>
     *
     * @return 明细ID
     */
    public Long getAllocationDetailId() {
        return allocationDetailId;
    }

    /**
     * <p>明细ID</p>
     *
     * @param allocationDetailId 明细ID
     */
    public void setAllocationDetailId(Long allocationDetailId) {
        this.allocationDetailId = allocationDetailId;
    }
    /**
     * <p>划拨单ID</p>
     *
     * @return 划拨单ID
     */
    public Long getAllocationId() {
        return allocationId;
    }

    /**
     * <p>划拨单ID</p>
     *
     * @param allocationId 划拨单ID
     */
    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public Long getTargetCommodityId() {
        return targetCommodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param targetCommodityId 商品ID
     */
    public void setTargetCommodityId(Long targetCommodityId) {
        this.targetCommodityId = targetCommodityId;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public Long getOriginalCommodityId() {
        return originalCommodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param originalCommodityId 商品ID
     */
    public void setOriginalCommodityId(Long originalCommodityId) {
        this.originalCommodityId = originalCommodityId;
    }
    /**
     * <p>货主类型</p>
     *
     * @return 货主类型
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>货主类型</p>
     *
     * @param ownerType 货主类型
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
    /**
     * <p>货主ID</p>
     *
     * @return 货主ID
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * <p>货主ID</p>
     *
     * @param ownerId 货主ID
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * <p>货主编码</p>
     *
     * @return 货主编码
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /**
     * <p>货主编码</p>
     *
     * @param ownerCode 货主编码
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }
    /**
     * <p>货主名称</p>
     *
     * @return 货主名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * <p>货主名称</p>
     *
     * @param ownerName 货主名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    /**
     * <p>SKU编码</p>
     *
     * @return SKU编码
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>SKU编码</p>
     *
     * @param skuCode SKU编码
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>采购批次</p>
     *
     * @return 采购批次
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * <p>采购批次</p>
     *
     * @param lotNo 采购批次
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }
    /**
     * <p>单位</p>
     *
     * @return 单位
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>单位</p>
     *
     * @param uom 单位
     */
    public void setUom(String uom) {
        this.uom = uom;
    }
    /**
     * <p>库存状态</p>
     *
     * @return 库存状态
     */
    public String getInventoryStu() {
        return inventoryStu;
    }

    /**
     * <p>库存状态</p>
     *
     * @param inventoryStu 库存状态
     */
    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }

    /**
     * <p>库存数量</p>
     *
     * @return 库存数量
     */
    public java.math.BigDecimal getInventoryQty() {
        return inventoryQty;
    }

    /**
     * <p>库存数量</p>
     *
     * @param inventoryQty 库存数量
     */
    public void setInventoryQty(java.math.BigDecimal inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

    /**
     * <p>计划数量</p>
     *
     * @return 计划数量
     */
    public java.math.BigDecimal getPlanQty() {
        return planQty;
    }

    /**
     * <p>计划数量</p>
     *
     * @param planQty 计划数量
     */
    public void setPlanQty(java.math.BigDecimal planQty) {
        this.planQty = planQty;
    }

    /**
     * <p>实际执行数量</p>
     *
     * @return 实际执行数量
     */
    public java.math.BigDecimal getFactQty() {
        return factQty;
    }

    /**
     * <p>实际执行数量</p>
     *
     * @param factQty 实际执行数量
     */
    public void setFactQty(java.math.BigDecimal factQty) {
        this.factQty = factQty;
    }

}
