package com.bms.como.bean.result;

import com.framework.base.rest.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by yuan_zhifei on 2017/4/1.
 */
public class ComoInvAllocationRsResult extends BaseEntity {
    @ApiModelProperty(value = "划拨单Id")
    private Long allocationId;
    @ApiModelProperty(value = "划拨单编号")
    private String allocationCode;
    @ApiModelProperty(value = "物流区域ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区域编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区域名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "指定批次")
    private boolean assignLotNo;
    @ApiModelProperty(value = "备注")
    private String allocationRemark;
    @ApiModelProperty(value = "状态")
    private String allocationStu;
    @ApiModelProperty(value = "划拨结果")
    private boolean allocationResult;
    @ApiModelProperty(value = "发起时间")
    private java.util.Date applyTime;
    @ApiModelProperty(value = "发起人")
    private String applyMan;
    @ApiModelProperty(value = "完成日期")
    private java.util.Date completedTime;
    @ApiModelProperty(value = "完成回执人")
    private String completedMan;
    @ApiModelProperty(value = "明细ID集合")
    private List<Long> allocationDetailIds;
    @ApiModelProperty(value = "明细集合")
    private List<ComoInvAllocationDetailRsResult> details;

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public String getAllocationCode() {
        return allocationCode;
    }

    public void setAllocationCode(String allocationCode) {
        this.allocationCode = allocationCode;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public boolean getAssignLotNo() {
        return assignLotNo;
    }

    public void setAssignLotNo(boolean assignLotNo) {
        this.assignLotNo = assignLotNo;
    }

    public String getAllocationRemark() {
        return allocationRemark;
    }

    public void setAllocationRemark(String allocationRemark) {
        this.allocationRemark = allocationRemark;
    }

    public String getAllocationStu() {
        return allocationStu;
    }

    public void setAllocationStu(String allocationStu) {
        this.allocationStu = allocationStu;
    }

    public boolean getAllocationResult() {
        return allocationResult;
    }

    public void setAllocationResult(boolean allocationResult) {
        this.allocationResult = allocationResult;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyMan() {
        return applyMan;
    }

    public void setApplyMan(String applyMan) {
        this.applyMan = applyMan;
    }

    public Date getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(Date completedTime) {
        this.completedTime = completedTime;
    }

    public String getCompletedMan() {
        return completedMan;
    }

    public void setCompletedMan(String completedMan) {
        this.completedMan = completedMan;
    }

    public List<Long> getAllocationDetailIds() {
        return allocationDetailIds;
    }

    public void setAllocationDetailIds(List<Long> allocationDetailIds) {
        this.allocationDetailIds = allocationDetailIds;
    }

    public List<ComoInvAllocationDetailRsResult> getDetails() {
        return details;
    }

    public void setDetails(List<ComoInvAllocationDetailRsResult> details) {
        this.details = details;
    }
}
