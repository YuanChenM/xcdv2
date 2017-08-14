package com.zuul.bean.param;

import com.zuul.bean.PageParam;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/3/2.
 */
public class UserAuthSearchParam extends PageParam {
    private Long userId;
    private String interfaceUrl;

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
