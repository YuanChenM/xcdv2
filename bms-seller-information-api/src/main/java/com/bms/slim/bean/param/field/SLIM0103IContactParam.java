package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLIM0103IContactParam", description = "卖家联系人")
public class SLIM0103IContactParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "联系人ID")
    private Long contactId;
    @ApiModelProperty(value = "联系人名称")
    private String contactName;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "微信号")
    private String wechat;
    @ApiModelProperty(value = "QQ号")
    private String qq;
    @ApiModelProperty(value = "EMAIL地址")
    private String email;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
