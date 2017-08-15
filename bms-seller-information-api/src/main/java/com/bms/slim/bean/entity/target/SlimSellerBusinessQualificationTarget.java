package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

public class SlimSellerBusinessQualificationTarget extends BaseTarget {

    private static final long serialVersionUID = 1L;
    /** 是否三证合一，0：否，1：是 */
    private boolean threeInOneFlgFlg;
    /** 三证合一注册号，三证合一必填 */
    private boolean threeInOneNoFlg;
    /** 三证合一营业执照URL，三证合一必填 */
    private boolean threeInOneUrlFlg;
    /** 组织机构代码 */
    private boolean organizationCodeFlg;
    /** 组织机构代码证URL，非三证合一必填 */
    private boolean orgCodeCertUrlFlg;
    /** 税务登记证号 */
    private boolean taxRegCertNoFlg;
    /** 税务登记证URL，非三证合一必填 */
    private boolean taxRegCertUrlFlg;
    /** 增值税一般纳税人资格认定，非三证合一必填 */
    private boolean vatTaxpayerQualUrlFlg;
    /** 营业执照注册号，非三证合一必填 */
    private boolean businessLicenseNoFlg;
    /** 营业执照URL，非三证合一必填 */
    private boolean businessLicenseUrlFlg;
    /** 公司名称 */
    private boolean companyNameFlg;
    /** 公司性质 */
    private boolean companyNatureFlg;
    /** 公司地址 */
    private boolean companyAddressFlg;
    /** 法人代表 */
    private boolean legalPersonFlg;
    /** 注册资本(元) */
    private boolean registeredCapitalFlg;
    /** 实收资本(元) */
    private boolean paidInCapitalFlg;
    /** 成立日期 */
    private boolean foundingDateFlg;
    /** 营业期限 */
    private boolean operationPeriodFlg;
    /** 经营范围 */
    private boolean businessScopeFlg;
    /** 开户银行 */
    private boolean depositBankFlg;
    /** 开户行账号 */
    private boolean bankAccountFlg;
    /** 开户银行法人代表 */
    private boolean bankLegalPersonFlg;
    /** 银行开户许可证URL */
    private boolean accPermitCertUrlFlg;

    public boolean isThreeInOneFlgFlg() {
        return threeInOneFlgFlg;
    }

    public void setThreeInOneFlgFlg(boolean threeInOneFlgFlg) {
        this.threeInOneFlgFlg = threeInOneFlgFlg;
    }

    public boolean isThreeInOneNoFlg() {
        return threeInOneNoFlg;
    }

    public void setThreeInOneNoFlg(boolean threeInOneNoFlg) {
        this.threeInOneNoFlg = threeInOneNoFlg;
    }

    public boolean isThreeInOneUrlFlg() {
        return threeInOneUrlFlg;
    }

    public void setThreeInOneUrlFlg(boolean threeInOneUrlFlg) {
        this.threeInOneUrlFlg = threeInOneUrlFlg;
    }

    public boolean isOrganizationCodeFlg() {
        return organizationCodeFlg;
    }

    public void setOrganizationCodeFlg(boolean organizationCodeFlg) {
        this.organizationCodeFlg = organizationCodeFlg;
    }

    public boolean isOrgCodeCertUrlFlg() {
        return orgCodeCertUrlFlg;
    }

    public void setOrgCodeCertUrlFlg(boolean orgCodeCertUrlFlg) {
        this.orgCodeCertUrlFlg = orgCodeCertUrlFlg;
    }

    public boolean isTaxRegCertNoFlg() {
        return taxRegCertNoFlg;
    }

    public void setTaxRegCertNoFlg(boolean taxRegCertNoFlg) {
        this.taxRegCertNoFlg = taxRegCertNoFlg;
    }

    public boolean isTaxRegCertUrlFlg() {
        return taxRegCertUrlFlg;
    }

    public void setTaxRegCertUrlFlg(boolean taxRegCertUrlFlg) {
        this.taxRegCertUrlFlg = taxRegCertUrlFlg;
    }

