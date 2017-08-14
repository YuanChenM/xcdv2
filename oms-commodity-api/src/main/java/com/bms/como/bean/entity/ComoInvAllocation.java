/*
 * 2017/03/23 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_inv_allocation对应的实体ComoInvAllocation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoInvAllocation extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 划拨单ID
     */
    private Long allocationId;
    /**
     * 划拨单编号
     */
    private String allocationCode;
    /**
     * 物流区域ID
     */
    private Long lgcsAreaId;
    /**
     * 物流区域编码
     */
    private String lgcsAreaCode;
    /**
     * 物流区域名称
     */
    private String lgcsAreaName;
    /**
     * 指定批次
     */
    private boolean assignLotNo;
    /**
     * 备注
     */
    private String allocationRemark;
    /**
     * 状态
     */
    private String allocationStu;
    /**
     * 划拨结果
     */
    private boolean allocationResult;
    /**
     * 发起时间
     */
    private java.util.Date applyTime;
    /**
     * 发起人
     */
    private String applyMan;
    /**
     * 完成日期
     */
    private java.util.Date completedTime;
    /**
     * 完成回执人
     */
    private String completedMan;

    /**
     * <p>默认构造函数</p>
     */
    public ComoInvAllocation() {
    }

    /**
     * <p>划拨单ID</p>
     *
     * @return 划拨单ID
     */
    public Long getAllocationId() {
        return allocationId;
    }

    /**
     * <p>划拨单ID</p>
     *
     * @param allocationId 划拨单ID
     */
    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    /**
     * <p>划拨单编号</p>
     *
     * @return 划拨单编号
     */
    public String getAllocationCode() {
        return allocationCode;
    }

    /**
     * <p>划拨单编号</p>
     *
     * @param allocationCode 划拨单编号
     */
    public void setAllocationCode(String allocationCode) {
        this.allocationCode = allocationCode;
    }

    /**
     * <p>物流区域ID</p>
     *
     * @return 物流区域ID
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区域ID</p>
     *
     * @param lgcsAreaId 物流区域ID
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    /**
     * <p>物流区域编码</p>
     *
     * @return 物流区域编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区域编码</p>
     *
     * @param lgcsAreaCode 物流区域编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * <p>物流区域名称</p>
     *
     * @return 物流区域名称
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区域名称</p>
     *
     * @param lgcsAreaName 物流区域名称
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    /**
     * <p>指定批次</p>
     *
     * @return 指定批次
     */
    public boolean getAssignLotNo() {
        return assignLotNo;
    }

    /**
     * <p>指定批次</p>
     *
     * @param assignLotNo 指定批次
     */
    public void setAssignLotNo(boolean assignLotNo) {
        this.assignLotNo = assignLotNo;
    }

    /**
     * <p>备注</p>
     *
     * @return 备注
     */
    public String getAllocationRemark() {
        return allocationRemark;
    }

    /**
     * <p>备注</p>
     *
     * @param allocationRemark 备注
     */
    public void setAllocationRemark(String allocationRemark) {
        this.allocationRemark = allocationRemark;
    }

    /**
     * <p>状态</p>
     *
     * @return 状态
     */
    public String getAllocationStu() {
        return allocationStu;
    }

    /**
     * <p>状态</p>
     *
     * @param allocationStu 状态
     */
    public void setAllocationStu(String allocationStu) {
        this.allocationStu = allocationStu;
    }

    /**
     * <p>划拨结果</p>
     *
     * @return 划拨结果
     */
    public boolean getAllocationResult() {
        return allocationResult;
    }

    /**
     * <p>划拨结果</p>
     *
     * @param allocationResult 划拨结果
     */
    public void setAllocationResult(boolean allocationResult) {
        this.allocationResult = allocationResult;
    }

    /**
     * <p>发起时间</p>
     *
     * @return 发起时间
     */
    public java.util.Date getApplyTime() {
        return applyTime;
    }

    /**
     * <p>发起时间</p>
     *
     * @param applyTime 发起时间
     */
    public void setApplyTime(java.util.Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * <p>发起人</p>
     *
     * @return 发起人
     */
    public String getApplyMan() {
        return applyMan;
    }

    /**
     * <p>发起人</p>
     *
     * @param applyMan 发起人
     */
    public void setApplyMan(String applyMan) {
        this.applyMan = applyMan;
    }

    /**
     * <p>完成日期</p>
     *
     * @return 完成日期
     */
    public java.util.Date getCompletedTime() {
        return completedTime;
    }

    /**
     * <p>完成日期</p>
     *
     * @param completedTime 完成日期
     */
    public void setCompletedTime(java.util.Date completedTime) {
        this.completedTime = completedTime;
    }

    /**
     * <p>完成回执人</p>
     *
     * @return 完成回执人
     */
    public String getCompletedMan() {
        return completedMan;
    }

    /**
     * <p>完成回执人</p>
     *
     * @param completedMan 完成回执人
     */
    public void setCompletedMan(String completedMan) {
        this.completedMan = completedMan;
    }

}
