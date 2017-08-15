package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class YDPRestResult implements Serializable {
    //返回消息。
    private String message;
    //业务返回值
    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
