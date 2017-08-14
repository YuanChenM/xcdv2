package com.bms.como.bean.result;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/4/1.
 */
public class ComoInvAllocationCompleteRsResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private int count;
    private String message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
