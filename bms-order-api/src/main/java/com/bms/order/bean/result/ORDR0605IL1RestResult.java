package com.bms.order.bean.result;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bms.order.common.rest.result.RestSearchData;

/**
 * 买手订单查询接口Result
 * 
 * @author li_huiqian
 */
public class ORDR0605IL1RestResult extends RestSearchData {

    /**
     * 
     */
    private static final long serialVersionUID = 4337831240029322673L;
    private List<ORDR0605IL2RestResult> bsOrderDetails;

    /**
     * @return the bsOrderDetails
     */
    public List<ORDR0605IL2RestResult> getBsOrderDetails() {
        return bsOrderDetails;
    }

    /**
     * @param bsOrderDetails
     *            the bsOrderDetails to set
     */
    public void setBsOrderDetails(List<ORDR0605IL2RestResult> bsOrderDetails) {
        this.bsOrderDetails = bsOrderDetails;
    }

    /** 订单：买手订单ID */
    private Long bsOrderId;

    /**
     * 获取订单：买手订单ID
     * 
     * @return 订单：买手订单ID
     */
    public Long getBsOrderId() {
        return this.bsOrderId;
    }

    /**
     * 设置订单：买手订单ID
     * 
     * @param bsOrderId
     */
    public void setBsOrderId(Long bsOrderId) {
        this.bsOrderId = bsOrderId;
    }

    /** 订单：买手订单编号 */
    private String bsOrderCode;
    /** 订单：买手订单参考号 */
    private String backNo;
    /**
     * 获取订单：买手订单编号
     * 
     * @return 订单：买手订单编号
     */
    public String getBsOrderCode() {
        return this.bsOrderCode;
    }

    /**
     * 设置订单：买手订单编号
     * 
     * @param bsOrderCode
     */
    public void setBsOrderCode(String bsOrderCode) {
        this.bsOrderCode = bsOrderCode;
    }

    /** 订单：订单类型 [CodeMaster] */
    private String orderType;

    /**
     * 获取订单：订单类型 [CodeMaster]
     * 
     * @return 订单：订单类型 [CodeMaster]
     */
    public String getOrderType() {
        return this.orderType;
    }

    /**
     * 设置订单：订单类型 [CodeMaster]
     * 
     * @param orderType
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /** 订单：销售平台 [CodeMaster 美侍客等] */
    private String salePlatformType;

    /**
     * 获取订单：销售平台 [CodeMaster 美侍客等]
     * 
     * @return 订单：销售平台 [CodeMaster 美侍客等]
     */
    public String getSalePlatformType() {
        return this.salePlatformType;
    }

    /**
     * 设置订单：销售平台 [CodeMaster 美侍客等]
     * 
     * @param salePlatformType
     */
    public void setSalePlatformType(String salePlatformType) {
        this.salePlatformType = salePlatformType;
    }

    /** 订单：订单来源 [CodeMaster APP、客户端等] */
    private String orderSourceType;

    /**
     * 获取订单：订单来源 [CodeMaster APP、客户端等]
     * 
     * @return 订单：订单来源 [CodeMaster APP、客户端等]
     */
    public String getOrderSourceType() {
        return this.orderSourceType;
    }

    /**
     * 设置订单：订单来源 [CodeMaster APP、客户端等]
     * 
     * @param orderSourceType
     */
    public void setOrderSourceType(String orderSourceType) {
        this.orderSourceType = orderSourceType;
    }

    /** 下单：下单员ID */
    private String orderPlacerId;

    /**
     * 获取下单：下单员ID
     * 
     * @return 下单：下单员ID
     */
    public String getOrderPlacerId() {
        return this.orderPlacerId;
    }

    /**
     * 设置下单：下单员ID
     * 
     * @param orderPlacerId
     */
    public void setOrderPlacerId(String orderPlacerId) {
        this.orderPlacerId = orderPlacerId;
    }

    /** 下单：下单员类型 [CodeMaster 【是否需要】] */
    private String orderPlacerType;

