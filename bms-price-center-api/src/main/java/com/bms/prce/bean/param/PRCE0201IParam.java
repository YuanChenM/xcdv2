package com.bms.prce.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sun_jiaju on 2017/01/11.
 */
public class PRCE0201IParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "通道分类名称")
    private String wayTypeName;

    public String getWayTypeName() {
        return wayTypeName;
    }

    public void setWayTypeName(String wayTypeName) {
        this.wayTypeName = wayTypeName;
    }
}
