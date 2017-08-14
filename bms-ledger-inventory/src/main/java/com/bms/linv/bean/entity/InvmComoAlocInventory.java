/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_como_aloc_inventory对应的实体InvmComoAlocInventory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmComoAlocInventory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 占用身份 */
    private String alocNo;
    /** 物流区ID */
    private Long laId;
    /** 销售平台编码（预留） */
    private String splatCode;
    /** 货权人ID */
    private String ownerId;
    /** 货权人编码 */
    private String ownerCode;
    /** 货权人类型，平台卖家,买手，新增【20170409】 */
    private String ownerType;
    /** 商品ID */
    private String commodityId;
    /** 存储计量单位 */
    private String uom;
    /** 业务类型，Master数据 */
    private String bizType;
    /** 库存类型,Master数据 */
    private String ivType;
    /**商品库存类型,Master数据*/
    private String comoIvType;
    /** 占用数量 */
    private java.math.BigDecimal alocQty;
    /** 目标方ID */
    private String tgtId;
    /** 目标方编码 */
    private String tgtCode;
    /** 目标类型,Master数据 */
    private String tgtType;

    /**
     * <p>默认构造函数</p>
     */
    public InvmComoAlocInventory() {
    }

    /**
     * <p>占用身份</p>
     *
     * @return 占用身份
     */
    public String getAlocNo() {
        return alocNo;
    }

    /**
     * <p>占用身份</p>
     *
     * @param alocNo 占用身份
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
     * <p>货权人ID</p>
     *
     * @return 货权人ID
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * <p>货权人ID</p>
     *
     * @param ownerId 货权人ID
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * <p>货权人编码</p>
     *
     * @return 货权人编码
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /**
     * <p>货权人编码</p>
     *
     * @param ownerCode 货权人编码
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }
    /**
     * <p>货权人类型，平台卖家,买手，新增【20170409】</p>
     *
     * @return 货权人类型，平台卖家,买手，新增【20170409】
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>货权人类型，平台卖家,买手，新增【20170409】</p>
     *
     * @param ownerType 货权人类型，平台卖家,买手，新增【20170409】
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
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
     * <p>业务类型，Master数据</p>
     *
     * @return 业务类型，Master数据
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * <p>业务类型，Master数据</p>
     *
     * @param bizType 业务类型，Master数据
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
    /**
     * <p>库存类型,Master数据</p>
     *
     * @return 库存类型,Master数据
     */
    public String getIvType() {
        return ivType;
    }

    /**
     * <p>库存类型,Master数据</p>
     *
     * @param ivType 库存类型,Master数据
     */
    public void setIvType(String ivType) {
        this.ivType = ivType;
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
    /**
     * <p>目标方ID</p>
     *
     * @return 目标方ID
     */
    public String getTgtId() {
        return tgtId;
    }

    /**
     * <p>目标方ID</p>
     *
     * @param tgtId 目标方ID
     */
    public void setTgtId(String tgtId) {
        this.tgtId = tgtId;
    }
    /**
     * <p>目标方编码</p>
     *
     * @return 目标方编码
     */
    public String getTgtCode() {
        return tgtCode;
    }

    /**
     * <p>目标方编码</p>
     *
     * @param tgtCode 目标方编码
     */
    public void setTgtCode(String tgtCode) {
        this.tgtCode = tgtCode;
    }
    /**
     * <p>目标类型,Master数据</p>
     *
     * @return 目标类型,Master数据
     */
    public String getTgtType() {
        return tgtType;
    }

    /**
     * <p>目标类型,Master数据</p>
     *
     * @param tgtType 目标类型,Master数据
     */
    public void setTgtType(String tgtType) {
        this.tgtType = tgtType;
    }

    public String getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(String comoIvType) {
        this.comoIvType = comoIvType;
    }
}
