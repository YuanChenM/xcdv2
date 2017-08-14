package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestBean;

/**
 * 问题订单创建接口Param
 *
 * @author li_huiqian
 */
public class ISSU0101IBean extends RestBean {
    private static final long serialVersionUID = 1L;

    private Long orderId;

    private String initiatorType;

    private String initiatorId;

    private String initiatorName;

    private String initiateTime;

    private String issueDesc;

    private String issueStatus;

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getInitiatorType() {
        return initiatorType;
    }

    public void setInitiatorType(String initiatorType) {
        this.initiatorType = initiatorType;
    }

    public String getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(String initiatorId) {
        this.initiatorId = initiatorId;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getIssueDesc() {
        return issueDesc;
    }

    public void setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
    }

    public String getInitiateTime() {
        return initiateTime;
    }

    public void setInitiateTime(String initiateTime) {
        this.initiateTime = initiateTime;
    }
}
