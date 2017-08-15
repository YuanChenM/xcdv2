package com.bms.order.bean.param;

import java.math.BigDecimal;
import java.util.List;

import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.common.rest.param.RestBean;
import com.framework.core.utils.DateUtils;

/**
 * 买家订单创建接口Param
 *
 * @author li_huiqian
 */
public class ORDR0101IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -2979773459079811383L;

    // 买家ID
    private String buyerId;
    //订单：参考号
    private String backNo;
    private String lgcsAreaCode;
    // 是否开具发票
    private Boolean invoiceFlg;
    // 是否使用账期
    private Boolean useNetFlg;
    // 下单时间
    private String orderPlaceDatetime;
    // 销售平台
    private String salePlatform;
    // 订单来源
    private String orderSource;
    // 是否分批
    private Boolean batchFlg;
    // 下单员ID
    private String orderPlacerId;
    // 下单员类型（目前业务暂定是否必传，买家，买手）
    private String orderPlacerType;
    // 付款类型
    private String paymentType;
    // 运费金额
    private BigDecimal freight;
    // 优惠金额
    private BigDecimal preferentialAmount;
    // 定金应付金额
    private BigDecimal earnestAmount;
    // 预付应付金额
    private BigDecimal advancePaymentAmount;
    // 分批订单
    private List<ORDR010101IRestParam> details;

    public BuyerOrder generateBuyerOrder() {
        // 构建买家订单
        BuyerOrderEntity entity = new BuyerOrderEntity();
        BuyerOrderAttachedEntity attachedEntity = new BuyerOrderAttachedEntity();

        entity.setBuyerId(buyerId);
        entity.setBackNo(backNo);
        entity.setInvoiceFlg(invoiceFlg);
        entity.setUseNetFlg(useNetFlg);
        entity.setOrderPlaceDatetime(DateUtils.parseDateTime(orderPlaceDatetime));
        entity.setSalePlatformType(salePlatform);
        entity.setOrderSourceType(orderSource);
        entity.setBatchFlg(batchFlg);
        entity.setOrderPlacerId(orderPlacerId);
        entity.setOrderPlacerType(orderPlacerType);
        entity.setPaymentType(paymentType);
        entity.setFreight(freight);
        entity.setPreferentialAmount(preferentialAmount);
        entity.setEarnestAmount(earnestAmount);
        entity.setAdvancePaymentAmount(advancePaymentAmount);

        BuyerOrder buyerOrder = BuyerOrder.build(null).forCreate(entity, attachedEntity);

        // 绑定买家分批订单
        for (ORDR010101IRestParam detail : details) {
            detail.generateBuyerBatchOrder(buyerOrder);
        }
        buyerOrder.buyerBatchOrdersLinked();
        buyerOrder.buyerBatchOrderDetailsLinked();

        return buyerOrder;
    }


    public BuyerOrder generateBuyerOrderByBackNo() {
        // 构建买家订单
        BuyerOrderEntity entity = new BuyerOrderEntity();
        BuyerOrderAttachedEntity attachedEntity = new BuyerOrderAttachedEntity();
        entity.setBackNo(backNo);
        BuyerOrder buyerOrder = BuyerOrder.build(null).forCreate(entity, attachedEntity);

        return buyerOrder;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public Boolean getInvoiceFlg() {
        return invoiceFlg;
    }

    public void setInvoiceFlg(Boolean invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    public Boolean getUseNetFlg() {
        return useNetFlg;
    }

    public void setUseNetFlg(Boolean useNetFlg) {
        this.useNetFlg = useNetFlg;
    }

    public String getOrderPlaceDatetime() {
        return orderPlaceDatetime;
    }

    public void setOrderPlaceDatetime(String orderPlaceDatetime) {
        this.orderPlaceDatetime = orderPlaceDatetime;
    }

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public Boolean getBatchFlg() {
        return batchFlg;
    }

    public void setBatchFlg(Boolean batchFlg) {
        this.batchFlg = batchFlg;
    }

    public String getOrderPlacerId() {
        return orderPlacerId;
    }

    public void setOrderPlacerId(String orderPlacerId) {
        this.orderPlacerId = orderPlacerId;
    }

    public String getOrderPlacerType() {
        return orderPlacerType;
    }

    public void setOrderPlacerType(String orderPlacerType) {
        this.orderPlacerType = orderPlacerType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getPreferentialAmount() {
        return preferentialAmount;
    }

    public void setPreferentialAmount(BigDecimal preferentialAmount) {
        this.preferentialAmount = preferentialAmount;
    }

    public BigDecimal getEarnestAmount() {
        return earnestAmount;
    }

    public void setEarnestAmount(BigDecimal earnestAmount) {
        this.earnestAmount = earnestAmount;
    }

    public BigDecimal getAdvancePaymentAmount() {
        return advancePaymentAmount;
    }

    public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    public List<ORDR010101IRestParam> getDetails() {
        return details;
    }

    public void setDetails(List<ORDR010101IRestParam> details) {
        this.details = details;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
}
