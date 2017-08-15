/*
 * 2017/03/17 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_seller_business_qualification对应的实体SlimSellerBusinessQualification</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSellerBusinessQualification extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家经营资质ID */
    private Long sbqId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 是否三证合一，0：否，1：是 */
    private Boolean threeInOneFlg;
    /** 三证合一注册号，三证合一必填 */
    private String threeInOneNo;
    /** 三证合一营业执照URL，三证合一必填 */
    private String threeInOneUrl;
    /** 组织机构代码 */
    private String organizationCode;
    /** 组织机构代码证URL，非三证合一必填 */
    private String orgCodeCertUrl;
    /** 税务登记证号 */
    private String taxRegCertNo;
    /** 税务登记证URL，非三证合一必填 */
    private String taxRegCertUrl;
    /** 增值税一般纳税人资格认定，非三证合一必填 */
    private String vatTaxpayerQualUrl;
    /** 营业执照注册号，非三证合一必填 */
    private String businessLicenseNo;
    /** 营业执照URL，非三证合一必填 */
    private String businessLicenseUrl;
    /** 公司名称 */
    private String companyName;
    /** 公司性质 */
    private String companyNature;
    /** 公司地址 */
    private String companyAddress;
    /** 法人代表 */
    private String legalPerson;
    /** 注册资本(万元) */
    private java.math.BigDecimal registeredCapital;
    /** 实收资本(万元) */
    private java.math.BigDecimal paidInCapital;
    /** 成立日期 */
    private java.util.Date foundingDate;
    /** 营业期限 */
    private String operationPeriod;
    /** 经营范围 */
    private String businessScope;
    /** 开户银行 */
    private String depositBank;
    /** 开户行账号 */
    private String bankAccount;
    /** 开户银行法人代表 */
    private String bankLegalPerson;
    /** 银行开户许可证URL */
    private String accPermitCertUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimSellerBusinessQualification() {
    }

    /**
     * <p>卖家经营资质ID</p>
     *
     * @return 卖家经营资质ID
     */
    public Long getSbqId() {
        return sbqId;
    }

    /**
     * <p>卖家经营资质ID</p>
     *
     * @param sbqId 卖家经营资质ID
     */
    public void setSbqId(Long sbqId) {
        this.sbqId = sbqId;
    }
    /**
     * <p>实体卖家ID</p>
     *
     * @return 实体卖家ID
     */
    public Long getEntitySellerId() {
        return entitySellerId;
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @param entitySellerId 实体卖家ID
     */
    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
    /**
     * <p>是否三证合一，0：否，1：是</p>
     *
     * @return 是否三证合一，0：否，1：是
     */
    public Boolean getThreeInOneFlg() {
        return threeInOneFlg;
    }

    /**
     * <p>是否三证合一，0：否，1：是</p>
     *
     * @param threeInOneFlg 是否三证合一，0：否，1：是
     */
    public void setThreeInOneFlg(Boolean threeInOneFlg) {
        this.threeInOneFlg = threeInOneFlg;
    }
    /**
     * <p>三证合一注册号，三证合一必填</p>
     *
     * @return 三证合一注册号，三证合一必填
     */
    public String getThreeInOneNo() {
        return threeInOneNo;
    }

    /**
     * <p>三证合一注册号，三证合一必填</p>
     *
     * @param threeInOneNo 三证合一注册号，三证合一必填
     */
    public void setThreeInOneNo(String threeInOneNo) {
        this.threeInOneNo = threeInOneNo;
    }
    /**
     * <p>三证合一营业执照URL，三证合一必填</p>
     *
     * @return 三证合一营业执照URL，三证合一必填
     */
    public String getThreeInOneUrl() {
        return threeInOneUrl;
    }

    /**
     * <p>三证合一营业执照URL，三证合一必填</p>
     *
     * @param threeInOneUrl 三证合一营业执照URL，三证合一必填
     */
    public void setThreeInOneUrl(String threeInOneUrl) {
        this.threeInOneUrl = threeInOneUrl;
    }
    /**
     * <p>组织机构代码</p>
     *
     * @return 组织机构代码
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * <p>组织机构代码</p>
     *
     * @param organizationCode 组织机构代码
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }
    /**
     * <p>组织机构代码证URL，非三证合一必填</p>
     *
     * @return 组织机构代码证URL，非三证合一必填
     */
    public String getOrgCodeCertUrl() {
        return orgCodeCertUrl;
    }

    /**
     * <p>组织机构代码证URL，非三证合一必填</p>
     *
     * @param orgCodeCertUrl 组织机构代码证URL，非三证合一必填
     */
    public void setOrgCodeCertUrl(String orgCodeCertUrl) {
        this.orgCodeCertUrl = orgCodeCertUrl;
    }
    /**
     * <p>税务登记证号</p>
     *
     * @return 税务登记证号
     */
    public String getTaxRegCertNo() {
        return taxRegCertNo;
    }

    /**
     * <p>税务登记证号</p>
     *
     * @param taxRegCertNo 税务登记证号
     */
    public void setTaxRegCertNo(String taxRegCertNo) {
        this.taxRegCertNo = taxRegCertNo;
    }
    /**
     * <p>税务登记证URL，非三证合一必填</p>
     *
     * @return 税务登记证URL，非三证合一必填
     */
    public String getTaxRegCertUrl() {
        return taxRegCertUrl;
    }

    /**
     * <p>税务登记证URL，非三证合一必填</p>
     *
     * @param taxRegCertUrl 税务登记证URL，非三证合一必填
     */
    public void setTaxRegCertUrl(String taxRegCertUrl) {
        this.taxRegCertUrl = taxRegCertUrl;
    }
    /**
     * <p>增值税一般纳税人资格认定，非三证合一必填</p>
     *
     * @return 增值税一般纳税人资格认定，非三证合一必填
     */
    public String getVatTaxpayerQualUrl() {
        return vatTaxpayerQualUrl;
    }

    /**
     * <p>增值税一般纳税人资格认定，非三证合一必填</p>
     *
     * @param vatTaxpayerQualUrl 增值税一般纳税人资格认定，非三证合一必填
     */
    public void setVatTaxpayerQualUrl(String vatTaxpayerQualUrl) {
        this.vatTaxpayerQualUrl = vatTaxpayerQualUrl;
    }
    /**
     * <p>营业执照注册号，非三证合一必填</p>
     *
     * @return 营业执照注册号，非三证合一必填
     */
    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    /**
     * <p>营业执照注册号，非三证合一必填</p>
     *
     * @param businessLicenseNo 营业执照注册号，非三证合一必填
     */
    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }
    /**
     * <p>营业执照URL，非三证合一必填</p>
     *
     * @return 营业执照URL，非三证合一必填
     */
    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    /**
     * <p>营业执照URL，非三证合一必填</p>
     *
     * @param businessLicenseUrl 营业执照URL，非三证合一必填
     */
    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }
    /**
     * <p>公司名称</p>
     *
     * @return 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * <p>公司名称</p>
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    /**
     * <p>公司性质</p>
     *
     * @return 公司性质
     */
    public String getCompanyNature() {
        return companyNature;
    }

    /**
     * <p>公司性质</p>
     *
     * @param companyNature 公司性质
     */
    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }
    /**
     * <p>公司地址</p>
     *
     * @return 公司地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * <p>公司地址</p>
     *
     * @param companyAddress 公司地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
    /**
     * <p>法人代表</p>
     *
     * @return 法人代表
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * <p>法人代表</p>
     *
     * @param legalPerson 法人代表
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }
    /**
     * <p>注册资本(万元)</p>
     *
     * @return 注册资本(万元)
     */
    public java.math.BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * <p>注册资本(万元)</p>
     *
     * @param registeredCapital 注册资本(万元)
     */
    public void setRegisteredCapital(java.math.BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }
    /**
     * <p>实收资本(万元)</p>
     *
     * @return 实收资本(万元)
     */
    public java.math.BigDecimal getPaidInCapital() {
        return paidInCapital;
    }

    /**
     * <p>实收资本(万元)</p>
     *
     * @param paidInCapital 实收资本(万元)
     */
    public void setPaidInCapital(java.math.BigDecimal paidInCapital) {
        this.paidInCapital = paidInCapital;
    }
    /**
     * <p>成立日期</p>
     *
     * @return 成立日期
     */
    public java.util.Date getFoundingDate() {
        return foundingDate;
    }

    /**
     * <p>成立日期</p>
     *
     * @param foundingDate 成立日期
     */
    public void setFoundingDate(java.util.Date foundingDate) {
        this.foundingDate = foundingDate;
    }
    /**
     * <p>营业期限</p>
     *
     * @return 营业期限
     */
    public String getOperationPeriod() {
        return operationPeriod;
    }

    /**
     * <p>营业期限</p>
     *
     * @param operationPeriod 营业期限
     */
    public void setOperationPeriod(String operationPeriod) {
        this.operationPeriod = operationPeriod;
    }
    /**
     * <p>经营范围</p>
     *
     * @return 经营范围
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * <p>经营范围</p>
     *
     * @param businessScope 经营范围
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }
    /**
     * <p>开户银行</p>
     *
     * @return 开户银行
     */
    public String getDepositBank() {
        return depositBank;
    }

    /**
     * <p>开户银行</p>
     *
     * @param depositBank 开户银行
     */
    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }
    /**
     * <p>开户行账号</p>
     *
     * @return 开户行账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * <p>开户行账号</p>
     *
     * @param bankAccount 开户行账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    /**
     * <p>开户银行法人代表</p>
     *
     * @return 开户银行法人代表
     */
    public String getBankLegalPerson() {
        return bankLegalPerson;
    }

    /**
     * <p>开户银行法人代表</p>
     *
     * @param bankLegalPerson 开户银行法人代表
     */
    public void setBankLegalPerson(String bankLegalPerson) {
        this.bankLegalPerson = bankLegalPerson;
    }
    /**
     * <p>银行开户许可证URL</p>
     *
     * @return 银行开户许可证URL
     */
    public String getAccPermitCertUrl() {
        return accPermitCertUrl;
    }

    /**
     * <p>银行开户许可证URL</p>
     *
     * @param accPermitCertUrl 银行开户许可证URL
     */
    public void setAccPermitCertUrl(String accPermitCertUrl) {
        this.accPermitCertUrl = accPermitCertUrl;
    }

}
