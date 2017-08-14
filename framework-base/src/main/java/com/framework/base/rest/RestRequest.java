package com.framework.base.rest;


import com.framework.base.rest.param.RestAuthorityParam;

import java.io.Serializable;

/**
 * 服务接口请求值
 *
 * @author mao_yejun
 * @version 1.0
 */
@Deprecated
public class RestRequest implements Serializable {
    /**
     * 权限验证参数
     */
    private RestAuthorityParam authorityParam;
    /**
     * 构造方法
     */
    public RestRequest() {
    }

    public RestAuthorityParam getAuthorityParam() {
        return authorityParam;
    }

    public void setAuthorityParam(RestAuthorityParam authorityParam) {
        this.authorityParam = authorityParam;
    }






}
