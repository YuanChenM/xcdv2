package com.msk.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mao_yejun on 2016/10/12.
 */
public class DeleteNoticeParam implements Serializable {
    @ApiModelProperty(value = "消息id")
    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
