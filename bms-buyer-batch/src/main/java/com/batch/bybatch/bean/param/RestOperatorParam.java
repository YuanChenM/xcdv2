package com.batch.bybatch.bean.param;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/2/24.
 */
public class RestOperatorParam implements Serializable {

    private static final long serialVersionUID = -7276464855343005881L;

    /**
     * 操作者类型
     */
    private String operatorType;

    /**
     * 操作者Id
     */
    private String operatorId;

    public RestOperatorParam() {

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
