/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_load对应的实体InvmLoad</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmLoad extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 库存身份编号 */
    private String loadNo;
    /** 物流区域ID */
    private Long laId;
    /** 物流区域编码 */
    private String laCode;
    /** 销售平台编码（预留） */
    private String splatCode;
    /** 货主ID，WMS称为货主，即平台卖家ID */
    private String ownerId;
    /** 货主编码，WMS称为货主，即平台卖家编码 */
    private String ownerCode;
    /** 货主类型，WMS称为货主，平台卖家,Master */
    private String ownerType;
    /** 预留，货主细分类（预留） */
    private String ownerDType;
    /** 仓库ID */
    private Long whId;
    /** 仓库编码 */
    private String whCode;
    /** 供应商ID */
    private String spId;
    /** 供应商编码 */
    private String spCode;
    /** 最小库存存储单位，与WMS一致 */
    private String skuCode;
    /** 采购入库批次 */
    private String lotNo;
    /** 存储计量单位 */
    private String uom;
    /** 库存数量 */
    private java.math.BigDecimal ivQty;
    /** 库存状态，Master数据 */
    private String ivType;
    /** 销售状态ID */
    private Long saleStatusId;
    /** 销售状态编码 */
    private String saleStatusCode;

    /**
     * <p>默认构造函数</p>
     */
    public InvmLoad() {
    }

    /**
     * <p>库存身份编号</p>
     *
     * @return 库存身份编号
     */
    public String getLoadNo() {
        return loadNo;
    }

    /**
     * <p>库存身份编号</p>
     *
     * @param loadNo 库存身份编号
     */
    public void setLoadNo(String loadNo) {
        this.loadNo = loadNo;
    }
    /**
     * <p>物流区域ID</p>
     *
     * @return 物流区域ID
     */
    public Long getLaId() {
        return laId;
    }

    /**
     * <p>物流区域ID</p>
     *
     * @param laId 物流区域ID
     */
    public void setLaId(Long laId) {
        this.laId = laId;
    }
    /**
     * <p>物流区域编码</p>
     *
     * @return 物流区域编码
     */
    public String getLaCode() {
        return laCode;
    }

    /**
     * <p>物流区域编码</p>
     *
     * @param laCode 物流区域编码
     */
    public void setLaCode(String laCode) {
        this.laCode = laCode;
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
    /**
     * <p>货主类型，WMS称为货主，平台卖家,Master</p>
     *
     * @return 货主类型，WMS称为货主，平台卖家,Master
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>货主类型，WMS称为货主，平台卖家,Master</p>
     *
     * @param ownerType 货主类型，WMS称为货主，平台卖家,Master
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
    /**
     * <p>预留，货主细分类（预留）</p>
     *
     * @return 预留，货主细分类（预留）
     */
    public String getOwnerDType() {
        return ownerDType;
    }

    /**
     * <p>预留，货主细分类（预留）</p>
     *
     * @param ownerDType 预留，货主细分类（预留）
     */
    public void setOwnerDType(String ownerDType) {
        this.ownerDType = ownerDType;
    }
    /**
     * <p>仓库ID</p>
     *
     * @return 仓库ID
     */
    public Long getWhId() {
        return whId;
    }

    /**
     * <p>仓库ID</p>
     *
     * @param whId 仓库ID
     */
    public void setWhId(Long whId) {
        this.whId = whId;
    }
    /**
     * <p>仓库编码</p>
     *
     * @return 仓库编码
     */
    public String getWhCode() {
        return whCode;
    }

    /**
     * <p>仓库编码</p>
     *
     * @param whCode 仓库编码
     */
    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }
    /**
     * <p>供应商ID</p>
     *
     * @return 供应商ID
     */
    public String getSpId() {
        return spId;
    }

    /**
     * <p>供应商ID</p>
     *
     * @param spId 供应商ID
     */
    public void setSpId(String spId) {
        this.spId = spId;
    }
    /**
     * <p>供应商编码</p>
     *
     * @return 供应商编码
     */
    public String getSpCode() {
        return spCode;
    }

    /**
     * <p>供应商编码</p>
     *
     * @param spCode 供应商编码
     */
    public void setSpCode(String spCode) {
        this.spCode = spCode;
    }
    /**
     * <p>最小库存存储单位，与WMS一致</p>
     *
     * @return 最小库存存储单位，与WMS一致
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>最小库存存储单位，与WMS一致</p>
     *
     * @param skuCode 最小库存存储单位，与WMS一致
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>采购入库批次</p>
     *
     * @return 采购入库批次
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * <p>采购入库批次</p>
     *
     * @param lotNo 采购入库批次
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }
    /**
     * <p>存储计量单位</p>
     *
     * @return 存储计量单位
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>存储计量单位</p>
     *
     * @param uom 存储计量单位
     */
    public void setUom(String uom) {
        this.uom = uom;
    }
    /**
     * <p>库存数量</p>
     *
     * @return 库存数量
     */
    public java.math.BigDecimal getIvQty() {
        return ivQty;
    }

    /**
     * <p>库存数量</p>
     *
     * @param ivQty 库存数量
     */
    public void setIvQty(java.math.BigDecimal ivQty) {
        this.ivQty = ivQty;
    }
    /**
     * <p>库存状态，Master数据</p>
     *
     * @return 库存状态，Master数据
     */
    public String getIvType() {
        return ivType;
    }

    /**
     * <p>库存状态，Master数据</p>
     *
     * @param ivType 库存状态，Master数据
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
     * <p>销售状态编码</p>
     *
     * @return 销售状态编码
     */
    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    /**
     * <p>销售状态编码</p>
     *
     * @param saleStatusCode 销售状态编码
     */
    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

}
