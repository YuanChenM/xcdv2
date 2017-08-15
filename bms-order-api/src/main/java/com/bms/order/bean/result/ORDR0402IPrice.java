package com.bms.order.bean.result;

import com.framework.base.rest.result.BaseRestResult;

import java.math.BigDecimal;

/**
 * 订单信息及对应价盘查询接口Result
 *
 * @author peng_hao
 */
public class ORDR0402IPrice extends BaseRestResult {

    private static final long serialVersionUID = 1L;
    /**
     * 价格通道ID
     */
    private Long pricePlateChannelId;
    /**
     *  通道等级
     */
    private String priceChannelLevel;
    /**
     * 通道开始数量
     */
    private BigDecimal priceChannelStartQuantity;
    /**
     * 通道结束数量
     */
    private BigDecimal priceChannelEndQuantity;
    /**
     *价格通道单价
     */
    private BigDecimal priceChannelUnitPrice;

    public Long getPricePlateChannelId() {
        return pricePlateChannelId;
    }

    public void setPricePlateChannelId(Long pricePlateChannelId) {
        this.pricePlateChannelId = pricePlateChannelId;
    }

    public String getPriceChannelLevel() {
        return priceChannelLevel;
    }

    public void setPriceChannelLevel(String priceChannelLevel) {
        this.priceChannelLevel = priceChannelLevel;
    }

    public BigDecimal getPriceChannelStartQuantity() {
        return priceChannelStartQuantity;
    }

    public void setPriceChannelStartQuantity(BigDecimal priceChannelStartQuantity) {
        this.priceChannelStartQuantity = priceChannelStartQuantity;
    }

    public BigDecimal getPriceChannelEndQuantity() {
        return priceChannelEndQuantity;
    }

    public void setPriceChannelEndQuantity(BigDecimal priceChannelEndQuantity) {
        this.priceChannelEndQuantity = priceChannelEndQuantity;
    }

    public BigDecimal getPriceChannelUnitPrice() {
        return priceChannelUnitPrice;
    }

    public void setPriceChannelUnitPrice(BigDecimal priceChannelUnitPrice) {
        this.priceChannelUnitPrice = priceChannelUnitPrice;
    }
}
