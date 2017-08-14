package com.bms.agif.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/17.
 */
@ApiModel(value = "BuyerButlerAgentRelationRsResult", description = "买家所属的买手和管家信息返回参数")
public class BuyerButlerAgentRelationRsResult implements Serializable {
    @ApiModelProperty(value = "关系ID")
    private Long relationId;
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "买手ID")
    private String agentId;
    @ApiModelProperty(value = "买手姓名")
    private String agentName;
    @ApiModelProperty(value = "买手编码")
    private String agentCode;
    @ApiModelProperty(value = "买手账号")
    private String agentAccount;
    @ApiModelProperty(value = "买手注册手机号")
    private String agentTelNo;
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "管家姓名")
    private String butlerName;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = "管家帐号")
    private String butlerAccount;
    @ApiModelProperty(value = "管家注册手机号")
    private String butlerTelNo;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentAccount() {
        return agentAccount;
    }

    public void setAgentAccount(String agentAccount) {
        this.agentAccount = agentAccount;
    }

    public String getAgentTelNo() {
        return agentTelNo;
    }

    public void setAgentTelNo(String agentTelNo) {
        this.agentTelNo = agentTelNo;
    }

    public String getButlerId() {
        return butlerId;
    }

    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    public String getButlerName() {
        return butlerName;
    }

    public void setButlerName(String butlerName) {
        this.butlerName = butlerName;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    public String getButlerAccount() {
        return butlerAccount;
    }

    public void setButlerAccount(String butlerAccount) {
        this.butlerAccount = butlerAccount;
    }

    public String getButlerTelNo() {
        return butlerTelNo;
    }

    public void setButlerTelNo(String butlerTelNo) {
        this.butlerTelNo = butlerTelNo;
    }
}
