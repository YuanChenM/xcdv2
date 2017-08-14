package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class BuyerOrderEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 订单：买家订单ID
     */
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

    /**
     * 订单：买家订单编号
     */
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

    /**
     * 订单：订单类型 [CodeMaster A类分批订单，A类标准订单，B类分批订单，B类标准订单]
     */
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

    /**
     * 订单：销售平台 [CodeMaster 美侍客等]
     */
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

    /**
     * 订单：订单来源 [CodeMaster APP、客户端等]
     */
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

    /**
     * 订单：是否分批
     */
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

    /**
     * 订单：分拆规则 [CodeMaster 按订单分拆、按分批订单分拆]
     */
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

    /**
     * 下单：下单员ID
     */
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

    /**
     * 下单：下单员类型 [CodeMaster]
     */
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

    /**
     * 下单：下单时间 [订单日期]
     */
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

    /**
     * 下单：下单类型 [CodeMaster]
     */
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

    /**
     * 区域：物流区ID
     */
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

    /**
     * 买家：买家类型编码
     */
    private String buyerType;

    /**
     * 获取买家：买家类型编码
     *
     * @return 买家：买家类型编码
     */
    public String getBuyerType() {
        return this.buyerType;
    }

    /**
     * 设置买家：买家类型编码
     *
     * @param buyerType
     */
    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    /**
     * 买家：买家类型名称
     */
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

    /**
     * 买家：买家ID [【需要和买家确认】]
     */
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

    /**
     * 买家：专属买手类型 [CodeMaster 区域买手、非区域买手、区域分销买手、账期用户买手]
     */
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

    /**
     * 买家：专属买手ID [【需要和买手确认】]
     */
    private String bsId;

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    /**
     * 买家：常客买家等级编码 [默认共四级：0，1，2，3]
     */
    private String frequenterLevelCode;

    /**
     * 获取买家：常客买家等级编码 [默认共四级：0，1，2，3]
     *
     * @return 买家：常客买家等级编码 [默认共四级：0，1，2，3]
     */
    public String getFrequenterLevelCode() {
        return this.frequenterLevelCode;
    }

    /**
     * 设置买家：常客买家等级编码 [默认共四级：0，1，2，3]
     *
     * @param frequenterLevelCode
     */
    public void setFrequenterLevelCode(String frequenterLevelCode) {
        this.frequenterLevelCode = frequenterLevelCode;
    }

    /**
     * 支付：是否开具发票
     */
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

    /**
     * 支付：是否是账期买家
     */
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

    /**
     * 支付：是否使用账期
     */
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

    /**
     * 支付：付款类型
     */
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

    /**
     * 支付：支付状态 [codemaster]
     */
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

    /**
     * 支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
     */
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

    /**
     * 支付：运费金额 [分批订单运费合计]
     */
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

    /**
     * 支付：优惠金额 [分批订单优惠合计]
     */
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

    /**
     * 支付：已收金额 [订单总额-已收金额=尾款金额]
     */
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

    /**
     * 支付：定金应付比例
     */
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

    /**
     * 支付：定金应付金额
     */
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

    /**
     * 支付：应预付比例
     */
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

    /**
     * 支付：应预付金额
     */
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

    /**
     * 状态：买家订单状态
     */
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

    /**
     * 订单：是否发过邮件
     */
    private Boolean mailedFlg;

    public Boolean getMailedFlg() {
        return mailedFlg;
    }

    public void setMailedFlg(Boolean mailedFlg) {
        this.mailedFlg = mailedFlg;
    }
}
