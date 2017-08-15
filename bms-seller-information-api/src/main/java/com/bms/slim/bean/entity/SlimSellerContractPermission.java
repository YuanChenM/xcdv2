/*
 * 2017/02/24 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_SELLER_CONTRACT_PERMISSION对应的实体SlimSellerContractPermission</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSellerContractPermission extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家合同信息准入ID */
    private Long scpId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 卖家全称 */
    private String sellerFullName;
    /** 国家编码 */
    private String countryCode;
    /** 国家 */
    private String countryName;
    /** 省编码 */
    private String provinceCode;
    /** 省 */
    private String provinceName;
    /** 市编码 */
    private String cityCode;
    /** 市 */
    private String cityName;
    /** 经营地址 */
    private String businessAddress;
    /** 收款人全称 */
    private String payeeName;
    /** 收款银行 */
    private String payeeBank;
    /** 银行账号 */
    private String bankAccount;
    /** 合同快递收件地址 */
    private String expressAddress;

    /**
     * <p>默认构造函数</p>
     */
    public SlimSellerContractPermission() {
    }

    /**
     * <p>卖家合同信息准入ID</p>
     *
     * @return 卖家合同信息准入ID
     */
    public Long getScpId() {
        return scpId;
    }

    /**
     * <p>卖家合同信息准入ID</p>
     *
     * @param scpId 卖家合同信息准入ID
     */
    public void setScpId(Long scpId) {
        this.scpId = scpId;
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
     * <p>卖家全称</p>
     *
     * @return 卖家全称
     */
    public String getSellerFullName() {
        return sellerFullName;
    }

    /**
     * <p>卖家全称</p>
     *
     * @param sellerFullName 卖家全称
     */
    public void setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
    }
    /**
     * <p>国家编码</p>
     *
     * @return 国家编码
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * <p>国家编码</p>
     *
     * @param countryCode 国家编码
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     * <p>国家</p>
     *
     * @return 国家
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * <p>国家</p>
     *
     * @param countryName 国家
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    /**
     * <p>省编码</p>
     *
     * @return 省编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>省编码</p>
     *
     * @param provinceCode 省编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    /**
     * <p>省</p>
     *
     * @return 省
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>省</p>
     *
     * @param provinceName 省
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    /**
     * <p>市编码</p>
     *
     * @return 市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * <p>市编码</p>
     *
     * @param cityCode 市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * <p>市</p>
     *
     * @return 市
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * <p>市</p>
     *
     * @param cityName 市
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    /**
     * <p>经营地址</p>
     *
     * @return 经营地址
     */
    public String getBusinessAddress() {
        return businessAddress;
    }

    /**
     * <p>经营地址</p>
     *
     * @param businessAddress 经营地址
     */
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }
    /**
     * <p>收款人全称</p>
     *
     * @return 收款人全称
     */
    public String getPayeeName() {
        return payeeName;
    }

    /**
     * <p>收款人全称</p>
     *
     * @param payeeName 收款人全称
     */
    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }
    /**
     * <p>收款银行</p>
     *
     * @return 收款银行
     */
    public String getPayeeBank() {
        return payeeBank;
    }

    /**
     * <p>收款银行</p>
     *
     * @param payeeBank 收款银行
     */
    public void setPayeeBank(String payeeBank) {
        this.payeeBank = payeeBank;
    }
    /**
     * <p>银行账号</p>
     *
     * @return 银行账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * <p>银行账号</p>
     *
     * @param bankAccount 银行账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    /**
     * <p>合同快递收件地址</p>
     *
     * @return 合同快递收件地址
     */
    public String getExpressAddress() {
        return expressAddress;
    }

    /**
     * <p>合同快递收件地址</p>
     *
     * @param expressAddress 合同快递收件地址
     */
    public void setExpressAddress(String expressAddress) {
        this.expressAddress = expressAddress;
    }

}
