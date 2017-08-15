package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;
import java.util.List;

/**
 * 买手退货信息查询接口Result
 *
 * @author li_huiqian
 */
public class ORDR0904IRestResult extends RestSearchData {

    private static final long serialVersionUID = 1L;

    /**
     * 退货单ID
     */
    private Long returnId;
    /**
     * 退货单编码
     */
    private String returnCode;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 买家ID
     */
    private String bsId;
    /**
     * 买家编码
     */
    private String bsCode;
    /**
     * 买家名称
     */
    private String bsName;
    /**
     * 退货单来源
     */
    private String returnSource;
    /**
     * 退货类型
     */
    private String returnType;
    /**
     * 退货总金额
     */
    private BigDecimal returnAmount;
    /**
     * 退货原因ID
     */
    private Long returnReasonId;
    /**
     * 退货原因名称
     */
    private String returnReasonName;
    /**
     * 申请人类型
     */
    private String applyUserType;
    /**
     * 申请人ID
     */
    private String applyUid;
    /**
     * 申请人名称
     */
    private String applyUname;
    /**
     * 申请时间
     */
    private String applyTime;
    /**
     * 申请备注
     */
    private String applyRemark;
    /**
     * 退货确认人类型
     */
    private String confirmUserType;
    /**
     * 退货确认人ID
     */
    private String confirmUid;
    /**
     * 退货确认人名称
     */
    private String confirmUname;
    /**
     * 退货确认时间
     */
    private String confirmTime;
    /**
     * 退货确认备注
     */
    private String confirmRemark;
    /**
     * 退货单状态
     */
    private String returnStatus;
    /**
     * 删除标记
     */
    private Boolean delFlg;
    /**
     * 创建者ID
     */
    private String crtId;
    /**
     * 创建时间(yyyy-MM-dd HH:mm:ss)
     */
    private String crtTime;
    /**
     * 更新者ID
     */
    private String updId;
    /**
     * 更新时间(yyyy-MM-dd HH:mm:ss)
     */
    private String updTime;
    /**
     * 版本
     */
    private Integer ver;

    private List<ORDR0904IDetailRestResult> details;

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
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

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
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

    public String getReturnSource() {
        return returnSource;
    }

    public void setReturnSource(String returnSource) {
        this.returnSource = returnSource;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Long getReturnReasonId() {
        return returnReasonId;
    }

    public void setReturnReasonId(Long returnReasonId) {
        this.returnReasonId = returnReasonId;
    }

    public String getReturnReasonName() {
        return returnReasonName;
    }

    public void setReturnReasonName(String returnReasonName) {
        this.returnReasonName = returnReasonName;
    }

    public String getApplyUserType() {
        return applyUserType;
    }

    public void setApplyUserType(String applyUserType) {
        this.applyUserType = applyUserType;
    }

    public String getApplyUid() {
        return applyUid;
    }

    public void setApplyUid(String applyUid) {
        this.applyUid = applyUid;
    }

    public String getApplyUname() {
        return applyUname;
    }

    public void setApplyUname(String applyUname) {
        this.applyUname = applyUname;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public String getConfirmUserType() {
        return confirmUserType;
    }

    public void setConfirmUserType(String confirmUserType) {
        this.confirmUserType = confirmUserType;
    }

    public String getConfirmUid() {
        return confirmUid;
    }

    public void setConfirmUid(String confirmUid) {
        this.confirmUid = confirmUid;
    }

    public String getConfirmUname() {
        return confirmUname;
    }

    public void setConfirmUname(String confirmUname) {
        this.confirmUname = confirmUname;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getConfirmRemark() {
        return confirmRemark;
    }

    public void setConfirmRemark(String confirmRemark) {
        this.confirmRemark = confirmRemark;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public List<ORDR0904IDetailRestResult> getDetails() {
        return details;
    }

    public void setDetails(List<ORDR0904IDetailRestResult> details) {
        this.details = details;
    }
}