    public boolean isVatTaxpayerQualUrlFlg() {
        return vatTaxpayerQualUrlFlg;
    }

    public void setVatTaxpayerQualUrlFlg(boolean vatTaxpayerQualUrlFlg) {
        this.vatTaxpayerQualUrlFlg = vatTaxpayerQualUrlFlg;
    }

    public boolean isBankLegalPersonFlg() {
        return bankLegalPersonFlg;
    }

    public void setBankLegalPersonFlg(boolean bankLegalPersonFlg) {
        this.bankLegalPersonFlg = bankLegalPersonFlg;
    }

    public boolean isBusinessLicenseNoFlg() {
        return businessLicenseNoFlg;
    }

    public void setBusinessLicenseNoFlg(boolean businessLicenseNoFlg) {
        this.businessLicenseNoFlg = businessLicenseNoFlg;
    }

    public boolean isBusinessLicenseUrlFlg() {
        return businessLicenseUrlFlg;
    }

    public void setBusinessLicenseUrlFlg(boolean businessLicenseUrlFlg) {
        this.businessLicenseUrlFlg = businessLicenseUrlFlg;
    }

    public boolean isCompanyNameFlg() {
        return companyNameFlg;
    }

    public void setCompanyNameFlg(boolean companyNameFlg) {
        this.companyNameFlg = companyNameFlg;
    }

    public boolean isCompanyNatureFlg() {
        return companyNatureFlg;
    }

    public void setCompanyNatureFlg(boolean companyNatureFlg) {
        this.companyNatureFlg = companyNatureFlg;
    }

    public boolean isCompanyAddressFlg() {
        return companyAddressFlg;
    }

    public void setCompanyAddressFlg(boolean companyAddressFlg) {
        this.companyAddressFlg = companyAddressFlg;
    }

    public boolean isLegalPersonFlg() {
        return legalPersonFlg;
    }

    public void setLegalPersonFlg(boolean legalPersonFlg) {
        this.legalPersonFlg = legalPersonFlg;
    }

    public boolean isRegisteredCapitalFlg() {
        return registeredCapitalFlg;
    }

    public void setRegisteredCapitalFlg(boolean registeredCapitalFlg) {
        this.registeredCapitalFlg = registeredCapitalFlg;
    }

    public boolean isPaidInCapitalFlg() {
        return paidInCapitalFlg;
    }

    public void setPaidInCapitalFlg(boolean paidInCapitalFlg) {
        this.paidInCapitalFlg = paidInCapitalFlg;
    }

    public boolean isFoundingDateFlg() {
        return foundingDateFlg;
    }

    public void setFoundingDateFlg(boolean foundingDateFlg) {
        this.foundingDateFlg = foundingDateFlg;
    }

    public boolean isOperationPeriodFlg() {
        return operationPeriodFlg;
    }

    public void setOperationPeriodFlg(boolean operationPeriodFlg) {
        this.operationPeriodFlg = operationPeriodFlg;
    }

    public boolean isBusinessScopeFlg() {
        return businessScopeFlg;
    }

    public void setBusinessScopeFlg(boolean businessScopeFlg) {
        this.businessScopeFlg = businessScopeFlg;
    }

    public boolean isDepositBankFlg() {
        return depositBankFlg;
    }

    public void setDepositBankFlg(boolean depositBankFlg) {
        this.depositBankFlg = depositBankFlg;
    }

    public boolean isBankAccountFlg() {
        return bankAccountFlg;
    }

    public void setBankAccountFlg(boolean bankAccountFlg) {
        this.bankAccountFlg = bankAccountFlg;
    }

    public boolean isAccPermitCertUrlFlg() {
        return accPermitCertUrlFlg;
    }

    public void setAccPermitCertUrlFlg(boolean accPermitCertUrlFlg) {
        this.accPermitCertUrlFlg = accPermitCertUrlFlg;
    }
}
