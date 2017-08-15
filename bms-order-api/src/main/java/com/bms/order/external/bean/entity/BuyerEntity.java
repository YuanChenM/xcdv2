package com.bms.order.external.bean.entity;

/**
 * 买家信息
 * 
 * @author li_huiqian
 *
 */
public final class BuyerEntity {

    /**
     * 买家：买家ID
     */
    private String buyerId;

    /**
     * 买家：买家名称
     */
    private String buyerName;

    /**
     * 买家：买家编码
     */
    private String buyerCode;

    /**
     * 买家：买家类型
     */
    private String buyerType;

    /**
     * 买家：买家类型名称
     */
    private String buyerTypeName;

    /**
     * 买家：是否是账期买家
     */
    private Boolean netBuyerFlg;

    /**
     * 区域：物流区ID
     */
    private Long logisticsZoneId;

    /**
     * 区域：物流区编码
     */
    private String logisticsZoneCode;

    /**
     * 区域：物流区名称
     */
    private String logisticsZoneName;

    /**
     * 区域：省ID
     */
    private Long provinceId;

    /**
     * 区域：省编码
     */
    private String provinceCode;

    /**
     * 区域：省名称
     */
    private String provinceName;

    /**
     * 区域：市ID
     */
    private Long cityId;

    /**
     * 区域：市编码
     */
    private String cityCode;

    /**
     * 区域：市名称
     */
    private String cityName;

    /**
     * 区域：区县ID
     */
    private Long countryId;

    /**
     * 区域：区县编码
     */
    private String countryCode;

    /**
     * 区域：区县名称
     */
    private String countryName;

    /**
     * 区域：街道ID
     */
    private Long streetId;

    /**
     * 区域：街道编码
     */
    private String streetCode;

    /**
     * 区域：街道名称
     */
    private String streetName;

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
     * 习惯支付方式
     */
    private String[] paymentType;

    /**
     * 收货时间段
     */
    private String receivePeriod;

    /**
     * 最早时间要求
     */
    private String receiveEarliest;

    /**
     * 最晚时间要求
     */
    private String receiveLatest;

    /**
     * 买家：专属买手类型
     */
    private String bsType;

    /**
     * 买家：专属买手ID
     */
    private String bsId;

    /**
     * 买家：区域买手ID
     */
    private String regionalBsId;

    /**
     * 买家：区域买手编码
     */
    private String regionalBsCode;

    /**
     * 买家：区域买手名称
     */
    private String regionalBsName;

    /**
     * 买家：非区域买手ID
     */
    private String nonRegionalBsId;

    /**
     * 买家：非区域买手编码
     */
    private String nonRegionalBsCode;

    /**
     * 买家：非区域买手名称
     */
    private String nonRegionalBsName;

    /**
     * 买家：区域分销买手ID
     */
    private String regionalDistributionBsId;

    /**
     * 买家：区域分销买手编码
     */
    private String regionalDistributionBsCode;

    /**
     * 买家：区域分销买手名称
     */
    private String regionalDistributionBsName;

    /**
     * 买家：账期用户买手ID
     */
    private String netUserBsId;

    /**
     * 买家：账期用户买手编码
     */
    private String netUserBsCode;

    /**
     * 买家：账期用户买手名称
     */
    private String netUserBsName;

    /**
     * 买家：冻品管家ID
     */
    private String saId;

    /**
     * 买家：冻品管家编码
     */
    private String saCode;

    /**
     * 买家：冻品管家名称
     */
    private String saName;

    /**
     * 区域：区域配送站ID
     */
    private Long regionalDistributionStation;

    /**
     * 区域：区域配送站编码
     */
    private String regionalDistributionStationCode;

    /**
     * 区域：区域配送站名称
     */
    private String regionalDistributionStationName;

    private String frequenterLevelCode;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }

    public Boolean getNetBuyerFlg() {
        return netBuyerFlg;
    }

    public void setNetBuyerFlg(Boolean netBuyerFlg) {
        this.netBuyerFlg = netBuyerFlg;
    }

    public Long getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    public String getLogisticsZoneCode() {
        return logisticsZoneCode;
    }

    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }

    public String getLogisticsZoneName() {
        return logisticsZoneName;
    }

    public void setLogisticsZoneName(String logisticsZoneName) {
        this.logisticsZoneName = logisticsZoneName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public String[] getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String[] paymentType) {
        this.paymentType = paymentType;
    }

    public String getReceivePeriod() {
        return receivePeriod;
    }

    public void setReceivePeriod(String receivePeriod) {
        this.receivePeriod = receivePeriod;
    }

    public String getReceiveEarliest() {
        return receiveEarliest;
    }

    public void setReceiveEarliest(String receiveEarliest) {
        this.receiveEarliest = receiveEarliest;
    }

    public String getReceiveLatest() {
        return receiveLatest;
    }

    public void setReceiveLatest(String receiveLatest) {
        this.receiveLatest = receiveLatest;
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

    public Long getRegionalDistributionStation() {
        return regionalDistributionStation;
    }

    public void setRegionalDistributionStation(Long regionalDistributionStation) {
        this.regionalDistributionStation = regionalDistributionStation;
    }

    public String getRegionalDistributionStationCode() {
        return regionalDistributionStationCode;
    }

    public void setRegionalDistributionStationCode(String regionalDistributionStationCode) {
        this.regionalDistributionStationCode = regionalDistributionStationCode;
    }

    public String getRegionalDistributionStationName() {
        return regionalDistributionStationName;
    }

    public void setRegionalDistributionStationName(String regionalDistributionStationName) {
        this.regionalDistributionStationName = regionalDistributionStationName;
    }

    public String getFrequenterLevelCode() {
        return frequenterLevelCode;
    }

    public void setFrequenterLevelCode(String frequenterLevelCode) {
        this.frequenterLevelCode = frequenterLevelCode;
    }
}
