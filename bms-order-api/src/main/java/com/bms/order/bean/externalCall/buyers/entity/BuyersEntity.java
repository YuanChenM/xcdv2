package com.bms.order.bean.externalCall.buyers.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang_jianzhou on 2017/1/6.
 */
public class BuyersEntity implements Serializable{


    private static final long serialVersionUID = 1L;

    /**
     * 买家：买家ID [【需要和买家确认】]
     */
    private String buyerId;

    /**
     * 买家：买家类型 [CodeMaster]
     */
    private String buyerType;

    /**
     * 买家：专属买手类型 [CodeMaster 区域买手、非区域买手、区域分销买手、账期用户买手]
     */
    private String bsType;

    /**
     * 买家：专属买手ID [【需要和买手确认】]
     */
    private String bsId;

    /**
     * 买家：买家编码
     */
    private String buyerCode;

    /**
     * 买家：买家名称
     */
    private String buyerName;

    /**
     * 买家：买家联系电话
     */
    private String buyerPhone;

    /**
     * 买家：买家微信号
     */
    private String buyerWechat;

    /**
     * 买家：买家QQ
     */
    private String buyerQq;

    /**
     * 买家：买家邮箱
     */
    private String buyerMail;

    /**
     * 买家：区域买手ID [【需要和买手确认】]
     */
    private String regionalBsId;

    /**
     * 买家：区域买手编码 [【需要和买手确认】]
     */
    private String regionalBsCode;

    /**
     * 买家：区域买手名称 [【需要和买手确认】]
     */
    private String regionalBsName;

    /**
     * 买家：非区域买手ID [【需要和买手确认】]
     */
    private String nonRegionalBsId;

    /**
     * 买家：非区域买手编码 [【需要和买手确认】]
     */
    private String nonRegionalBsCode;

    /**
     * 买家：非区域买手名称 [【需要和买手确认】]
     */
    private String nonRegionalBsName;

    /**
     * 买家：区域分销买手ID [【需要和买手确认】]
     */
    private String regionalDistributionBsId;

    /**
     * 买家：区域分销买手编码 [【需要和买手确认】]
     */
    private String regionalDistributionBsCode;

    /**
     * 买家：区域分销买手名称 [【需要和买手确认】]
     */
    private String regionalDistributionBsName;

    /**
     * 买家：账期用户买手ID [【需要和买手确认】]
     */
    private String netUserBsId;

    /**
     * 买家：账期用户买手编码 [【需要和买手确认】]
     */
    private String netUserBsCode;

    /**
     * 买家：账期用户买手名称 [【需要和买手确认】]
     */
    private String netUserBsName;

    /**
     * 买家：冻品管家ID [【需要和买手确认】]
     */
    private String saId;

    /**
     * 买家：冻品管家编码 [【需要和买手确认】]
     */
    private String saCode;

    /**
     * 买家：冻品管家名称 [【需要和买手确认】]
     */
    private String saName;

    /**
     * 买家：是否是账期买家
     */
    private Boolean netBuyerFlg;
    /**
     * 区域：区域配送站ID
     */
    private Long regionalDistributionStation;

    /**
     * 获取区域：区域配送站ID
     *
     * @return 区域：区域配送站ID
     */
    public Long getRegionalDistributionStation() {
        return this.regionalDistributionStation;
    }

    /**
     * 设置区域：区域配送站ID
     *
     * @param regionalDistributionStation
     */
    public void setRegionalDistributionStation(Long regionalDistributionStation) {
        this.regionalDistributionStation = regionalDistributionStation;
    }

    /**
     * 区域：区域配送站编码
     */
    private String regionalDistributionStationCode;

    /**
     * 获取区域：区域配送站编码
     *
     * @return 区域：区域配送站编码
     */
    public String getRegionalDistributionStationCode() {
        return this.regionalDistributionStationCode;
    }

    /**
     * 设置区域：区域配送站编码
     *
     * @param regionalDistributionStationCode
     */
    public void setRegionalDistributionStationCode(String regionalDistributionStationCode) {
        this.regionalDistributionStationCode = regionalDistributionStationCode;
    }

    /**
     * 区域：区域配送站名称
     */
    private String regionalDistributionStationName;

    /**
     * 获取区域：区域配送站名称
     *
     * @return 区域：区域配送站名称
     */
    public String getRegionalDistributionStationName() {
        return this.regionalDistributionStationName;
    }

    /**
     * 设置区域：区域配送站名称
     *
     * @param regionalDistributionStationName
     */
    public void setRegionalDistributionStationName(String regionalDistributionStationName) {
        this.regionalDistributionStationName = regionalDistributionStationName;
    }

    /**
     * 收货人,收货地址
     */
    private List<BuyersReceiverEntity> buyersReceiverEntityList;


    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public String getBsType() {
        return bsType;
    }

    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerWechat() {
        return buyerWechat;
    }

    public void setBuyerWechat(String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }

