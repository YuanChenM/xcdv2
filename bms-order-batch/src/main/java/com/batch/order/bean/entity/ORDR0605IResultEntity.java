package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by wu_honglei on 2016/12/29.
 */
public class ORDR0605IResultEntity extends BaseEntity {
    private Long bsOrderId; //买手订单ID
    private String bsOrderCode;//买手订单编码
    private String bsOrderType;//订单类型
    private String salePlatformType;//销售平台
    private String orderSourceType;//订单来源
    private Long   orderPlacerId;//下单员ID
    private String orderPlacerType;//下单员类型
    private String orderPlacerCode;//下单员编码
    private Date orderPlaceDateTime;//下单时间
    private Long logisticZoneId;//物流区ID
    private String logisticZoneCode;//物流区编码
    private String logisticZoneName;//物流区名称
    private Long countryId;//区县ID
    private String countryName;//区县名称
    private Long cityId;//城市ID
    private String cityName;//城市名称
    private String bsId;//买手ID
    private String bsCode;//买手编码
    private String bsName;//买手名称
    private String bsType;//买手类型
    private Boolean invoiceFLg;//是否开发票
    private Boolean useNetFlg;//是否使用账期
    private BigDecimal orderAmount;//订单金额
    private BigDecimal preferentAmount;//优惠金额
    private BigDecimal receivedAmount;//已收金额
    private BigDecimal earnestPercent;//定金应付比例
    private BigDecimal earnestAmount;//定金应付金额
    private BigDecimal advancePaymentPercent;//应预付比例
    private BigDecimal advancePaymentAmount;//应预付金额
    private String  bsOrderStatus;//买手订单状态
    private String  paymentStatus;//支付状态
    private Integer ver;//版本号
    private Integer sortSeq;//排序号
    //买手订单明细
    private List<BsOrderDetailIResultEntity> bsOrderDetailList;

    public Long getBsOrderId() {
        return bsOrderId;
    }

    public void setBsOrderId(Long bsOrderId) {
        this.bsOrderId = bsOrderId;
    }

    public String getBsOrderCode() {
        return bsOrderCode;
    }

    public void setBsOrderCode(String bsOrderCode) {
        this.bsOrderCode = bsOrderCode;
    }

    public String getBsOrderType() {
        return bsOrderType;
    }

    public void setBsOrderType(String bsOrderType) {
        this.bsOrderType = bsOrderType;
    }

    public String getSalePlatformType() {
        return salePlatformType;
    }

    public void setSalePlatformType(String salePlatformType) {
        this.salePlatformType = salePlatformType;
    }

    public String getOrderSourceType() {
        return orderSourceType;
    }

    public void setOrderSourceType(String orderSourceType) {
        this.orderSourceType = orderSourceType;
    }

    public Long getOrderPlacerId() {
        return orderPlacerId;
    }

    public void setOrderPlacerId(Long orderPlacerId) {
        this.orderPlacerId = orderPlacerId;
    }

    public String getOrderPlacerType() {
        return orderPlacerType;
    }

    public void setOrderPlacerType(String orderPlacerType) {
        this.orderPlacerType = orderPlacerType;
    }

    public String getOrderPlacerCode() {
        return orderPlacerCode;
    }

    public void setOrderPlacerCode(String orderPlacerCode) {
        this.orderPlacerCode = orderPlacerCode;
    }

    public Date getOrderPlaceDateTime() {
        return orderPlaceDateTime;
    }

    public void setOrderPlaceDateTime(Date orderPlaceDateTime) {
        this.orderPlaceDateTime = orderPlaceDateTime;
    }

    public Long getLogisticZoneId() {
        return logisticZoneId;
    }

    public void setLogisticZoneId(Long logisticZoneId) {
        this.logisticZoneId = logisticZoneId;
    }

    public String getLogisticZoneCode() {
        return logisticZoneCode;
    }

    public void setLogisticZoneCode(String logisticZoneCode) {
        this.logisticZoneCode = logisticZoneCode;
    }

    public String getLogisticZoneName() {
        return logisticZoneName;
    }

    public void setLogisticZoneName(String logisticZoneName) {
        this.logisticZoneName = logisticZoneName;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getBsType() {
        return bsType;
    }

    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    public Boolean getInvoiceFLg() {
        return invoiceFLg;
    }

    public void setInvoiceFLg(Boolean invoiceFLg) {
        this.invoiceFLg = invoiceFLg;
    }

    public Boolean getUseNetFlg() {
        return useNetFlg;
    }

    public void setUseNetFlg(Boolean useNetFlg) {
        this.useNetFlg = useNetFlg;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPreferentAmount() {
        return preferentAmount;
    }

    public void setPreferentAmount(BigDecimal preferentAmount) {
        this.preferentAmount = preferentAmount;
    }

    public BigDecimal getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(BigDecimal receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public BigDecimal getEarnestPercent() {
        return earnestPercent;
    }

    public void setEarnestPercent(BigDecimal earnestPercent) {
        this.earnestPercent = earnestPercent;
    }

    public BigDecimal getEarnestAmount() {
        return earnestAmount;
    }

    public void setEarnestAmount(BigDecimal earnestAmount) {
        this.earnestAmount = earnestAmount;
    }

    public BigDecimal getAdvancePaymentPercent() {
        return advancePaymentPercent;
    }

    public void setAdvancePaymentPercent(BigDecimal advancePaymentPercent) {
        this.advancePaymentPercent = advancePaymentPercent;
    }

    public BigDecimal getAdvancePaymentAmount() {
        return advancePaymentAmount;
    }

    public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    public String getBsOrderStatus() {
        return bsOrderStatus;
    }

    public void setBsOrderStatus(String bsOrderStatus) {
        this.bsOrderStatus = bsOrderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    public List<BsOrderDetailIResultEntity> getBsOrderDetailList() {
        return bsOrderDetailList;
    }

    public void setBsOrderDetailList(List<BsOrderDetailIResultEntity> bsOrderDetailList) {
        this.bsOrderDetailList = bsOrderDetailList;
    }
}
