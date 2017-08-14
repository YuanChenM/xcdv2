package com.msk.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhu_kai1 on 2017/1/6.
 */
public class GroupUserParam implements Serializable {
    @ApiModelProperty(value = "用户组列表")
    private List<String> group;

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }
}
