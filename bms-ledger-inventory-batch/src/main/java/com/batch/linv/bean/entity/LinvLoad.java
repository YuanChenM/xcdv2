/*
 * 2017/02/06 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.batch.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表LINV_LOAD对应的实体LinvLoad</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class LinvLoad extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** LOAD_NO */
    private String loadNo;
    /** WH_ID */
    private Long whId;
    /** WH_CODE */
    private String whCode;
    /** L_A_ID */
    private Long laId;
    /** L_A_CODE */
    private String laCode;
    /** S_PLAT_CODE */
    private String splatCode;
    /** OWNER_ID */
    private Long ownerId;
    /** OWNER_CODE */
    private String ownerCode;
    /** OWNER_TYPE */
    private String ownerType;
    /** OWNER_D_TYPE */
    private String ownerDType;
    /** COMMODITY_ID */
    private String commodityId;
    /** SKU_CODE */
    private String skuCode;
    /** LOT_NO */
    private String lotNo;
    /** BUY_PRICE */
    private java.math.BigDecimal buyPrice;
    /** UOM */
    private String uom;
    /** QTY */
    private java.math.BigDecimal qty;
    /** IV_TYPE */
    private String ivType;
    /** SALES_LABEL */
    private String salesLabel;

    /**
     * <p>默认构造函数</p>
     */
    public LinvLoad() {
    }

    /**
     * <p>LOAD_NO</p>
     *
     * @return LOAD_NO
     */
    public String getLoadNo() {
        return loadNo;
    }

    /**
     * <p>LOAD_NO</p>
     *
     * @param loadNo LOAD_NO
     */
    public void setLoadNo(String loadNo) {
        this.loadNo = loadNo;
    }
    /**
     * <p>WH_ID</p>
     *
     * @return WH_ID
     */
    public Long getWhId() {
        return whId;
    }

    /**
     * <p>WH_ID</p>
     *
     * @param whId WH_ID
     */
    public void setWhId(Long whId) {
        this.whId = whId;
    }
    /**
     * <p>WH_CODE</p>
     *
     * @return WH_CODE
     */
    public String getWhCode() {
        return whCode;
    }

    /**
     * <p>WH_CODE</p>
     *
     * @param whCode WH_CODE
     */
    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }
    /**
     * <p>L_A_ID</p>
     *
     * @return L_A_ID
     */
    public Long getLaId() {
        return laId;
    }

    /**
     * <p>L_A_ID</p>
     *
     * @param laId L_A_ID
     */
    public void setLaId(Long laId) {
        this.laId = laId;
    }
    /**
     * <p>L_A_CODE</p>
     *
     * @return L_A_CODE
     */
    public String getLaCode() {
        return laCode;
    }

    /**
     * <p>L_A_CODE</p>
     *
     * @param laCode L_A_CODE
     */
    public void setLaCode(String laCode) {
        this.laCode = laCode;
    }
    /**
     * <p>S_PLAT_CODE</p>
     *
     * @return S_PLAT_CODE
     */
    public String getSplatCode() {
        return splatCode;
    }

    /**
     * <p>S_PLAT_CODE</p>
     *
     * @param splatCode S_PLAT_CODE
     */
    public void setSplatCode(String splatCode) {
        this.splatCode = splatCode;
    }
    /**
     * <p>OWNER_ID</p>
     *
     * @return OWNER_ID
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * <p>OWNER_ID</p>
     *
     * @param ownerId OWNER_ID
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * <p>OWNER_CODE</p>
     *
     * @return OWNER_CODE
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /**
     * <p>OWNER_CODE</p>
     *
     * @param ownerCode OWNER_CODE
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }
    /**
     * <p>OWNER_TYPE</p>
     *
     * @return OWNER_TYPE
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>OWNER_TYPE</p>
     *
     * @param ownerType OWNER_TYPE
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
    /**
     * <p>OWNER_D_TYPE</p>
     *
     * @return OWNER_D_TYPE
     */
    public String getOwnerDType() {
        return ownerDType;
    }

    /**
     * <p>OWNER_D_TYPE</p>
     *
     * @param ownerDType OWNER_D_TYPE
     */
    public void setOwnerDType(String ownerDType) {
        this.ownerDType = ownerDType;
    }

    /**
     * <p>COMMODITY_ID</p>
     *
     * @return COMMODITY_ID
     */
    public String getCommodityId() {
        return commodityId;
    }

    /**
     * <p>COMMODITY_ID</p>
     *
     * @param commodityId COMMODITY_ID
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }
    /**
     * <p>SKU_CODE</p>
     *
     * @return SKU_CODE
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>SKU_CODE</p>
     *
     * @param skuCode SKU_CODE
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>LOT_NO</p>
     *
     * @return LOT_NO
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * <p>LOT_NO</p>
     *
     * @param lotNo LOT_NO
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }
    /**
     * <p>BUY_PRICE</p>
     *
     * @return BUY_PRICE
     */
    public java.math.BigDecimal getBuyPrice() {
        return buyPrice;
    }

    /**
     * <p>BUY_PRICE</p>
     *
     * @param buyPrice BUY_PRICE
     */
    public void setBuyPrice(java.math.BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
    /**
     * <p>UOM</p>
     *
     * @return UOM
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>UOM</p>
     *
     * @param uom UOM
     */
    public void setUom(String uom) {
        this.uom = uom;
    }
    /**
     * <p>QTY</p>
     *
     * @return QTY
     */
    public java.math.BigDecimal getQty() {
        return qty;
    }

    /**
     * <p>QTY</p>
     *
     * @param qty QTY
     */
    public void setQty(java.math.BigDecimal qty) {
        this.qty = qty;
    }
    /**
     * <p>IV_TYPE</p>
     *
     * @return IV_TYPE
     */
    public String getIvType() {
        return ivType;
    }

    /**
     * <p>IV_TYPE</p>
     *
     * @param ivType IV_TYPE
     */
    public void setIvType(String ivType) {
        this.ivType = ivType;
    }
    /**
     * <p>SALES_LABEL</p>
     *
     * @return SALES_LABEL
     */
    public String getSalesLabel() {
        return salesLabel;
    }

    /**
     * <p>SALES_LABEL</p>
     *
     * @param salesLabel SALES_LABEL
     */
    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }

}
