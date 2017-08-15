package com.bms.order.fms.bean;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * oms内部子系统-买手系统的买手的配送站信息
 */
public class OmsAgentDistribution implements Serializable {
    private static final long serialVersionUID = -5484401771185921790L;
    //买手ID
    private String agentId;
    //物流区主键
    private Long lgcsAreaId;
    //物流区编码
    private String lgcsAreaCode;
    //物流区名称
    private String lgcsAreaName;
    //物流区划地区主键
    private Long zoneId;
    //物流区划地区编码
    private String zoneCode;
    //物流区划地区名称
    private String zoneName;
    //配送站主键
    private Long distributionId;
    //配送站分类
    private String distributionType;
    //配送站表示码
    private String distributionName;
    //配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)
    private String distributionCode;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }
}

