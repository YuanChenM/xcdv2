package com.bms.issue.external.bean.result;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bms.issue.common.rest.result.RestSearchData;


/**
 * 买家订单查询接口Result
 *
 * @author li_huiqian
 */
public class ORDR0105IL1RestResult extends RestSearchData {

    /**
     * 
     */
    private static final long serialVersionUID = -8552794987581260234L;
    /**
     * 买家分批订单
     */
    private List<ORDR0105IL2RestResult> batchOrders;

    /**
     * @return the batchOrders
     */
    public List<ORDR0105IL2RestResult> getBatchOrders() {
        return batchOrders;
    }

    /**
     * @param batchOrders
     *            the batchOrders to set
     */
    public void setBatchOrders(List<ORDR0105IL2RestResult> batchOrders) {
        this.batchOrders = batchOrders;
    }

    /** 订单：买家订单ID */
    private Long buyerOrderId;

    /**
     * 获取订单：买家订单ID
     * 
     * @return 订单：买家订单ID
     */
    public Long getBuyerOrderId() {
        return this.buyerOrderId;
    }

    /**
     * 设置订单：买家订单ID
     * 
     * @param buyerOrderId
     */
    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    /** 订单：买家订单编号 */
    private String buyerOrderCode;

    /**
     * 获取订单：买家订单编号
     * 
     * @return 订单：买家订单编号
     */
    public String getBuyerOrderCode() {
        return this.buyerOrderCode;
    }

    /**
     * 设置订单：买家订单编号
     * 
     * @param buyerOrderCode
     */
    public void setBuyerOrderCode(String buyerOrderCode) {
        this.buyerOrderCode = buyerOrderCode;
    }

    /** 订单：订单类型 [CodeMaster A类分批订单，A类标准订单，B类分批订单，B类标准订单] */
    private String orderType;

    /**
     * 获取订单：订单类型 [CodeMaster A类分批订单，A类标准订单，B类分批订单，B类标准订单]
     * 
     * @return 订单：订单类型 [CodeMaster A类分批订单，A类标准订单，B类分批订单，B类标准订单]
     */
    public String getOrderType() {
        return this.orderType;
    }

    /**
     * 设置订单：订单类型 [CodeMaster A类分批订单，A类标准订单，B类分批订单，B类标准订单]
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

    /** 订单：是否分批 */
    private Boolean batchFlg;

    /**
     * 获取订单：是否分批
     * 
     * @return 订单：是否分批
     */
    public Boolean getBatchFlg() {
        return this.batchFlg;
    }

    /**
     * 设置订单：是否分批
     * 
     * @param batchFlg
     */
    public void setBatchFlg(Boolean batchFlg) {
        this.batchFlg = batchFlg;
    }

    /** 订单：分拆规则 [CodeMaster 按订单分拆、按分批订单分拆] */
    private String orderSplitType;

    /**
     * 获取订单：分拆规则 [CodeMaster 按订单分拆、按分批订单分拆]
     * 
     * @return 订单：分拆规则 [CodeMaster 按订单分拆、按分批订单分拆]
     */
    public String getOrderSplitType() {
        return this.orderSplitType;
    }

