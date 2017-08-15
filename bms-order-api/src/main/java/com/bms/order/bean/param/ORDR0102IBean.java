package com.bms.order.bean.param;

import java.math.BigDecimal;
import java.util.List;

import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.common.rest.param.RestBean;

/**
 * 买家订单修改接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0102IBean extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = 2385494427608954452L;
    private List<ORDR0102IBatchBean> batchOrderList;
    /** 订单id */
    private Long buyerOrderId;
    /** 订单：参考号*/
    private String backNo;
    /** 是否开具发票 */
    private Boolean invoiceFlg;
    /** 是否使用账期 */
    private Boolean useNetFlg;
    /** 运费金额 */
    private BigDecimal freight;
    /** 优惠金额 */
    private BigDecimal preferentialAmount;
    /** 定金应付金额 */
    private BigDecimal earnestAmount;
    /** 预付应付金额 */
    private BigDecimal advancePaymentAmount;
    /** 买家联系电话 */
    private String buyerPhone;
    /** 买家微信号 */
    private String buyerWechat;
    /** 买家QQ */
    private String buyerQQ;
    /** 买家邮箱 */
    private String buyerMail;
    /** 版本号 */
    private Integer ver;

    public List<ORDR0102IBatchBean> getBatchOrderList() {
        return batchOrderList;
    }

    public void setBatchOrderList(List<ORDR0102IBatchBean> batchOrderList) {
        this.batchOrderList = batchOrderList;
    }

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
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

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerWechat() {
        return buyerWechat;
    }

    public void setBuyerWechat(String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }

    public String getBuyerQQ() {
        return buyerQQ;
    }

    public void setBuyerQQ(String buyerQQ) {
        this.buyerQQ = buyerQQ;
    }

    public String getBuyerMail() {
        return buyerMail;
    }

    public void setBuyerMail(String buyerMail) {
        this.buyerMail = buyerMail;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public BuyerOrder generateBuyerOrder() {
        return BuyerOrder.build(null).forComplete(buyerOrderId);
    }

    public BuyerOrder modifiedBuyerOrder() {
        // 构建买家订单
        BuyerOrderEntity entity = new BuyerOrderEntity();
        BuyerOrderAttachedEntity attachedEntity = new BuyerOrderAttachedEntity();
        entity.setBuyerOrderId(buyerOrderId);
        attachedEntity.setBuyerOrderId(buyerOrderId);

        entity.setInvoiceFlg(invoiceFlg);
        entity.setUseNetFlg(useNetFlg);
        entity.setFreight(freight);
        entity.setPreferentialAmount(preferentialAmount);
        entity.setEarnestAmount(earnestAmount);
        entity.setAdvancePaymentAmount(advancePaymentAmount);
        attachedEntity.setBuyerPhone(buyerPhone);
        attachedEntity.setBuyerWechat(buyerWechat);
        attachedEntity.setBuyerQq(buyerQQ);
        attachedEntity.setBuyerMail(buyerMail);
        entity.setVersion(ver);
        attachedEntity.setVersion(ver);
        BuyerOrder buyerOrder = BuyerOrder.build(null).forCreate(entity, attachedEntity);

        if (batchOrderList != null) {
            for (ORDR0102IBatchBean batchParam : batchOrderList) {
                batchParam.modifiedBuyerBatchOrder(buyerOrder);
            }
        }
        buyerOrder.buyerBatchOrdersLinked();
        buyerOrder.buyerBatchOrderDetailsLinked();

        return buyerOrder;
    }
}
