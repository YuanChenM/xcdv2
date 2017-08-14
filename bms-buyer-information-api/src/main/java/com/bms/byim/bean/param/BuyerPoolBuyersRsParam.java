package com.bms.byim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by zhou_yajun on 2017/1/17.
 */
public class BuyerPoolBuyersRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "买家池买家关系ID")
    private Long relationShipId;
    @ApiModelProperty(value = "买家池ID")
    private Long buyerPoolId;
    @ApiModelProperty(value = "买家池名称")
    private String buyerPoolName;
    @ApiModelProperty(value = "买家池编码")
    private String buyerPoolCode;
    @ApiModelProperty(value = "物流区ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "买家类型")
    private String buyerType;
    @ApiModelProperty(value = "买家类型名称")
    private String buyerTypeName;
    @ApiModelProperty(value = "买家一级分类")
    private String buyerFirstCategory;
    @ApiModelProperty(value = "买家一级分类名称")
    private String buyerFirstCategoryName;
    @ApiModelProperty(value = "买家二级分类")
    private String buyerSubCategory;
    @ApiModelProperty(value = "买家二级分类名称")
    private String buyerSubCategoryName;
    @ApiModelProperty(value = "所属期开始时间")
    private Date periodStart;
    @ApiModelProperty(value = "所属期结束时间")
    private Date periodEnd;
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "买家名称")
    private String buyerName;
    @ApiModelProperty(value = "买家地址")
    private String buyerAddr;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "城市编码")
    private String cityCode;
    @ApiModelProperty(value = "城市名称")
    private String cityName;
    @ApiModelProperty(value = "区县编码")
    private String districtCode;
    @ApiModelProperty(value = "区县名称")
    private String districtName;
    @ApiModelProperty(value = "买家QQ")
    private String buyerQq;
    @ApiModelProperty(value = "买家微信")
    private String buyerWechat;
    @ApiModelProperty(value = "上线状态一级分类")
    private String[] marketingFirstStatus;
    @ApiModelProperty(value = "上线状态二级分类")
    private String marketingSubStatus;
    @ApiModelProperty(value = "是否信息错误")
    private boolean infoErrorFlg;
    @ApiModelProperty(value = "信息错误备注")
    private String infoErrorRemark;
    @ApiModelProperty(value = "市场ID")
    private String marketId;
    @ApiModelProperty(value = "市场编码")
    private String marketCode;
    @ApiModelProperty(value = "市场名称")
    private String marketName;
    @ApiModelProperty(value = "市场类型")
    private String marketType;
    @ApiModelProperty(value = "店铺经营地址")
    private String storeAddr;
    @ApiModelProperty(value = "店铺号")
    private String storeNo;
    @ApiModelProperty(value = "登记人")
    private java.lang.String registrantId;
    @ApiModelProperty(value = "登记日")
    private java.util.Date registrantDate;
    @ApiModelProperty(value = "预注册人")
    private java.lang.String preRegistrantId;
    @ApiModelProperty(value = "预注册日")
    private java.util.Date preRegistrationDate;
    @ApiModelProperty(value = "老板名称")
    private String bossName;
    @ApiModelProperty(value = "老板手机号")
    private String employeeTel;
    @ApiModelProperty(value = "老板微信")
    private String employeeWechat;
    @ApiModelProperty(value = "老板QQ")
    private String employeeQq;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;
    @ApiModelProperty(value = "创建者")
    private String crtId;
    @ApiModelProperty(value = "创建时间")
    private Date crtTime;
    @ApiModelProperty(value = "更新着")
    private String updId;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;
    @ApiModelProperty(value = "版本号")
    private Integer version;
    private String marketingFirstStatusStr;

    public Long getRelationShipId() {
        return relationShipId;
    }

    public void setRelationShipId(Long relationShipId) {
        this.relationShipId = relationShipId;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public Long getBuyerPoolId() {
        return buyerPoolId;
    }

    public void setBuyerPoolId(Long buyerPoolId) {
        this.buyerPoolId = buyerPoolId;
    }

    public String getBuyerPoolName() {
        return buyerPoolName;
    }

    public void setBuyerPoolName(String buyerPoolName) {
        this.buyerPoolName = buyerPoolName;
    }

    public String getBuyerPoolCode() {
        return buyerPoolCode;
    }

    public void setBuyerPoolCode(String buyerPoolCode) {
        this.buyerPoolCode = buyerPoolCode;
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

    public String getBuyerFirstCategory() {
        return buyerFirstCategory;
    }

    public void setBuyerFirstCategory(String buyerFirstCategory) {
        this.buyerFirstCategory = buyerFirstCategory;
    }

    public String getBuyerFirstCategoryName() {
        return buyerFirstCategoryName;
    }

    public void setBuyerFirstCategoryName(String buyerFirstCategoryName) {
        this.buyerFirstCategoryName = buyerFirstCategoryName;
    }

    public String getRegistrantId() {
        return registrantId;
    }

    public void setRegistrantId(String registrantId) {
        this.registrantId = registrantId;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }

    public String getPreRegistrantId() {
        return preRegistrantId;
    }

    public void setPreRegistrantId(String preRegistrantId) {
        this.preRegistrantId = preRegistrantId;
    }

    public Date getPreRegistrationDate() {
        return preRegistrationDate;
    }

    public void setPreRegistrationDate(Date preRegistrationDate) {
        this.preRegistrationDate = preRegistrationDate;
    }

    public String getBuyerSubCategory() {
        return buyerSubCategory;
    }

    public void setBuyerSubCategory(String buyerSubCategory) {
        this.buyerSubCategory = buyerSubCategory;
    }

    public String getBuyerSubCategoryName() {
        return buyerSubCategoryName;
    }

    public void setBuyerSubCategoryName(String buyerSubCategoryName) {
        this.buyerSubCategoryName = buyerSubCategoryName;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
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

    public String getBuyerAddr() {
        return buyerAddr;
    }

    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
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

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getBuyerQq() {
        return buyerQq;
    }

    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }

    public String getBuyerWechat() {
        return buyerWechat;
    }

    public void setBuyerWechat(String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }

    public String[] getMarketingFirstStatus() {
        return marketingFirstStatus;
    }

    public void setMarketingFirstStatus(String[] marketingFirstStatus) {
        this.marketingFirstStatus = marketingFirstStatus;
    }

    public String getMarketingSubStatus() {
        return marketingSubStatus;
    }

    public void setMarketingSubStatus(String marketingSubStatus) {
        this.marketingSubStatus = marketingSubStatus;
    }

    public boolean isInfoErrorFlg() {
        return infoErrorFlg;
    }

    public void setInfoErrorFlg(boolean infoErrorFlg) {
        this.infoErrorFlg = infoErrorFlg;
    }

    public String getInfoErrorRemark() {
        return infoErrorRemark;
    }

    public void setInfoErrorRemark(String infoErrorRemark) {
        this.infoErrorRemark = infoErrorRemark;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getEmployeeTel() {
        return employeeTel;
    }

    public void setEmployeeTel(String employeeTel) {
        this.employeeTel = employeeTel;
    }

    public String getEmployeeWechat() {
        return employeeWechat;
    }

    public void setEmployeeWechat(String employeeWechat) {
        this.employeeWechat = employeeWechat;
    }

    public String getEmployeeQq() {
        return employeeQq;
    }

    public void setEmployeeQq(String employeeQq) {
        this.employeeQq = employeeQq;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String getMarketingFirstStatusStr() {
        return marketingFirstStatusStr;
    }

    public void setMarketingFirstStatusStr(String marketingFirstStatusStr) {
        this.marketingFirstStatusStr = marketingFirstStatusStr;
    }
}
