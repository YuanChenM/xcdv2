package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
@ApiModel(value = "AccountParam",
        description = "买手账号信息类")
public class AccountParam extends AgentParam{

    @ApiModelProperty(value = "账号ID")
    private Long accountId;
    @ApiModelProperty(value = "账号名称")
    private String accountName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "电话号码")
    private String telNo;
    @ApiModelProperty(value = "邮箱地址")
    private String mailAddr;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }
}
