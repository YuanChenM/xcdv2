package com.msk.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mao_yejun on 2016/10/12.
 */
public class UpdateNoticeParam  implements Serializable{
    @ApiModelProperty(value = "消息关系id")
    private List<String> ids;
    @ApiModelProperty(value = "更新状态")
    private String status;
    @ApiModelProperty(value = "更新者")
    private String updId;
    @ApiModelProperty(value = "消息id")
    private List<String> messageIds;
    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

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

    public List<String> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<String> messageIds) {
        this.messageIds = messageIds;
    }
}

