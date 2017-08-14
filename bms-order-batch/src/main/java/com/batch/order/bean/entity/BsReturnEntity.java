package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class BsReturnEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 退货单ID [退货单ID]
     */
    private Long returnId;

    /**
     * 获取退货单ID [退货单ID]
     *
     * @return 退货单ID [退货单ID]
     */
    public Long getReturnId() {
        return this.returnId;
    }

    /**
     * 设置退货单ID [退货单ID]
     *
     * @param returnId
     */
    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    /**
     * 退货单编码 [退货单编码]
     */
    private String returnCode;

    /**
     * 获取退货单编码 [退货单编码]
     *
     * @return 退货单编码 [退货单编码]
     */
    public String getReturnCode() {
        return this.returnCode;
    }

    /**
     * 设置退货单编码 [退货单编码]
     *
     * @param returnCode
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * 买手订单ID [订单ID]
     */
    private Long orderId;

    /**
     * 获取买手订单ID [订单ID]
     *
     * @return 买手订单ID [订单ID]
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * 设置买手订单ID [订单ID]
     *
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 买手ID [买家ID，冗余]
     */
    private String bsId;

    /**
     * 获取买手ID [买家ID，冗余]
     *
     * @return 买手ID [买家ID，冗余]
     */
    public String getBsId() {
        return this.bsId;
    }

    /**
     * 设置买手ID [买家ID，冗余]
     *
     * @param bsId
     */
    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    /**
     * 买手编码 [买家编码，冗余]
     */
    private String bsCode;

    /**
     * 获取买手编码 [买家编码，冗余]
     *
     * @return 买手编码 [买家编码，冗余]
     */
    public String getBsCode() {
        return this.bsCode;
    }

    /**
     * 设置买手编码 [买家编码，冗余]
     *
     * @param bsCode
     */
    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    /**
     * 买手名称 [买家名称，冗余]
     */
    private String bsName;

    /**
     * 获取买手名称 [买家名称，冗余]
     *
     * @return 买手名称 [买家名称，冗余]
     */
    public String getBsName() {
        return this.bsName;
    }

    /**
     * 设置买手名称 [买家名称，冗余]
     *
     * @param bsName
     */
    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    /**
     * 买手退货单来源 [退货单系统来源-CodeMaster
     * ]
     */
    private String bsReturnSource;

    /**
     * 获取买手退货单来源 [退货单系统来源-CodeMaster
     * ]
     *
     * @return 买手退货单来源 [退货单系统来源-CodeMaster
     * ]
     */
    public String getBsReturnSource() {
        return this.bsReturnSource;
    }

    /**
     * 设置买手退货单来源 [退货单系统来源-CodeMaster
     * ]
     *
     * @param bsReturnSource
     */
    public void setBsReturnSource(String bsReturnSource) {
        this.bsReturnSource = bsReturnSource;
    }

    /**
     * 买手退货类型 [退货单类型-CodeMaster
     * 1、买手A类囤货退货，2、买手B类囤货退货]
     */
    private String bsReturnType;

    /**
     * 获取买手退货类型 [退货单类型-CodeMaster
     * 1、买手A类囤货退货，2、买手B类囤货退货]
     *
     * @return 买手退货类型 [退货单类型-CodeMaster
     * 1、买手A类囤货退货，2、买手B类囤货退货]
     */
    public String getBsReturnType() {
        return this.bsReturnType;
    }

    /**
     * 设置买手退货类型 [退货单类型-CodeMaster
     * 1、买手A类囤货退货，2、买手B类囤货退货]
     *
     * @param bsReturnType
     */
    public void setBsReturnType(String bsReturnType) {
        this.bsReturnType = bsReturnType;
    }

    /**
     * 退货总金额 [退货总金额]
     */
    private BigDecimal returnAmount;

    /**
     * 获取退货总金额 [退货总金额]
     *
     * @return 退货总金额 [退货总金额]
     */
    public BigDecimal getReturnAmount() {
        return this.returnAmount;
    }

    /**
     * 设置退货总金额 [退货总金额]
     *
     * @param returnAmount
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    /**
     * 退货原因ID [退货原因ID]
     */
    private Long returnReasonId;

    /**
     * 获取退货原因ID [退货原因ID]
     *
     * @return 退货原因ID [退货原因ID]
     */
    public Long getReturnReasonId() {
        return this.returnReasonId;
    }

    /**
     * 设置退货原因ID [退货原因ID]
     *
     * @param returnReasonId
     */
    public void setReturnReasonId(Long returnReasonId) {
        this.returnReasonId = returnReasonId;
    }

    /**
     * 买手退货申请人类型 [退货申请人类型]
     */
    private String bsApplyUserType;

    /**
     * 获取买手退货申请人类型 [退货申请人类型]
     *
     * @return 买手退货申请人类型 [退货申请人类型]
     */
    public String getBsApplyUserType() {
        return this.bsApplyUserType;
    }

    /**
     * 设置买手退货申请人类型 [退货申请人类型]
     *
     * @param bsApplyUserType
     */
    public void setBsApplyUserType(String bsApplyUserType) {
        this.bsApplyUserType = bsApplyUserType;
    }

    /**
     * 退货申请人ID [退货申请人ID]
     */
    private String applyUid;

    /**
     * 获取退货申请人ID [退货申请人ID]
     *
     * @return 退货申请人ID [退货申请人ID]
     */
    public String getApplyUid() {
        return this.applyUid;
    }

    /**
     * 设置退货申请人ID [退货申请人ID]
     *
     * @param applyUid
     */
    public void setApplyUid(String applyUid) {
        this.applyUid = applyUid;
    }

    /**
     * 退货申请人名称 [退货申请人名称]
     */
    private String applyUname;

    /**
     * 获取退货申请人名称 [退货申请人名称]
     *
     * @return 退货申请人名称 [退货申请人名称]
     */
    public String getApplyUname() {
        return this.applyUname;
    }

    /**
     * 设置退货申请人名称 [退货申请人名称]
     *
     * @param applyUname
     */
    public void setApplyUname(String applyUname) {
        this.applyUname = applyUname;
    }

    /**
     * 退货申请时间 [退货申请时间]
     */
    private Date applyTime;

    /**
     * 获取退货申请时间 [退货申请时间]
     *
     * @return 退货申请时间 [退货申请时间]
     */
    public Date getApplyTime() {
        return this.applyTime;
    }

    /**
     * 设置退货申请时间 [退货申请时间]
     *
     * @param applyTime
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 退货申请备注 [退货备注]
     */
    private String applyRemark;

    /**
     * 获取退货申请备注 [退货备注]
     *
     * @return 退货申请备注 [退货备注]
     */
    public String getApplyRemark() {
        return this.applyRemark;
    }

    /**
     * 设置退货申请备注 [退货备注]
     *
     * @param applyRemark
     */
    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    /**
     * 退货确认人ID [退货确认人ID]
     */
    private String confirmUid;

    /**
     * 获取退货确认人ID [退货确认人ID]
     *
     * @return 退货确认人ID [退货确认人ID]
     */
    public String getConfirmUid() {
        return this.confirmUid;
    }

    /**
     * 设置退货确认人ID [退货确认人ID]
     *
     * @param confirmUid
     */
    public void setConfirmUid(String confirmUid) {
        this.confirmUid = confirmUid;
    }

    /**
     * 退货确认人名称 [确认人名称]
     */
    private String confirmUname;

    /**
     * 获取退货确认人名称 [确认人名称]
     *
     * @return 退货确认人名称 [确认人名称]
     */
    public String getConfirmUname() {
        return this.confirmUname;
    }

    /**
     * 设置退货确认人名称 [确认人名称]
     *
     * @param confirmUname
     */
    public void setConfirmUname(String confirmUname) {
        this.confirmUname = confirmUname;
    }

    /**
     * 退货确认时间 [确认时间]
     */
    private Date confirmTime;

    /**
     * 获取退货确认时间 [确认时间]
     *
     * @return 退货确认时间 [确认时间]
     */
    public Date getConfirmTime() {
        return this.confirmTime;
    }

    /**
     * 设置退货确认时间 [确认时间]
     *
     * @param confirmTime
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * 退货确认备注 [退货确认备注]
     */
    private String confirmRemark;

    /**
     * 获取退货确认备注 [退货确认备注]
     *
     * @return 退货确认备注 [退货确认备注]
     */
    public String getConfirmRemark() {
        return this.confirmRemark;
    }

    /**
     * 设置退货确认备注 [退货确认备注]
     *
     * @param confirmRemark
     */
    public void setConfirmRemark(String confirmRemark) {
        this.confirmRemark = confirmRemark;
    }

    /**
     * 买手退货状态 [退货状态，CodeMaster]
     */
    private String bsReturnStu;

    /**
     * 获取买手退货状态 [退货状态，CodeMaster]
     *
     * @return 买手退货状态 [退货状态，CodeMaster]
     */
    public String getBsReturnStu() {
        return this.bsReturnStu;
    }

    /**
     * 设置买手退货状态 [退货状态，CodeMaster]
     *
     * @param bsReturnStu
     */
    public void setBsReturnStu(String bsReturnStu) {
        this.bsReturnStu = bsReturnStu;
    }
}