    /**
     * 获取下单：下单员类型 [CodeMaster 【是否需要】]
     * 
     * @return 下单：下单员类型 [CodeMaster 【是否需要】]
     */
    public String getOrderPlacerType() {
        return this.orderPlacerType;
    }

    /**
     * 设置下单：下单员类型 [CodeMaster 【是否需要】]
     * 
     * @param orderPlacerType
     */
    public void setOrderPlacerType(String orderPlacerType) {
        this.orderPlacerType = orderPlacerType;
    }

    /** 下单：下单时间 [【是否需要】] */
    private Date orderPlaceDatetime;

    /**
     * 获取下单：下单时间 [【是否需要】]
     * 
     * @return 下单：下单时间 [【是否需要】]
     */
    public Date getOrderPlaceDatetime() {
        return this.orderPlaceDatetime;
    }

    /**
     * 设置下单：下单时间 [【是否需要】]
     * 
     * @param orderPlaceDatetime
     */
    public void setOrderPlaceDatetime(Date orderPlaceDatetime) {
        this.orderPlaceDatetime = orderPlaceDatetime;
    }

    /**
     * 下单：订单创建时间
     */
    private Date orderCreateDatetime;

    /**
     * 获取下单：订单创建时间
     *
     * @return 下单：订单创建时间
     */
    public Date getOrderCreateDatetime() {
        return this.orderCreateDatetime;
    }

    /**
     * 设置下单：订单创建时间
     *
     * @param orderCreateDatetime
     */
    public void setOrderCreateDatetime(Date orderCreateDatetime) {
        this.orderCreateDatetime = orderCreateDatetime;
    }

    /** 区域：物流区ID */
    private Long logisticsZoneId;

    /**
     * 获取区域：物流区ID
     * 
     * @return 区域：物流区ID
     */
    public Long getLogisticsZoneId() {
        return this.logisticsZoneId;
    }

