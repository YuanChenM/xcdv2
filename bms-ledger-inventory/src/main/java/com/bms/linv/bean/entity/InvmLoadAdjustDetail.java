package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by zheng_xu on 2017/5/3.
 */
public class InvmLoadAdjustDetail extends BaseEntity {
    /* 产品库存调整明细ID */
    private Long detailId;
    // 调整ID
    private Long loadAdjustId;
    // 物流区域ID
    private Long logicId;
    // 物流区域编码
    private String logicCode;
    // 货主ID，WMS称为货主，即平台卖家ID
    private String ownerId;
    // 货主编码，WMS称为货主，即平台卖家编码
    private String ownerCode;
    // 货主类型，WMS称为货主，平台卖家
    private String ownerType;
    // 仓库ID
    private Long whId;
    // 仓库编码
    private String whCode;
    // 仓库名称
    private String whName;

    private String skuCode;
    // 采购入库批次
    private String lotNo;
    // 存储计量单位
    private String uom;
    // 销售状态ID
    private Long saleStatusId;
    // 销售状态编码
    private String saleStatusCode;
    // 出仓仓库状态
    private String ivTypeFrom;
    // 入仓仓库状态
    private String ivTypeTo;
    // 调整数量
    private BigDecimal adjustQty;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getLoadAdjustId() {
        return loadAdjustId;
    }

    public void setLoadAdjustId(Long loadAdjustId) {
        this.loadAdjustId = loadAdjustId;
    }

    public Long getLogicId() {
        return logicId;
    }

    public void setLogicId(Long logicId) {
        this.logicId = logicId;
    }

    public String getLogicCode() {
        return logicCode;
    }

    public void setLogicCode(String logicCode) {
        this.logicCode = logicCode;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Long getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

    public String getIvTypeFrom() {
        return ivTypeFrom;
    }

    public void setIvTypeFrom(String ivTypeFrom) {
        this.ivTypeFrom = ivTypeFrom;
    }

    public String getIvTypeTo() {
        return ivTypeTo;
    }

    public void setIvTypeTo(String ivTypeTo) {
        this.ivTypeTo = ivTypeTo;
    }

    public BigDecimal getAdjustQty() {
        return adjustQty;
    }

    public void setAdjustQty(BigDecimal adjustQty) {
        this.adjustQty = adjustQty;
    }
}
