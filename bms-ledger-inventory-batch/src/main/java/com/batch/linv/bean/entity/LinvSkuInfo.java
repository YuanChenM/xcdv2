/*
 * 2017/02/08 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.batch.linv.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表LINV_SKU_INFO对应的实体LinvSkuInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class LinvSkuInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** SKU_CODE */
    private String skuCode;
    /** P_ID */
    private Long pid;
    /** P_CODE */
    private String pcode;
    /** 一级分类编码 */
    private String classesCode;
    /** 产品二级分类编码 */
    private String machiningCode;
    /** BREED_CODE */
    private String breedCode;
    /** 产品特征编码 */
    private String featureCode;
    /** P_DESC */
    private String pdesc;
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
    /** MFRS_ID */
    private Long mfrsId;
    /** MFRS_CODE */
    private String mfrsCode;

    /**
     * <p>默认构造函数</p>
     */
    public LinvSkuInfo() {
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

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
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

}
