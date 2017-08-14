/*
 * 2017/03/21 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表byim_account对应的实体ByimAccount</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimAccount extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * ACCOUNT_ID
     */
    private Long accountId;
    /**
     * BUYER_ID
     */
    private String buyerId;
    /**
     * ACCOUNT_NO
     */
    private String accountNo;
    /**
     * PASSWORD
     */
    private String password;
    /**
     * TEL_NO
     */
    private String telNo;
    /**
     * MAIL_ADDR
     */
    private String mailAddr;

    /**
     * <p>默认构造函数</p>
     */
    public ByimAccount() {
    }

    /**
     * <p>ACCOUNT_ID</p>
     *
     * @return ACCOUNT_ID
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * <p>ACCOUNT_ID</p>
     *
     * @param accountId ACCOUNT_ID
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * <p>BUYER_ID</p>
     *
     * @return BUYER_ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>BUYER_ID</p>
     *
     * @param buyerId BUYER_ID
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * <p>ACCOUNT_NO</p>
     *
     * @return ACCOUNT_NO
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * <p>ACCOUNT_NO</p>
     *
     * @param accountNo ACCOUNT_NO
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * <p>PASSWORD</p>
     *
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>PASSWORD</p>
     *
     * @param password PASSWORD
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <p>TEL_NO</p>
     *
     * @return TEL_NO
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * <p>TEL_NO</p>
     *
     * @param telNo TEL_NO
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * <p>MAIL_ADDR</p>
     *
     * @return MAIL_ADDR
     */
    public String getMailAddr() {
        return mailAddr;
    }

    /**
     * <p>MAIL_ADDR</p>
     *
     * @param mailAddr MAIL_ADDR
     */
    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

}
