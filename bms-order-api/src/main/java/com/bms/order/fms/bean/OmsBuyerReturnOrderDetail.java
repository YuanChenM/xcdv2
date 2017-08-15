package com.bms.order.fms.bean;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * Oms买家订单明细（产品信息）
 */
public class OmsBuyerReturnOrderDetail extends FmsBuyerReturnOrderDetail {
    private static final long serialVersionUID = -72386056175144266L;
    //配送通知单明细ID
    private Long distributionDetailId;
    //分批订单明细ID
    private Long orderDetailId;
    //退货订单明细ID
    private Long returnDetailId;
    //分批订单预配送明细ID
    private Long deliverDetailId;
    //发货通知单明细ID
    private Long sendDetailId;
    //供货方ID
    private String sellSideId;
    //供货方类型（平台，买手，合伙人）
    private String sellSideType;

    /**
     * Getter method for property <tt>distributionDetailId</tt>.
     *
     * @return property value of distributionDetailId
     */
    public Long getDistributionDetailId() {
        return distributionDetailId;
    }

    /**
     * Setter method for property <tt>distributionDetailId</tt>.
     *
     * @param distributionDetailId value to be assigned to property distributionDetailId
     */
    public void setDistributionDetailId(Long distributionDetailId) {
        this.distributionDetailId = distributionDetailId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getReturnDetailId() {
        return returnDetailId;
    }

    public void setReturnDetailId(Long returnDetailId) {
        this.returnDetailId = returnDetailId;
    }

    public Long getDeliverDetailId() {
        return deliverDetailId;
    }

    public void setDeliverDetailId(Long deliverDetailId) {
        this.deliverDetailId = deliverDetailId;
    }

    public Long getSendDetailId() {
        return sendDetailId;
    }

    public void setSendDetailId(Long sendDetailId) {
        this.sendDetailId = sendDetailId;
    }

    public String getSellSideId() {
        return sellSideId;
    }

    public void setSellSideId(String sellSideId) {
        this.sellSideId = sellSideId;
    }

    public String getSellSideType() {
        return sellSideType;
    }

    public void setSellSideType(String sellSideType) {
        this.sellSideType = sellSideType;
    }
}
