package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;

/**
 * 买手退货信息查询接口Param
 *
 * @author li_huiqian
 */
public class ORDR0904IFilter extends RestFilter {
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
     * 买手ID
     */
    private String[] bsId;
    /**
     * 买手编码
     */
    private String bsCode;
    /**
     * 买手名称，模糊查询
     */
    private String bsName;
    /**
     * 退货申请人ID
     */
    private String applyUserId;
    /**
     * 退货申请名称，模糊查询
     */
    private String applyUserName;
    /**
     * 申请开始时间（yyyy-MM-dd）
     */
    private String applyTimeFrom;
    /**
     * 申请截止时间（yyyy-MM-dd）
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

    public String[] getBsId() {
        return bsId;
    }

    public void setBsId(String[] bsId) {
        this.bsId = bsId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
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