    public String getBuyerQq() {
        return buyerQq;
    }

    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }

    public String getBuyerMail() {
        return buyerMail;
    }

    public void setBuyerMail(String buyerMail) {
        this.buyerMail = buyerMail;
    }

    public String getRegionalBsId() {
        return regionalBsId;
    }

    public void setRegionalBsId(String regionalBsId) {
        this.regionalBsId = regionalBsId;
    }

    public String getRegionalBsCode() {
        return regionalBsCode;
    }

    public void setRegionalBsCode(String regionalBsCode) {
        this.regionalBsCode = regionalBsCode;
    }

    public String getRegionalBsName() {
        return regionalBsName;
    }

    public void setRegionalBsName(String regionalBsName) {
        this.regionalBsName = regionalBsName;
    }

    public String getNonRegionalBsId() {
        return nonRegionalBsId;
    }

    public void setNonRegionalBsId(String nonRegionalBsId) {
        this.nonRegionalBsId = nonRegionalBsId;
    }

    public String getNonRegionalBsCode() {
        return nonRegionalBsCode;
    }

    public void setNonRegionalBsCode(String nonRegionalBsCode) {
        this.nonRegionalBsCode = nonRegionalBsCode;
    }

    public String getNonRegionalBsName() {
        return nonRegionalBsName;
    }

    public void setNonRegionalBsName(String nonRegionalBsName) {
        this.nonRegionalBsName = nonRegionalBsName;
    }

    public String getRegionalDistributionBsId() {
        return regionalDistributionBsId;
    }

    public void setRegionalDistributionBsId(String regionalDistributionBsId) {
        this.regionalDistributionBsId = regionalDistributionBsId;
    }

    public String getRegionalDistributionBsCode() {
        return regionalDistributionBsCode;
    }

    public void setRegionalDistributionBsCode(String regionalDistributionBsCode) {
        this.regionalDistributionBsCode = regionalDistributionBsCode;
    }

    public String getRegionalDistributionBsName() {
        return regionalDistributionBsName;
    }

    public void setRegionalDistributionBsName(String regionalDistributionBsName) {
        this.regionalDistributionBsName = regionalDistributionBsName;
    }

    public String getNetUserBsId() {
        return netUserBsId;
    }

    public void setNetUserBsId(String netUserBsId) {
        this.netUserBsId = netUserBsId;
    }

    public String getNetUserBsCode() {
        return netUserBsCode;
    }

    public void setNetUserBsCode(String netUserBsCode) {
        this.netUserBsCode = netUserBsCode;
    }

    public String getNetUserBsName() {
        return netUserBsName;
    }

    public void setNetUserBsName(String netUserBsName) {
        this.netUserBsName = netUserBsName;
    }

    public String getSaId() {
        return saId;
    }

    public void setSaId(String saId) {
        this.saId = saId;
    }

    public String getSaCode() {
        return saCode;
    }

    public void setSaCode(String saCode) {
        this.saCode = saCode;
    }

    public String getSaName() {
        return saName;
    }

    public void setSaName(String saName) {
        this.saName = saName;
    }

    public List<BuyersReceiverEntity> getBuyersReceiverEntityList() {
        return buyersReceiverEntityList;
    }

    public void setBuyersReceiverEntityList(List<BuyersReceiverEntity> buyersReceiverEntityList) {
        this.buyersReceiverEntityList = buyersReceiverEntityList;
    }

    /**
     * @return the netBuyerFlg
     */
    public Boolean getNetBuyerFlg() {
        return netBuyerFlg;
    }

    /**
     * @param netBuyerFlg
     *            the netBuyerFlg to set
     */
    public void setNetBuyerFlg(Boolean netBuyerFlg) {
        this.netBuyerFlg = netBuyerFlg;
    }

    @Override
    public String toString() {
        return "BuyersEntity{" +
                "buyerId='" + buyerId + '\'' +
                ", buyerType='" + buyerType + '\'' +
                ", bsType='" + bsType + '\'' +
                ", bsId=" + bsId +
                ", buyerCode='" + buyerCode + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerWechat='" + buyerWechat + '\'' +
                ", buyerQq='" + buyerQq + '\'' +
                ", buyerMail='" + buyerMail + '\'' +
                ", regionalBsId=" + regionalBsId +
                ", regionalBsCode='" + regionalBsCode + '\'' +
                ", regionalBsName='" + regionalBsName + '\'' +
                ", nonRegionalBsId=" + nonRegionalBsId +
                ", nonRegionalBsCode='" + nonRegionalBsCode + '\'' +
                ", nonRegionalBsName='" + nonRegionalBsName + '\'' +
                ", regionalDistributionBsId=" + regionalDistributionBsId +
                ", regionalDistributionBsCode='" + regionalDistributionBsCode + '\'' +
                ", regionalDistributionBsName='" + regionalDistributionBsName + '\'' +
                ", netUserBsId=" + netUserBsId +
                ", netUserBsCode='" + netUserBsCode + '\'' +
                ", netUserBsName='" + netUserBsName + '\'' +
                ", saId=" + saId +
                ", saCode='" + saCode + '\'' +
                ", saName='" + saName + '\'' +
                ", buyersReceiverEntityList=" + buyersReceiverEntityList +
                '}';
    }
}
