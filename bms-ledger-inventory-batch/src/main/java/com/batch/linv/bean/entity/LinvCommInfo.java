/*
 * 2017/02/08 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.batch.linv.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表LINV_COMM_INFO对应的实体LinvCommInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class LinvCommInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** COMMODITY_ID */
    private String commodityId;
    /** SKU_CODE */
    private String skuCode;
    /** P_ID */
    private Long pid;
    /** P_CODE */
    private String pcode;
    /** OWNER_ID */
    private Long ownerId;
    /** OWNER_CODE */
    private String ownerCode;
    /** OWNER_TYPE */
    private String ownerType;
    /** OWNER_D_TYPE */
    private String ownerDType;
    /** BR_ID */
    private Long brId;
    /** BR_CODE */
    private String brCode;
    /** P_BR_CODE */
    private String pbrCode;
    /** PD_ID */
    private String pdId;
    /** LEVEL */
    private String level;
    /** NET_WEIGHT */
    private java.math.BigDecimal netWeight;
    /** PDRS_ID */
    private Long pdrsId;
    /** PDRS_CODE */
    private String pdrsCode;
    /** P_BR_PDRS_CODE */
    private String pbrPdrsCode;
    /** P_BR_PDRS_SP_CODE */
    private String pbrPdrsSpCode;
    /** LOT_NO */
    private String lotNo;
    /** MFRS_ID */
    private Long mfrsId;
    /** MFRS_CODE */
    private String mfrsCode;

    private String salesLabel;

    private boolean isDefault;

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * <p>默认构造函数</p>
     */
    public LinvCommInfo() {
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
     * <p>P_ID</p>
     *
     * @return P_ID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * <p>P_ID</p>
     *
     * @param pid P_ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }
    /**
     * <p>P_CODE</p>
     *
     * @return P_CODE
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * <p>P_CODE</p>
     *
     * @param pcode P_CODE
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
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
     * <p>BR_ID</p>
     *
     * @return BR_ID
     */
    public Long getBrId() {
        return brId;
    }

    /**
     * <p>BR_ID</p>
     *
     * @param brId BR_ID
     */
    public void setBrId(Long brId) {
        this.brId = brId;
    }
    /**
     * <p>BR_CODE</p>
     *
     * @return BR_CODE
     */
    public String getBrCode() {
        return brCode;
    }

    /**
     * <p>BR_CODE</p>
     *
     * @param brCode BR_CODE
     */
    public void setBrCode(String brCode) {
        this.brCode = brCode;
    }
    /**
     * <p>P_BR_CODE</p>
     *
     * @return P_BR_CODE
     */
    public String getPbrCode() {
        return pbrCode;
    }

    /**
     * <p>P_BR_CODE</p>
     *
     * @param pbrCode P_BR_CODE
     */
    public void setPbrCode(String pbrCode) {
        this.pbrCode = pbrCode;
    }
    /**
     * <p>PD_ID</p>
     *
     * @return PD_ID
     */
    public String getPdId() {
        return pdId;
    }

    /**
     * <p>PD_ID</p>
     *
     * @param pdId PD_ID
     */
    public void setPdId(String pdId) {
        this.pdId = pdId;
    }
    /**
     * <p>LEVEL</p>
     *
     * @return LEVEL
     */
    public String getLevel() {
        return level;
    }

    /**
     * <p>LEVEL</p>
     *
     * @param level LEVEL
     */
    public void setLevel(String level) {
        this.level = level;
    }
    /**
     * <p>NET_WEIGHT</p>
     *
     * @return NET_WEIGHT
     */
    public java.math.BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * <p>NET_WEIGHT</p>
     *
     * @param netWeight NET_WEIGHT
     */
    public void setNetWeight(java.math.BigDecimal netWeight) {
        this.netWeight = netWeight;
    }
    /**
     * <p>PDRS_ID</p>
     *
     * @return PDRS_ID
     */
    public Long getPdrsId() {
        return pdrsId;
    }

    /**
     * <p>PDRS_ID</p>
     *
     * @param pdrsId PDRS_ID
     */
    public void setPdrsId(Long pdrsId) {
        this.pdrsId = pdrsId;
    }
    /**
     * <p>PDRS_CODE</p>
     *
     * @return PDRS_CODE
     */
    public String getPdrsCode() {
        return pdrsCode;
    }

    /**
     * <p>PDRS_CODE</p>
     *
     * @param pdrsCode PDRS_CODE
     */
    public void setPdrsCode(String pdrsCode) {
        this.pdrsCode = pdrsCode;
    }
    /**
     * <p>P_BR_PDRS_CODE</p>
     *
     * @return P_BR_PDRS_CODE
     */
    public String getPbrPdrsCode() {
        return pbrPdrsCode;
    }

    /**
     * <p>P_BR_PDRS_CODE</p>
     *
     * @param pbrPdrsCode P_BR_PDRS_CODE
     */
    public void setPbrPdrsCode(String pbrPdrsCode) {
        this.pbrPdrsCode = pbrPdrsCode;
    }
    /**
     * <p>P_BR_PDRS_SP_CODE</p>
     *
     * @return P_BR_PDRS_SP_CODE
     */
    public String getPbrPdrsSpCode() {
        return pbrPdrsSpCode;
    }

    /**
     * <p>P_BR_PDRS_SP_CODE</p>
     *
     * @param pbrPdrsSpCode P_BR_PDRS_SP_CODE
     */
    public void setPbrPdrsSpCode(String pbrPdrsSpCode) {
        this.pbrPdrsSpCode = pbrPdrsSpCode;
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
     * <p>MFRS_ID</p>
     *
     * @return MFRS_ID
     */
    public Long getMfrsId() {
        return mfrsId;
    }

    /**
     * <p>MFRS_ID</p>
     *
     * @param mfrsId MFRS_ID
     */
    public void setMfrsId(Long mfrsId) {
        this.mfrsId = mfrsId;
    }
    /**
     * <p>MFRS_CODE</p>
     *
     * @return MFRS_CODE
     */
    public String getMfrsCode() {
        return mfrsCode;
    }

    /**
     * <p>MFRS_CODE</p>
     *
     * @param mfrsCode MFRS_CODE
     */
    public void setMfrsCode(String mfrsCode) {
        this.mfrsCode = mfrsCode;
    }

    public String getSalesLabel() {
        return salesLabel;
    }

    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }
}
