/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>表invm_load_aloc_inventory对应的实体InvmLoadAlocInventory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmLoadAlocInventory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 占用编号 */
    private String alocNo;
    /** 物流区ID */
    private Long laId;
    /** 销售平台编码（预留） */
    private String splatCode;
    /** 货主ID，WMS称为货主，即平台卖家ID */
    private String ownerId;
    /** 货主编码，WMS称为货主，即平台卖家编码 */
    private String ownerCode;
    /** 货主类型 */
    private String ownerType;
    /** 目标方ID，例如买家ID */
    private String tgtId;
    /** 目标方编码，例如买家编码 */
    private String tgtCode;
    /** 目标方类型，Master数据，例如买家买手等 */
    private String tgtType;
    /** 业务类型,Master数据 */
    private String bizType;
    /** 最小库存存储单位，与WMS一致【20170411】 */
    private String skuCode;
    /** 采购批次【20170411】，指定批次出库时才会有 */
    private String lotNo;
    /** 库存类型 */
    private String ivType;
    /** 销售状态ID */
    private Long saleStatusId;
    /** 销售计量单位 */
    private String uom;
    /** 占用数量 */
    private java.math.BigDecimal alocQty;

    @ApiModelProperty(value = "原占用业务单ID")
    private Long releaseTransactionId;
    @ApiModelProperty(value = "原占用业务单号")
    private String releaseTransactionNo;
    @ApiModelProperty(value = "原占用业务明细ID")
    private Long releaseTransactionDetailId;

    /**
     * <p>默认构造函数</p>
     */
    public InvmLoadAlocInventory() {
    }

    /**
     * <p>占用编号</p>
     *
     * @return 占用编号
     */
    public String getAlocNo() {
        return alocNo;
    }

    /**
     * <p>占用编号</p>
     *
     * @param alocNo 占用编号
     */
    public void setAlocNo(String alocNo) {
        this.alocNo = alocNo;
    }
    /**
     * <p>物流区ID</p>
     *
     * @return 物流区ID
     */
    public Long getLaId() {
        return laId;
    }

    /**
     * <p>物流区ID</p>
     *
     * @param laId 物流区ID
     */
    public void setLaId(Long laId) {
        this.laId = laId;
    }
    /**
     * <p>销售平台编码（预留）</p>
     *
     * @return 销售平台编码（预留）
     */
    public String getSplatCode() {
        return splatCode;
    }

    /**
     * <p>销售平台编码（预留）</p>
     *
     * @param splatCode 销售平台编码（预留）
     */
    public void setSplatCode(String splatCode) {
        this.splatCode = splatCode;
    }
    /**
     * <p>货主ID，WMS称为货主，即平台卖家ID</p>
     *
     * @return 货主ID，WMS称为货主，即平台卖家ID
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * <p>货主ID，WMS称为货主，即平台卖家ID</p>
     *
     * @param ownerId 货主ID，WMS称为货主，即平台卖家ID
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * <p>货主编码，WMS称为货主，即平台卖家编码</p>
     *
     * @return 货主编码，WMS称为货主，即平台卖家编码
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /**
     * <p>货主编码，WMS称为货主，即平台卖家编码</p>
     *
     * @param ownerCode 货主编码，WMS称为货主，即平台卖家编码
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * <p>目标方ID，例如买家ID</p>
     *
     * @return 目标方ID，例如买家ID
     */
    public String getTgtId() {
        return tgtId;
    }

    /**
     * <p>目标方ID，例如买家ID</p>
     *
     * @param tgtId 目标方ID，例如买家ID
     */
    public void setTgtId(String tgtId) {
        this.tgtId = tgtId;
    }
    /**
     * <p>目标方编码，例如买家编码</p>
     *
     * @return 目标方编码，例如买家编码
     */
    public String getTgtCode() {
        return tgtCode;
    }

    /**
     * <p>目标方编码，例如买家编码</p>
     *
     * @param tgtCode 目标方编码，例如买家编码
     */
    public void setTgtCode(String tgtCode) {
        this.tgtCode = tgtCode;
    }
    /**
     * <p>目标方类型，Master数据，例如买家买手等</p>
     *
     * @return 目标方类型，Master数据，例如买家买手等
     */
    public String getTgtType() {
        return tgtType;
    }

    /**
     * <p>目标方类型，Master数据，例如买家买手等</p>
     *
     * @param tgtType 目标方类型，Master数据，例如买家买手等
     */
    public void setTgtType(String tgtType) {
        this.tgtType = tgtType;
    }
    /**
     * <p>业务类型,Master数据</p>
     *
     * @return 业务类型,Master数据
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * <p>业务类型,Master数据</p>
     *
     * @param bizType 业务类型,Master数据
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
    /**
     * <p>最小库存存储单位，与WMS一致【20170411】</p>
     *
     * @return 最小库存存储单位，与WMS一致【20170411】
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>最小库存存储单位，与WMS一致【20170411】</p>
     *
     * @param skuCode 最小库存存储单位，与WMS一致【20170411】
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>采购批次【20170411】，指定批次出库时才会有</p>
     *
     * @return 采购批次【20170411】，指定批次出库时才会有
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * <p>采购批次【20170411】，指定批次出库时才会有</p>
     *
     * @param lotNo 采购批次【20170411】，指定批次出库时才会有
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }
    /**
     * <p>库存类型</p>
     *
     * @return 库存类型
     */
    public String getIvType() {
        return ivType;
    }

    /**
     * <p>库存类型</p>
     *
     * @param ivType 库存类型
     */
    public void setIvType(String ivType) {
        this.ivType = ivType;
    }
    /**
     * <p>销售状态ID</p>
     *
     * @return 销售状态ID
     */
    public Long getSaleStatusId() {
        return saleStatusId;
    }

    /**
     * <p>销售状态ID</p>
     *
     * @param saleStatusId 销售状态ID
     */
    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }
    /**
     * <p>销售计量单位</p>
     *
     * @return 销售计量单位
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>销售计量单位</p>
     *
     * @param uom 销售计量单位
     */
    public void setUom(String uom) {
        this.uom = uom;
    }
    /**
     * <p>占用数量</p>
     *
     * @return 占用数量
     */
    public java.math.BigDecimal getAlocQty() {
        return alocQty;
    }

    /**
     * <p>占用数量</p>
     *
     * @param alocQty 占用数量
     */
    public void setAlocQty(java.math.BigDecimal alocQty) {
        this.alocQty = alocQty;
    }


    public Long getReleaseTransactionId() {
        return releaseTransactionId;
    }

    public void setReleaseTransactionId(Long releaseTransactionId) {
        this.releaseTransactionId = releaseTransactionId;
    }

    public String getReleaseTransactionNo() {
        return releaseTransactionNo;
    }

    public void setReleaseTransactionNo(String releaseTransactionNo) {
        this.releaseTransactionNo = releaseTransactionNo;
    }

    public Long getReleaseTransactionDetailId() {
        return releaseTransactionDetailId;
    }

    public void setReleaseTransactionDetailId(Long releaseTransactionDetailId) {
        this.releaseTransactionDetailId = releaseTransactionDetailId;
    }
}
