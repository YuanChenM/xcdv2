package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;

/**
 * 买家退货信息查询接口Param
 *
 * @author li_huiqian
 */
public class ORDR0807IFilter extends RestFilter {
    private static final long serialVersionUID = 1L;

    /**
     * 退货单ID
     */
    private Long[] returnId;
    /**
     * 退货单编码，模糊查询
     */
    private String returnCode;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单编码，模糊查询
     */
    private String orderCode;
    /**
     * 物流区ID
     */
    private Long[] logisticsZoneId;
    /**
     * 物流区编码
     */
    private String logisticsZoneCode;
    /**
     * 买家ID
     */
    private String[] buyerId;
    /**
     * 买家编码
     */
    private String buyerCode;
    /**
     * 买家名称
     */
    private String buyerName;
    /**
     * 退货申请人类型
     */
    private String applyUserType;
    /**
     * 退货申请人ID
     */
    private String applyUserId;
    /**
     * 退货申请名称，模糊查询
     */
    private String applyUserName;
    /**
     * 申请开始时间
     */
    private String applyTimeFrom;
    /**
     * 申请截止时间
     */
    private String applyTimeTo;
    /**
     * 退货类型
     */
    private String returnType;
    /**
     * 退货单状态
     */
    private String returnStatus;

    public Long[] getReturnId() {
        return returnId;
    }

    public void setReturnId(Long[] returnId) {
        this.returnId = returnId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long[] getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long[] logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    public String getLogisticsZoneCode() {
        return logisticsZoneCode;
    }

    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }

    public String[] getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String[] buyerId) {
        this.buyerId = buyerId;
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

    public String getApplyUserType() {
        return applyUserType;
    }

    public void setApplyUserType(String applyUserType) {
        this.applyUserType = applyUserType;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getApplyTimeFrom() {
        return applyTimeFrom;
    }

    public void setApplyTimeFrom(String applyTimeFrom) {
        this.applyTimeFrom = applyTimeFrom;
    }

    public String getApplyTimeTo() {
        return applyTimeTo;
    }

    public void setApplyTimeTo(String applyTimeTo) {
        this.applyTimeTo = applyTimeTo;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
}
