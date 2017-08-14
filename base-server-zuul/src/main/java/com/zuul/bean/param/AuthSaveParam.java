package com.zuul.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mao_yejun on 2017/3/14.
 */
public class AuthSaveParam implements Serializable {
    private  long userId;
    private List<Long> interfaceList;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Long> getInterfaceList() {
        return interfaceList;
    }

    public void setInterfaceList(List<Long> interfaceList) {
        this.interfaceList = interfaceList;
    }
}
