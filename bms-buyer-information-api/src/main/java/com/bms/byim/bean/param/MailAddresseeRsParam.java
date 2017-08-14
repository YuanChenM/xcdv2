package com.bms.byim.bean.param;


import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhang_jian4 on 2017/2/10.
 */
@ApiModel(value = "MailAddresseeRsParam", description = "邮件发送邮箱列表")
public class MailAddresseeRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "发送列表ID")
    private Long mailAddresseeId;
    @ApiModelProperty(value = "收件人姓名")
    private String addresseeName;
    @ApiModelProperty(value = "收件人地址")
    private String addresseeEmail;
    @ApiModelProperty(value = "发送类型")
    private String sendType;
    @ApiModelProperty(value = "发送群组")
    private String sendGroup;

    public Long getMailAddresseeId() {
        return mailAddresseeId;
    }

    public void setMailAddresseeId(Long mailAddresseeId) {
        this.mailAddresseeId = mailAddresseeId;
    }

    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName;
    }

    public String getAddresseeEmail() {
        return addresseeEmail;
    }

    public void setAddresseeEmail(String addresseeEmail) {
        this.addresseeEmail = addresseeEmail;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getSendGroup() {
        return sendGroup;
    }

    public void setSendGroup(String sendGroup) {
        this.sendGroup = sendGroup;
    }
}
