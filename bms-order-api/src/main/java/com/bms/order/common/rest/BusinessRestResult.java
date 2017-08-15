package com.bms.order.common.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.common.rest.result.RestSucceedData;

/**
 * 业务Result
 * 
 * @author li_huiqian
 *
 */
public class BusinessRestResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4306034480260592495L;

    /**
     * 处理过的数量
     */
    private int processedCount;

    /**
     * 处理成功的数量
     */
    private int succeedCount;

    /**
     * 处理失败的数量
     */
    private int failedCount;

    /**
     * 处理失败的数据
     */
    private List<RestFailedData> failedDatas;

    /**
     * 处理成功的数据
     */
    private List<RestSucceedData> succeedDatas;

    /**
     * @return the processedCount
     */
    public int getProcessedCount() {
        return processedCount;
    }

    /**
     * @param processedCount
     *            the processedCount to set
     */
    public void setProcessedCount(int processedCount) {
        this.processedCount = processedCount;
    }

    /**
     * @return the succeedCount
     */
    public int getSucceedCount() {
        return succeedCount;
    }

    /**
     * @param succeedCount
     *            the succeedCount to set
     */
    public void setSucceedCount(int succeedCount) {
        this.succeedCount = succeedCount;
    }

    /**
     * @return the failedCount
     */
    public int getFailedCount() {
        return failedCount;
    }

    /**
     * @param failedCount
     *            the failedCount to set
     */
    public void setFailedCount(int failedCount) {
        this.failedCount = failedCount;
    }

    /**
     * @return the failedDatas
     */
    public List<RestFailedData> getFailedDatas() {
        return failedDatas;
    }

    /**
     * @param failedDatas
     *            the failedDatas to set
     */
    public void setFailedDatas(List<RestFailedData> failedDatas) {
        this.failedDatas = failedDatas;
    }

    /**
     * @param failedDatas
     *            the failedDatas to set
     */
    public void putFailedData(RestFailedData failedData) {
        if (failedDatas == null)
            failedDatas = new ArrayList<>();
        failedDatas.add(failedData);
    }

    /**
     * @return the succeedDatas
     */
    public List<RestSucceedData> getSucceedDatas() {
        return succeedDatas;
    }

    /**
     * @param succeedDatas
     *            the succeedDatas to set
     */
    public void setSucceedDatas(List<RestSucceedData> succeedDatas) {
        this.succeedDatas = succeedDatas;
    }

    public void putSucceedData(RestSucceedData succeedData) {
        if (succeedDatas == null)
            succeedDatas = new ArrayList<>();
        succeedDatas.add(succeedData);
    }
}
