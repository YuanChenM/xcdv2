package com.bms.slim.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLIM0246IParam", description = "联系人信息")
public class SLIM0246IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "targets")
    private String[] targets;

    @ApiModelProperty(value = "联系人Id")
    private Long contactId;
    @ApiModelProperty(value = "联系人名称")
    private String contactName;
    @ApiModelProperty(value = "联系人类型(1:签约联系人;2:订单联系人;3:收款联系人;4营销负责人;5:合同负责人;6:生产负责人;7:品控负责人;8:包材负责人;9:运输负责人;10:合同快递收件人)")
    private String contactType;
    @ApiModelProperty(value = "工作单位ID")
    private Long workunitId;
    @ApiModelProperty(value = "工作单位类型，1：卖家，2：生产商")
    private String workunitType;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "微信号")
    private String wechat;
    @ApiModelProperty(value = "QQ号")
    private String qq;
    @ApiModelProperty(value = "EMAIL地址")
    private String email;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

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

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public Long getWorkunitId() {
        return workunitId;
    }

    public void setWorkunitId(Long workunitId) {
        this.workunitId = workunitId;
    }

    public String getWorkunitType() {
        return workunitType;
    }

    public void setWorkunitType(String workunitType) {
        this.workunitType = workunitType;
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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