    /**
     * 设置区域：物流区ID
     * 
     * @param logisticsZoneId
     */
    public void setLogisticsZoneId(Long logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    /** 买手：买手ID [【需要和买手确认】] */
    private String bsId;

    /**
     * 获取买手：买手ID [【需要和买手确认】]
     * 
     * @return 买手：买手ID [【需要和买手确认】]
     */
    public String getBsId() {
        return this.bsId;
    }

    /**
     * 设置买手：买手ID [【需要和买手确认】]
     * 
     * @param bsId
     */
    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    /** 支付：支付状态 [codemaster] */
    private String paymentStu;

    /**
     * 获取支付：支付状态 [codemaster]
     * 
     * @return 支付：支付状态 [codemaster]
     */
    public String getPaymentStu() {
        return this.paymentStu;
    }

    /**
     * 设置支付：支付状态 [codemaster]
     * 
     * @param paymentStu
     */
    public void setPaymentStu(String paymentStu) {
        this.paymentStu = paymentStu;
    }

    /** 支付：是否开具发票 */
    private Boolean invoiceFlg;

    /**
     * 获取支付：是否开具发票
     * 
     * @return 支付：是否开具发票
     */
    public Boolean getInvoiceFlg() {
        return this.invoiceFlg;
    }

    /**
     * 设置支付：是否开具发票
     * 
     * @param invoiceFlg
     */
    public void setInvoiceFlg(Boolean invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    /** 支付：是否使用账期 */
    private Boolean useNetFlg;

    /**
     * 获取支付：是否使用账期
     * 
     * @return 支付：是否使用账期
     */
    public Boolean getUseNetFlg() {
        return this.useNetFlg;
    }

    /**
     * 设置支付：是否使用账期
     * 
     * @param useNetFlg
     */
    public void setUseNetFlg(Boolean useNetFlg) {
        this.useNetFlg = useNetFlg;
    }

    /** 支付：订单金额 [订单金额-优惠金额=订单总额] */
    private BigDecimal orderAmount;

    /**
     * 获取支付：订单金额 [订单金额-优惠金额=订单总额]
     * 
     * @return 支付：订单金额 [订单金额-优惠金额=订单总额]
     */
    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }

    /**
     * 设置支付：订单金额 [订单金额-优惠金额=订单总额]
     * 
     * @param orderAmount
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /** 支付：优惠金额 */
    private BigDecimal preferentialAmount;

    /**
     * 获取支付：优惠金额
     * 
     * @return 支付：优惠金额
     */
    public BigDecimal getPreferentialAmount() {
        return this.preferentialAmount;
    }

    /**
     * 设置支付：优惠金额
     * 
     * @param preferentialAmount
     */
    public void setPreferentialAmount(BigDecimal preferentialAmount) {
        this.preferentialAmount = preferentialAmount;
    }

    /** 支付：已收金额 [订单总额-已收金额=尾款金额] */
    private BigDecimal receiveAmount;

    /**
     * 获取支付：已收金额 [订单总额-已收金额=尾款金额]
     * 
     * @return 支付：已收金额 [订单总额-已收金额=尾款金额]
     */
    public BigDecimal getReceiveAmount() {
        return this.receiveAmount;
    }

    /**
     * 设置支付：已收金额 [订单总额-已收金额=尾款金额]
     * 
     * @param receiveAmount
     */
    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    /** 支付：定金应付比例 */
    private BigDecimal earnestPercent;

    /**
     * 获取支付：定金应付比例
     * 
     * @return 支付：定金应付比例
     */
    public BigDecimal getEarnestPercent() {
        return this.earnestPercent;
    }

    /**
     * 设置支付：定金应付比例
     * 
     * @param earnestPercent
     */
    public void setEarnestPercent(BigDecimal earnestPercent) {
        this.earnestPercent = earnestPercent;
    }

    /** 支付：定金应付金额 */
    private BigDecimal earnestAmount;

    /**
     * 获取支付：定金应付金额
     * 
     * @return 支付：定金应付金额
     */
    public BigDecimal getEarnestAmount() {
        return this.earnestAmount;
    }

    /**
     * 设置支付：定金应付金额
     * 
     * @param earnestAmount
     */
    public void setEarnestAmount(BigDecimal earnestAmount) {
        this.earnestAmount = earnestAmount;
    }

    /** 支付：应预付比例 */
    private BigDecimal advancePaymentPercent;

    /**
     * 获取支付：应预付比例
     * 
     * @return 支付：应预付比例
     */
    public BigDecimal getAdvancePaymentPercent() {
        return this.advancePaymentPercent;
    }

    /**
     * 设置支付：应预付比例
     * 
     * @param advancePaymentPercent
     */
    public void setAdvancePaymentPercent(BigDecimal advancePaymentPercent) {
        this.advancePaymentPercent = advancePaymentPercent;
    }

    /** 支付：应预付金额 */
    private BigDecimal advancePaymentAmount;

    /**
     * 获取支付：应预付金额
     * 
     * @return 支付：应预付金额
     */
    public BigDecimal getAdvancePaymentAmount() {
        return this.advancePaymentAmount;
    }

    /**
     * 设置支付：应预付金额
     * 
     * @param advancePaymentAmount
     */
    public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    /** 状态：买手订单状态 */
    private String bsOrderStu;

    /**
     * 获取状态：买手订单状态
     * 
     * @return 状态：买手订单状态
     */
    public String getBsOrderStu() {
        return this.bsOrderStu;
    }

    /**
     * 设置状态：买手订单状态
     * 
     * @param bsOrderStu
     */
    public void setBsOrderStu(String bsOrderStu) {
        this.bsOrderStu = bsOrderStu;
    }

    /** 下单：下单员编码 [【需要和买家 买手 管家 平台订单人员 确认】] */
    private String orderPlacerCode;

    /**
     * 获取下单：下单员编码 [【需要和买家 买手 管家 平台订单人员 确认】]
     * 
     * @return 下单：下单员编码 [【需要和买家 买手 管家 平台订单人员 确认】]
     */
    public String getOrderPlacerCode() {
        return this.orderPlacerCode;
    }

    /**
     * 设置下单：下单员编码 [【需要和买家 买手 管家 平台订单人员 确认】]
     * 
     * @param orderPlacerCode
     */
    public void setOrderPlacerCode(String orderPlacerCode) {
        this.orderPlacerCode = orderPlacerCode;
    }

    /** 下单：下单员名称 [【需要和买家 买手 管家 订单人员确认】] */
    private String orderPlacerName;

    /**
     * 获取下单：下单员名称 [【需要和买家 买手 管家 订单人员确认】]
     * 
     * @return 下单：下单员名称 [【需要和买家 买手 管家 订单人员确认】]
     */
    public String getOrderPlacerName() {
        return this.orderPlacerName;
    }

    /**
     * 设置下单：下单员名称 [【需要和买家 买手 管家 订单人员确认】]
     * 
     * @param orderPlacerName
     */
    public void setOrderPlacerName(String orderPlacerName) {
        this.orderPlacerName = orderPlacerName;
    }

    /** 区域：物流区编码 [【类型待定】] */
    private String logisticsZoneCode;

    /**
     * 获取区域：物流区编码 [【类型待定】]
     * 
     * @return 区域：物流区编码 [【类型待定】]
     */
    public String getLogisticsZoneCode() {
        return this.logisticsZoneCode;
    }

    /**
     * 设置区域：物流区编码 [【类型待定】]
     * 
     * @param logisticsZoneCode
     */
    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }

