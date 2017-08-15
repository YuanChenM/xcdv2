/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_BRAND对应的实体SlpdBrand</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdBrand extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 品牌ID */
    private Long brandId;
    /** 品牌编码 */
    private String brandCode;
    /** 品牌名称 */
    private String brandName;
    /** 品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌 */
    private String brandType;
    /** 商标注册证号 */
    private String trademarkRegNo;
    /** 有效期开始时间 */
    private java.util.Date startValidDate;
    /** 有效期结束时间 */
    private java.util.Date endValidDate;
    /** 品牌证书URL */
    private String brandCertUrl;
    /** 产品包装URL */
    private String productPackageUrl;
    /** 荣誉证书编号 */
    private String honorCertNo;
    /** 荣誉证书发证日期 */
    private java.util.Date honorCertDate;
    /** 荣誉证书发证单位 */
    private String honorCertUnit;
    /** 荣誉证书URL */
    private String honorCertUrl;
    /** 审核状态，0：待审核，1：正式 */
    private String auditStu;
    /** 审核备注 */
    private String auditRemark;
    /** 审核履历，格式：0,未注册,admin,2017-01-25; */
    private String auditHistory;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdBrand() {
    }

    /**
     * <p>品牌ID</p>
     *
     * @return 品牌ID
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * <p>品牌ID</p>
     *
     * @param brandId 品牌ID
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    /**
     * <p>品牌编码</p>
     *
     * @return 品牌编码
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * <p>品牌编码</p>
     *
     * @param brandCode 品牌编码
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
    /**
     * <p>品牌名称</p>
     *
     * @return 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * <p>品牌名称</p>
     *
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    /**
     * <p>品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌</p>
     *
     * @return 品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌
     */
    public String getBrandType() {
        return brandType;
    }

    /**
     * <p>品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌</p>
     *
     * @param brandType 品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌
     */
    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }
    /**
     * <p>商标注册证号</p>
     *
     * @return 商标注册证号
     */
    public String getTrademarkRegNo() {
        return trademarkRegNo;
    }

    /**
     * <p>商标注册证号</p>
     *
     * @param trademarkRegNo 商标注册证号
     */
    public void setTrademarkRegNo(String trademarkRegNo) {
        this.trademarkRegNo = trademarkRegNo;
    }
    /**
     * <p>有效期开始时间</p>
     *
     * @return 有效期开始时间
     */
    public java.util.Date getStartValidDate() {
        return startValidDate;
    }

    /**
     * <p>有效期开始时间</p>
     *
     * @param startValidDate 有效期开始时间
     */
    public void setStartValidDate(java.util.Date startValidDate) {
        this.startValidDate = startValidDate;
    }
    /**
     * <p>有效期结束时间</p>
     *
     * @return 有效期结束时间
     */
    public java.util.Date getEndValidDate() {
        return endValidDate;
    }

    /**
     * <p>有效期结束时间</p>
     *
     * @param endValidDate 有效期结束时间
     */
    public void setEndValidDate(java.util.Date endValidDate) {
        this.endValidDate = endValidDate;
    }
    /**
     * <p>品牌证书URL</p>
     *
     * @return 品牌证书URL
     */
    public String getBrandCertUrl() {
        return brandCertUrl;
    }

    /**
     * <p>品牌证书URL</p>
     *
     * @param brandCertUrl 品牌证书URL
     */
    public void setBrandCertUrl(String brandCertUrl) {
        this.brandCertUrl = brandCertUrl;
    }
    /**
     * <p>产品包装URL</p>
     *
     * @return 产品包装URL
     */
    public String getProductPackageUrl() {
        return productPackageUrl;
    }

    /**
     * <p>产品包装URL</p>
     *
     * @param productPackageUrl 产品包装URL
     */
    public void setProductPackageUrl(String productPackageUrl) {
        this.productPackageUrl = productPackageUrl;
    }
    /**
     * <p>荣誉证书编号</p>
     *
     * @return 荣誉证书编号
     */
    public String getHonorCertNo() {
        return honorCertNo;
    }

    /**
     * <p>荣誉证书编号</p>
     *
     * @param honorCertNo 荣誉证书编号
     */
    public void setHonorCertNo(String honorCertNo) {
        this.honorCertNo = honorCertNo;
    }
    /**
     * <p>荣誉证书发证日期</p>
     *
     * @return 荣誉证书发证日期
     */
    public java.util.Date getHonorCertDate() {
        return honorCertDate;
    }

    /**
     * <p>荣誉证书发证日期</p>
     *
     * @param honorCertDate 荣誉证书发证日期
     */
    public void setHonorCertDate(java.util.Date honorCertDate) {
        this.honorCertDate = honorCertDate;
    }
    /**
     * <p>荣誉证书发证单位</p>
     *
     * @return 荣誉证书发证单位
     */
    public String getHonorCertUnit() {
        return honorCertUnit;
    }

    /**
     * <p>荣誉证书发证单位</p>
     *
     * @param honorCertUnit 荣誉证书发证单位
     */
    public void setHonorCertUnit(String honorCertUnit) {
        this.honorCertUnit = honorCertUnit;
    }
    /**
     * <p>荣誉证书URL</p>
     *
     * @return 荣誉证书URL
     */
    public String getHonorCertUrl() {
        return honorCertUrl;
    }

    /**
     * <p>荣誉证书URL</p>
     *
     * @param honorCertUrl 荣誉证书URL
     */
    public void setHonorCertUrl(String honorCertUrl) {
        this.honorCertUrl = honorCertUrl;
    }
    /**
     * <p>审核状态，0：待审核，1：正式</p>
     *
     * @return 审核状态，0：待审核，1：正式
     */
    public String getAuditStu() {
        return auditStu;
    }

    /**
     * <p>审核状态，0：待审核，1：正式</p>
     *
     * @param auditStu 审核状态，0：待审核，1：正式
     */
    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }
    /**
     * <p>审核备注</p>
     *
     * @return 审核备注
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * <p>审核备注</p>
     *
     * @param auditRemark 审核备注
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }
    /**
     * <p>审核履历，格式：0,未注册,admin,2017-01-25;</p>
     *
     * @return 审核履历，格式：0,未注册,admin,2017-01-25;
     */
    public String getAuditHistory() {
        return auditHistory;
    }

    /**
     * <p>审核履历，格式：0,未注册,admin,2017-01-25;</p>
     *
     * @param auditHistory 审核履历，格式：0,未注册,admin,2017-01-25;
     */
    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }

}
