package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

/**
 * 买手退货原因查询接口Result
 * 
 * @author li_huiqian
 */
public class ORDR0903IRestResult extends RestSearchData {

    private static final long serialVersionUID = 1L;

    /**
     * 原因ID
     */
    private Long reasonId;
    /**
     * 原因名称
     */
    private String reasonName;
    /**
     * 适用类型
     */
    private String applyType;
    /**
     * 适用对象
     */
    private String applyObject;

    public Long getReasonId() {
        return reasonId;
    }

    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplyObject() {
        return applyObject;
    }

    public void setApplyObject(String applyObject) {
        this.applyObject = applyObject;
    }
}
