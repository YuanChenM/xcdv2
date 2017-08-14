package com.msk.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by mao_yejun on 2016/10/12.
 */
public class CreateNoticeParam extends BaseCreateParam {
    @ApiModelProperty(value = "用户列表")
    private List<String> receiverCodes;
    @ApiModelProperty(value = "用户组列表")
    private List<String> groupCodes;

    public List<String> getGroupCodes() {
        return groupCodes;
    }

    public void setGroupCodes(List<String> groupCodes) {
        this.groupCodes = groupCodes;
    }

    public List<String> getReceiverCodes() {
        return receiverCodes;
    }

    public void setReceiverCodes(List<String> receiverCodes) {
        this.receiverCodes = receiverCodes;
    }
}
