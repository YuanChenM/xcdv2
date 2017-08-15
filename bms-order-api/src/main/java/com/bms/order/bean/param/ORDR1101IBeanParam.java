package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;
import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/4/26.
 */
@ApiModel(value = "ORDR1101IBeanParam", description = "沽货主表数据对象")
public class ORDR1101IBeanParam extends RestBean {

    private String backNo;

    private String sellerCode;

    private String sellerName;

    private String orderPlaceDatetime;

    private String orderType;

    private String buyerCode;

    private String buyerName;

    private BigDecimal totalPrice;

    private BigDecimal taxRate;

    private String currency;

    private BigDecimal sellerFeeMoney;

    private BigDecimal sellerDepositMoney;

    private BigDecimal sellerDelMoney;

    private BigDecimal buyerFeeMoney;

    private BigDecimal buyerDepositMoney;

    private BigDecimal buyerDelMoney;

    private String tradeTime;

    private List<ORDR110101IBeanParam> products;

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getOrderPlaceDatetime() {
        return orderPlaceDatetime;
    }

    public void setOrderPlaceDatetime(String orderPlaceDatetime) {
        this.orderPlaceDatetime = orderPlaceDatetime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSellerFeeMoney() {
        return sellerFeeMoney;
    }

    public void setSellerFeeMoney(BigDecimal sellerFeeMoney) {
        this.sellerFeeMoney = sellerFeeMoney;
    }

    public BigDecimal getSellerDepositMoney() {
        return sellerDepositMoney;
    }

    public void setSellerDepositMoney(BigDecimal sellerDepositMoney) {
        this.sellerDepositMoney = sellerDepositMoney;
    }

    public BigDecimal getSellerDelMoney() {
        return sellerDelMoney;
    }

    public void setSellerDelMoney(BigDecimal sellerDelMoney) {
        this.sellerDelMoney = sellerDelMoney;
    }

    public BigDecimal getBuyerFeeMoney() {
        return buyerFeeMoney;
    }

    public void setBuyerFeeMoney(BigDecimal buyerFeeMoney) {
        this.buyerFeeMoney = buyerFeeMoney;
    }

    public BigDecimal getBuyerDepositMoney() {
        return buyerDepositMoney;
    }

    public void setBuyerDepositMoney(BigDecimal buyerDepositMoney) {
        this.buyerDepositMoney = buyerDepositMoney;
    }

    public BigDecimal getBuyerDelMoney() {
        return buyerDelMoney;
    }

    public void setBuyerDelMoney(BigDecimal buyerDelMoney) {
        this.buyerDelMoney = buyerDelMoney;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public List<ORDR110101IBeanParam> getProducts() {
        return products;
    }

    public void setProducts(List<ORDR110101IBeanParam> products) {
        this.products = products;
    }
}