    /**
     * 设置订单：分拆规则 [CodeMaster 按订单分拆、按分批订单分拆]
     * 
     * @param orderSplitType
     */
    public void setOrderSplitType(String orderSplitType) {
        this.orderSplitType = orderSplitType;
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

    /** 下单：下单员类型 [CodeMaster] */
    private String orderPlacerType;

    /**
     * 获取下单：下单员类型 [CodeMaster]
     * 
     * @return 下单：下单员类型 [CodeMaster]
     */
    public String getOrderPlacerType() {
        return this.orderPlacerType;
    }

    /**
     * 设置下单：下单员类型 [CodeMaster]
     * 
     * @param orderPlacerType
     */
    public void setOrderPlacerType(String orderPlacerType) {
        this.orderPlacerType = orderPlacerType;
    }

    /** 下单：下单时间 [订单日期] */
    private Date orderPlaceDatetime;

    /**
     * 获取下单：下单时间 [订单日期]
     * 
     * @return 下单：下单时间 [订单日期]
     */
    public Date getOrderPlaceDatetime() {
        return this.orderPlaceDatetime;
    }

    /**
     * 设置下单：下单时间 [订单日期]
     * 
     * @param orderPlaceDatetime
     */
    public void setOrderPlaceDatetime(Date orderPlaceDatetime) {
        this.orderPlaceDatetime = orderPlaceDatetime;
    }

    /** 下单：下单类型 [CodeMaster] */
    private String orderPlaceType;

    /**
     * 获取下单：下单类型 [CodeMaster]
     * 
     * @return 下单：下单类型 [CodeMaster]
     */
    public String getOrderPlaceType() {
        return this.orderPlaceType;
    }

    /**
     * 设置下单：下单类型 [CodeMaster]
     * 
     * @param orderPlaceType
     */
    public void setOrderPlaceType(String orderPlaceType) {
        this.orderPlaceType = orderPlaceType;
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

    /** 买家：买家类型 [CodeMaster] */
    private String buyerType;

    /**
     * 获取买家：买家类型 [CodeMaster]
     * 
     * @return 买家：买家类型 [CodeMaster]
     */
    public String getBuyerType() {
        return this.buyerType;
    }

    /**
     * 设置买家：买家类型 [CodeMaster]
     * 
     * @param buyerType
     */
    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    /** 买家：买家类型名称 */
    private String buyerTypeName;

    /**
     * 获取买家：买家类型名称
     * 
     * @return 买家：买家类型名称
     */
    public String getBuyerTypeName() {
        return this.buyerTypeName;
    }

    /**
     * 设置买家：买家类型名称
     * 
     * @param buyerTypeName
     */
    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }

    /** 买家：买家ID [【需要和买家确认】] */
    private String buyerId;

    /**
     * 获取买家：买家ID [【需要和买家确认】]
     * 
     * @return 买家：买家ID [【需要和买家确认】]
     */
    public String getBuyerId() {
        return this.buyerId;
    }

    /**
     * 设置买家：买家ID [【需要和买家确认】]
     * 
     * @param buyerId
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    /** 买家：专属买手类型 [CodeMaster 区域买手、非区域买手、区域分销买手、账期用户买手] */
    private String bsType;

    /**
     * 获取买家：专属买手类型 [CodeMaster 区域买手、非区域买手、区域分销买手、账期用户买手]
     * 
     * @return 买家：专属买手类型 [CodeMaster 区域买手、非区域买手、区域分销买手、账期用户买手]
     */
    public String getBsType() {
        return this.bsType;
    }

    /**
     * 设置买家：专属买手类型 [CodeMaster 区域买手、非区域买手、区域分销买手、账期用户买手]
     * 
     * @param bsType
     */
    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    /** 买家：专属买手ID [【需要和买手确认】] */
    private String bsId;

    /**
     * 获取买家：专属买手ID [【需要和买手确认】]
     * 
     * @return 买家：专属买手ID [【需要和买手确认】]
     */
    public String getBsId() {
        return this.bsId;
    }

    /**
     * 设置买家：专属买手ID [【需要和买手确认】]
     * 
     * @param bsId
     */
    public void setBsId(String bsId) {
        this.bsId = bsId;
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

    /** 支付：是否是账期买家 */
    private Boolean netBuyerFlg;

    /**
     * 获取支付：是否是账期买家
     * 
     * @return 支付：是否是账期买家
     */
    public Boolean getNetBuyerFlg() {
        return this.netBuyerFlg;
    }

    /**
     * 设置支付：是否是账期买家
     * 
     * @param netBuyerFlg
     */
    public void setNetBuyerFlg(Boolean netBuyerFlg) {
        this.netBuyerFlg = netBuyerFlg;
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

    /** 支付：付款类型 */
    private String paymentType;

    /**
     * 获取支付：付款类型
     * 
     * @return 支付：付款类型
     */
    public String getPaymentType() {
        return this.paymentType;
    }

    /**
     * 设置支付：付款类型
     * 
     * @param paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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

    /** 支付：订单金额 [订单金额+运费金额-优惠金额=订单总额] */
    private BigDecimal orderAmount;

    /**
     * 获取支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
     * 
     * @return 支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
     */
    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }

    /**
     * 设置支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
     * 
     * @param orderAmount
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /** 支付：运费金额 [分批订单运费合计] */
    private BigDecimal freight;

    /**
     * 获取支付：运费金额 [分批订单运费合计]
     * 
     * @return 支付：运费金额 [分批订单运费合计]
     */
    public BigDecimal getFreight() {
        return this.freight;
    }

    /**
     * 设置支付：运费金额 [分批订单运费合计]
     * 
     * @param freight
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    /** 支付：优惠金额 [分批订单优惠合计] */
    private BigDecimal preferentialAmount;

    /**
     * 获取支付：优惠金额 [分批订单优惠合计]
     * 
     * @return 支付：优惠金额 [分批订单优惠合计]
     */
    public BigDecimal getPreferentialAmount() {
        return this.preferentialAmount;
    }

    /**
     * 设置支付：优惠金额 [分批订单优惠合计]
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

    /** 状态：买家订单状态 */
    private String buyerOrderStu;

    /**
     * 获取状态：买家订单状态
     * 
     * @return 状态：买家订单状态
     */
    public String getBuyerOrderStu() {
        return this.buyerOrderStu;
    }

    /**
     * 设置状态：买家订单状态
     * 
     * @param buyerOrderStu
     */
    public void setBuyerOrderStu(String buyerOrderStu) {
        this.buyerOrderStu = buyerOrderStu;
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

    /** 区域：物流区编码 */
    private String logisticsZoneCode;

    /**
     * 获取区域：物流区编码
     * 
     * @return 区域：物流区编码
     */
    public String getLogisticsZoneCode() {
        return this.logisticsZoneCode;
    }

    /**
     * 设置区域：物流区编码
     * 
     * @param logisticsZoneCode
     */
    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }

    /** 区域：物流区名称 */
    private String logisticsZoneName;

    /**
     * 获取区域：物流区名称
     * 
     * @return 区域：物流区名称
     */
    public String getLogisticsZoneName() {
        return this.logisticsZoneName;
    }

    /**
     * 设置区域：物流区名称
     * 
     * @param logisticsZoneName
     */
    public void setLogisticsZoneName(String logisticsZoneName) {
        this.logisticsZoneName = logisticsZoneName;
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

    /** 区域：城市编码 */
    private String cityCode;

    /**
     * 获取区域：城市编码
     * 
     * @return 区域：城市编码
     */
    public String getCityCode() {
        return this.cityCode;
    }

    /**
     * 设置区域：城市编码
     * 
     * @param cityName
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /** 区域：城市名称 */
    private String cityName;

    /**
     * 获取区域：城市名称
     * 
     * @return 区域：城市名称
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     * 设置区域：城市名称
     * 
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    /** 区域：区县编码 */
    private String countryCode;

    /**
     * 获取区域：区县编码
     * 
     * @return 区域：区县编码
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * 设置区域：区县编码
     * 
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /** 区域：区县名称 */
    private String countryName;

    /**
     * 获取区域：区县名称
     * 
     * @return 区域：区县名称
     */
    public String getCountryName() {
        return this.countryName;
    }

    /**
     * 设置区域：区县名称
     * 
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /** 区域：区域配送站ID */
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

    /** 区域：区域配送站编码 */
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

    /** 区域：区域配送站名称 */
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

    /** 买家：买家编码 */
    private String buyerCode;

    /**
     * 获取买家：买家编码
     * 
     * @return 买家：买家编码
     */
    public String getBuyerCode() {
        return this.buyerCode;
    }

    /**
     * 设置买家：买家编码
     * 
     * @param buyerCode
     */
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    /** 买家：买家名称 */
    private String buyerName;

    /**
     * 获取买家：买家名称
     * 
     * @return 买家：买家名称
     */
    public String getBuyerName() {
        return this.buyerName;
    }

    /**
     * 设置买家：买家名称
     * 
     * @param buyerName
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    /** 买家：买家联系电话 */
    private String buyerPhone;

    /**
     * 获取买家：买家联系电话
     * 
     * @return 买家：买家联系电话
     */
    public String getBuyerPhone() {
        return this.buyerPhone;
    }

    /**
     * 设置买家：买家联系电话
     * 
     * @param buyerPhone
     */
    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    /** 买家：买家微信号 */
    private String buyerWechat;

    /**
     * 获取买家：买家微信号
     * 
     * @return 买家：买家微信号
     */
    public String getBuyerWechat() {
        return this.buyerWechat;
    }

    /**
     * 设置买家：买家微信号
     * 
     * @param buyerWechat
     */
    public void setBuyerWechat(String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }

    /** 买家：买家QQ */
    private String buyerQq;

    /**
     * 获取买家：买家QQ
     * 
     * @return 买家：买家QQ
     */
    public String getBuyerQq() {
        return this.buyerQq;
    }

    /**
     * 设置买家：买家QQ
     * 
     * @param buyerQq
     */
    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }

    /** 买家：买家邮箱 */
    private String buyerMail;

    /**
     * 获取买家：买家邮箱
     * 
     * @return 买家：买家邮箱
     */
    public String getBuyerMail() {
        return this.buyerMail;
    }

    /**
     * 设置买家：买家邮箱
     * 
     * @param buyerMail
     */
    public void setBuyerMail(String buyerMail) {
        this.buyerMail = buyerMail;
    }

    /** 买家：区域买手ID [【需要和买手确认】] */
    private String regionalBsId;

    /**
     * 获取买家：区域买手ID [【需要和买手确认】]
     * 
     * @return 买家：区域买手ID [【需要和买手确认】]
     */
    public String getRegionalBsId() {
        return this.regionalBsId;
    }

    /**
     * 设置买家：区域买手ID [【需要和买手确认】]
     * 
     * @param regionalBsId
     */
    public void setRegionalBsId(String regionalBsId) {
        this.regionalBsId = regionalBsId;
    }

    /** 买家：区域买手编码 [【需要和买手确认】] */
    private String regionalBsCode;

    /**
     * 获取买家：区域买手编码 [【需要和买手确认】]
     * 
     * @return 买家：区域买手编码 [【需要和买手确认】]
     */
    public String getRegionalBsCode() {
        return this.regionalBsCode;
    }

    /**
     * 设置买家：区域买手编码 [【需要和买手确认】]
     * 
     * @param regionalBsCode
     */
    public void setRegionalBsCode(String regionalBsCode) {
        this.regionalBsCode = regionalBsCode;
    }

    /** 买家：区域买手名称 [【需要和买手确认】] */
    private String regionalBsName;

    /**
     * 获取买家：区域买手名称 [【需要和买手确认】]
     * 
     * @return 买家：区域买手名称 [【需要和买手确认】]
     */
    public String getRegionalBsName() {
        return this.regionalBsName;
    }

    /**
     * 设置买家：区域买手名称 [【需要和买手确认】]
     * 
     * @param regionalBsName
     */
    public void setRegionalBsName(String regionalBsName) {
        this.regionalBsName = regionalBsName;
    }

    /** 买家：非区域买手ID [【需要和买手确认】] */
    private String nonRegionalBsId;

    /**
     * 获取买家：非区域买手ID [【需要和买手确认】]
     * 
     * @return 买家：非区域买手ID [【需要和买手确认】]
     */
    public String getNonRegionalBsId() {
        return this.nonRegionalBsId;
    }

    /**
     * 设置买家：非区域买手ID [【需要和买手确认】]
     * 
     * @param nonRegionalBsId
     */
    public void setNonRegionalBsId(String nonRegionalBsId) {
        this.nonRegionalBsId = nonRegionalBsId;
    }

    /** 买家：非区域买手编码 [【需要和买手确认】] */
    private String nonRegionalBsCode;

    /**
     * 获取买家：非区域买手编码 [【需要和买手确认】]
     * 
     * @return 买家：非区域买手编码 [【需要和买手确认】]
     */
    public String getNonRegionalBsCode() {
        return this.nonRegionalBsCode;
    }

    /**
     * 设置买家：非区域买手编码 [【需要和买手确认】]
     * 
     * @param nonRegionalBsCode
     */
    public void setNonRegionalBsCode(String nonRegionalBsCode) {
        this.nonRegionalBsCode = nonRegionalBsCode;
    }

    /** 买家：非区域买手名称 [【需要和买手确认】] */
    private String nonRegionalBsName;

    /**
     * 获取买家：非区域买手名称 [【需要和买手确认】]
     * 
     * @return 买家：非区域买手名称 [【需要和买手确认】]
     */
    public String getNonRegionalBsName() {
        return this.nonRegionalBsName;
    }

    /**
     * 设置买家：非区域买手名称 [【需要和买手确认】]
     * 
     * @param nonRegionalBsName
     */
    public void setNonRegionalBsName(String nonRegionalBsName) {
        this.nonRegionalBsName = nonRegionalBsName;
    }

    /** 买家：区域分销买手ID [【需要和买手确认】] */
    private String regionalDistributionBsId;

    /**
     * 获取买家：区域分销买手ID [【需要和买手确认】]
     * 
     * @return 买家：区域分销买手ID [【需要和买手确认】]
     */
    public String getRegionalDistributionBsId() {
        return this.regionalDistributionBsId;
    }

    /**
     * 设置买家：区域分销买手ID [【需要和买手确认】]
     * 
     * @param regionalDistributionBsId
     */
    public void setRegionalDistributionBsId(String regionalDistributionBsId) {
        this.regionalDistributionBsId = regionalDistributionBsId;
    }

    /** 买家：区域分销买手编码 [【需要和买手确认】] */
    private String regionalDistributionBsCode;

    /**
     * 获取买家：区域分销买手编码 [【需要和买手确认】]
     * 
     * @return 买家：区域分销买手编码 [【需要和买手确认】]
     */
    public String getRegionalDistributionBsCode() {
        return this.regionalDistributionBsCode;
    }

    /**
     * 设置买家：区域分销买手编码 [【需要和买手确认】]
     * 
     * @param regionalDistributionBsCode
     */
    public void setRegionalDistributionBsCode(String regionalDistributionBsCode) {
        this.regionalDistributionBsCode = regionalDistributionBsCode;
    }

    /** 买家：区域分销买手名称 [【需要和买手确认】] */
    private String regionalDistributionBsName;

    /**
     * 获取买家：区域分销买手名称 [【需要和买手确认】]
     * 
     * @return 买家：区域分销买手名称 [【需要和买手确认】]
     */
    public String getRegionalDistributionBsName() {
        return this.regionalDistributionBsName;
    }

    /**
     * 设置买家：区域分销买手名称 [【需要和买手确认】]
     * 
     * @param regionalDistributionBsName
     */
    public void setRegionalDistributionBsName(String regionalDistributionBsName) {
        this.regionalDistributionBsName = regionalDistributionBsName;
    }

    /** 买家：账期用户买手ID [【需要和买手确认】] */
    private String netUserBsId;

    /**
     * 获取买家：账期用户买手ID [【需要和买手确认】]
     * 
     * @return 买家：账期用户买手ID [【需要和买手确认】]
     */
    public String getNetUserBsId() {
        return this.netUserBsId;
    }

    /**
     * 设置买家：账期用户买手ID [【需要和买手确认】]
     * 
     * @param netUserBsId
     */
    public void setNetUserBsId(String netUserBsId) {
        this.netUserBsId = netUserBsId;
    }

    /** 买家：账期用户买手编码 [【需要和买手确认】] */
    private String netUserBsCode;

    /**
     * 获取买家：账期用户买手编码 [【需要和买手确认】]
     * 
     * @return 买家：账期用户买手编码 [【需要和买手确认】]
     */
    public String getNetUserBsCode() {
        return this.netUserBsCode;
    }

    /**
     * 设置买家：账期用户买手编码 [【需要和买手确认】]
     * 
     * @param netUserBsCode
     */
    public void setNetUserBsCode(String netUserBsCode) {
        this.netUserBsCode = netUserBsCode;
    }

    /** 买家：账期用户买手名称 [【需要和买手确认】] */
    private String netUserBsName;

    /**
     * 获取买家：账期用户买手名称 [【需要和买手确认】]
     * 
     * @return 买家：账期用户买手名称 [【需要和买手确认】]
     */
    public String getNetUserBsName() {
        return this.netUserBsName;
    }

    public String getCancelPersonId() {
        return cancelPersonId;
    }

    public void setCancelPersonId(String cancelPersonId) {
        this.cancelPersonId = cancelPersonId;
    }

    /**

     * 设置买家：账期用户买手名称 [【需要和买手确认】]
     * 
     * @param netUserBsName
     */
    public void setNetUserBsName(String netUserBsName) {
        this.netUserBsName = netUserBsName;
    }

    /** 买家：冻品管家ID [【需要和买手确认】] */
    private String saId;

    /**
     * 获取买家：冻品管家ID [【需要和买手确认】]
     * 
     * @return 买家：冻品管家ID [【需要和买手确认】]
     */
    public String getSaId() {
        return this.saId;
    }

    /**
     * 设置买家：冻品管家ID [【需要和买手确认】]
     * 
     * @param saId
     */
    public void setSaId(String saId) {
        this.saId = saId;
    }

    /** 买家：冻品管家编码 [【需要和买手确认】] */
    private String saCode;

    /**
     * 获取买家：冻品管家编码 [【需要和买手确认】]
     * 
     * @return 买家：冻品管家编码 [【需要和买手确认】]
     */
    public String getSaCode() {
        return this.saCode;
    }

    /**
     * 设置买家：冻品管家编码 [【需要和买手确认】]
     * 
     * @param saCode
     */
    public void setSaCode(String saCode) {
        this.saCode = saCode;
    }

    /** 买家：冻品管家名称 [【需要和买手确认】] */
    private String saName;

    /**
     * 获取买家：冻品管家名称 [【需要和买手确认】]
     * 
     * @return 买家：冻品管家名称 [【需要和买手确认】]
     */
    public String getSaName() {
        return this.saName;
    }

    /**
     * 设置买家：冻品管家名称 [【需要和买手确认】]
     * 
     * @param saName
     */
    public void setSaName(String saName) {
        this.saName = saName;
    }

    /** 取消：取消模式 [全部取消/部分取消] */
    private String cancelType;

    /**
     * 获取取消：取消模式 [全部取消/部分取消]
     * 
     * @return 取消：取消模式 [全部取消/部分取消]
     */
    public String getCancelType() {
        return this.cancelType;
    }

    /**
     * 设置取消：取消模式 [全部取消/部分取消]
     * 
     * @param cancelType
     */
    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    /** 取消：取消人类型 */
    private String cancelPersonType;

    /**
     * 获取取消：取消人类型
     * 
     * @return 取消：取消人类型
     */
    public String getCancelPersonType() {
        return this.cancelPersonType;
    }

    /**
     * 设置取消：取消人类型
     * 
     * @param cancelPersonType
     */
    public void setCancelPersonType(String cancelPersonType) {
        this.cancelPersonType = cancelPersonType;
    }

    /** 取消：取消人ID */
    private String cancelPersonId;


    /** 取消：取消人编码 [【需要与买家 买手 管家 平台人员确认】] */
    private String cancelPersonCode;

    /**
     * 获取取消：取消人编码 [【需要与买家 买手 管家 平台人员确认】]
     * 
     * @return 取消：取消人编码 [【需要与买家 买手 管家 平台人员确认】]
     */
    public String getCancelPersonCode() {
        return this.cancelPersonCode;
    }

    /**
     * 设置取消：取消人编码 [【需要与买家 买手 管家 平台人员确认】]
     * 
     * @param cancelPersonCode
     */
    public void setCancelPersonCode(String cancelPersonCode) {
        this.cancelPersonCode = cancelPersonCode;
    }

    /** 取消：取消人名称 [【需要与买家 买手 管家 平台人员确认】] */
    private String cancelPersonName;

    /**
     * 获取取消：取消人名称 [【需要与买家 买手 管家 平台人员确认】]
     * 
     * @return 取消：取消人名称 [【需要与买家 买手 管家 平台人员确认】]
     */
    public String getCancelPersonName() {
        return this.cancelPersonName;
    }

    /**
     * 设置取消：取消人名称 [【需要与买家 买手 管家 平台人员确认】]
     * 
     * @param cancelPersonName
     */
    public void setCancelPersonName(String cancelPersonName) {
        this.cancelPersonName = cancelPersonName;
    }

    /** 取消：取消时间 */
    private Date cancelDatetime;

    /**
     * 获取取消：取消时间
     * 
     * @return 取消：取消时间
     */
    public Date getCancelDatetime() {
        return this.cancelDatetime;
    }

    /**
     * 设置取消：取消时间
     * 
     * @param cancelDatetime
     */
    public void setCancelDatetime(Date cancelDatetime) {
        this.cancelDatetime = cancelDatetime;
    }

    /** 取消：取消原因 */
    private String cancelReason;

    /**
     * 获取取消：取消原因
     * 
     * @return 取消：取消原因
     */
    public String getCancelReason() {
        return this.cancelReason;
    }

    /**
     * 设置取消：取消原因
     * 
     * @param cancelReason
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
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

}
