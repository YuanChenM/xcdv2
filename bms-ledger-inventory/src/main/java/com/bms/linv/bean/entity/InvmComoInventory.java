/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_como_inventory对应的实体InvmComoInventory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmComoInventory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 商品库存身份编号 */
    private String storeNo;
    /** 物流区ID */
    private Long laId;
    /** 物流区编码 */
    private String laCode;
    /** 销售平台编码（预留） */
    private String splatCode;
    /** 货权人ID【20170411】 */
    private String ownerId;
    /** 货权人编码【20170411】 */
    private String ownerCode;
    /** 货权人类型，【20170411】，Master平台卖家，买手 */
    private String ownerType;
    /** 货权人细分类（预留）【20170411】 */
    private String ownerDType;
    /** 商品ID */
    private String commodityId;
    /** 存储计量单位 */
    private String uom;
    /** 库存数量 */
    private java.math.BigDecimal ivQty;
    /** 库存类型，Master数据 */
    private String ivType;
    /**商品库存类型,Master数据*/
    private String comoIvType;

    /**
     * <p>默认构造函数</p>
     */
    public InvmComoInventory() {
    }

    /**
     * <p>商品库存身份编号</p>
     *
     * @return 商品库存身份编号
     */
    public String getStoreNo() {
        return storeNo;
    }

    /**
     * <p>商品库存身份编号</p>
     *
     * @param storeNo 商品库存身份编号
     */
    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
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
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLaCode() {
        return laCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param laCode 物流区编码
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
     * <p>货权人ID【20170411】</p>
     *
     * @return 货权人ID【20170411】
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * <p>货权人ID【20170411】</p>
     *
     * @param ownerId 货权人ID【20170411】
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * <p>货权人编码【20170411】</p>
     *
     * @return 货权人编码【20170411】
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /**
     * <p>货权人编码【20170411】</p>
     *
     * @param ownerCode 货权人编码【20170411】
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }
    /**
     * <p>货权人类型，【20170411】，Master平台卖家，买手</p>
     *
     * @return 货权人类型，【20170411】，Master平台卖家，买手
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>货权人类型，【20170411】，Master平台卖家，买手</p>
     *
     * @param ownerType 货权人类型，【20170411】，Master平台卖家，买手
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
    /**
     * <p>货权人细分类（预留）【20170411】</p>
     *
     * @return 货权人细分类（预留）【20170411】
     */
    public String getOwnerDType() {
        return ownerDType;
    }

    /**
     * <p>货权人细分类（预留）【20170411】</p>
     *
     * @param ownerDType 货权人细分类（预留）【20170411】
     */
    public void setOwnerDType(String ownerDType) {
        this.ownerDType = ownerDType;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public String getCommodityId() {
        return commodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
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
     * <p>库存类型，Master数据</p>
     *
     * @return 库存类型，Master数据
     */
    public String getIvType() {
        return ivType;
    }

    /**
     * <p>库存类型，Master数据</p>
     *
     * @param ivType 库存类型，Master数据
     */
    public void setIvType(String ivType) {
        this.ivType = ivType;
    }

    public String getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(String comoIvType) {
        this.comoIvType = comoIvType;
    }
}
