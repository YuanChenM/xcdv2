/*
 * 2017/03/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>表AGIF_BUTLER_ACCOUNT对应的实体AgifButlerAccount</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
@ApiModel(value = "ButlerAccountRsParam", description = "冻品管家帐号信息Param")
public class ButlerAccountRsParam implements Serializable {


    @ApiModelProperty(value = "管家帐号ID")
    private Long accountId;
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "帐号名")
    private String accountName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "注册手机")
    private String telNo;
    @ApiModelProperty(value = "注册邮箱")
    private String mailAddr;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * <p>默认构造函数</p>
     */
    public ButlerAccountRsParam() {
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
     * <p>BUTLER_ID</p>
     *
     * @return BUTLER_ID
     */
    public String getButlerId() {
        return butlerId;
    }

    /**
     * <p>BUTLER_ID</p>
     *
     * @param butlerId BUTLER_ID
     */
    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    /**
     * <p>ACCOUNT_NAME</p>
     *
     * @return ACCOUNT_NAME
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * <p>ACCOUNT_NAME</p>
     *
     * @param accountName ACCOUNT_NAME
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
