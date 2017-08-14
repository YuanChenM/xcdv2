package com.bms.byim.bean.param;


import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhao_chen1 on 2016/12/30.
 */
@ApiModel(value = "配送地址参数类", description = "配送地址参数类")
public class DeliveryAddrRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "配送地址ID")
    private Long deliveryId;
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "省ID")
    private Long provinceId;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "城市ID")
    private Long cityId;
    @ApiModelProperty(value = "城市编码")
    private String cityCode;
    @ApiModelProperty(value = "城市名称")
    private String cityName;
    @ApiModelProperty(value = "区（县）ID")
    private Long districtId;
    @ApiModelProperty(value = "区（县）编码")
    private String districtCode;
    @ApiModelProperty(value = "区（县）名称")
    private String districtName;
    @ApiModelProperty(value = "配送地址")
    private String deliveryAddr;
    @ApiModelProperty(value = "配送参照地址")
    private String referenceAddr;
    @ApiModelProperty(value = "经营地址")
    private String manageAddr;
    @ApiModelProperty(value = "虚拟经营地址")
    private String virtualAddr;
    @ApiModelProperty(value = "收货联系人")
    private String receivePersonName;
    @ApiModelProperty(value = "联系人电话")
    private String receivePersonTel;
    @ApiModelProperty(value = "联系人微信")
    private String receivePersonWechat;
    @ApiModelProperty(value = "联系人QQ")
    private String receivePersonQq;
    @ApiModelProperty(value = "通行区域ID")
    private Long deliveryAreaId;
    @ApiModelProperty(value = "订单配送区域")
    private String deliveryArea;
    @ApiModelProperty(value = "订单配送区域环标码")
    private String deliveryAreaCode;
    @ApiModelProperty(value = "准入通行车型")
    private String passTrafficModel;
    @ApiModelProperty(value = "是否默认配送地址")
    //true:表示默认地址;false:表示不是默认地址
    private Boolean isDefaultFlg;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;
    @ApiModelProperty(value = "正常收货时间")
    private String normalReceiveTime;
    @ApiModelProperty(value = "最早时间")
    private String earliestTime;
    @ApiModelProperty(value = "最晚时间")
    private String latestTime;
    @ApiModelProperty(value = "买家支付方式")
    private String paymentType;


    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getVirtualAddr() {
        return virtualAddr;
    }

    public void setVirtualAddr(String virtualAddr) {
        this.virtualAddr = virtualAddr;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
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

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
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

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public String getReferenceAddr() {
        return referenceAddr;
    }

    public void setReferenceAddr(String referenceAddr) {
        this.referenceAddr = referenceAddr;
    }

    public String getManageAddr() {
        return manageAddr;
    }

    public void setManageAddr(String manageAddr) {
        this.manageAddr = manageAddr;
    }

    public String getReceivePersonName() {
        return receivePersonName;
    }

    public void setReceivePersonName(String receivePersonName) {
        this.receivePersonName = receivePersonName;
    }

    public String getReceivePersonTel() {
        return receivePersonTel;
    }

    public void setReceivePersonTel(String receivePersonTel) {
        this.receivePersonTel = receivePersonTel;
    }

    public String getReceivePersonWechat() {
        return receivePersonWechat;
    }

    public void setReceivePersonWechat(String receivePersonWechat) {
        this.receivePersonWechat = receivePersonWechat;
    }

    public String getReceivePersonQq() {
        return receivePersonQq;
    }

    public void setReceivePersonQq(String receivePersonQq) {
        this.receivePersonQq = receivePersonQq;
    }

    public Long getDeliveryAreaId() {
        return deliveryAreaId;
    }

    public void setDeliveryAreaId(Long deliveryAreaId) {
        this.deliveryAreaId = deliveryAreaId;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getDeliveryAreaCode() {
        return deliveryAreaCode;
    }

    public void setDeliveryAreaCode(String deliveryAreaCode) {
        this.deliveryAreaCode = deliveryAreaCode;
    }

    public String getPassTrafficModel() {
        return passTrafficModel;
    }

    public void setPassTrafficModel(String passTrafficModel) {
        this.passTrafficModel = passTrafficModel;
    }

    public Boolean getIsDefaultFlg() {
        return isDefaultFlg;
    }

    public void setIsDefaultFlg(Boolean isDefaultFlg) {
        this.isDefaultFlg = isDefaultFlg;
    }

    public String getNormalReceiveTime() {
        return normalReceiveTime;
    }

    public void setNormalReceiveTime(String normalReceiveTime) {
        this.normalReceiveTime = normalReceiveTime;
    }

    public String getEarliestTime() {
        return earliestTime;
    }

    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
