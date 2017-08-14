package com.msk.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/10/14.
 */
public class UpdateNoticeByEmployParam implements Serializable{
    @ApiModelProperty(value = "更新状态")
    private String status;
    @ApiModelProperty(value = "更新者")
    private String updId;
    @ApiModelProperty(value = "用户Code")
    private String userCode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
