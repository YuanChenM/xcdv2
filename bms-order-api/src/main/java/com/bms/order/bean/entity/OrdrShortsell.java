/*
 * 2017/04/26 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表ordr_shortsell对应的实体OrdrShortsell</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class OrdrShortsell extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 沽货订单ID */
    private Long orderId;
    /** 沽货订单编号 */
    private String orderCode;
    /** 冻期所沽货订单单号 */
    private String backNo;
    /** CodeMaster,003-沽货订单 */
    private String orderType;
    /** CodeMaster,001-冻期所 */
    private String orderSourceType;
    /** 物流区ID */
    private Long logisticsId;
    /** 物流区编码 */
    private String logisticsCode;
    /** 物流区名称 */
    private String logisticsName;
    /** 卖方ID */
    private String sellerId;
    /** 卖方编码 */
    private String sellerCode;
    /** 卖方名称 */
    private String sellerName;
    /** 卖方类型 */
    private String sellerType;
    /** 买方ID */
    private String buyerId;
    /** 买方编码 */
    private String buyerCode;
    /** 买方名称 */
    private String buyerName;
    /** 买方类型 */
    private String buyerType;
    /** 订单总额 */
    private java.math.BigDecimal totalAmount;
    /** 已收金额 */
    private java.math.BigDecimal receiveAmount;
    /** codemaster */
    private String paymentStu;
    /** 税率 */
    private java.math.BigDecimal taxRate;
    /** 币种 */
    private String currency;
    /** 卖家交易手续费 */
    private java.math.BigDecimal sellerFeeMoney;
    /** 卖家交易保证金 */
    private java.math.BigDecimal sellerDepositMoney;
    /** 卖家交收手续费 */
    private java.math.BigDecimal sellerDelMoney;
    /** 买家交易手续费 */
    private java.math.BigDecimal buyerFeeMoney;
    /** 买家交易保证金 */
    private java.math.BigDecimal buyerDepositMoney;
    /** 买家交收手续费 */
    private java.math.BigDecimal buyerDelMoney;
    /** 下单员编码 */
    private String placeCode;
    /** 下单员名称 */
    private String placeName;
    /** 下单时间 */
    private java.util.Date placeTime;
    /** 交易时间，即交割完成时间 */
    private java.util.Date tradeTime;
    /** 订单状态 */
    private String orderStu;

    /**
     * <p>默认构造函数</p>
     */
    public OrdrShortsell() {
    }

    /**
     * <p>沽货订单ID</p>
     *
     * @return 沽货订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * <p>沽货订单ID</p>
     *
     * @param orderId 沽货订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    /**
     * <p>沽货订单编号</p>
     *
     * @return 沽货订单编号
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * <p>沽货订单编号</p>
     *
     * @param orderCode 沽货订单编号
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    /**
     * <p>冻期所沽货订单单号</p>
     *
     * @return 冻期所沽货订单单号
     */
    public String getBackNo() {
        return backNo;
    }

    /**
     * <p>冻期所沽货订单单号</p>
     *
     * @param backNo 冻期所沽货订单单号
     */
    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }
    /**
     * <p>CodeMaster,003-沽货订单</p>
     *
     * @return CodeMaster,003-沽货订单
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * <p>CodeMaster,003-沽货订单</p>
     *
     * @param orderType CodeMaster,003-沽货订单
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    /**
     * <p>CodeMaster,001-冻期所</p>
     *
     * @return CodeMaster,001-冻期所
     */
    public String getOrderSourceType() {
        return orderSourceType;
    }

    /**
     * <p>CodeMaster,001-冻期所</p>
     *
     * @param orderSourceType CodeMaster,001-冻期所
     */
    public void setOrderSourceType(String orderSourceType) {
        this.orderSourceType = orderSourceType;
    }
    /**
     * <p>物流区ID</p>
     *
     * @return 物流区ID
     */
    public Long getLogisticsId() {
        return logisticsId;
    }

    /**
     * <p>物流区ID</p>
     *
     * @param logisticsId 物流区ID
     */
    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLogisticsCode() {
        return logisticsCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param logisticsCode 物流区编码
     */
    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }
    /**
     * <p>物流区名称</p>
     *
     * @return 物流区名称
     */
    public String getLogisticsName() {
        return logisticsName;
    }

    /**
     * <p>物流区名称</p>
     *
     * @param logisticsName 物流区名称
     */
    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }
    /**
     * <p>卖方ID</p>
     *
     * @return 卖方ID
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * <p>卖方ID</p>
     *
     * @param sellerId 卖方ID
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
    /**
     * <p>卖方编码</p>
     *
     * @return 卖方编码
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>卖方编码</p>
     *
     * @param sellerCode 卖方编码
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
    /**
     * <p>卖方名称</p>
     *
     * @return 卖方名称
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * <p>卖方名称</p>
     *
     * @param sellerName 卖方名称
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    /**
     * <p>卖方类型</p>
     *
     * @return 卖方类型
     */
    public String getSellerType() {
        return sellerType;
    }

    /**
     * <p>卖方类型</p>
     *
     * @param sellerType 卖方类型
     */
    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }
    /**
     * <p>买方ID</p>
     *
     * @return 买方ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买方ID</p>
     *
     * @param buyerId 买方ID
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
    /**
     * <p>买方编码</p>
     *
     * @return 买方编码
     */
    public String getBuyerCode() {
        return buyerCode;
    }

    /**
     * <p>买方编码</p>
     *
     * @param buyerCode 买方编码
     */
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }
    /**
     * <p>买方名称</p>
     *
     * @return 买方名称
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * <p>买方名称</p>
     *
     * @param buyerName 买方名称
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    /**
     * <p>买方类型</p>
     *
     * @return 买方类型
     */
    public String getBuyerType() {
        return buyerType;
    }

    /**
     * <p>买方类型</p>
     *
     * @param buyerType 买方类型
     */
    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }
    /**
     * <p>订单总额</p>
     *
     * @return 订单总额
     */
    public java.math.BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * <p>订单总额</p>
     *
     * @param totalAmount 订单总额
     */
    public void setTotalAmount(java.math.BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    /**
     * <p>已收金额</p>
     *
     * @return 已收金额
     */
    public java.math.BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    /**
     * <p>已收金额</p>
     *
     * @param receiveAmount 已收金额
     */
    public void setReceiveAmount(java.math.BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }
    /**
     * <p>codemaster</p>
     *
     * @return codemaster
     */
    public String getPaymentStu() {
        return paymentStu;
    }

    /**
     * <p>codemaster</p>
     *
     * @param paymentStu codemaster
     */
    public void setPaymentStu(String paymentStu) {
        this.paymentStu = paymentStu;
    }
    /**
     * <p>税率</p>
     *
     * @return 税率
     */
    public java.math.BigDecimal getTaxRate() {
        return taxRate;
    }

    /**
     * <p>税率</p>
     *
     * @param taxRate 税率
     */
    public void setTaxRate(java.math.BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    /**
     * <p>币种</p>
     *
     * @return 币种
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * <p>币种</p>
     *
     * @param currency 币种
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    /**
     * <p>卖家交易手续费</p>
     *
     * @return 卖家交易手续费
     */
    public java.math.BigDecimal getSellerFeeMoney() {
        return sellerFeeMoney;
    }

    /**
     * <p>卖家交易手续费</p>
     *
     * @param sellerFeeMoney 卖家交易手续费
     */
    public void setSellerFeeMoney(java.math.BigDecimal sellerFeeMoney) {
        this.sellerFeeMoney = sellerFeeMoney;
    }
    /**
     * <p>卖家交易保证金</p>
     *
     * @return 卖家交易保证金
     */
    public java.math.BigDecimal getSellerDepositMoney() {
        return sellerDepositMoney;
    }

    /**
     * <p>卖家交易保证金</p>
     *
     * @param sellerDepositMoney 卖家交易保证金
     */
    public void setSellerDepositMoney(java.math.BigDecimal sellerDepositMoney) {
        this.sellerDepositMoney = sellerDepositMoney;
    }
    /**
     * <p>卖家交收手续费</p>
     *
     * @return 卖家交收手续费
     */
    public java.math.BigDecimal getSellerDelMoney() {
        return sellerDelMoney;
    }

    /**
     * <p>卖家交收手续费</p>
     *
     * @param sellerDelMoney 卖家交收手续费
     */
    public void setSellerDelMoney(java.math.BigDecimal sellerDelMoney) {
        this.sellerDelMoney = sellerDelMoney;
    }
    /**
     * <p>买家交易手续费</p>
     *
     * @return 买家交易手续费
     */
    public java.math.BigDecimal getBuyerFeeMoney() {
        return buyerFeeMoney;
    }

    /**
     * <p>买家交易手续费</p>
     *
     * @param buyerFeeMoney 买家交易手续费
     */
    public void setBuyerFeeMoney(java.math.BigDecimal buyerFeeMoney) {
        this.buyerFeeMoney = buyerFeeMoney;
    }
    /**
     * <p>买家交易保证金</p>
     *
     * @return 买家交易保证金
     */
    public java.math.BigDecimal getBuyerDepositMoney() {
        return buyerDepositMoney;
    }

    /**
     * <p>买家交易保证金</p>
     *
     * @param buyerDepositMoney 买家交易保证金
     */
    public void setBuyerDepositMoney(java.math.BigDecimal buyerDepositMoney) {
        this.buyerDepositMoney = buyerDepositMoney;
    }
    /**
     * <p>买家交收手续费</p>
     *
     * @return 买家交收手续费
     */
    public java.math.BigDecimal getBuyerDelMoney() {
        return buyerDelMoney;
    }

    /**
     * <p>买家交收手续费</p>
     *
     * @param buyerDelMoney 买家交收手续费
     */
    public void setBuyerDelMoney(java.math.BigDecimal buyerDelMoney) {
        this.buyerDelMoney = buyerDelMoney;
    }
    /**
     * <p>下单员编码</p>
     *
     * @return 下单员编码
     */
    public String getPlaceCode() {
        return placeCode;
    }

    /**
     * <p>下单员编码</p>
     *
     * @param placeCode 下单员编码
     */
    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }
    /**
     * <p>下单员名称</p>
     *
     * @return 下单员名称
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * <p>下单员名称</p>
     *
     * @param placeName 下单员名称
     */
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    /**
     * <p>下单时间</p>
     *
     * @return 下单时间
     */
    public java.util.Date getPlaceTime() {
        return placeTime;
    }

    /**
     * <p>下单时间</p>
     *
     * @param placeTime 下单时间
     */
    public void setPlaceTime(java.util.Date placeTime) {
        this.placeTime = placeTime;
    }
    /**
     * <p>交易时间，即交割完成时间</p>
     *
     * @return 交易时间，即交割完成时间
     */
    public java.util.Date getTradeTime() {
        return tradeTime;
    }

    /**
     * <p>交易时间，即交割完成时间</p>
     *
     * @param tradeTime 交易时间，即交割完成时间
     */
    public void setTradeTime(java.util.Date tradeTime) {
        this.tradeTime = tradeTime;
    }
    /**
     * <p>订单状态</p>
     *
     * @return 订单状态
     */
    public String getOrderStu() {
        return orderStu;
    }

    /**
     * <p>订单状态</p>
     *
     * @param orderStu 订单状态
     */
    public void setOrderStu(String orderStu) {
        this.orderStu = orderStu;
    }

}
