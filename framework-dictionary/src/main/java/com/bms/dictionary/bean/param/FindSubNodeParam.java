package com.bms.dictionary.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/11/2.
 */
public class FindSubNodeParam implements Serializable {
    @ApiModelProperty(value = "所属字典根节点")
    private String rootCode;
    @ApiModelProperty(value = "父节点")
    private String parentCode;
    @ApiModelProperty(value = "是否加载值详细信息")
    private boolean detail;

    public String getRootCode() {
        return rootCode;
    }

    public void setRootCode(String rootCode) {
        this.rootCode = rootCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public boolean isDetail() {
        return detail;
    }

    public void setDetail(boolean detail) {
        this.detail = detail;
    }
}
