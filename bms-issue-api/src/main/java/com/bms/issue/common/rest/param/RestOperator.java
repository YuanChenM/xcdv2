package com.bms.issue.common.rest.param;

import java.io.Serializable;

/**
 * 操作者
 * 
 * @author li_huiqian
 *
 */
public class RestOperator implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7276464855343005881L;

    /**
     * 操作者类型
     */
    private String operatorType;

    /**
     * 操作者Id
     */
    private String operatorId;

    public RestOperator() {

    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

}
