package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class AGIF0401IRestResult implements Serializable {
    //买手ID
    private String agentId;
    //买手姓名
    private String agentName;
    //买手编码
    private String agentCode;
    //管家ID
    private String butlerId;
    //管家姓名
    private String butlerName;
    //管家编码
    private String butlerCode;
    //管家帐号
    private String butlerAccount;
    //管家注册手机号
    private String butlerTelNo;
    //物流区名称
    private String lgcsAreaName;
    //地区名称
    private String zoneName;
    //配送站名称
    private String distributionName;
    //领地名称
    private String demesneName;

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

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public String getDemesneName() {
        return demesneName;
    }

    public void setDemesneName(String demesneName) {
        this.demesneName = demesneName;
    }
}
