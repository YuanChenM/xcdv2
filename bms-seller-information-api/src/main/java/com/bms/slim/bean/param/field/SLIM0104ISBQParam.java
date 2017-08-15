package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "SLIM0104ISBQParam", description = "卖家经营资质")
public class SLIM0104ISBQParam implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "卖家经营资质ID")
	private Long sbqId;
	@ApiModelProperty(value = "实体卖家ID")
	private Long entitySellerId;
	@ApiModelProperty(value = "是否三证合一，0：否，1：是")
	private Boolean threeInOneFlg;
	@ApiModelProperty(value = "三证合一注册号，三证合一必填")
	private String threeInOneNo;
	@ApiModelProperty(value = "三证合一营业执照URL，三证合一必填")
	private String threeInOneUrl;
	@ApiModelProperty(value = "组织机构代码")
	private String organizationCode;
	@ApiModelProperty(value = "组织机构代码证URL，非三证合一必填")
	private String orgCodeCertUrl;
	@ApiModelProperty(value = "税务登记证号")
	private String taxRegCertNo;
	@ApiModelProperty(value = "税务登记证URL，非三证合一必填")
	private String taxRegCertUrl;
	@ApiModelProperty(value = "增值税一般纳税人资格认定URL，非三证合一必填")
	private String vatTaxpayerQualUrl;
	@ApiModelProperty(value = "营业执照注册号，非三证合一必填")
	private String businessLicenseNo;
	@ApiModelProperty(value = "营业执照URL，非三证合一必填")
	private String businessLicenseUrl;
	@ApiModelProperty(value = "公司名称")
	private String companyName;
	@ApiModelProperty(value = "公司性质")
	private String companyNature;
	@ApiModelProperty(value = "公司地址")
	private String companyAddress;
	@ApiModelProperty(value = "法人代表")
	private String legalPerson;
	@ApiModelProperty(value = "注册资本(万元)")
	private java.math.BigDecimal registeredCapital;
	@ApiModelProperty(value = "实收资本(万元)")
	private java.math.BigDecimal paidInCapital;
	@ApiModelProperty(value = "成立日期")
	private java.util.Date foundingDate;
	@ApiModelProperty(value = "营业期限")
	private String operationPeriod;
	@ApiModelProperty(value = "经营范围")
	private String businessScope;
	@ApiModelProperty(value = "开户银行")
	private String depositBank;
	@ApiModelProperty(value = "开户行账号")
	private String bankAccount;
	@ApiModelProperty(value = "开户银行法人代表")
	private String bankLegalPerson;
	@ApiModelProperty(value = "银行开户许可证URL")
	private String accPermitCertUrl;

	public Long getSbqId() {
		return sbqId;
	}

	public void setSbqId(Long sbqId) {
		this.sbqId = sbqId;
	}

	public Long getEntitySellerId() {
		return entitySellerId;
	}

	public void setEntitySellerId(Long entitySellerId) {
		this.entitySellerId = entitySellerId;
	}

    public Boolean getThreeInOneFlg() {
        return threeInOneFlg;
    }

    public void setThreeInOneFlg(Boolean threeInOneFlg) {
        this.threeInOneFlg = threeInOneFlg;
    }

    public String getThreeInOneNo() {
		return threeInOneNo;
	}

	public void setThreeInOneNo(String threeInOneNo) {
		this.threeInOneNo = threeInOneNo;
	}

	public String getThreeInOneUrl() {
		return threeInOneUrl;
	}

	public void setThreeInOneUrl(String threeInOneUrl) {
		this.threeInOneUrl = threeInOneUrl;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOrgCodeCertUrl() {
		return orgCodeCertUrl;
	}

	public void setOrgCodeCertUrl(String orgCodeCertUrl) {
		this.orgCodeCertUrl = orgCodeCertUrl;
	}

	public String getTaxRegCertNo() {
		return taxRegCertNo;
	}

	public void setTaxRegCertNo(String taxRegCertNo) {
		this.taxRegCertNo = taxRegCertNo;
	}

	public String getTaxRegCertUrl() {
		return taxRegCertUrl;
	}

	public void setTaxRegCertUrl(String taxRegCertUrl) {
		this.taxRegCertUrl = taxRegCertUrl;
	}

	public String getBusinessLicenseNo() {
		return businessLicenseNo;
	}

	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}

	public String getBusinessLicenseUrl() {
		return businessLicenseUrl;
	}

	public void setBusinessLicenseUrl(String businessLicenseUrl) {
		this.businessLicenseUrl = businessLicenseUrl;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyNature() {
		return companyNature;
	}

	public void setCompanyNature(String companyNature) {
		this.companyNature = companyNature;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public BigDecimal getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(BigDecimal registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public BigDecimal getPaidInCapital() {
		return paidInCapital;
	}

	public void setPaidInCapital(BigDecimal paidInCapital) {
		this.paidInCapital = paidInCapital;
	}

	public Date getFoundingDate() {
		return foundingDate;
	}

	public void setFoundingDate(Date foundingDate) {
		this.foundingDate = foundingDate;
	}

	public String getOperationPeriod() {
		return operationPeriod;
	}

	public void setOperationPeriod(String operationPeriod) {
		this.operationPeriod = operationPeriod;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getAccPermitCertUrl() {
		return accPermitCertUrl;
	}

	public void setAccPermitCertUrl(String accPermitCertUrl) {
		this.accPermitCertUrl = accPermitCertUrl;
	}

	public String getVatTaxpayerQualUrl() {
		return vatTaxpayerQualUrl;
	}

	public void setVatTaxpayerQualUrl(String vatTaxpayerQualUrl) {
		this.vatTaxpayerQualUrl = vatTaxpayerQualUrl;
	}

	public String getBankLegalPerson() {
		return bankLegalPerson;
	}

	public void setBankLegalPerson(String bankLegalPerson) {
		this.bankLegalPerson = bankLegalPerson;
	}
}
