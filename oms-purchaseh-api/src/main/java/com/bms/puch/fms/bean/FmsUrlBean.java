package com.bms.puch.fms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * FmsUrlBean
 */
@ApiModel(value = "FmsUrlBean", description = "fms接口连接条件设定")
public class FmsUrlBean implements Serializable {
    private static final long serialVersionUID = 1041063365606192854L;

    @ApiModelProperty(value = "传入参数（json字符串）")
    private Object postJsonData;
    @ApiModelProperty(value = "FmsUrl")
    private String postUrl;
    @ApiModelProperty(value = "Fms主机IP或者域名")
    private String postHost;
    @ApiModelProperty(value = "Fms验证用户名")
    private String fmsUser;
    @ApiModelProperty(value = "Fms验证密码")
    private String fmsPsd;

    public Object getPostJsonData() {
        return postJsonData;
    }

    public void setPostJsonData(Object postJsonData) {
        this.postJsonData = postJsonData;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getPostHost() {
        return postHost;
    }

    public void setPostHost(String postHost) {
        this.postHost = postHost;
    }

    public String getFmsUser() {
        return fmsUser;
    }

    public void setFmsUser(String fmsUser) {
        this.fmsUser = fmsUser;
    }

    public String getFmsPsd() {
        return fmsPsd;
    }

    public void setFmsPsd(String fmsPsd) {
        this.fmsPsd = fmsPsd;
    }
}
