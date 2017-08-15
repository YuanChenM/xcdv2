package com.bms.order.bean.result;

import com.framework.base.rest.result.BaseRestResult;

import java.util.List;

/**
 * 发货通知回传接口Result
 *
 * @author li_huiqian
 */
public class ORDR0401IRestResult extends BaseRestResult {
    private static final long serialVersionUID = 1L;
    /**
     * 处理条数
     */
    private int executedCount;
    /**
     * 成功条数
     */
    private int succeedCount;
    /**
     * 失败条数
     */
    private int failedCount;
    /**
     * 处理失败的发货通知单
     */
    private List<ORDR040101IRestResult> sendNotificationBean;

    public int getExecutedCount() {
        return executedCount;
    }

    public void setExecutedCount(int executedCount) {
        this.executedCount = executedCount;
    }

    public int getSucceedCount() {
        return succeedCount;
    }

    public void setSucceedCount(int succeedCount) {
        this.succeedCount = succeedCount;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(int failedCount) {
        this.failedCount = failedCount;
    }

    public List<ORDR040101IRestResult> getSendNotificationBean() {
        return sendNotificationBean;
    }

    public void setSendNotificationBean(List<ORDR040101IRestResult> sendNotificationBean) {
        this.sendNotificationBean = sendNotificationBean;
    }

}