    /** 区域：物流区名称 [【类型待定】] */
    private String logisticsZoneName;

    /**
     * 获取区域：物流区名称 [【类型待定】]
     * 
     * @return 区域：物流区名称 [【类型待定】]
     */
    public String getLogisticsZoneName() {
        return this.logisticsZoneName;
    }

    /**
     * 设置区域：物流区名称 [【类型待定】]
     * 
     * @param logisticsZoneName
     */
    public void setLogisticsZoneName(String logisticsZoneName) {
        this.logisticsZoneName = logisticsZoneName;
    }

    /** 区域：区县ID */
    private Long countryId;

    /**
     * 获取区域：区县ID
     * 
     * @return 区域：区县ID
     */
    public Long getCountryId() {
        return this.countryId;
    }

    /**
     * 设置区域：区县ID
     * 
     * @param countryId
     */
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    /** 区域：区县名称 [【类型待定】] */
    private String countryName;

    /**
     * 获取区域：区县名称 [【类型待定】]
     * 
     * @return 区域：区县名称 [【类型待定】]
     */
    public String getCountryName() {
        return this.countryName;
    }

    /**
     * 设置区域：区县名称 [【类型待定】]
     * 
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /** 区域：城市ID */
    private Long cityId;

    /**
     * 获取区域：城市ID
     * 
     * @return 区域：城市ID
     */
    public Long getCityId() {
        return this.cityId;
    }

    /**
     * 设置区域：城市ID
     * 
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /** 区域：城市名称 [【类型待定】] */
    private String cityName;

    /**
     * 获取区域：城市名称 [【类型待定】]
     * 
     * @return 区域：城市名称 [【类型待定】]
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     * 设置区域：城市名称 [【类型待定】]
     * 
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /** 买手：买手编码 [【需要和买手确认】] */
    private String bsCode;

    /**
     * 获取买手：买手编码 [【需要和买手确认】]
     * 
     * @return 买手：买手编码 [【需要和买手确认】]
     */
    public String getBsCode() {
        return this.bsCode;
    }

    /**
     * 设置买手：买手编码 [【需要和买手确认】]
     * 
     * @param bsCode
     */
    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    /** 买手：买手名称 [【需要和买手确认】] */
    private String bsName;

    /**
     * 获取买手：买手名称 [【需要和买手确认】]
     * 
     * @return 买手：买手名称 [【需要和买手确认】]
     */
    public String getBsName() {
        return this.bsName;
    }

    /**
     * 设置买手：买手名称 [【需要和买手确认】]
     * 
     * @param bsName
     */
    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    /** 买手：买手类型 */
    private String bsType;

    /**
     * 获取买手：买手类型
     * 
     * @return 买手：买手类型
     */
    public String getBsType() {
        return this.bsType;
    }

    /**
     * 设置买手：买手类型
     * 
     * @param bsType
     */
    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    private Integer sortSeq;

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }
}
